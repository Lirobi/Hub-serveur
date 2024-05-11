package fr.lilianbischung;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.lilianbischung.commands.Commands;

public class Hub extends JavaPlugin{

	public static Hub INSTANCE;

	@Override
	public void onEnable() {
		
		INSTANCE = this;
		
		getServer().getPluginManager().registerEvents(new HubListeners(), INSTANCE);
		
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel((Plugin) INSTANCE, "Bungeecord");
		getCommand("fly").setExecutor(new Commands());
		
		FileConfiguration config = this.getConfig();
		config.addDefault("spawnX", 45);
		config.addDefault("spawnY", 86);
		config.addDefault("spawnZ", 21.5);
		
		
		this.saveDefaultConfig();
		
		
		
		super.onEnable();
	}
	

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
	}
	
	
}
