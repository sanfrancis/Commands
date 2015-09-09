package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Max on 20.06.15.
 */
public class night implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("night")) {

            Player p = (Player) sender;

            if (args.length == 0) {
                if (!(p.hasPermission("sP.night"))) {
                    p.sendMessage("§4You aren´t allowed to use this command!");

                }

                p.getWorld().setTime(13000);
                p.sendMessage("§6Succesfully changed to night!");
                return true;
            }
        }
        return false;
    }
}