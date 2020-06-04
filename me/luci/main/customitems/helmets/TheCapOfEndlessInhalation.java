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

public class TheCapOfEndlessInhalation implements Listener {
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public void customRecipe() {
		ItemStack item = new ItemStack(Material.DIAMOND_HELMET, 1);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "The Cap Of Endless Inhalation");
		ArrayList<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Respiration III, Protection V");
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, "Endless");
		ShapedRecipe re = new ShapedRecipe(key, item);
		
		re.shape("#$#", "# #", "   ");
		re.setIngredient('#', Material.EMERALD);
		re.setIngredient('$', Material.NETHER_STAR);
		
		Bukkit.addRecipe(re);
	}

}
