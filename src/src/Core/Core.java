package src.Core;

import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin {
	  
	  public void onEnable() {
	    getConfig().options().copyDefaults(true);
	    saveDefaultConfig();
	    getServer().getPluginManager().registerEvents(new AntiSwear(this), this);
	    getServer().getPluginManager().registerEvents(new ChatCooldown(), this);
	  }
	}
