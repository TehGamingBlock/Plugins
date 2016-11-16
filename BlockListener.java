package me.tehgamingblock;

import org.bukkit.event.Listener;

public class BlockListener implements Listener {

	public BlockListener(PlayerHealer plugin){
		plugin.getServer().getPluginManager().registerEvents(this,  plugin);}
}

