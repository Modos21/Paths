package me.modos21.paths.listener;

import me.modos21.paths.Paths;
import me.modos21.paths.entities.PathPlayer;
import me.modos21.paths.events.PlayerLevelUpEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.DARK_AQUA;

public class PlayerKillListener implements Listener {

    private final Paths plugin;

    public PlayerKillListener(Paths plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMonsterKill(EntityDeathEvent event) {
        if (event.getDamageSource().getCausingEntity() instanceof Player player) {
            player.sendActionBar(text("+ 10xp", DARK_AQUA));
            final PathPlayer ppl = plugin.getFromCache(player);
            if (ppl.incExp(event.getEntity()) > 0) {
                player.sendMessage(text("Exp: " + ppl.getExp()));
            }
            if (ppl.getExp() % 100 == 0) {
                Bukkit.getPluginManager().callEvent(new PlayerLevelUpEvent(player));
            }
        }
    }
}
