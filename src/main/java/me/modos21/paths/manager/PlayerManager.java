package me.modos21.paths.manager;

import me.modos21.paths.entities.PathPlayer;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager extends HashMap<UUID, PathPlayer> {

    public PathPlayer getFromPlayerEntity(Player player) {
        return this.get(player.getUniqueId());
    }

    public void addToCache(Player p) {
        if (!this.containsKey(p.getUniqueId())) {
            this.put(p.getUniqueId(), new PathPlayer(p));
        }
    }
}
