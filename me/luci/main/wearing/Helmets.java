package me.luci.main.wearing;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.luci.main.Main;
import me.luci.main.events.ArmorEquipEvent;

public class Helmets implements Listener {

	private Plugin plugin = Main.getPlugin(Main.class);

	boolean cancel = false;

	public void runnable(PotionEffectType type, int effectDuration, int aplifier, int delay, int period,
			ArmorEquipEvent event) {
		new BukkitRunnable() {
			@Override
			public void run() {
				event.getPlayer().addPotionEffect(new PotionEffect(type, effectDuration, aplifier));
				if (cancel == true) {
					this.cancel();
				}
			}
		}.runTaskTimer(plugin, delay, period);
	}

	@EventHandler
	public void onWear(ArmorEquipEvent e) {
		if (e.getNewArmorPiece().getType() == Material.DIAMOND_HELMET) {
			if (e.getNewArmorPiece().getItemMeta().getDisplayName()
					.equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "the protecter of fine craniums")) {
				this.runnable(PotionEffectType.WATER_BREATHING, 100, 0, 0, 100, e);
				cancel = false;
			} else if (e.getNewArmorPiece().getItemMeta().getDisplayName()
					.equalsIgnoreCase(ChatColor.AQUA + "The Helmet Of Beguiling Gaze")) {
				this.runnable(PotionEffectType.WATER_BREATHING, 500, 1, 0, 500, e);
				cancel = false;
			} else if (e.getNewArmorPiece().getItemMeta().getDisplayName()
					.equalsIgnoreCase(ChatColor.GOLD + "The Cap Of Endless Inhalation")) {
				e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 100000000, 2, true));
				cancel = false;
			}
		}

		if (e.getNewArmorPiece().getType() == Material.AIR) {
			if (e.getOldArmorPiece().getItemMeta().getDisplayName()
					.equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "the protecter of fine craniums")) {
				e.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
				cancel = true;
			} else if (e.getOldArmorPiece().getItemMeta().getDisplayName()
					.equalsIgnoreCase(ChatColor.AQUA + "The Helmet Of Beguiling Gaze")) {
				e.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
				cancel = true;
			} else if (e.getOldArmorPiece().getItemMeta().getDisplayName()
					.equalsIgnoreCase(ChatColor.GOLD + "The Cap Of Endless Inhalation")) {
				e.getPlayer().removePotionEffect(PotionEffectType.WATER_BREATHING);
				cancel = true;
			}
		}
	}
}