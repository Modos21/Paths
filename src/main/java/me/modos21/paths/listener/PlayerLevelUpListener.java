package me.modos21.paths.listener;

import me.modos21.paths.Paths;
import me.modos21.paths.entities.PathPlayer;
import me.modos21.paths.events.PlayerLevelUpEvent;
import me.modos21.paths.manager.PlayerManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

import static net.kyori.adventure.text.format.NamedTextColor.GOLD;

public class PlayerLevelUpListener implements Listener {
    private final Paths plugin;
    private final PlayerManager pm;

    public PlayerLevelUpListener(Paths plugin) {
        this.plugin = plugin;
        this.pm = plugin.getPlayerManager();
    }

    @EventHandler
    public void onPlayerLevelUp(PlayerLevelUpEvent event) {
        final Player player = event.getPlayer();
        final PathPlayer ppl = pm.getFromPlayerEntity(player);
        ppl.levelUp();
        Component title = Component.text("Choose your blessing!", GOLD);
        Inventory levelUpGUI = Bukkit.createInventory(player, 27, title);
        player.openInventory(levelUpGUI);
    }
}
