package lesson7_2;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Collections;
import java.util.List;

import static lesson7_2.MessagePatterns.*;

public class Network implements Closeable {

    public Socket socket;
    public DataInputStream in;
    public DataOutputStream out;
    private String hostName;
    private int port;
    private MessageReciever messageReciever;
    private String login;
    private Thread receiverThread;

    public Network(String hostName, int port, MessageReciever messageReciever) {
        this.hostName = hostName;
        this.port = port;
        this.messageReciever = messageReciever;

        this.receiverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String text = in.readUTF();

                        System.out.println("New message " + text);

//                        TextMessage msg = parseTextMessageRegx(text, login);
//                        if (msg != null) {
//                            messageReciever.submitMessage(msg);
//                            continue;
//                        }

                        String[] messageParts = text.split(" ");
                        if (messageParts.length != 3 || !messageParts[0].equals("/w")) {
                            System.out.printf("Incorrect message type %s%n", text);
                        }

                        TextMessage textMessage = new TextMessage(messageParts[1], login, messageParts[2]); //// TODOопределить текст и отправителя
                        messageReciever.submitMessage(textMessage);

                        System.out.println("Connection message " + text);
                        String login = parseConnectedMessage(text);
                        if (login != null) {
                            messageReciever.userConnected(login);
                            continue;
                        }

                        messageReciever.userDisconnected(login);

                        // TODO добавить обработку отключения пользователя

                    } catch (IOException e) {
                        e.printStackTrace();
                        if (socket.isClosed()) {
                            break;
                        }
                    }
                }
            }
        });
    }

    public void authorize(String login, String password) throws IOException, AuthException {
        socket = new Socket(hostName, port);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());

        sendMessage(String.format(AUTH_PATTERN, login, password));
        String response = in.readUTF();
        if (response.equals(AUTH_SUCCESS_RESPONSE)) {
            this.login = login;
            receiverThread.start();
        } else {
            throw new AuthException();
        }
    }

    public void sendTextMessage(TextMessage message) {
        sendMessage(String.format(MESSAGE_SEND_PATTERN, message.getUserTo(), message.getText()));
    }

    private void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> requestConnectedUserList() {
        // TODO реализовать запрос с сервера списка всех подключенных пользователей
        return Collections.emptyList();
    }

    public String getLogin() {
        return login;
    }

    @Override
    public void close() throws IOException {
        this.receiverThread.interrupt();
        sendMessage(DISCONNECT);
    }
}
