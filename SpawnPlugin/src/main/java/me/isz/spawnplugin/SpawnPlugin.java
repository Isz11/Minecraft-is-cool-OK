package me.isz.spawnplugin;

import me.isz.spawnplugin.commands.SetSpawnCommands;
import me.isz.spawnplugin.commands.SpawnCommand;
import me.isz.spawnplugin.listeners.SpawnListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Optional;

public final class SpawnPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        //config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommands(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getServer().getPluginManager().registerEvents(new SpawnListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
