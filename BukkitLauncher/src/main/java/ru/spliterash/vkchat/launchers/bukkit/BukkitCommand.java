package ru.spliterash.vkchat.launchers.bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import ru.spliterash.vkchat.wrappers.AbstractCommandExecutor;

import java.util.List;

import static ru.spliterash.vkchat.launchers.bukkit.BukkitPlugin.*;

public class BukkitCommand implements TabExecutor {
    private final AbstractCommandExecutor executor;

    public BukkitCommand(AbstractCommandExecutor executor) {
        this.executor = executor;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        executor.onCommand(wrapSender(sender), args);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return executor.onTabComplete(wrapSender(sender), args);
    }
}
