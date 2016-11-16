package me.tehgamingblock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class InvGUI extends JavaPlugin implements Listener {
// When it enables, it saves a config.
	
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this,  this);
		this.getConfig().addDefault("MobKills", 0);
		
		this.getConfig().options().copyDefaults(true);
		
		saveConfig();
	}
	// This is the GUI config code.
	private void teleportInWorld(Player p, int x, int y, int z) {
		p.teleport(new Location(p.getWorld(), x, y, z));
	}
	
	private void openGUI(Player p){
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "Boss Selector");
		
		ItemStack ZombieBoss = new ItemStack(Material.ROTTEN_FLESH);
		ItemMeta ZombieBossMeta =  ZombieBoss.getItemMeta();
		ItemStack SkeleBoss = new ItemStack(Material.BONE);
		ItemMeta SkeleBossMeta = SkeleBoss.getItemMeta();
		SkeleBossMeta.setDisplayName(ChatColor.DARK_GREEN + "Skeleton Boss");
		ZombieBossMeta.setDisplayName(ChatColor.DARK_BLUE + "Zombie Boss");
		
		inv.setItem(3, SkeleBoss);
		inv.setItem(5, ZombieBoss);
		
		p.openInventory(inv);
	}
	// This detects if the compass name is "Boss Selector".
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Boss Selector"))
		return;
	Player p = (Player) event.getWhoClicked();
	event.setCancelled(true);
	
	if(event.getCurrentItem()==null || event.getCurrentItem().getType()==Material.AIR||event.getCurrentItem().hasItemMeta()){
		return;
	// This does an action depending on what item they clicked.
	}
	switch(event.getCurrentItem().getType()) {
	case ROTTEN_FLESH:
	teleportInWorld(p, 396, 72, -24);
	p.closeInventory();
	p.setInvulnerable(false);
	p.sendMessage(String.format("%sTeleported to %sZombie King%s!", ChatColor.GOLD, ChatColor.DARK_GREEN, ChatColor.GOLD));
	break;
	case BONE:
	p.closeInventory();
	p.sendMessage(String.format("%sThis boss has not %syet %sbeen implemented!", ChatColor.GOLD, ChatColor.WHITE, ChatColor.GOLD));
	break;
		default:
			p.closeInventory();
			break;
	}
}

	// This is what happens when players join.
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		event.getPlayer().sendMessage(ChatColor.GREEN + "Welcome to the server!");
		event.getPlayer().setCanPickupItems(false);
		event.getPlayer().teleport(new Location(p.getWorld(), 262, 86, 342));
		event.getPlayer().setInvulnerable(true);
		event.getPlayer().getInventory().clear();
		ItemStack compass = new ItemStack(Material.COMPASS);
		ItemMeta compassMeta = compass.getItemMeta();
		compassMeta.setDisplayName(ChatColor.RED + "Boss Selector");
		compass.setItemMeta(compassMeta);
		p.getInventory().addItem(compass);
	    }

	// This opens the GUI when the player right clicks.
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		ItemStack is = event.getItem();
		
		if(event.getAction() == Action.PHYSICAL || is == null || is.getType() == Material.AIR)
				if(!(is.getType() == Material.COMPASS))
		return;
	
		if (is.getType() == Material.COMPASS && getName().equalsIgnoreCase("Boss Selector"));
			openGUI(event.getPlayer());
	
		
	}
		
	
	{
}
}



		
	
	
