package hw03.client;

import java.io.*;

public class HistoryKeeper {

//    private TextMessage textMessage;
//    private String login;

//    public HistoryKeeper(TextMessage msg, String login){
//        this.textMessage  = msg;
//        this.login = login;
//    }

    public void writer (TextMessage msg) throws IOException {

        File printTextFile = new File("history_" + msg.getUserFrom() + ".txt");
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(printTextFile, true)))) {
            writer.println(msg.getCreated());
            writer.println(msg.getUserFrom());
            writer.println(msg.getText());
        }

        File printTextFile2 = new File("history_" + msg.getUserTo() + ".txt");
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(printTextFile2, true)))) {
            writer.println(msg.getCreated());
            writer.println(msg.getUserFrom());
            writer.println(msg.getText());
        }
    }

    public String reader (String login) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("history_" + login + ".txt"))) {

            while (reader.ready()) {
                //TODO
                return reader.readLine();
            }
        }
        return null;
    }
}
