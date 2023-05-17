package net.mauki.maukiseasonpl.features.crosschat;

import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.mauki.maukiseasonpl.core.Boot;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class Configuration extends ListenerAdapter implements Listener {

    @EventHandler
    public void onReloadCommand(PlayerCommandPreprocessEvent event) {
        String cmd = event.getMessage().split(" ")[0].replaceAll("(?i)bukkit", "");
        if(!((cmd.equalsIgnoreCase("/reload") || cmd.equalsIgnoreCase("/rl")))) return;
        event.setCancelled(true);
        event.getPlayer().sendMessage(ChatColor.GREEN + "Server wird neu geladen!");
        Boot.getLOGGER().info("Reloading the server...");
        Boot.getDISCORD_CLIENT().getJDA().shutdownNow();
        Boot.getPLUGIN().getServer().reload();
    }

    @EventHandler
    public void onReloadCommand(ServerCommandEvent event) {
        String cmd = event.getCommand().split(" ")[0].replaceAll("(?i)bukkit", "");
        if(!((cmd.equalsIgnoreCase("reload") || cmd.equalsIgnoreCase("rl")))) return;
        event.setCancelled(true);
        event.getSender().sendMessage(ChatColor.GREEN + "Server wird neu geladen!");
        Boot.getLOGGER().info("Reloading the server...");
        Boot.getDISCORD_CLIENT().getJDA().shutdownNow();
        Boot.getPLUGIN().getServer().reload();
    }

}
