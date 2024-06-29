package me.modos21.paths.listener;

import me.modos21.paths.Paths;
import me.modos21.paths.events.PlayerLevelUpEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.GOLD;

public class PlayerLevelUpListener implements Listener {
    private final Paths plugin;

    public PlayerLevelUpListener(Paths plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLevelUp(PlayerLevelUpEvent event) {
        event.getPlayer().sendMessage(text("LEVEL UP!", GOLD));
    }
}
