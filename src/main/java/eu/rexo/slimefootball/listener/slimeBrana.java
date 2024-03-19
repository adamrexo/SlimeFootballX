package eu.rexo.slimefootball.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.*;

import eu.rexo.slimefootball.utils.*;

public class slimeBrana implements Listener {
    private gameManager game;
    private dbManager db;
    Player player;


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        player = event.getPlayer();
        this.game = new gameManager();
        this.db = new dbManager();
        World world = Bukkit.getWorld("world");
        Location playerLocation = player.getLocation();

        if (slimeCheck(player, playerLocation.getWorld(),160.0, 123.0, 163.0, 127.0)) { // tym 1
            pridatGol(player);
            pridatPunch(player);
            for (Player target : Bukkit.getOnlinePlayers()) {
                Bukkit.getConsoleSender().sendMessage("Tym 1 dal gol");
                target.sendMessage("Tym 1 dal gol");
                for (Entity entity : world.getEntities()) {
                    if (entity.getType() == EntityType.SLIME) {
                        Location location = new Location(world, 174.5, 123.0, 238.5);
                        entity.teleport(location);
                    }
                }
            }
        }

        else if (slimeCheck(player, playerLocation.getWorld(),187.0, 123.0, 190.0, 127.0)) { // tym 2
            pridatGol(player);
            pridatPunch(player);
            for (Player target : Bukkit.getOnlinePlayers()) {
                Bukkit.getConsoleSender().sendMessage("Tym 2 dal gol");
                target.sendMessage("Tym 2 dal gol");
                for (Entity entity : world.getEntities()) {
                    if (entity.getType() == EntityType.SLIME) {
                        Location location = new Location(world, 174.5, 123.0, 238.5);
                        entity.teleport(location);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity entity = event.getEntity();

        if (entity instanceof Slime && damager instanceof Player) {
            Player player = (Player) damager;
            pridatPunch(player);
        }
    }

    private void pridatGol(Player player) {
        String playerName = player.getName();
        String uuid = player.getUniqueId().toString();

        db.pridatGol(playerName, uuid, 1);
    }

    private void pridatPunch(Player player) {
        String playerName = player.getName();
        String uuid = player.getUniqueId().toString();

        db.pridatPunche(playerName, uuid, 1);
    }

    private boolean slimeCheck(Player player, World world, double minX, double minY, double maxX, double maxY) {
        for (Entity entity : world.getEntities()) {
            if (entity.getType() == EntityType.SLIME && entityInRegion(entity, minX, minY, maxX, maxY)) {
                return true;
            }
        }
        return false;
    }

    private boolean entityInRegion(Entity entity, double xmin, double ymin, double xmax, double ymax) {
        Location loc = entity.getLocation();

        return xmin <= loc.getX() && xmax >= loc.getX() && ymin <= loc.getY() && ymax >= loc.getY();
    }

}
