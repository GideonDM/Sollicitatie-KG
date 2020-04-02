package nl.zeeezel.sollicititatie.menu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import nl.zeeezel.sollicititatie.particles.ParticleUtil;
import nl.zeeezel.sollicititatie.particles.Particles;

public class GadgetMenu extends Menu {

	public GadgetMenu(String name, int size) {
		super(name, size);
	}

	@Override
	public void registeritems() {

		ItemStack fire = new ItemStack(Material.FIREBALL, 1);
		ItemMeta firemeta = fire.getItemMeta();
		firemeta.setDisplayName(Particles.VUUR.getName());
		fire.setItemMeta(firemeta);
		inv.setItem(0, fire);

		ItemStack water = new ItemStack(Material.WATER_BUCKET, 1);
		ItemMeta watermeta = fire.getItemMeta();
		watermeta.setDisplayName(Particles.WATER.getName());
		water.setItemMeta(watermeta);
		inv.setItem(1, water);

		ItemStack none = new ItemStack(Material.BARRIER, 1);
		ItemMeta nonemeta = fire.getItemMeta();
		nonemeta.setDisplayName(Particles.NONE.getName());
		none.setItemMeta(nonemeta);
		inv.setItem(8, none);

		ItemStack heart = new ItemStack(Material.REDSTONE_BLOCK, 1);
		ItemMeta heartmeta = fire.getItemMeta();
		heartmeta.setDisplayName(Particles.HEART.getName());
		heart.setItemMeta(heartmeta);
		inv.setItem(2, heart);

	}

	@Override
	public void click(ItemStack i, Player p) {

		if (i.hasItemMeta()) {
			if (i.getItemMeta().hasDisplayName()) {
				

					String name = i.getItemMeta().getDisplayName();

					if (name.equals(Particles.VUUR.getName())) {
						ParticleUtil.giveParticle(p, Particles.VUUR.getParticle());
						p.sendMessage(ChatColor.GRAY + "De " + ChatColor.GOLD + "Fire" + ChatColor.GRAY
								+ " particles staan aan!");
					} else if (name.equals(Particles.WATER.getName())) {

						ParticleUtil.giveParticle(p, Particles.WATER.getParticle());
						p.sendMessage(ChatColor.GRAY + "De " + ChatColor.BLUE + "Water" + ChatColor.GRAY
								+ " particles staan aan!");
					} else if (name.equals(Particles.NONE.getName())) {

						p.sendMessage(ChatColor.GRAY + "Je hebt " + ChatColor.RED + "alle" + ChatColor.GRAY
								+ " particles uitgezet!");
						ParticleUtil.removePartible(p);
					} else if (name.equals(Particles.HEART.getName())) {

						ParticleUtil.giveParticle(p, Particles.HEART.getParticle());
						p.sendMessage(ChatColor.GRAY + "De " + ChatColor.RED + "hartjes" + ChatColor.GRAY
								+ " particles staan aan!");

					}
				
			}

		}

	}

}
