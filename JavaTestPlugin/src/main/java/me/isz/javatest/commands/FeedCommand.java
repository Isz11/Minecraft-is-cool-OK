package me.isz.javatest.commands;

import me.isz.javatest.JavaTest;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class FeedCommand implements CommandExecutor {

    Plugin plugin = JavaTest.getPlugin(JavaTest.class); // this extends the main class to allow grabbing of config values

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String feed_allow = plugin.getConfig().getString("feed");
        String feed_deny = plugin.getConfig().getString("feed_no_permission");

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if(p.hasPermission("javatestplugin.feed")) {
                p.setSaturation(50);
                p.setFoodLevel(20);

                p.sendMessage(feed_allow);
            } else {
                p.sendMessage(feed_deny);
            }
        }
        return true;
    }
}
