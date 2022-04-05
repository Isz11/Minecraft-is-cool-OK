package me.isz.vaultplugin;

import me.isz.vaultplugin.commands.VaultCommand;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class VaultPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("The vault plugin has started up");

        getCommand("vault").setExecutor(new VaultCommand());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
