package ru.spliterash.vkchat.launchers.bungee;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import ru.spliterash.vkchat.utils.ArrayUtils;

import java.util.List;

public class TabCompleteListener implements Listener {
    @EventHandler
    public void onTabComplete(TabCompleteEvent e) {
        if (!e.getCursor().startsWith("/"))
            return;
        if (!(e.getSender() instanceof CommandSender)) {
            return;
        }
        CommandSender sender = (CommandSender) e.getSender();
        String[] command = e.getCursor().split(" ");
        if (command.length <= 1)
            return;
        String cmd = command[0].substring(1);
        BungeeCommandExecutor executor = BungeePlugin.getInstance().getExecutor(cmd);
        if (executor != null) {
            String[] result = ArrayUtils.removeFirst(String.class, command);
            List<String> list = executor.processTab(BungeePlugin.wrapSender(sender), result);
            e.getSuggestions().clear();
            if (list != null)
                e.getSuggestions().addAll(list);
        }
    }
}
