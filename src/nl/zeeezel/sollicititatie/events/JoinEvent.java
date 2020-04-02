package nl.zeeezel.sollicititatie.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import nl.zeeezel.sollicititatie.menu.MenuManager;

public class JoinEvent implements Listener {
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
	
		Player p = e.getPlayer();	
		ItemStack compass = new ItemStack(Material.CHEST);
		ItemMeta compassmeta = compass.getItemMeta();
		
			compassmeta.setDisplayName(ChatColor.RED + "Menu");
		compass.setItemMeta(compassmeta);
		p.getInventory().setItem(4, compass);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void click(PlayerInteractEvent e) {
		
		if(e.getPlayer().getItemInHand() != null) {
		if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().contains(ChatColor.RED + "Menu")) {
		e.getPlayer().openInventory((MenuManager.getMenu("hoofdmenu")).inv);
		e.setCancelled(true);
		
		}
		}
	}
}
