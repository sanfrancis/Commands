package commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Max on 05.07.15.
 */
public class teamitem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("teamitem")){
            if(sender instanceof ConsoleCommandSender){
            System.out.println("Only players can use this command!");
                return true;

            }
            Player player = (Player) sender;

            ItemStack teamitem = new ItemStack(Material.DIAMOND_HOE);
            ItemMeta metateamitem = teamitem.getItemMeta();
            metateamitem.setDisplayName("§6Choose Your Team!");
            teamitem.setItemMeta(metateamitem);

            if(player.hasPermission("sp.teamitem")){
                player.getInventory().addItem(new ItemStack(teamitem));
                player.sendMessage("§6Succesfully added the item for team-selecting to your inventory. Right click to choose!");
                return true;

            }
        }
        return true;
    }
}
