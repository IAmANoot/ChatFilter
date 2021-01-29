package src.Core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if ((cmd.getName().equalsIgnoreCase("chatfilter")) && ((sender instanceof Player))) {
      Player p = (Player)sender;
      
      if (args.length == 0) {
        p.sendMessage("§2ChatFilter plugin by IAmANoot (Nathan)");
        p.sendMessage("§6http://www.mc-market.org/members/44760/");
        p.sendMessage("§6https://www.spigotmc.org/members/nath.51900/");
        return true;
      }
      return true;
    }
    return false;
  }
}
