package me.tehgamingblock.Threads;

import org.bukkit.scheduler.BukkitRunnable;

import me.tehgamingblock.MinigameProject;
import me.tehgamingblock.Handlers.Game;
import me.tehgamingblock.Utils.ChatUtils;

public class StartCountdown extends BukkitRunnable {
	
	MinigameProject plugin;
	
	public StartCountdown(MinigameProject pl){
		plugin = pl;
	}
	

	public static  int timeUntilStart;

	public void run() {
				if (timeUntilStart == 0){
					if (!Game.canStart()){
						plugin.restartCountdown();
						ChatUtils.broadcast("Game starting when there are enough players!");
						return;
					
					
					Game.start();
					Game.canStart = true;
					
				}
				}
				if(timeUntilStart % 10 == 0 || timeUntilStart <10) {
					ChatUtils.broadcast(String.valueOf(timeUntilStart) + " seconds until the game starts!");
				}
				
				timeUntilStart -= 1;
			}
			
	}

	
