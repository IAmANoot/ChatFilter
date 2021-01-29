package src.Core;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

public class AntiSwear implements Listener {
	  Core plugin;
	  
	  public AntiSwear(Core plugin)
	  {
	    this.plugin = plugin;
	  }

	  
	  @EventHandler
	  public void onChat(AsyncPlayerChatEvent e) {
		  Player p = e.getPlayer();
		    String message = e.getMessage();
		    String message2 = message.toLowerCase();
		    String message3 = message2.replace(".", "").replace(",", "").replace("*", "").replace("&", "").replace("(", "").replace(")", "").replace("{", "");
		    String message4 = message3.replace("}", "").replace("!", "").replace("?", "").replace("#", "").replace(" ", "").replace("^", "");
		    String message5 = message4.replace("%", "").replace("ï¿½", "").replace("-", "").replace("_", "").replace("$", "").replace("1", "").replace("2", "");
		    String message6 = message4.replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", "").replace("9", "").replace("0", "");
		    String message7 = message5.replaceAll(">", "").replaceAll("<", "").replaceAll("%", "").replaceAll("$", "").replaceAll("£", "").replaceAll("", "").replace("\\w\\1+", "$1");
		    String message8 = message7.replaceAll(";", "");
		    for (String a : this.plugin.getConfig().getStringList("Swear-Words")) {
		        if (message8.contains(a)) {
		        	e.setCancelled(true);
	                List<String> list1 = this.plugin.getConfig().getStringList("message");
	                for (String l1 : list1) {
	                  p.sendMessage(l1.replace("&", "§").replace("%word%", a).replace("%message%", message).replace("%player%", p.getName()));
		        }
		    if (plugin.getConfig().getBoolean("kick-player")) {
				  Bukkit.getServer().getScheduler().runTaskLater((Plugin)this.plugin, () -> {
					  p.kickPlayer(plugin.getConfig().getString("kick-message").replaceAll("&", "§"));
		    }, 1);
		    }
		    if (plugin.getConfig().getBoolean("broadcast-on-swear")) {
		    	Bukkit.broadcastMessage(plugin.getConfig().getString("broadcast").replace("&", "§").replace("%word%", a).replace("%message%", message).replace("%player%", p.getName()));
		    }
		    if (plugin.getConfig().getBoolean("command-on-swear")) {
		    	Bukkit.getServer().getScheduler().runTaskLater((Plugin)this.plugin, () -> {
		    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), plugin.getConfig().getString("command").replace("%word%", a).replace("%message%", message).replace("%player%", p.getName()));
		    }, 1);
		    }
		    if (plugin.getConfig().getBoolean("staff-notify")) {
		    	for (Player all : Bukkit.getOnlinePlayers()) {
		    		if (all.hasPermission("chatfilter.notify")) {
		                List<String> list = this.plugin.getConfig().getStringList("notify-message");
		                for (String l1 : list) {
		                  all.sendMessage(l1.replace("&", "§").replace("%word%", a).replace("%message%", message).replace("%player%", p.getName()));
		    		}
		    	}
		    }
}
}
}
}

	  @EventHandler
	  public void onChat(PlayerCommandPreprocessEvent e) {
		  Player p = e.getPlayer();
		  if (plugin.getConfig().getBoolean("block-commands")) {
		    String message = e.getMessage();
		    String message2 = message.toLowerCase();
		    String message3 = message2.replace(".", "").replace(",", "").replace("*", "").replace("&", "").replace("(", "").replace(")", "").replace("{", "");
		    String message4 = message3.replace("}", "").replace("!", "").replace("?", "").replace("#", "").replace(" ", "").replace("^", "");
		    String message5 = message4.replace("%", "").replace("ï¿½", "").replace("-", "").replace("_", "").replace("$", "").replace("1", "").replace("2", "");
		    String message6 = message4.replace("3", "").replace("4", "").replace("5", "").replace("6", "").replace("7", "").replace("8", "").replace("9", "").replace("0", "");
		    String message7 = message5.replaceAll(">", "").replaceAll("<", "").replaceAll("%", "").replaceAll("$", "").replaceAll("£", "").replaceAll("", "").replace("\\w\\1+", "$1");
		    String message8 = message7.replaceAll(";", "");
		    for (String a : this.plugin.getConfig().getStringList("Swear-Words")) {
		        if (message8.contains(a)) {
		        	e.setCancelled(true);
	                List<String> list1 = this.plugin.getConfig().getStringList("message");
	                for (String l1 : list1) {
	                  p.sendMessage(l1.replace("&", "§").replace("%word%", a).replace("%message%", message).replace("%player%", p.getName()));
		        }
		    if (plugin.getConfig().getBoolean("kick-player")) {
				  Bukkit.getServer().getScheduler().runTaskLater((Plugin)this.plugin, () -> {
					  p.kickPlayer(plugin.getConfig().getString("kick-message").replaceAll("&", "§"));
		    }, 1);
		    }
		    if (plugin.getConfig().getBoolean("broadcast-on-swear")) {
		    	Bukkit.broadcastMessage(plugin.getConfig().getString("broadcast").replace("&", "§").replace("%word%", a).replace("%message%", message).replace("%player%", p.getName()));
		    }
		    if (plugin.getConfig().getBoolean("command-on-swear")) {
		    	Bukkit.getServer().getScheduler().runTaskLater((Plugin)this.plugin, () -> {
		    	Bukkit.dispatchCommand(Bukkit.getConsoleSender(), plugin.getConfig().getString("command").replace("%word%", a).replace("%message%", message).replace("%player%", p.getName()));
		    }, 1);
		    }
		    if (plugin.getConfig().getBoolean("staff-notify")) {
		    	for (Player all : Bukkit.getOnlinePlayers()) {
		    		if (all.hasPermission("chatfilter.notify")) {
		                List<String> list = this.plugin.getConfig().getStringList("notify-message");
		                for (String l1 : list) {
		                  all.sendMessage(l1.replace("&", "§").replace("%word%", a).replace("%message%", message).replace("%player%", p.getName()));
		    		}
		    	}
		    }
}
}
}
}
}
}