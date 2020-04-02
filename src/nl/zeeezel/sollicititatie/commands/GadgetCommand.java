package nl.zeeezel.sollicititatie.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import nl.zeeezel.sollicititatie.menu.MenuManager;

public class GadgetCommand implements CommandExecutor {
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if (label.equalsIgnoreCase("gadgetmenu") && 
      sender instanceof Player) {
      Player p = (Player)sender;
      if (args.length == 1 && args[0].equalsIgnoreCase("open")) {
        p.openInventory((MenuManager.getMenu("gadget")).inv);
      } else {
        sendIndex(p);
      } 
    } 
    return false;
  }
  
  private void sendIndex(Player p) {
    p.sendMessage(ChatColor.RED + "Gebruik: /gadgetmenu open");
  }
}

