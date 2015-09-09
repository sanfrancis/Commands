package listeners;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;



/**
 * Created by Max on 06.07.15.
 */
public class ArrowListener extends BowGuiListener implements Listener  {

    @EventHandler(priority = EventPriority.HIGH)
    public void onArrowHit(ProjectileHitEvent event) {
        Arrow arrow = (Arrow) event.getEntity();
        Player player = (Player) arrow.getShooter();
        if(player.hasPermission("sP.bow.use.ender")) {
            if(Arrow_Ender.contains(player.getName())) {
                Location location = arrow.getLocation();
                player.teleport(location);
                player.damage(0);
                player.setHealth(player.getHealth()- 2);
                player.sendMessage("§1You were teleported!");
                System.out.println("Somebody was teleported to " + location);

            }
        }


    }
}
