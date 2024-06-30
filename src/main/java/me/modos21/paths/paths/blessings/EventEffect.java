package me.modos21.paths.paths.blessings;

import org.bukkit.entity.Player;

@FunctionalInterface
public interface EventEffect extends Effect {

    @Override
    void apply(Player player);
}
