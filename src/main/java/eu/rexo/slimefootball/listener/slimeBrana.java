package eu.rexo.slimefootball.listener;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class slimeBrana implements Listener {
    Player player;
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        player = event.getPlayer();
        Location playerLocation = player.getLocation();

        if (slimeCheck(player, playerLocation.getWorld(),163.0, 123.0, 160.0, 127.0)) {
            player.chat("slime v brane 1");
        }
        else if (slimeCheck(player, playerLocation.getWorld(),187.0, 123.0, 190.0, 127.0)) {
            player.chat("slime v brane 2");
        }
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
