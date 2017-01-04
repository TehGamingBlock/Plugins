package me.tehgamingblock.Listeners.entity;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.tehgamingblock.MinigameProject;
import me.tehgamingblock.Handlers.Game;
import me.tehgamingblock.Handlers.Team;
import me.tehgamingblock.Listeners.MGListener;

public class EntityDamageByEntity extends MGListener {

	public EntityDamageByEntity(MinigameProject pl) {
		super(pl);
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
		if(!(event.getEntity() instanceof Player && event.getDamager() instanceof Player)){
			event.setCancelled(true);
			return;
		}
		
		if(Game.hasStarted()){
			event.setCancelled(true);
			return;
		}
		Player player = (Player) event.getEntity();
		Player damager = (Player) event.getEntity();
		
		if(Team.getTeam(player) == Team.getTeam(damager)){
			event.setCancelled(true);
		}
	}

}
