package listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Max on 06.07.15.
 */
public class BowOpenGuiListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK | event.getAction() == Action.RIGHT_CLICK_AIR){
            if(player.isSneaking()) {
                if (player.hasPermission("sP.open.BowGui")) {
                    if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Bow")) {
                        Inventory BowGui = player.getServer().createInventory(null, 54, "§6Choose your type of Arrow!");

                        ItemStack EnderArrow = new ItemStack(Material.ENDER_PEARL);
                        ItemMeta metaender = EnderArrow.getItemMeta();
                        metaender.setDisplayName("§1Use a EnderArrow");
                        EnderArrow.setItemMeta(metaender);

                        ItemStack Explosionarrow = new ItemStack(Material.SULPHUR);
                        ItemMeta metaexplosion = Explosionarrow.getItemMeta();
                        metaexplosion.setDisplayName("§2Use a ExplosionArrow");
                        Explosionarrow.setItemMeta(metaexplosion);

                        ItemStack LightningArrow = new ItemStack(Material.BLAZE_ROD);
                        ItemMeta metalightning = LightningArrow.getItemMeta();
                        metalightning.setDisplayName("");
                        LightningArrow.setItemMeta(metalightning);

                        BowGui.setItem(4, EnderArrow);

                        player.openInventory(BowGui);
                    }
                }
            }
        }

    }
}
