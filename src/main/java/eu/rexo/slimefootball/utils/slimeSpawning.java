package eu.rexo.slimefootball.utils;

import org.bukkit.Location;
import org.bukkit.entity.*;
import org.bukkit.potion.*;

public class slimeSpawning {
    public void spawn(Location location) {
        Slime slime = (Slime) location.getWorld().spawnEntity(location, EntityType.SLIME);

        slime.setSize(1);

        slime.setGravity(false);

        slime.setGlowing(true);

        PotionEffectType effType = PotionEffectType.SLOW;
        PotionEffect potEff = new PotionEffect(effType, 999999999, 256);
        slime.addPotionEffect(potEff);

        slime.setInvulnerable(true);
        slime.setAbsorptionAmount(99999.0);
        slime.setSilent(true);
    }
}
