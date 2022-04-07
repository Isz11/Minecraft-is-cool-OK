package me.isz.javatest.commands;

import me.isz.javatest.JavaTest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class FlyCommand implements CommandExecutor {

    private JavaTest plugin; // another way of getting values from config. Seems to be better for multiple methods etc...

    public FlyCommand(JavaTest plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                flyMethod(player);
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                flyMethod(target);
            } else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("feed_no_permission")));
            }
        }
        return true;
    }

    private void flyMethod(Player player) {
        if (player.hasPermission("javatestplugin.fly")) {
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("fly_allow")));
            } else {
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                        plugin.getConfig().getString("fly_deny")));
            }
        }
    }

}
