package Controller;

import Model.ChatMessage;

import java.util.ArrayList;
import java.util.List;

public class ChatService {
    private List<ChatMessage> messages;

    public ChatService() {
        messages = new ArrayList<>();
    }

    public void addMessage(ChatMessage message) {
        messages.add(message);
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void clearMessages() {
        messages.clear();
    }
}