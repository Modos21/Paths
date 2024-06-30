package me.modos21.paths.entities;

import org.bukkit.entity.*;

public enum PathMob {

    // if this works for all animals I'm happy
    ANIMAL(Animals.class, 0),
    SILVERFISH(Silverfish.class, 2),
    ZOMBIE(Zombie.class, 2),
    SKELETON(Skeleton.class, 2),
    SPIDER(Spider.class, 2),
    CREEPER(Creeper.class, 2),
    ENDERMAN(Enderman.class, 8);


    private final Class<? extends Entity> reference;
    private final int expValue;
    PathMob(Class<? extends Entity> reference, int expValue) {
        this.reference = reference;
        this.expValue = expValue;
    }

    public static int getExpValue(Entity mob) {
        for (PathMob pm : values()) {
            // "bissn reflection benutzt, aber das sollte schon passen" - Ghast
            if (Arrays.stream(mob.getClass().getInterfaces()).toList().contains(pm.reference)) {
                return pm.expValue;
            }
        }
        return 0;
    }

    public Class<? extends Entity> reference() {
        return reference;
    }
}


