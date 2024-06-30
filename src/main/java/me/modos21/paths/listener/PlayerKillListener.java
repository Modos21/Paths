package me.modos21.paths.listener;

import me.modos21.paths.Paths;
import me.modos21.paths.entities.PathPlayer;
import me.modos21.paths.events.PlayerLevelUpEvent;
import me.modos21.paths.manager.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import static me.modos21.paths.entities.PathPlayer.EXP_PER_LEVEL;
import static net.kyori.adventure.text.Component.text;
import static net.kyori.adventure.text.format.NamedTextColor.DARK_AQUA;

public class PlayerKillListener implements Listener {

    private final Paths plugin;
    private final PlayerManager pm;

    public PlayerKillListener(Paths plugin) {
        this.plugin = plugin;
        this.pm = plugin.getPlayerManager();
    }

    @EventHandler
    public void onMonsterKill(EntityDeathEvent event) {
        if (event.getDamageSource().getCausingEntity() instanceof Player player) {
            final PathPlayer ppl = pm.getFromPlayerEntity(player);
            final int expGained = ppl.gainExp(event.getEntity());
            if (expGained > 0) {
                player.sendMessage(text("[DEBUG] Exp: " + ppl.getExp()));
                player.sendActionBar(text("+ " + expGained + "xp", DARK_AQUA));
            }
            if (ppl.getExp() >= EXP_PER_LEVEL) {
                Bukkit.getPluginManager().callEvent(new PlayerLevelUpEvent(player));
            }
        }
    }
}
