package hw03.client;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistoryKeeper {

    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private TextMessage textMessage;
//    private String login;

//    public HistoryKeeper(TextMessage msg, String login){
//        this.textMessage  = msg;
//        this.login = login;
//    }

    public void writer (TextMessage msg) throws IOException {

        File printTextFile = new File("history_" + msg.getUserFrom() + ".txt");
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(printTextFile, true)))) {
            writer.println(msg.getCreated().format(timeFormatter) + ";");
            writer.println(msg.getUserFrom() + ";");
            writer.println(msg.getText() + ";");
        }

        File printTextFile2 = new File("history_" + msg.getUserTo() + ".txt");
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(printTextFile2, true)))) {
            writer.println(msg.getCreated().format(timeFormatter) + ";");
            writer.println(msg.getUserFrom() + ";");
            writer.println(msg.getText() + ";");
        }
    }

    public TextMessage reader (String login) throws IOException {

        List<TextMessage> messageList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("history_" + login + ".txt"))) {

            while (reader.ready()) {
                String[] parts = reader.readLine().split(";",3);
                messageList.add(new TextMessage(parts[1], login, parts[0]));

                    return messageList.get(0);
            }
        }
        return null;
    }
}
