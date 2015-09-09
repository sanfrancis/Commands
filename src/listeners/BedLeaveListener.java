package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

/**
 * Created by Max on 11.06.15.
 */
public class BedLeaveListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void BedLeave(PlayerBedLeaveEvent e){
        Player p = e.getPlayer();
        p.sendMessage("§6Good morning "+p.getName()+", have a nice day");
    }
}
