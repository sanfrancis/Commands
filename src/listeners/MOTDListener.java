package listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

/**
 * Created by Max on 20.07.15.
 */
public class MOTDListener implements Listener {
    public String motd = "The Localhost Server of sanfrancis!";

    @EventHandler
    public void onMOTD(ServerListPingEvent event) {
        event.setMotd(motd);

    }
}
