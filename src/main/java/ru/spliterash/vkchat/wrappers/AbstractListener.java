package ru.spliterash.vkchat.wrappers;

public interface AbstractListener {
    void onNewMessage(AbstractPlayer sender,String message);

    void onJoin(AbstractPlayer player,boolean first);

    void onExit(AbstractPlayer player);

    void onDie(AbstractPlayer player, String deathMessage);
}
