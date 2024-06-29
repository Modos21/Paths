package me.modos21.paths;

import me.modos21.paths.listener.PlayerKillListener;
import me.modos21.paths.listener.PlayerLevelUpListener;
import me.modos21.paths.paths.PathPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.GREEN;

public final class Paths extends JavaPlugin {

    private static final String VERSION = "0.0.7";

    HashMap<Player, PathPlayer> playerCache = new HashMap<>();

    @Override
    public void onEnable() {
        System.out.println("Enabled!");
        Bukkit.getPluginManager().registerEvents(new PlayerKillListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerLevelUpListener(this), this);
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
        return playerCache.getOrDefault(p, null);
    }

    public void addToCache(Player p) {
        playerCache.put(p, new PathPlayer(p));
    }
}
