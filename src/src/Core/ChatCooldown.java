package src.Core;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import src.Core.Core;

public class ChatCooldown implements Listener {
	private static Core plugin = Core.getPlugin(Core.class);
	  
	public static List<String> talk = new ArrayList<String>();
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if (plugin.getConfig().getBoolean("chat-cooldown")) {
		if (!talk.contains(p.getName())) {
				talk.add(p.getName());
				
				Bukkit.getScheduler().runTaskLater((Plugin) this, new Runnable() {
					  @Override
					  public void run() {
					    talk.remove(p.getName());
					  }
					}, 40);
	} else {
		e.setCancelled(true);
        List<String> list = plugin.getConfig().getStringList("cooldown-message");
        for (String l1 : list) {
          p.sendMessage(l1);
        }
	   }
	  }
	}
}