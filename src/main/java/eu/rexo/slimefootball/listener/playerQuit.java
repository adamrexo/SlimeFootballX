package eu.rexo.slimefootball.listener;

import eu.rexo.slimefootball.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class playerQuit implements Listener {
    private Main main;

    public playerQuit(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        for (Player target : Bukkit.getOnlinePlayers()) {
            Bukkit.getConsoleSender().sendMessage(Bukkit.getOnlinePlayers().size()-1 + "/2");
            target.sendMessage(Bukkit.getOnlinePlayers().size() + "/2");
        }

        main.countCheck();
    }
}
