package me.isz.javatest.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        if (player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.GREEN + "Welcome to the server " + player.getDisplayName());
        } else {
            e.setJoinMessage(ChatColor.LIGHT_PURPLE + "Everybody welcome " + player.getDisplayName() + " to the server for the first time.");
        }
    }


    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.YELLOW + player.getDisplayName() + ChatColor.RED + "has left the server. Let's hope they come back.");
    }

}
