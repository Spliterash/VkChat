package ru.spliterash.vkchat.launchers.bungee;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import ru.spliterash.vkchat.wrappers.AbstractCommandExecutor;
import ru.spliterash.vkchat.wrappers.AbstractSender;

import java.util.List;

public class BungeeCommandExecutor extends Command {
    private final AbstractCommandExecutor executor;

    public BungeeCommandExecutor(String command, AbstractCommandExecutor executor) {
        super(command);
        this.executor = executor;
    }

    public List<String> processTab(AbstractSender sender, String[] args) {
        return executor.onTabComplete(sender, args);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        executor.onCommand(BungeePlugin.wrapSender(sender), args);
    }
}
