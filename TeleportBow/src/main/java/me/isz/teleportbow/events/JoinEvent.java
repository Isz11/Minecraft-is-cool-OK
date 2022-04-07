package me.isz.teleportbow.events;

import me.isz.teleportbow.TeleportBow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    TeleportBow plugin;

    public JoinEvent(TeleportBow plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {

        if (plugin.getConfig().getBoolean("give-bow-on-join")) {
            Player player = event.getPlayer();
            plugin.bowMethod(player);
        }
    }
}
