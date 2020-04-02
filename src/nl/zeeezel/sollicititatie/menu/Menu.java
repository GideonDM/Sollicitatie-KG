package nl.zeeezel.sollicititatie.menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public abstract class Menu {
	
	public Inventory inv;
	
	
	public Menu(String name, int size) {
		
		inv = Bukkit.createInventory(null, size, name);
	
		registeritems();
		
		
		
	}
	
	public Menu(String name, InventoryType type) {
		
		inv = Bukkit.createInventory(null, type, name);
		registeritems();
		
	}
	
	public abstract void registeritems(); 
	public abstract void click(ItemStack i, Player p) ;
		
	

}
