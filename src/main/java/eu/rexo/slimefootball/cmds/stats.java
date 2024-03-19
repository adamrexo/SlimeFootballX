package eu.rexo.slimefootball.cmds;

import eu.rexo.slimefootball.listener.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.sql.SQLException;

public class stats implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            guiManager.openMainMenu(player);
            return true;
        } else {
            sender.sendMessage("Tento příkaz může používat pouze hráč.");
            return false;
        }
    }
}