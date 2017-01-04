package me.tehgamingblock.Listeners.player;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import me.tehgamingblock.MinigameProject;
import me.tehgamingblock.Handlers.Game;
import me.tehgamingblock.Listeners.MGListener;

public class Playerjoin extends MGListener{
	
	public Playerjoin(MinigameProject pl) {
		super(pl);
		
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Game.setCanStart(Bukkit.getOnlinePlayers().size() >=2);
	}

	}


