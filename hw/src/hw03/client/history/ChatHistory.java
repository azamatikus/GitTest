package hw03.client.history;

import hw03.client.TextMessage;

import java.util.List;

public interface ChatHistory {

    void addMessage(TextMessage message);

    List<TextMessage> getLastMessages(int count);

    void flush();
}