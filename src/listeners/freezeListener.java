package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import commands.freeze;

/**
 * Created by Max on 29.06.15.
 */
public class freezeListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if(freeze.freezelist.contains(player.getName())){
            event.setCancelled(true);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void BlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(freeze.freezelist.contains(player.getName())){
        }
    }

}
