package me.isz.teleportbow.events;

import me.isz.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class TeleportBowEvent implements Listener {

    TeleportBow plugin;

    public TeleportBowEvent(TeleportBow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBowShoot(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Arrow) {
            Player player = (Player) event.getEntity().getShooter();
            Location location = event.getEntity().getLocation();

            player.teleport(location);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("teleport-message")));
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        }
    }

}
