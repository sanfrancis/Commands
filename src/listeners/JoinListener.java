package listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by Max on 08.06.15.
 */
public class JoinListener implements Listener {

    FileConfiguration cfg;

    public JoinListener(FileConfiguration config) {
        cfg = config;
    }

    @EventHandler(priority= EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.setDisplayName("Test");
        event.setJoinMessage("§2>> §F" + player.getName()+" has joined!");

    }
}
