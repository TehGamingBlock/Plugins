package me.tehgamingblock.Listeners.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.tehgamingblock.MinigameProject;
import me.tehgamingblock.Handlers.Team;
import me.tehgamingblock.Listeners.MGListener;

public class Playerdeath extends MGListener {

	public Playerdeath(MinigameProject pl) {
		super(pl);

	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event){
			Player player = event.getEntity();
			Team.getTeam(player).remove(player);
			
			player.kickPlayer(ChatColor.RED + "You died!");
}
}