package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Max on 20.06.15.
 */
public class day implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("day")) {

            Player p = (Player) sender;

            if (args.length == 0) {
                if (!(p.hasPermission("sP.day"))) {
                    p.sendMessage("§4You aren´t allowed to use this command!");
                }

                p.getWorld().setTime(26000);
                p.sendMessage("§6Succesfully changed to day!");
                return true;
            }
        }
        return false;
    }
}