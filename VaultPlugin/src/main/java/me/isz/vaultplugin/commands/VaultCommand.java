package me.isz.vaultplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class VaultCommand implements CommandExecutor {

    private final HashMap<UUID, Long> cooldown;
    public VaultCommand() {
        this.cooldown = new HashMap<>();
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!this.cooldown.containsKey(player.getUniqueId()) || System.currentTimeMillis() - cooldown.get(player.getUniqueId()) >= 10000) {
                this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());

                Inventory vault = Bukkit.createInventory(player, 45, "Your vault");
                ItemStack item1 = new ItemStack(Material.CLAY_BALL, 2);

                item1.addUnsafeEnchantment(Enchantment.DIG_SPEED, 40);
                ItemMeta meta1 = item1.getItemMeta();
                meta1.setDisplayName(ChatColor.AQUA + "Balls");
                meta1.setUnbreakable(true);
                ArrayList<String> lore1 = new ArrayList<>();
                lore1.add(ChatColor.GOLD + "This lore is line 1");
                lore1.add(ChatColor.DARK_PURPLE + "This is lore line 2");
                meta1.setLore(lore1);
                item1.setItemMeta(meta1);

                ItemStack item2 = new ItemStack(Material.BEEF, 16);
                vault.setItem(5, item1);
                // vault.addItem(item1);

                ItemStack[] items = {item1, item2};                    // putting an item array into an inventory will wipe anything else in there.
                vault.setContents(items);


                player.openInventory(vault);
            } else {
                player.sendMessage("Your vault is on cool down. Please wait another " + ((10000 - (System.currentTimeMillis() - cooldown.get(player.getUniqueId()))) / 1000) + " seconds.");
            }
        } else {
            System.out.println("You need to be a player to execute this command.");
        }
        return true;
    }
}
