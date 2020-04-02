package nl.zeeezel.sollicititatie.menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class HoofdMenu extends Menu {

	public HoofdMenu(String name, int size) {
		super(name, size);
	}

	@Override
	public void registeritems() {

		ItemStack compass = new ItemStack(Material.COMPASS, 1);
		ItemMeta compassmeta = compass.getItemMeta();
		compassmeta.setDisplayName(ChatColor.RED + "Server Selector");
		compass.setItemMeta(compassmeta);
		inv.setItem(0, compass);

		ItemStack chest = new ItemStack(Material.CHEST, 1);
		ItemMeta chestmeta = chest.getItemMeta();
		chestmeta.setDisplayName(ChatColor.RED + "Particle menu");
		chest.setItemMeta(chestmeta);
		inv.setItem(1, chest);

	}

	@Override
	public void click(ItemStack i, Player p) {

		if (i.hasItemMeta()) {
			if (i.getItemMeta().hasDisplayName()) {

				String name = i.getItemMeta().getDisplayName();

				if (name.equals(ChatColor.RED + "Particle menu")) {
					p.openInventory((MenuManager.getMenu("gadget")).inv);
					
				}
			}
		}

	}

}
