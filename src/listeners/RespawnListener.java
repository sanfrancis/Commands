package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created by Max on 11.06.15.
 */
public class RespawnListener implements Listener {

    @EventHandler(priority = EventPriority.HIGH)
    public void Respawn(PlayerRespawnEvent event){
        Player p = event.getPlayer();
        //p.sendMessage("§4Bitte versuche diesmal länger zu leben, Lappen!");
    }
}
