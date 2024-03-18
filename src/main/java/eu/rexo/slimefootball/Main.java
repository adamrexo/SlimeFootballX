package eu.rexo.slimefootball;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import eu.rexo.slimefootball.listener.*;
import eu.rexo.slimefootball.utils.*;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new slimeVelocity(), this);
        getServer().getPluginManager().registerEvents(new slimeBrana(), this);

        slimeSpawning slime = new slimeSpawning();
        World world = Bukkit.getWorld("world");
        Location loc = new Location(world, 4.5, 123.0, -0.5);
        slime.spawn(loc);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
