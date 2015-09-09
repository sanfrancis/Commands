package listeners;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;

/**
 * Created by Max on 06.07.15.
 */
public class BowGuiListener implements Listener {

    public ArrayList<String> Arrow_Ender = new ArrayList<>();

    @EventHandler(priority = EventPriority.HIGH)
    public void onBowGuiClick(InventoryClickEvent event) {
        Player clicker = (Player) event.getWhoClicked();
        if(event.getInventory().getName().equalsIgnoreCase("§6Choose your type of Arrow!")) {
            event.setCancelled(true);
            if (clicker.hasPermission("sP.arrows.choose")) {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§1Use a EnderArrow")) {
                    if (Arrow_Ender.contains(clicker.getName())) {
                        clicker.sendMessage("§4You have already equipped EnderArrows!");
                        clicker.closeInventory();
                    } else if (!(Arrow_Ender.contains(clicker.getName()))) {
                        Arrow_Ender.add(clicker.getName());
                        //clicker.sendMessage("§1You have choosen EnderArrows");
                        clicker.closeInventory();
                        clicker.playEffect(clicker.getLocation(), Effect.ENDER_SIGNAL, 3) ;
                        clicker.playSound(clicker.getLocation(), Sound.ENDERDRAGON_WINGS, 3, 2);
                    }


                }
            }
        }
    }
}
