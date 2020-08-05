package ru.spliterash.vkchat.messages;

import lombok.Synchronized;
import ru.spliterash.vkchat.VkChat;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SendingMessage {
    private static final Map<Integer, SendingMessage> messageMap = new HashMap<>();
    private static ScheduledExecutorService executor;
    private final Integer peer;
    private final StringBuilder messageBuilder;
    private final ScheduledFuture<?> task;

    public SendingMessage(Integer peerId) {
        this.peer = peerId;
        this.messageBuilder = new StringBuilder();
        this.task = executor.schedule(this::onTimer, 50, TimeUnit.MILLISECONDS);
    }

    public static List<Runnable> shutdown() {
        if (executor != null) {
            List<Runnable> list = executor.shutdownNow();
            executor = null;
            return list;
        }
        return Collections.emptyList();
    }

    public static void start() {
        shutdown();
        executor = Executors.newScheduledThreadPool(4);
    }
    @Synchronized
    public static void send(Integer peer, String message) {
        SendingMessage sending = messageMap.computeIfAbsent(peer, SendingMessage::new);
        sending.addText(message);
    }

    private void addText(String message) {
        if (messageBuilder.length() > 0)
            messageBuilder.append("\n");
        messageBuilder.append(message);
    }

    public void cancel() {
        if (task != null)
            task.cancel(false);
        messageMap.remove(peer);
    }

    private void onTimer() {
        VkChat.getInstance().sendMessageRightNow(peer, messageBuilder.toString());
        cancel();
    }

}
