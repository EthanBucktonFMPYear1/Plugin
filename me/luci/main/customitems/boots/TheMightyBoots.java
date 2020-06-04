package me.luci.main.customitems.boots;

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

public class TheMightyBoots implements Listener {
	
	private Plugin plugin = Main.getPlugin(Main.class);
	
	public void customRecipe() {
		ItemStack item = new ItemStack(Material.DIAMOND_BOOTS, 1);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.GOLD + "The Mighty Boots");
		ArrayList<String> lore = new ArrayList<String>();
		
		lore.add(ChatColor.GRAY + "Jump Boost III, Protection V, Depth Strider III");
		meta.setLore(lore);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
		item.addUnsafeEnchantment(Enchantment.DEPTH_STRIDER, 3);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(plugin, "Mighty");
		ShapedRecipe re = new ShapedRecipe(key, item);
		
		re.shape("# #", "# #", "   ");
		re.setIngredient('#', Material.EMERALD);
		
		Bukkit.addRecipe(re);
	}

}
