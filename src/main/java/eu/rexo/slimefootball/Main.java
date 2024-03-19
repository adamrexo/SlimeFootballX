package eu.rexo.slimefootball;

import eu.rexo.slimefootball.cmds.stats;
import org.bukkit.plugin.java.JavaPlugin;
import eu.rexo.slimefootball.listener.*;
import eu.rexo.slimefootball.utils.*;

public class Main extends JavaPlugin {
    private gameManager game;
    private dbManager db = new dbManager();

    @Override
    public void onEnable() {
        db.createTable();
        getCommand("stats").setExecutor(new stats());

        getServer().getPluginManager().registerEvents(new slimeVelocity(), this);
        getServer().getPluginManager().registerEvents(new slimeBrana(), this);

        getServer().getPluginManager().registerEvents(new guiManager(), this);

        getServer().getPluginManager().registerEvents(new playerQuit(this), this);
        getServer().getPluginManager().registerEvents(new playerJoin(this), this);

        this.game = new gameManager();
        }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void countCheck() {
        game.checkPlayerCount();
    }
}
