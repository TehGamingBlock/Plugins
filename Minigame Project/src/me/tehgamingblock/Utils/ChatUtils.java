package me.tehgamingblock.Utils;

import static org.bukkit.ChatColor.*;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
public class ChatUtils {

	public static void broadcast(String msg){
		for(Player player : Bukkit.getOnlinePlayers()){
			player.sendMessage(DARK_GRAY + "[" + RED + "Minigame Project" + DARK_GRAY + "] " + WHITE + ">>");
		}
	}
	
	public static void broadcast1(String msg){
		for(Player player : Bukkit.getOnlinePlayers()){
			player.sendMessage (DARK_GRAY + "[" + ORANGE + "Game" + DARK_GRAY + "]" + WHITE + ">>");
			
		}

				
	}
}
