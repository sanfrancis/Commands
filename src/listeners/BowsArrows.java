package listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.ArrayList;

import static org.bukkit.event.EventPriority.HIGH;

/**
 * Created by Max on 19.06.15.
 */
public class BowsArrows implements Listener {

    ArrayList<String> list = new ArrayList<String>();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onShoot(EntityShootBowEvent e) {
        Player p = (Player) e.getEntity();

        if (p.hasPermission("sP.bows")) {
            if (p.isSneaking()) {
                if (p.getItemInHand().hasItemMeta()) {
                    list.add(p.getItemInHand().getItemMeta().getDisplayName());

                }
            }
        }
    }

    @EventHandler(priority = HIGH)
    public void onHit(ProjectileHitEvent e) {

        Player p = (Player) e.getEntity().getShooter();
        Arrow a = (Arrow) e.getEntity();
        Location loc = a.getLocation();

        String tp;
        tp = new String("§2TeleportBow");

        String ex;
        ex = new String("§1ExplosionBow");

        String li;
        li = new String("§eLightningBow");

        String bb;
        bb = new String("§4DamageBow");


        double x = a.getLocation().getX();

        double y = a.getLocation().getY();

        double z = a.getLocation().getZ();

        if (p.isSneaking()) {
            if (list.contains(tp)) {
                p.teleport(loc);
                p.damage(4.0);
                list.remove(tp);

            }
            if (list.contains(ex)) {
                p.getWorld().createExplosion(x, y, z, 3, false, false);
                p.damage(4.0);
                list.remove(ex);

            }

            if (list.contains(li)) {
                p.getWorld().strikeLightningEffect(loc);
                p.damage(4.0);
                list.remove(li);

            }

            if (list.contains(bb)) {
                if (a.getLocation().add(0, -1, 0).getBlock().getType() != Material.BEDROCK) {
                    a.getLocation().add(0, -1, 0).getBlock().breakNaturally();
                    p.damage(4.0);
                    list.remove(bb);
                }

            }


        }
    }
}


