package eu.rexo.slimefootball.listener;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

public class slimeVelocity implements Listener {
    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Slime) {
            Slime slime = (Slime) event.getEntity();
            double knockbackMultiplier = 1.2;

            Vector knockback = event.getDamager().getLocation().getDirection().multiply(knockbackMultiplier);
            slime.setVelocity(knockback);

            event.setCancelled(true);
        }
    }
}
