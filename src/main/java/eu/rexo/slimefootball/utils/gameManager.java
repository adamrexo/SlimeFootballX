package eu.rexo.slimefootball.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class gameManager {
    private boolean gameRunning = false;

    dbManager db = new dbManager();

    public void checkPlayerCount() {
        int onlinePlayers = Bukkit.getServer().getOnlinePlayers().size();
        if (onlinePlayers >= 2 && !gameRunning) {
            startGame();
        }
    }

    private void startGame() {
        gameRunning = true;

        for (Player target : Bukkit.getOnlinePlayers()) {
            Bukkit.getConsoleSender().sendMessage("Game startingggggg"); // Send message also to console
            target.sendMessage("§4Game startingggggg");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        for (Player target : Bukkit.getOnlinePlayers()) {
            target.sendTitle("Starting in", "3...");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        for (Player target : Bukkit.getOnlinePlayers()) {
            target.sendTitle("Starting in", "2...");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
        for (Player target : Bukkit.getOnlinePlayers()) {
            target.sendTitle("Starting in", "1...");
        }

        Player[] players = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0]);
        if (players.length > 0) {
            int halfway = players.length / 2;
            Player[] group1 = new Player[halfway];
            Player[] group2 = new Player[players.length - halfway];
            System.arraycopy(players, 0, group1, 0, halfway);
            System.arraycopy(players, halfway, group2, 0, players.length - halfway);

            groupTP(group1, new Location(Bukkit.getWorld("world"), 166.5, 123.0, 238.5));
            groupTP(group2, new Location(Bukkit.getWorld("world"), 184.5, 123.0, 238.5));
        }

        World world = Bukkit.getWorld("world");

        slimeSpawning slime = new slimeSpawning();
        Location loc = new Location(world, 174.5, 123.0, 238.5);

        slime.spawn(loc);
    }

    public void groupTP(Player[] players, Location location) {
        for (Player player : players) {
            player.teleport(location);
            db.pridatHry(player.getDisplayName(), String.valueOf(player.getUniqueId()), 1);
        }
    }
}
