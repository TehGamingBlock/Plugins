package me.tehgamingblock.Handlers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;

import me.tehgamingblock.Utils.ChatUtils;

public class Kits {
	
	private static List<Kits> allKits = new ArrayList<Kits>();
	private static HashMap<String, Kits> playerKits = new HashMap<String, Kits>();
	private List<ItemStack > items = new ArrayList<ItemStack>();
	private String name, permission;
	
	private int displayItem;
	
	@SuppressWarnings("deprecation")
	public Kits(String name, List<String> items, int displayItem){
		this.name = name;
		this.permission = "MinigameProject.kit" + name;
		this.displayItem = displayItem;
		
		for(String s : items) {
			int id = 0, amount = 1;
			if(s.contains(":")){
				String[] splitItem = s.split(":");
				id = Integer.valueOf(splitItem[0].trim());
				amount = Integer.valueOf(splitItem[1].trim());
				
			} else
				id = Integer.valueOf(s.trim());
			this.items.add(new ItemStack(id, amount));
			
		}
		allKits.add(this);
	}
	
	public static boolean isKit(String name){
		for(Kits k : allKits)
			if(name == k.getName())
				return true;
		return false;
	}
	public static Kits getKit(String name){
		for(Kits k : allKits)
			if(name.equalsIgnoreCase(name))
return k;
return null;
	}
	public static void setKit(Player player, Kits kit){
		if(!player.hasPermission(kit.getPermissionNode()))
			ChatUtils.broadcast(null);
		playerKits.put(player.getName(), kit);
	}
	public static Kits getKit(Player player){
		return playerKits.get(player.getName()) == null ? allKits.get(0) : playerKits.get(player.getName());
	}
	
	public void setKit(Player player){
		setKit(player, this);
	}
	
	public String getName(){
		return name;
	}
	
	public ItemStack getDisplayItem(){
		ItemStack is = new ItemStack(displayItem);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(name);
		
		is.setItemMeta(im);
		return is;
		
		
	}
	
	public Permission getPermissionNode() {
		return new Permission(permission);
	}

}
