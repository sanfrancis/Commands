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
 * Created by Max on 05.07.15.
 */
public class InteractItemsListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(event.getAction() == Action.RIGHT_CLICK_AIR) {
            if(event.getMaterial().equals(Material.DIAMOND_HOE)) {

                Inventory ChooseTeamInv = player.getServer().createInventory(null, 9, "§6Choose your Team!");

                ItemStack teamblue = new ItemStack(Material.STAINED_CLAY, (short) 1, (short) 3);
                ItemMeta metablue = teamblue.getItemMeta();
                metablue.setDisplayName("§3Team Blue");
                teamblue.setItemMeta(metablue);

                ItemStack teamred = new ItemStack(Material.STAINED_CLAY, (short) 1, (short) 14);
                ItemMeta metared = teamred.getItemMeta();
                metared.setDisplayName("§cTeam Red");
                teamred.setItemMeta(metared);

                ItemStack teamyellow = new ItemStack(Material.STAINED_CLAY, (short) 1, (short) 4);
                ItemMeta metayellow = teamyellow.getItemMeta();
                metayellow.setDisplayName("§eTeam Yellow");
                teamyellow.setItemMeta(metayellow);

                ItemStack teamgreen = new ItemStack(Material.STAINED_CLAY, (short) 1, (short) 13);
                ItemMeta metagreen = teamgreen.getItemMeta();
                metagreen.setDisplayName("§2Team Green");
                teamgreen.setItemMeta(metagreen);

                ItemStack removefromteams = new ItemStack(Material.BARRIER);
                ItemMeta metaremove = removefromteams.getItemMeta();
                metaremove.setDisplayName("§7Remove from your team!");
                removefromteams.setItemMeta(metaremove);

                ChooseTeamInv.setItem(0, teamblue);
                ChooseTeamInv.setItem(2, teamred);
                ChooseTeamInv.setItem(4, removefromteams);
                ChooseTeamInv.setItem(6, teamyellow);
                ChooseTeamInv.setItem(8, teamgreen);

                player.openInventory(ChooseTeamInv);


            }
        }else if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Choose your Team!")) {
                event.setCancelled(true);
            }
        }
    }
}
