package me.isz.teleportbow;

import me.isz.teleportbow.commands.TeleportBowCommand;
import me.isz.teleportbow.events.JoinEvent;
import me.isz.teleportbow.events.TeleportBowEvent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class TeleportBow extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("tpbow").setExecutor(new TeleportBowCommand(this));
        getServer().getPluginManager().registerEvents(new TeleportBowEvent(this), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void bowMethod(Player player) {
        if (player.hasPermission("tpbow.spawnbow")) {
            ItemStack teleport_bow = new ItemStack(Material.BOW);
            teleport_bow.addEnchantment(Enchantment.ARROW_INFINITE, 1);

            ItemMeta meta = teleport_bow.getItemMeta();
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                    this.getConfig().getString("bow-name")));
            meta.setUnbreakable(true);
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.translateAlternateColorCodes('&',
                    this.getConfig().getString("bow-lore")));
            meta.setLore(lore);

            teleport_bow.setItemMeta(meta);

            player.getInventory().addItem(teleport_bow);   // give item to players inv
        }
    }
}
