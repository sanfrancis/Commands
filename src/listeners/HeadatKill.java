package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Max on 29.06.15.
 */
public class HeadatKill implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onDeath(PlayerDeathEvent e) {
        if(e.getEntity().getKiller() instanceof Player){
            Player killer = e.getEntity().getKiller();

            ItemStack head = new ItemStack(397, 1, (short) 3);
            ItemMeta meta = head.getItemMeta();
            meta.setDisplayName("§6"+e.getEntity().getName());
            head.setItemMeta(meta);

            killer.getInventory().addItem(head);
        }
    }
}
