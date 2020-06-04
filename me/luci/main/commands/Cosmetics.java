package me.luci.main.commands;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.luci.main.guis.GUITest;

public class Cosmetics implements CommandExecutor {

	private ItemStack on, off;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		on = GUITest.createItem(Material.MAGENTA_DYE, 1, "&d&l&nMagenta circle",
				Arrays.asList("&d&l&nMagenta circle around your feet as you fly.", "&4&lOff"));
		off = GUITest.createItem(Material.MAGENTA_DYE, 1, "&d&l&nMagenta circle",
				Arrays.asList("&d&l&nMagenta circle around your feet as you fly.", "&a&lOn"));
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			p.getPlayer().openInventory(GUITest.inv);
			if (p.hasPermission("gayworld.flight.particle.pink.circle")) {
				GUITest.inv.setItem(10, off);
			} else {
				GUITest.inv.setItem(10, on);
			}
		}
		
		return true;
	}

}
