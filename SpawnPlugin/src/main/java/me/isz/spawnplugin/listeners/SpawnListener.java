package me.isz.spawnplugin.listeners;

import me.isz.spawnplugin.SpawnPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {

    private final SpawnPlugin plugin;

    public SpawnListener(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        if (event.getPlayer().hasPlayedBefore()) {

            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {
                player.teleport(location);
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {

        //when a player dies respawn them at the spawn location if it is set
        Location location = plugin.getConfig().getLocation("spawn");
        if (location != null) {
            event.setRespawnLocation(location);
        }
    }
}
