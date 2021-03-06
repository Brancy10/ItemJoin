package me.RockinChaos.itemjoin.listeners;

import me.RockinChaos.itemjoin.handlers.ConfigHandler;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;

public class Pickups implements Listener {

	  @EventHandler
	  public void onPickup(EntityPickupItemEvent event)
	   {
		final Entity entity = event.getEntity();
		if (entity instanceof Player) {
		final Player player = (Player) event.getEntity();
		boolean Creative = player.getGameMode() == GameMode.CREATIVE;
	    if(ConfigHandler.getConfig("config.yml").getBoolean("Prevent-Pickups") == true) {
	      if(ConfigHandler.getConfig("config.yml").getBoolean("AllowOPBypass") == true
	      		&& player.isOp()
	      		|| ConfigHandler.getConfig("config.yml").getBoolean("CreativeBypass") == true
	      		&& Creative) {
	       } else {
	         event.setCancelled(true);
	  	 }
	 }
	}
}
}
