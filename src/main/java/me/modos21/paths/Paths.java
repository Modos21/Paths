package me.modos21.paths;

import me.modos21.paths.listener.PlayerJoinListener;
import me.modos21.paths.listener.PlayerKillListener;
import me.modos21.paths.listener.PlayerLevelUpListener;
import me.modos21.paths.paths.PathPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.GREEN;

public final class Paths extends JavaPlugin {

    private static final String VERSION = "0.0.10";

    HashMap<UUID, PathPlayer> playerCache = new HashMap<>();

    @Override
    public void onEnable() {
        System.out.println("Enabled!");
        Bukkit.getPluginManager().registerEvents(new PlayerKillListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLevelUpListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
    }

    @Override
    public void onLoad() {
        System.out.println("Reload complete");
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            player.sendMessage(text("Paths " + VERSION, GREEN));
            addToCache(player);
        }
    }

    public PathPlayer getFromCache(Player p) {
        return playerCache.getOrDefault(p.getUniqueId(), null);
    }

    public void addToCache(Player p) {
        if (!playerCache.containsKey(p.getUniqueId())) {
            playerCache.put(p.getUniqueId(), new PathPlayer(p));
        }
    }

    public HashMap<UUID, PathPlayer> getPlayerCache() {
        return playerCache;
    }
}
