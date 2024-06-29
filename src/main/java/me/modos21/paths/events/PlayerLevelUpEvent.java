package me.modos21.paths.events;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityEvent;
import org.jetbrains.annotations.NotNull;

public class PlayerLevelUpEvent extends EntityEvent {

    private static final HandlerList HANDLERS = new HandlerList();
    public PlayerLevelUpEvent(@NotNull Player player) {
        super(player);
    }

    public Player getPlayer() {
        return (Player) this.entity;
    }

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
