package nl.zeeezel.sollicititatie.particles;

import java.util.HashMap;

import org.bukkit.entity.Player;

import net.minecraft.server.v1_12_R1.EnumParticle;

public class ParticleUtil {

	public static HashMap<Player, EnumParticle> particles = new HashMap<Player, EnumParticle>();
	
	public static void giveParticle(Player p, EnumParticle particle) {
		
		if(particles.containsKey(p)) {
			particles.remove(p);
			particles.put(p, particle);
		
		}else {
			particles.put(p, particle);
		
		}
		
		
	}
	
	public static void removePartible(Player p) {
		if(particles.containsKey(p)) {
			particles.remove(p);
		}
	}

}
