package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Max on 09.06.15.
 */
public class heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("heal")) {

            if (sender instanceof ConsoleCommandSender) {
                System.out.println("Only Players can use this Command!");

                return true;
            }
            Player p = (Player) sender;


            if (args.length == 0) {
                if (!(p.hasPermission("sP.heal"))) {
                    p.sendMessage("§4You aren´t allowed to use this command!");
                    return true;
                }

                p.setHealth(20.0);
                p.setFoodLevel((int) 20.0);
                p.sendMessage("§6Succesfully healed yourself");
                return true;
            }

            if (args.length == 1) {
                if (!(p.hasPermission("sP.heal.other"))) {
                    p.sendMessage("§4You aren´t allowed to use this command!");
                    return true;

                }
                Player a = p.getServer().getPlayer(args[0]);
                a.setHealth(20.0);
                a.setFoodLevel((int) 20.0);
                p.sendMessage("§6You have succesfully healed §1" + a.getName() + " §6!");
                a.sendMessage("§6You were healed by §1" + p.getName() + " §6!");
                return true;
            }
        }
        return false;
    }
}