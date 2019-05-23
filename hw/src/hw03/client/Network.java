package hw03.client;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Set;

import static hw03.client.MessagePatterns.*;

public class Network implements Closeable {

    public Socket socket;
    public DataInputStream in;
    public DataOutputStream out;

    private String hostName;
    private int port;
    private MessageReciever messageReciever;

    private String login;

    private Thread receiverThread;

    private  HistoryKeeper historyKeeper;

    public Network(String hostName, int port, MessageReciever messageReciever) {
        this.hostName = hostName;
        this.port = port;
        this.messageReciever = messageReciever;

        this.receiverThread = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String text = in.readUTF();

                    System.out.println("New message " + text);
                    TextMessage msg = parseTextMessageRegx(text, login);
                    if (msg != null) {
                        messageReciever.submitMessage(msg);
//                        try {
//                            historyKeeper = new HistoryKeeper();
//                            historyKeeper.writer(msg);
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
                        continue;
                    }

                    String login = parseConnectedMessage(text);
                    if (login != null) {
                        messageReciever.userConnected(login);
                        continue;
                    }

                    login = parseDisconnectedMessage(text);
                    if (login != null) {
                        messageReciever.userDisconnected(login);
                        continue;
                    }

                    Set<String> users = parseUserList(text);
                    if (users != null) {
                        messageReciever.updateUserList(users);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (socket.isClosed()) {
                        break;
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
        try {
            historyKeeper = new HistoryKeeper();  // решил встатвить именно сюда. хотя можно и еще в три места
            historyKeeper.writer(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void requestConnectedUserList() {
        sendMessage(USER_LIST_TAG);
    }

    public String getLogin() {
        return login;
    }

    @Override
    public void close() {
        this.receiverThread.interrupt();
        sendMessage(DISCONNECT);
    }
}
