package fr.lilianbischung.Utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import fr.lilianbischung.Hub;

public class ServerTransfert {
	
	private Plugin INSTANCE;
	
	
	public void sendPlayerToServer(Player p, String serverName) {
		
		
		// -----------------------
		// Changer en fonction du plugin dans lequel on utilise cette class
		INSTANCE = (Plugin) Hub.INSTANCE;
		// -----------------------
		
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(INSTANCE, "Bungeecord");
		
		final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		final DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
		
		try {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);
            out.writeUTF("Connect");
            out.writeUTF(serverName);
            p.sendPluginMessage(INSTANCE, "BungeeCord", b.toByteArray());
            b.close();
            out.close();
        }
        catch (Exception e) {
            p.sendMessage(ChatColor.RED + "Error when trying to connect to " + serverName);
            
        }
		
		Bukkit.getServer().getMessenger().unregisterOutgoingPluginChannel(INSTANCE, "Bungeecord");
	}
}
