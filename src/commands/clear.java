package commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Max on 13.06.15.
 */
public class clear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("clear")) {

            if (sender instanceof ConsoleCommandSender) {
                System.out.println("Only Players can use this Command!");
                return true;
            }
            Player p = (Player) sender;

            if (args.length == 0) {
                if (!(p.hasPermission("sP.clear"))) {
                    p.sendMessage("§4You aren´t allowed to use this command!");
                    return true;
                }
                p.getInventory().clear();
                p.sendMessage("§6Succesfully cleared your Inventory");
                return true;

            }

            if (args.length == 1) {
                if (!(p.hasPermission("sP.clear.other"))) {
                    p.sendMessage("§4You aren´t allowed to use this command!");
                    return true;

                }
                Player a = p.getServer().getPlayer(args[0]);
                a.getInventory().clear();
                p.sendMessage("§6Succesfully cleared the Inventory of §1" + a.getName() + " §6!");
                a.sendMessage("§6Your Inventory was cleared by §1" + p.getName() + " §6! ");
                return true;
            }
        }
        return false;
    }
}