package listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Max on 06.07.15.
 */
public class ClickInChooseInventory implements Listener {
    public ArrayList<UUID> team_blue = new ArrayList<>();
    public ArrayList<UUID> team_red = new ArrayList<>();
    public ArrayList<UUID> team_yellow = new ArrayList<>();
    public ArrayList<UUID> team_green = new ArrayList<>();


    @EventHandler(priority = EventPriority.HIGH)
    public void onInvClick(InventoryClickEvent event) {
        if(event.getInventory().getName().equalsIgnoreCase("§6Choose your Team!")) {
            event.setCancelled(true);

            Player clicker = (Player) event.getWhoClicked();
            if(clicker.hasPermission("sP.team.choose")) {
                if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3Team Blue")) {
                    if(team_blue.contains(clicker.getUniqueId())){
                        clicker.sendMessage("§4[Error] §FYou are already in §3Team Blue §F!");
                        clicker.closeInventory();
                    } else if(team_red.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §cTeam red §F!");
                        clicker.closeInventory();
                    } else if(team_green.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §2Team green §F!");
                        clicker.closeInventory();
                    } else if(team_yellow.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §eTeam yellow §F!");
                        clicker.closeInventory();
                    } else if (!(team_blue.contains(clicker.getUniqueId()))) {
                        team_blue.add(clicker.getUniqueId());
                        clicker.sendMessage("Succesfully added you to §3Team Blue");
                        System.out.println("Added " + clicker.getName() + " to the blue Team");
                        clicker.closeInventory();
                    }
                }

                else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cTeam Red")) {

                    if (team_red.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §cTeam Red §F!");
                        clicker.closeInventory();
                    } else if(team_blue.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §3Team blue §F!");
                        clicker.closeInventory();
                    } else if(team_green.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §2Team green §F!");
                        clicker.closeInventory();
                    } else if(team_yellow.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §eTeam yellow §F!");
                        clicker.closeInventory();
                    } else if (!(team_red.contains(clicker.getUniqueId()))) {
                        team_red.add(clicker.getUniqueId());
                        clicker.sendMessage("Succesfully added you to §cTeam Red");
                        System.out.println("Added " + clicker.getName() + " to the red Team");
                        clicker.closeInventory();

                    }
                }

                else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eTeam Yellow")) {

                    if (team_yellow.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §eTeam Yellow §F!");
                        clicker.closeInventory();
                    } else if(team_blue.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §3Team blue §F!");
                        clicker.closeInventory();
                    } else if(team_red.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §cTeam red §F!");
                        clicker.closeInventory();
                    } else if(team_green.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §2Team green §F!");
                        clicker.closeInventory();
                    } else if (!(team_yellow.contains(clicker.getUniqueId()))) {
                        team_yellow.add(clicker.getUniqueId());
                        clicker.sendMessage("Succesfully added you to §eTeam Yellow");
                        System.out.println("Added " + clicker.getName() + " to the yellow Team");
                        clicker.closeInventory();

                    }
                }

                else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§2Team Green")) {

                    if (team_green.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §2Team Green §F!");
                        clicker.closeInventory();
                    } else if(team_blue.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §3Team blue §F!");
                        clicker.closeInventory();
                    } else if(team_red.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §cTeam red §F!");
                        clicker.closeInventory();
                    } else if(team_yellow.contains(clicker.getUniqueId())) {
                        clicker.sendMessage("§4[Error] §FYou are already in §eTeam yellow §F!");
                        clicker.closeInventory();
                    } else if (!(team_green.contains(clicker.getUniqueId()))) {
                        team_green.add(clicker.getUniqueId());
                        clicker.sendMessage("Succesfully added you to §2Team Green");
                        System.out.println("Added " + clicker.getName() + " to the green Team");
                        clicker.closeInventory();

                    }
                }

                else if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Remove from your team!")) {

                    if(team_blue.contains(clicker.getUniqueId())) {
                        team_blue.remove(clicker.getUniqueId());
                        clicker.sendMessage("Succesfully removed you from §3Team Blue");
                        clicker.closeInventory();
                    }
                    else if(team_red.contains(clicker.getUniqueId())) {
                        team_red.remove(clicker.getUniqueId());
                        clicker.sendMessage("Succesfully removed you from §cTeam Red");
                        clicker.closeInventory();
                    }
                    else if(team_green.contains(clicker.getUniqueId())) {
                        team_green.remove(clicker.getUniqueId());
                        clicker.sendMessage("Succesfully removed you from §2Team Green");
                        clicker.closeInventory();
                    }
                    else if(team_yellow.contains(clicker.getUniqueId())) {
                        team_yellow.remove(clicker.getUniqueId());
                        clicker.sendMessage("Succesfully removed you from §eTeam Yellow");
                        clicker.closeInventory();
                    }
                }

            }
        }
    }
}
