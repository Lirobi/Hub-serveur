package fr.lilianbischung.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		// TODO Auto-generated method stub
		
	
	
		if(cmd.getName().equalsIgnoreCase("fly")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				
				if(p.getAllowFlight() == false) {
					p.setAllowFlight(true);
				} else  {
					p.setAllowFlight(false);
				}
				
				return true;
				
			}
		}
		return false;
	}

}
