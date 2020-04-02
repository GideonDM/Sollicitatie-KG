package nl.zeeezel.sollicititatie.menu;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuManager implements Listener{
	
	private static Map<String, Menu> menulist = new HashMap<>();
	
	public MenuManager() {
		registerMenu("gadget", new GadgetMenu(ChatColor.RED + "Particle menu", 9));
		registerMenu("hoofdmenu", new HoofdMenu(ChatColor.RED + "Hoofdmenu", 9));
		
	}
	
	public static void registerMenu(String id, Menu menu) {
		menulist.put(id, menu);
	}
	
	public static Menu getMenu(String id) {
		
		return menulist.get(id);
		
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getWhoClicked() instanceof Player) {
			if(e.getInventory().getName() != null && e.getCurrentItem() != null) {
				for(Menu menus : menulist.values()) {
					if(e.getInventory().getName().equals(menus.inv.getName())) {
						Player p = (Player) e.getWhoClicked();
						menus.click(e.getCurrentItem(), p);
						e.setCancelled(true);
					}
				}
			}
		}
	}
	

}
