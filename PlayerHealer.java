package me.tehgamingblock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerHealer extends JavaPlugin {
	
	public Permission playerPermission = new Permission("playerabilities.allowed");

	@Override
	public void onEnable() {
		new BlockListener(this);
		PluginManager pm = getServer().getPluginManager();
		pm.addPermission(playerPermission);
	}
	
	@Override
	public void onDisable() {
	}

// Player healing command:
public boolean onCommand(Command sender, Command cmd, String label, String[] args){
	if (cmd.getName().equalsIgnoreCase("heal") && sender instanceof Player) {
		Player p = (Player) sender;
		// Arg 0 = first word entered after command.
		int length = args.length;
	
		
		if (length == 1) {
			
			boolean playerFound = false;
			
			for (Player playerToHeal : Bukkit.getServer().getOnlinePlayers()){
				if(playerToHeal.getName().equalsIgnoreCase(args[0])) {
					playerToHeal.setHealth(20.0);
					playerToHeal.sendMessage(ChatColor.GREEN + "You have been healed!");
					playerFound = true;
					break;
		}
			}
			if (playerFound == false)
				p.sendMessage(ChatColor.RED + args[0] + " was not found.");
			else p.sendMessage (ChatColor.RED + "Incorrect arguments, please use /heal [NAME]");
			return true;
			
		
	}
	
	}
	return false;
}
}
	



		
	