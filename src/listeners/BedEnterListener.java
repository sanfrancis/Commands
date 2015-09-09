package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

/**
 * Created by Max on 11.06.15.
 */
public class BedEnterListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void BedEnter(PlayerBedEnterEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("§6Sleep well, "+p.getName()+" §6!");
    }
}