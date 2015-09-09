package commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Max on 17.06.15.
 */
public class gamemodes implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("gm")) {

            if (sender instanceof ConsoleCommandSender) {
                System.out.println("Only Players can use this Command!");

                return true;
            }
            Player p = (Player) sender;

            if (args.length == 0) {
                if(!(p.hasPermission("sP.gm"))){
                    p.sendMessage("§4You aren´t allowed to use this command!");
                }
                if(p.getGameMode() == GameMode.SURVIVAL){
                    p.setGameMode(GameMode.CREATIVE);
                    p.sendMessage("§6Succesfully changed Gamemode!");
                    return true;

                }
                if(p.getGameMode() == GameMode.CREATIVE){
                    p.setGameMode(GameMode.SURVIVAL);
                    p.sendMessage("§6Succesfully changed Gamemode!");
                    return true;
                }


            }
        }
        return false;
    }
}
