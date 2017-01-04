package me.tehgamingblock.Listeners.player;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent.Result;

import me.tehgamingblock.MinigameProject;
import me.tehgamingblock.Handlers.Game;
import me.tehgamingblock.Listeners.MGListener;

public class AsyncPlayerPreLogic extends MGListener{

	public AsyncPlayerPreLogic(MinigameProject pl) {
		super(pl);
		
	}
	@EventHandler
	public void playerPreLogin(AsyncPlayerPreLoginEvent event) {
		if(Game.hasStarted())
			event.disallow(Result.KICK_OTHER, ChatColor.RED + "The game has already started!");

}
}
