package nl.zeeezel.sollicititatie.particles;

import org.bukkit.ChatColor;


import net.minecraft.server.v1_12_R1.EnumParticle;

public enum Particles {

	WATER(ChatColor.BLUE + "Water particles", EnumParticle.DRIP_WATER), 
	NONE(ChatColor.RED + "Verwijder particles", null), 
	HEART(ChatColor.RED + "Hartjes particles", EnumParticle.HEART), 
	VUUR(ChatColor.GOLD + "Vuur particles", EnumParticle.FLAME);
	
	String name;
	EnumParticle particle;
	
	private Particles(String name, EnumParticle particle) {
		
		this.name = name;
		this.particle = particle;
	}
	
	public String getName() {
		
		return this.name;
	}
	
	public EnumParticle getParticle() {
		
		return this.particle;
	
	}
}
