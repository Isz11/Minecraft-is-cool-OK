package me.isz.spawnplugin.commands;

import me.isz.spawnplugin.SpawnPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SpawnCommand(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = plugin.getConfig().getLocation("spawn");

            if (location != null) {
                player.teleport(location);
                player.sendMessage("You have been teleported to spawn!");
            } else {
                player.sendMessage("There is no spawn location set. Please use /setspawn to set a location.");
            }
        }

        return true;
    }
}
