package ru.spliterash.vkchat.launchers.bukkit.anvil;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class AnvilListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onAnvilDrop(EntityChangeBlockEvent e) {
        if (e.getEntity().hasMetadata("removeAnvil"))
            e.setCancelled(true);
    }
}
