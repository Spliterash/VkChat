package ru.spliterash.vkchat.obj;

public interface AbstractSender {
    String getName();

    void sendMessage(String text);

    boolean hasPermission(String pex);

    void sendJsonMessage(String json);
}
