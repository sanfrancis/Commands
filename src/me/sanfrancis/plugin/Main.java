package me.sanfrancis.plugin;

import commands.*;
import listeners.*;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    public void onEnable(){
        System.out.println("Succesfully activated sanfrancisPlugin!");

        config();

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new JoinListener(this.getConfig()), this);
        pm.registerEvents(new BedEnterListener(), this);
        pm.registerEvents(new BedLeaveListener(), this);
        pm.registerEvents(new RespawnListener(), this);
        pm.registerEvents(new LightningOnDeath(), this);
        //pm.registerEvents(new BowsArrows(), this);
        pm.registerEvents(new HeadatKill(), this);
        pm.registerEvents(new freezeListener(), this);
        pm.registerEvents(new InteractItemsListener(), this);
        pm.registerEvents(new ClickInChooseInventory(), this);
        pm.registerEvents(new BowGuiListener(), this);
        pm.registerEvents(new BowOpenGuiListener(), this);
        pm.registerEvents(new ArrowListener(), this);
        pm.registerEvents(new KickListener(), this);
        pm.registerEvents(new LeaveListener(), this);



        this.getCommand("heal").setExecutor(new heal());
        this.getCommand("clear").setExecutor(new clear());
        this.getCommand("gm").setExecutor(new gamemodes());
        this.getCommand("se").setExecutor(new standardequip());
        this.getCommand("day").setExecutor(new day());
        this.getCommand("night").setExecutor(new night());
        this.getCommand("freeze").setExecutor(new freeze());
        this.getCommand("unfreeze").setExecutor(new unfreeze());
        this.getCommand("teamitem").setExecutor(new teamitem());
        this.getCommand("chatclear").setExecutor(new chatclear());
        this.getCommand("bow").setExecutor(new command_SpecialBow());


        this.createSpecialBow();


    }

    public void onDisable(){
        System.out.println("Succesfully deactivated sanfrancisPlugin!");

    }


    public void config(){
        this.getConfig().addDefault("JoinMessage", " §6hat den Server betreten!");
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

    public void createSpecialBow() {

        ItemStack SpecialBow = new ItemStack(Material.BOW);
        ItemMeta metaSpecialBow = SpecialBow.getItemMeta();
        metaSpecialBow.setDisplayName("§6Bow");
        SpecialBow.setItemMeta(metaSpecialBow);

        ShapedRecipe rBow = new ShapedRecipe(SpecialBow);

        rBow.shape("DDD", "GBG", "EEE");
        rBow.setIngredient('D', Material.DIAMOND_BLOCK);
        rBow.setIngredient('G', Material.GOLD_BLOCK);
        rBow.setIngredient('B', Material.BOW);
        rBow.setIngredient('E', Material.EMERALD_BLOCK);

        this.getServer().addRecipe(rBow);

    }

    public void createTeleportBow() {

        ItemStack result = new ItemStack(Material.BOW);
        result.setAmount(1);
        ItemMeta meta = result.getItemMeta();
        meta.setDisplayName("§1TeleportBow");
        result.setItemMeta(meta);

        ShapedRecipe r = new ShapedRecipe(result);

        r.shape("DED", "DBD", "DDD");
        r.setIngredient('B', Material.BOW);
        r.setIngredient('E', Material.ENDER_PEARL);
        //r.setIngredient('D', Material.DIAMOND_BLOCK);


        this.getServer().addRecipe(r);
    }

    public void createExplosionBow() {

        ItemStack result = new ItemStack(Material.BOW);
        result.setAmount(1);
        ItemMeta meta = result.getItemMeta();
        meta.setDisplayName("§2ExplosionBow");
        result.setItemMeta(meta);

        ShapedRecipe r = new ShapedRecipe(result);

        r.shape("DSD", "DBD", "DDD");
        r.setIngredient('B', Material.BOW);
        r.setIngredient('S', Material.SULPHUR);
        //r.setIngredient('D', Material.DIAMOND_BLOCK);


        this.getServer().addRecipe(r);

    }

    public void createLightningBow() {

        ItemStack result = new ItemStack(Material.BOW);
        result.setAmount(1);
        ItemMeta meta = result.getItemMeta();
        meta.setDisplayName("§eLightningBow");
        result.setItemMeta(meta);

        ShapedRecipe r = new ShapedRecipe(result);

        r.shape("DED", "DBD", "DDD");
        r.setIngredient('B', Material.BOW);
        r.setIngredient('E', Material.BLAZE_ROD);
        //r.setIngredient('D', Material.DIAMOND_BLOCK);


        this.getServer().addRecipe(r);
    }

    public void createDamageBow() {

        ItemStack result = new ItemStack(Material.BOW);
        result.setAmount(1);
        ItemMeta meta = result.getItemMeta();
        meta.setDisplayName("§4DamageBow");
        result.setItemMeta(meta);

        ShapedRecipe r = new ShapedRecipe(result);

        r.shape("DPD", "DBD", "DDD");
        r.setIngredient('B', Material.BOW);
        r.setIngredient('P', Material.DIAMOND_PICKAXE);
        //r.setIngredient('D', Material.DIAMOND_BLOCK);


        this.getServer().addRecipe(r);

    }

    public void GlowStonefromGlowstoneBlocks(){

        ItemStack result = new ItemStack(Material.GLOWSTONE_DUST);
        result.setAmount(4);

        ShapelessRecipe r = new ShapelessRecipe(result);

        r.addIngredient(1, Material.GLOWSTONE);

        this.getServer().addRecipe(r);

    }

    public void ChickenSpawnStick(){

        ItemStack result = new ItemStack(Material.STICK);
        result.setAmount(1);
        ItemMeta meta = result.getItemMeta();
        meta.setDisplayName("SpawnChicken");
        result.setItemMeta(meta);

        ShapedRecipe r = new ShapedRecipe(result);

        r.shape("AAA", "ASA", "AFA");
        r.setIngredient('S', Material.STICK);
        r.setIngredient('F', Material.FEATHER);

        this.getServer().addRecipe(r);


    }
}