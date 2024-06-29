package me.modos21.paths.listener;

import me.modos21.paths.Paths;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final Paths plugin;

    public PlayerJoinListener(Paths plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.addToCache(event.getPlayer());
    }
}
