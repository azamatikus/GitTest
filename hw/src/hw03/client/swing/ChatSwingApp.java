package hw03.client.swing;

import javax.swing.*;

public class ChatSwingApp {

    private static ChatMainWindow chatMainWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> chatMainWindow = new ChatMainWindow());
    }
}
