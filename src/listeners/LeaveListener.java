package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by Max on 08.07.15.
 */
public class LeaveListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onQuit(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        event.setQuitMessage("§c<< §F"+player.getName()+ " has left!");
    }
}
