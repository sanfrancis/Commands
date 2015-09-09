package listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Max on 16.06.15.
 */
public class LightningOnDeath implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void onDeath(PlayerDeathEvent event){

        Player p = event.getEntity().getPlayer();
        Location loc = p.getLocation();

        p.getWorld().strikeLightningEffect(loc);
    }
}
