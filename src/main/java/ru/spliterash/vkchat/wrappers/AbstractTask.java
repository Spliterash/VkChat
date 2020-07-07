package ru.spliterash.vkchat.wrappers;

public interface AbstractTask {
    void cancel();

    boolean isCancelled();
}
