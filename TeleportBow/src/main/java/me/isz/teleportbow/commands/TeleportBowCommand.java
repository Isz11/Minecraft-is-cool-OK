package me.isz.teleportbow.commands;

import me.isz.teleportbow.TeleportBow;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class TeleportBowCommand implements CommandExecutor {

    TeleportBow plugin;

    public TeleportBowCommand(TeleportBow plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            plugin.bowMethod(player);
        } else {
            System.out.println("You are not a player");
        }

        if (sender instanceof ConsoleCommandSender) {
            System.out.println("The command was ran via the console.");
        }

        return true;
    }
}
