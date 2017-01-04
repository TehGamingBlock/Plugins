package me.tehgamingblock.Listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

import me.tehgamingblock.GameState;
import me.tehgamingblock.MinigameProject;
import me.tehgamingblock.Handlers.Game;
import me.tehgamingblock.Handlers.Team;
import me.tehgamingblock.Listeners.MGListener;

public class Playerquit extends MGListener {
	
	public Playerquit(MinigameProject pl) {
		super(pl);

	}

	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event){
		if(GameState.isState(GameState.IN_LOBBY))
			Game.setCanStart(Bukkit.getOnlinePlayers().size() -1 >=2);;
			
			Player player = event.getPlayer();
					
			if(Game.hasStarted())
				Team.getTeam(player).remove(player);

}
}
