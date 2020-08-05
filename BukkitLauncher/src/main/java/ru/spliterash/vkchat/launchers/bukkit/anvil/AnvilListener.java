package ru.spliterash.vkchat.launchers.bukkit.anvil;

import org.bukkit.ChatColor;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class AnvilListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onAnvilDrop(EntityChangeBlockEvent e) {
        if (e.getEntity().hasMetadata("removeAnvil"))
            e.setCancelled(true);
    }

    @EventHandler(ignoreCancelled = true)
    public void onDropRemove(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof FallingBlock))
            return;
        if (!e.getDamager().hasMetadata("removeAnvil"))
            return;
        if (e.getEntity() instanceof Player) {
            double health = ((Player) e.getEntity()).getHealth() - e.getFinalDamage();
            if (health <= 0) {
                e.getEntity().sendMessage(ChatColor.GREEN + "Ладно, можешь ещё пожить");
                e.setCancelled(true);
            }
        } else if (e.getEntity() instanceof Item)
            e.setCancelled(true);

    }
}
