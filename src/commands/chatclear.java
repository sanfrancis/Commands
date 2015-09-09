package commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Max on 07.07.15.
 */
public class chatclear implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("chatclear")) {

            if (sender instanceof ConsoleCommandSender) {
                System.out.println("Only Players can use this Command!");
                return true;
            }
            Player player = (Player) sender;
            Player target = (Player) player.getServer().getPlayer(args[0]);

            if (args.length == 0) {
                player.sendMessage("§4Use /<chatclear> <player");

            }


            if (args.length == 1) {
                if (!(player.hasPermission("sP.chatclear"))) {
                    player.sendMessage("§4You aren´t allowed to use this command!");
                    return true;

                }
                player.sendMessage("§6Succesfully cleared " + target.getName() + "´s chat");
                for (int i = 0; i < 1337; i++) {
                    target.sendMessage(" ");
                }
            }
        }
        return false;
    }
}