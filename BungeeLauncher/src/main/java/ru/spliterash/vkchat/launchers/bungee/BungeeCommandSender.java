package ru.spliterash.vkchat.launchers.bungee;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.Collection;
import java.util.Collections;
import java.util.function.Consumer;

public class BungeeCommandSender implements CommandSender {
    private final String name;
    private final Consumer<String[]> response;

    public BungeeCommandSender(String sender, Consumer<String[]> response) {
        this.name = sender;
        this.response = response;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void sendMessage(String message) {
        response.accept(new String[]{message});
    }

    @Override
    public void sendMessages(String... messages) {
        response.accept(messages);
    }

    @Override
    public void sendMessage(BaseComponent... message) {
        response.accept(new String[]{new TextComponent(message).toPlainText()});
    }

    @Override
    public void sendMessage(BaseComponent message) {
        response.accept(new String[]{new TextComponent(message).toPlainText()});
    }

    @Override
    public Collection<String> getGroups() {
        return Collections.emptyList();
    }

    @Override
    public void addGroups(String... groups) {
        //NONE
    }

    @Override
    public void removeGroups(String... groups) {
        //NONE
    }

    @Override
    public boolean hasPermission(String permission) {
        return true;
    }

    @Override
    public void setPermission(String permission, boolean value) {
        //NONE
    }

    @Override
    public Collection<String> getPermissions() {
        return Collections.singleton("*");
    }
}
