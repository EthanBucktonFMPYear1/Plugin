package me.luci.main.customitems.helmets;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.luci.main.Main;
import net.md_5.bungee.api.ChatColor;

public class TheHelmetOfBeguilingGaze implements Listener {

	private Plugin plugin = Main.getPlugin(Main.class);

	public void customRecipe() {
		ItemStack item = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.AQUA + "The Helmet Of Beguiling Gaze");
		ArrayList<String> lore = new ArrayList<String>();

		lore.add(ChatColor.GRAY + "Respiration II, Protection IV");
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
		item.setItemMeta(meta);

		NamespacedKey key = new NamespacedKey(plugin, "Gaze");
		ShapedRecipe re = new ShapedRecipe(key, item);
		
		re.shape("#$#", "# #", "   ");
		re.setIngredient('#', Material.DIAMOND);
		re.setIngredient('$', Material.LAVA_BUCKET);
		
		Bukkit.addRecipe(re);
	}

}
