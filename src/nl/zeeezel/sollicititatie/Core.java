package nl.zeeezel.sollicititatie;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.minecraft.server.v1_12_R1.EnumParticle;
import net.minecraft.server.v1_12_R1.PacketPlayOutWorldParticles;
import nl.zeeezel.sollicititatie.commands.GadgetCommand;
import nl.zeeezel.sollicititatie.events.JoinEvent;
import nl.zeeezel.sollicititatie.menu.MenuManager;
import nl.zeeezel.sollicititatie.particles.ParticleUtil;

public class Core extends JavaPlugin {

	@Override
	public void onEnable() {
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new MenuManager(), this);
		pm.registerEvents(new JoinEvent(), this);
		
		
		getCommand("gadgetmenu").setExecutor(new GadgetCommand());
		
		Bukkit.getConsoleSender().sendMessage("Kwartier granzier plugin geactiveerd");

		
		new BukkitRunnable() {
			
	

                    @Override
                    public void run() {
                    	
                		for (Player p : Bukkit.getOnlinePlayers()) {
                            if (ParticleUtil.particles.containsKey(p)) {
                                
                            	EnumParticle particleeffect = ParticleUtil.particles.get(p);
                   
                            	berekenCircle(p.getLocation(), 1f, particleeffect);
                    }
                }
            }
		}.runTaskTimerAsynchronously(this, 0, 10);
	}
    
	
	 public void berekenCircle(Location loc, float radius, EnumParticle particle){
	        for(double t = 0; t<10; t+=0.5){
	            float x = radius*(float)Math.sin(t);
	            float z = radius*(float)Math.cos(t);
	            PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particle, true,(float) loc.getX() + x, (float) loc.getY() + 2,(float) loc.getZ() + z, 0, 0, 0, 0, 1);
	            for(Player online : Bukkit.getOnlinePlayers()){
	                ((CraftPlayer)online).getHandle().playerConnection.sendPacket(packet);
	            }
	        }
	 }
		

}
