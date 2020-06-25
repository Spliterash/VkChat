package ru.spliterash.vkchat.launchers.console;

import net.md_5.bungee.api.chat.BaseComponent;
import ru.spliterash.vkchat.obj.AbstractPlayer;

public class ConsolePlayer extends AbstractPlayer {
    @Override
    public String getName() {
        return "Console";
    }

    @Override
    public void sendMessage(String text) {
        System.out.println(text);
    }

    @Override
    public boolean isOnline() {
        return true;
    }

    @Override
    public boolean hasPermission(String pex) {
        return true;
    }

    @Override
    public void sendJsonMessage(BaseComponent... components) {
        System.out.println();
        for (BaseComponent component : components) {
            System.out.print(component.toPlainText());
        }

    }
}
