package fr.lilianbischung;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HubListeners implements Listener {
	

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		//TODO do stuff
		FileConfiguration config = Hub.INSTANCE.getConfig();
		int x = config.getInt("spawnX");
		int y = config.getInt("spawnY");
		int z = config.getInt("spawnZ");
		
		
		Location loc = new Location(Hub.INSTANCE.getServer().getWorld("world"), x, y, z, 90.0f, 1.0f);
		
		p.teleport(loc);
		
		
		if(p.getGameMode() != GameMode.ADVENTURE) {
			p.setGameMode(GameMode.ADVENTURE);
		}
		
		
		ItemStack compass = new ItemStack(Material.COMPASS, 1);
		ItemMeta compassM = compass.getItemMeta();
		compassM.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
		compassM.setDisplayName("§eMenu");
		compass.setItemMeta(compassM);
		
	}
	
	@EventHandler 
	public void onQuit(PlayerQuitEvent e) {
		//TODO do stuff
	}
	
	@EventHandler
    public void onPlayerDamaged(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }
    
    @EventHandler
    public void onPortal(PlayerPortalEvent e) {
    	e.setCancelled(true);
    }

}
