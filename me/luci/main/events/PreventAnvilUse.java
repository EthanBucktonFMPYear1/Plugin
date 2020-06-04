package me.luci.main.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import net.md_5.bungee.api.ChatColor;

public class PreventAnvilUse implements Listener {

	@EventHandler // (priority = EventPriority.LOWEST)
	public void playerRenameItem(InventoryClickEvent event) {
		if (event.getView().getType() == InventoryType.ANVIL) {
			if (event.getRawSlot() == 2) {
				if (event.getView().getItem(0).getType() != Material.AIR
						&& event.getView().getItem(2).getType() != Material.AIR) {
					if (event.getView().getItem(0).getItemMeta().getDisplayName() != event.getView().getItem(2)
							.getItemMeta().getDisplayName()) {
						event.setCancelled(true);
						event.getWhoClicked().sendMessage(ChatColor.DARK_RED + "Renaming items is disabled.");
						event.getWhoClicked().closeInventory();
					}
				}
			}
		}
	}

}
