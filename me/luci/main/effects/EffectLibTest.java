package me.luci.main.effects;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Particle.DustOptions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.plugin.Plugin;

import me.luci.main.Main;
import net.md_5.bungee.api.ChatColor;

public class EffectLibTest implements Listener {

	private Plugin plugin = Main.getPlugin(Main.class);
	public static HashMap<String, Integer> playerTask = new HashMap<String, Integer>();

	@EventHandler
	public void onPlayerToggleFlight(final PlayerToggleFlightEvent e) {

		Player player = e.getPlayer();

		if (player.hasPermission("gayworld.flight.particle.pink.circle")) {
			if (e.isFlying() == true) {

				if (playerTask.containsKey(player.getName())) {
					Bukkit.getScheduler().cancelTask(playerTask.get(player.getName()));
					playerTask.remove(player.getName());
				} else {
					playerTask.put(player.getName(), Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {

						double t = 1;
						double r = 1;

						@Override
						public void run() {
							Location loc = player.getLocation();
							t = t + Math.PI / 16;
							double x = r * Math.sin(t);
							double y = 0;
							double z = r * Math.cos(t);
							loc.add(x, y, z);
							DustOptions dustOptions = new DustOptions(Color.fromRGB(255, 0, 255), 1);
							player.getWorld().spawnParticle(Particle.REDSTONE, loc, 10, dustOptions);
							loc.subtract(x, y, z);
						}
					}, 0l, 1l).getTaskId());
				}
			} else {
				Bukkit.getScheduler().cancelTask(playerTask.get(player.getName()));
				playerTask.remove(player.getName());
			}
		} else {
			return;
		}
	}

}
