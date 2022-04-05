package me.isz.spawnplugin.commands;

import me.isz.spawnplugin.SpawnPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommands implements CommandExecutor {

    private final SpawnPlugin plugin;

    public SetSpawnCommands(SpawnPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();

            // option 1 - set each value of the location
//            plugin.getConfig().set("spawn.x", location.getX());
//            plugin.getConfig().set("spawn.y", location.getY());
//            plugin.getConfig().set("spawn.z", location.getZ());
//            plugin.getConfig().set("spawn.world_name", location.getWorld().getName());

            // option 2 - save the location object directly
            plugin.getConfig().set("spawn", location);
            plugin.saveConfig();
            player.sendMessage("Spawn location set!");
        } else {
            System.out.println("You must be a player to run this command.");
        }




        return true;
    }
}
