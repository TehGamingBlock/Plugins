package me.tehgamingblock.Handlers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import me.tehgamingblock.Utils.LocationUtils;


public class Game {
	
	public static boolean canStart = false;
	private static boolean hasStarted = false;
	
public static void start() {
	hasStarted = true;
		new Team("Red", new Location(Bukkit.getWorld("world"),20,64,20));
		new Team("Blue", new Location(Bukkit.getWorld("world"),20,64,20));
		
		int i = 0;
				for(Player player : Bukkit.getOnlinePlayers()){
					if (i > Team.getAllTeams().size())
					i = 0;
					Team.getTeam(Team.getAllTeams().get(i++).getName()).add(player);
					LocationUtils.teleportToGame(player,  Team.getAllTeams().get(i++));
					
				}
	}
	public static void stop(Team team) {
		hasStarted = false;
		
}
	public static boolean canStart() {
		return canStart;
	}
	
	public static boolean hasStarted(){
		return hasStarted;
	}
	
	public static void setCanStart(boolean b){
		canStart = b;
	}

}
