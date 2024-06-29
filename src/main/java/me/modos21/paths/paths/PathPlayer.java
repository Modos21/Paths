package me.modos21.paths.paths;

import org.bukkit.entity.Player;

import java.util.UUID;

public class PathPlayer {

    Player playerRef;
    Path[] paths;
    UUID uuid;
    int exp;
    int level;

    public PathPlayer() {
        paths = new Path[0];
        exp = 0;
        level = 0;
    }

    public PathPlayer(Player pl) {
        this();
        playerRef = pl;
    }

    public void addPath(Path path) {
        Path[] newPaths = new Path[paths.length+1];
        System.arraycopy(paths, 0, newPaths, 0, paths.length);
        newPaths[newPaths.length-1] = path;
        this.paths = newPaths;
    }

    public int getExp() {
        return exp;
    }

    public void incExp(int amount) {
        this.exp += 10;
    }
}
