package me.luci.main.guis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.luci.main.Main;

public class GUITest implements Listener {

	public static Inventory inv;

	private ItemStack pinkCircle, border, border2, barrier, on, off;

	private Main main;

	boolean hasPerm;

	public GUITest(Main main) {
		this.main = main;
		inv = Bukkit.createInventory(new Inventoryholder(), 54, ChatColor.DARK_RED + "Cosmetics");
		setupGui();
	}

	@EventHandler
	public void click(InventoryClickEvent e) {
		if (!(e.getInventory().getHolder() instanceof InventoryHolder))
			return;
		Player p = (Player) e.getWhoClicked();
		ItemStack i = e.getCurrentItem();
		if (e.getInventory().equals(inv)) {
			if (i.equals(off)) {
				if (p.hasPermission("gayworld.flight.cosmetic.pink.circle")) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
								"lp user " + p.getName() + " permission unset gayworld.flight.particle.pink.circle");
						e.setCancelled(true);
						p.closeInventory();
						p.sendMessage(ChatColor.AQUA + "Disabled pink circle effect.");
				} else {
					inv.setItem(10, barrier);
					e.setCancelled(true);
				}
			} else if (i.equals(on)) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						"lp user " + p.getName() + " permission set gayworld.flight.particle.pink.circle true");
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage(ChatColor.AQUA + "Enabled pink circle effect.");
			} else if (i.equals(border)) {
				e.setCancelled(true);
			} else if (i.equals(border2)) {
				e.setCancelled(true);
			} else if (i.equals(barrier)) {
				if (p.hasPermission("gayworld.flight.cosmetic.pink.circle")) {
					inv.setItem(10, pinkCircle);
					e.setCancelled(true);
				} else {
					e.setCancelled(true);
				}
			}
		}
	}

	private void setupGui() {
		
		pinkCircle = createItem(Material.MAGENTA_DYE, 1, "&d&l&nMagenta circle",
				Arrays.asList("&d&l&nMagenta circle around your feet as you fly.", ""));
		border = createItem(Material.BLACK_STAINED_GLASS_PANE, 1, "&0&lCosmetics", Arrays.asList(""));
		border2 = createItem(Material.RED_STAINED_GLASS_PANE, 1, "&c&lCosmetics", Arrays.asList(""));
		barrier = createItem(Material.BARRIER, 1, "&c&lError", Arrays.asList("You do not own this cosmetic"));
		on = GUITest.createItem(Material.MAGENTA_DYE, 1, "&d&l&nMagenta circle",
				Arrays.asList("&d&l&nMagenta circle around your feet as you fly.", "&4&lOff"));
		off = GUITest.createItem(Material.MAGENTA_DYE, 1, "&d&l&nMagenta circle",
				Arrays.asList("&d&l&nMagenta circle around your feet as you fly.", "&a&lOn"));

		for (int i = 0; i < inv.getContents().length; i++) {
			if (i % 2 == 0) {
				inv.setItem(i, border);
			} else {
				inv.setItem(i, border2);
			}
		}
		inv.setItem(10, pinkCircle);
	}

	public static ItemStack createItem(Material mat, int amount, String name, List<String> lore) {
		ItemStack i = new ItemStack(mat, amount);
		ItemMeta im = i.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
		List<String> newLore = new ArrayList<String>();
		for (String s : lore) {
			newLore.add(ChatColor.translateAlternateColorCodes('&', s));
		}
		im.setLore(newLore);
		i.setItemMeta(im);
		return i;
	}

}
