package ru.spliterash.vkchat.launchers.bukkit.anvil;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.FixedMetadataValue;
import ru.spliterash.vkchat.launchers.bukkit.BukkitPlugin;

public class AnvilUtils {
    public static void dropAnvil(Player player) {
        Location start = player.getLocation();
        Location copy = start.clone();
        for (int i = 0; i < 8 && !copy.getBlock().getType().isSolid(); i++) {
            copy.add(0, 1, 0);
        }
        copy.add(0, -1, 0);
        FallingBlock block = copy.getWorld().spawnFallingBlock(copy, new MaterialData(Material.ANVIL));
        block.setDropItem(false);
        block.setFireTicks(Integer.MAX_VALUE);
        block.setMetadata("removeAnvil", new FixedMetadataValue(BukkitPlugin.getInstance(), null));
        block.setHurtEntities(true);
        block.setCustomName(ChatColor.GREEN + ":)");
        block.setCustomNameVisible(true);
    }
}
