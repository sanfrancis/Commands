package commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by Max on 29.06.15.
 */
public class freeze implements CommandExecutor {

    public static ArrayList<String> freezelist = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("freeze")){
            if(sender instanceof Player) {

                Player player = (Player) sender;

                if(player.hasPermission("sP.freeze")) {
                    if(args.length == 0){
                        player.sendMessage("§4You have to use /freeze <player>");
                        return true;

                    }else if(args.length == 1){
                        Player target = Bukkit.getPlayer(args[0]);
                            freezelist.add(target.getName());
                            target.sendMessage("§6You got frozen by §1" + player.getName() + " §6and can not" +
                                    " move until you get unfrozen!");
                            return true;
                    }


                }else{
                    player.sendMessage("§4You aren´t allowed to use this command!");
                    return true;
                }
            }
        }
        return false;
    }
}
