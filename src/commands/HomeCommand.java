package me.sanfrancis.commands;

import me.sanfrancis.main.Main;
import me.sanfrancis.util.Strings;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

/**
 * Created by Max on 27.10.15.
 */
public class HomeCommand implements CommandExecutor {

    public static final String HOME_DIR = Main.instance.getName() + "/homes" ;

    @Override
    public boolean onCommand ( CommandSender sender, Command command, String s, String[] arguments ) {

        if( command.getName().equalsIgnoreCase( "home" ) ) {

        } else if ( command.getName().equalsIgnoreCase( "sethome" ) ) {

        } else if ( command.getName().equalsIgnoreCase( "delhome" ) ) {

        }

    public static void sethome( Player player , String name) {
        if ( player == null ) {
            return;
        } else {
            File home_file = new File( HOME_DIR + "/" + player.getName() + ".yml" );
            if( home_file.exists () ) {

            } else {
                try {
                    home_file.createNewFile( );
                    YamlConfiguration cfg = YamlConfiguration.loadConfiguration( home_file );

                    Location location = player.getLocation();

                    cfg.set( name + ".X" , location.getBlockX() );
                    cfg.set( name + ".Y" , location.getBlockY( ) );
                    cfg.set( name + ".Z" , location.getBlockZ( ) );
                    cfg.set( name + ".Yaw" , location.getYaw( ) );
                    cfg.set( name + ".Pitch" , location.getPitch( ) );
                    cfg.set( name + ".World" , location.getWorld( ) );

                    cfg.save( home_file );
                    player.sendMessage( Strings.PREFIX + ChatColor.GOLD + "Your home was set!" );

                } catch ( IOException exception ) {
                    exception.printStackTrace();
                    player.sendMessage( Strings.PREFIX + ChatColor.RED + ChatColor.BOLD + " Error: " + ChatColor.RESET + "Your Home could not be set!" );
                }
            }
        }

        }

    }

    public static void checkHomeFolder() {
        File dir = new File( HOME_DIR );
        if ( !dir.exists() ) {
            dir.mkdir();
        }


    }



}


