package me.modos21.paths.listener;

import me.modos21.paths.Paths;
import me.modos21.paths.entities.PathPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoinListener implements Listener {

    private final Paths plugin;

    public PlayerJoinListener(Paths plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        plugin.getPlayerManager().addToCache(event.getPlayer());
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        PathPlayer pp = plugin.getPlayerManager().getFromPlayerEntity(p);
        System.out.println("Exp of player who left: " + pp.getExp());
        System.out.println("Player cache:");
        plugin.getPlayerManager().forEach((k, v) ->
                System.out.printf("Exp of player %-12s: %d", p.getName(), v.getExp())
        );
    }
}
