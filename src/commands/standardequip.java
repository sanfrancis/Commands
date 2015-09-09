package commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Max on 19.06.15.
 */
public class standardequip implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("se")) {

            if (sender instanceof ConsoleCommandSender) {
                System.out.println("Only Players can use this Command!");
                return true;
            }
            Player p = (Player) sender;

            if (args.length == 0) {
                if (!(p.hasPermission("sP.se"))) {
                    p.sendMessage("§4You aren´t allowed to use this command!");

                }
                p.getInventory().addItem(new ItemStack(Material.WORKBENCH));
                p.getInventory().addItem(new ItemStack(Material.ENCHANTMENT_TABLE));
                p.getInventory().addItem(new ItemStack(Material.ANVIL));
                p.sendMessage("§6Succesfully added some useful Stuff to your inventory!");
                return true;

            }


        }
        return false;
    }
}
