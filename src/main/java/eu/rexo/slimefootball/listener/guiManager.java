package eu.rexo.slimefootball.listener;

import eu.rexo.slimefootball.utils.dbManager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class guiManager implements Listener {
    private static Inventory statsMenu;
    private static dbManager databaseManager;

    public guiManager() {
        databaseManager = new dbManager();
        statsMenu = Bukkit.createInventory(null, 9, "Stats");
    }

    public static void openMainMenu(Player player) {
        player.openInventory(statsMenu);
        updateStatsMenu(player.getName());
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        if (event.getInventory().equals(statsMenu) && event.getPlayer() instanceof Player) {
            Player player = (Player) event.getPlayer();
            String playerName = player.getName();
            updateStatsMenu(playerName);
        }
    }

    private static void updateStatsMenu(String playerName) {
        ItemStack chestItem = new ItemStack(Material.CHEST, 1);
        ItemMeta chestMeta = chestItem.getItemMeta();
        if (chestMeta != null) {
            chestMeta.setDisplayName("§r§9" + playerName + " Staty");
            List<String> lore = new ArrayList<>();
            lore.add("§r§1odehrane hry: §r§3" + databaseManager.ziskatHry(playerName));
            lore.add("§r§1goly: §r§3" + databaseManager.ziskatGoly(playerName));
            lore.add("§r§1punche do slima: §r§3" + databaseManager.ziskatPunche(playerName));
            chestMeta.setLore(lore);
            chestItem.setItemMeta(chestMeta);
        }
        statsMenu.setItem(4, chestItem);
    }
}
