package commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Max on 29.06.15.
 */
public class unfreeze implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("unfreeze")) {
            if (sender instanceof Player) {

                Player player = (Player) sender;

                if (player.hasPermission("sP.unfreeze")) {
                    if (args.length == 0) {
                        player.sendMessage("§4You have to use /unfreeze <player>");
                        return true;

                    } else if (args.length == 1) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(!(freeze.freezelist.contains(target.getName()))){
                            player.sendMessage("§4This player is not frozen!");
                            return true;
                        }else if (freeze.freezelist.contains(target.getName())) {
                            freeze.freezelist.remove(target.getName());
                            target.sendMessage("§6You are not frozen anymore and can move again!");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

