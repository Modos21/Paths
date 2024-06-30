package me.modos21.paths.entities;

import me.modos21.paths.paths.Path;
import me.modos21.paths.paths.blessings.Blessing;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PathPlayer {

    Player playerRef;
    Path[] paths;
    List<Blessing> blessings;
    UUID uuid;
    int exp;
    int level;

    public PathPlayer() {
        paths = new Path[0];
        exp = 0;
        level = 0;
        blessings = new ArrayList<>();
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

    /**
     * Increases player's exp depending on which Mob was killed
     * @param mobSlain the mob that was killed by the player
     * @return the amount by which the exp was increased
     */
    public int incExp(Entity mobSlain) {
        int amount = PathMob.getExpValue(mobSlain);
        this.exp += amount;
        return amount;
    }

    public void levelUp() {
        this.exp -= 100;
        //todo: open inventory GUI to give the player one of 3 blessings
    }

    public void obtainBlessing(Blessing blessing) {
        this.blessings.add(blessing);
        blessing.effect().apply(playerRef);
    }

    public Player getPlayerRef() {
        return playerRef;
    }
}
