package me.modos21.paths;

import me.modos21.paths.entities.PathPlayer;
import me.modos21.paths.listener.PlayerJoinListener;
import me.modos21.paths.listener.PlayerKillListener;
import me.modos21.paths.listener.PlayerLevelUpListener;
import me.modos21.paths.paths.blessings.Blessing;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

import static me.modos21.paths.paths.Path.MINER;
import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.GREEN;

public final class Paths extends JavaPlugin {

    //todo: HashMap for all entities and the amount of EXP they give

    //todo: create some basic blessings for the player

    //todo: Open Inventory GUI when levelling up

    //todo: level up GUI lets you choose from 3 random blessings that you don't have yet

    //todo: add "paths" command to view your paths

    //todo: add file saving of player data for server restarts or plugin reloads

    //todo: brainstorm what should happen when you have obtained ALL blessings

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


    private void createBlessings() {
        final Blessing minersSight = new Blessing(MINER, "Miner's Sight", player -> {

        });
    }
}
