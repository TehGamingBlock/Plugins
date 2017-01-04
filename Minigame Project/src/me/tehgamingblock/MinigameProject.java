package me.tehgamingblock;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.tehgamingblock.Listeners.player.AsyncPlayerPreLogic;
import me.tehgamingblock.Listeners.player.Playerdeath;
import me.tehgamingblock.Listeners.player.Playerjoin;
import me.tehgamingblock.Listeners.player.Playerquit;
import me.tehgamingblock.Threads.StartCountdown;

public class MinigameProject extends JavaPlugin {
	
	public static int startCountdownId;
	
	public static void main(String[] args){
		List<String> strings = new ArrayList<String>();
		strings.add("one");
		
		System.out.println(strings.get(0));
	}
	
	public void onEnable() {
		GameState.setState(GameState.IN_LOBBY);
		startCountdown();
	}

	
	public void registerListeners(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Playerjoin(this), this);
		pm.registerEvents(new Playerquit(this), this);
		pm.registerEvents(new AsyncPlayerPreLogic(this), this);
		pm.registerEvents(new Playerdeath(this), this);
	}
	
	@SuppressWarnings("deprecation")
	public void startCountdown() {
		StartCountdown.timeUntilStart = 60;
		
		startCountdownId = getServer().getScheduler().scheduleSyncRepeatingTask(this, new StartCountdown(this),  201,  201);
		
	}
	public void stopCountdown(){
		getServer().getScheduler().cancelTask(startCountdownId);
	}
	public void restartCountdown(){
		stopCountdown();
		startCountdown();
	}

	
}