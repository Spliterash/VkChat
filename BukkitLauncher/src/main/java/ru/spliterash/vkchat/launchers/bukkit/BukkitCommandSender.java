package ru.spliterash.vkchat.launchers.bukkit;

import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BukkitCommandSender implements CommandSender {
    private final Consumer<String[]> onReply;
    private final String name;

    BukkitCommandSender(String name, Consumer<String[]> onReply) {
        this.name = name;
        this.onReply = onReply;
    }

    @Override
    public void sendMessage(String message) {
        onReply.accept(new String[]{message});
    }

    @Override
    public void sendMessage(String[] messages) {
        onReply.accept(messages);
    }

    @Override
    public Server getServer() {
        return Bukkit.getServer();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Spigot spigot() {
        return new Spigot() {
            @Override
            public void sendMessage(BaseComponent component) {
                BukkitCommandSender.this.sendMessage(component.toPlainText());
            }

            @Override
            public void sendMessage(BaseComponent... components) {
                BukkitCommandSender.this.sendMessage(Arrays.stream(components).map(BaseComponent::toPlainText).collect(Collectors.joining()));
            }
        };
    }

    @Override
    public boolean isPermissionSet(String name) {
        return true;
    }

    @Override
    public boolean isPermissionSet(Permission perm) {
        return true;
    }

    @Override
    public boolean hasPermission(String name) {
        return true;
    }

    @Override
    public boolean hasPermission(Permission perm) {
        return true;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
        return null;
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
        return null;
    }

    @Override
    public void removeAttachment(PermissionAttachment attachment) {

    }

    @Override
    public void recalculatePermissions() {

    }

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return Collections.emptySet();
    }

    @Override
    public boolean isOp() {
        return true;
    }

    @Override
    public void setOp(boolean value) {

    }
}
