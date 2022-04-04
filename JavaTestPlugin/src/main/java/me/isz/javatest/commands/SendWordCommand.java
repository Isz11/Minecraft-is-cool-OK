package me.isz.javatest.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SendWordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                // player.sendMessage(args[0]);
                if (args[0].equalsIgnoreCase("garbage")) {
                    player.sendMessage("Congratulations, " + args[0] + "is the correct word.");
                }
            } else {
                player.sendMessage("You need to give the command an argument.");
                player.sendMessage("/sendword <word>");
            }
        } else {
            System.out.println("You need to be a player to execute this command");
        }

        return false;
    }
}
