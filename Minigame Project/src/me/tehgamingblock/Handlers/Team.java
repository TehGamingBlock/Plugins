package me.tehgamingblock.Handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Team {

	private static List<Team> allTeams = new ArrayList<Team>();
	private static List<Team> activeTeams = new ArrayList<Team>();
	
	private List<String> members = new ArrayList<String>();
	
	private static HashMap<String, Team> playerTeams = new HashMap<String, Team>();
	
	private String teamName;
	
	private Location spawn;
	
	public Team(String teamName) {
		this.teamName = teamName;
		this.spawn = spawn;
		
		allTeams.add(this);
		activeTeams.add(this);
	}
	
	public Team(String string, Location location) {
	
	}

	public String getName() {
		return teamName;
	}
	
	public Location getSpawn(){
		return spawn;
	}
	
	public void add(Player player){
		
	playerTeams.put(player.getName(), this);
	members.add(player.getName());
	}
	public boolean remove(Player player){
		 if (hasTeam(player))
			 return false;
			 playerTeams.remove(player.getName());
			 members.remove(player.getName());
			 
			 if(members.isEmpty()){
				 activeTeams.remove(this);
				 
			 }
			 
			 if(activeTeams.size()==1){
				 Game.stop(activeTeams.get(0));
			 }
			 return true;
	}
	
	public static boolean hasTeam(Player player){
		return playerTeams.containsKey(player.getName());
		
	}
	
	public static Team getTeam(Player player) {
		if (!hasTeam(player))
			return null;
		return playerTeams.get(player.getName());
	}
	public static Team getTeam(String name) {
		for(Team t : allTeams){
			if(t.teamName.equalsIgnoreCase(name))
return t;
			return null;
		}
		return null;
	}
	public static List<Team> getAllTeams() {
		return allTeams;
				
	}
	}
