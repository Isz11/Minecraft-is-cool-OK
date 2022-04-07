package me.isz.javatest;

import me.isz.javatest.commands.*;
import me.isz.javatest.listeners.JoinLeaveListener;
import me.isz.javatest.listeners.ShearSheepListener;
import me.isz.javatest.listeners.XPBottleBreakListener;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JavaTest extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Plugin has started!");

        getServer().getPluginManager().registerEvents(new XPBottleBreakListener(), this);
        getServer().getPluginManager().registerEvents(new ShearSheepListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);

        getCommand("god").setExecutor(new GodCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("sendword").setExecutor(new SendWordCommand());
        getCommand("kill").setExecutor(new KillCommand());
        getCommand("fly").setExecutor(new FlyCommand(this));

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Plugin has stopped!");
    }
}
