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
 * Created by Max on 09.07.15.
 */
public class command_SpecialBow implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        if (cmd.getName().equalsIgnoreCase("bow")) {

            if (sender instanceof ConsoleCommandSender) {
            System.out.println("Only Players can use this Command!");
            return true;
            }

            Player p = (Player) sender;

            if (args.length == 0) {
                if (!(p.hasPermission("sP.give.specialbow"))) {
                    p.sendMessage("§4You aren´t allowed to use this command!");

                }

                ItemStack SpecialBow = new ItemStack(Material.BOW);
                ItemMeta metaSpecialBow = SpecialBow.getItemMeta();
                metaSpecialBow.setDisplayName("§6Bow");
                SpecialBow.setItemMeta(metaSpecialBow);

                p.getInventory().addItem(SpecialBow);
                return true;
            }

        }

    return true;
    }
}
