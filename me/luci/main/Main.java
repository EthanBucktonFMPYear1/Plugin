package me.luci.main;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.luci.main.commands.Cosmetics;
import me.luci.main.effects.EffectLibTest;
import me.luci.main.events.ArmorListener;
import me.luci.main.events.DispenserArmorListener;
import me.luci.main.events.PreventAnvilUse;
import me.luci.main.guis.GUITest;
import me.luci.main.wearing.Boots;
import me.luci.main.wearing.Chestplates;
import me.luci.main.wearing.Helmets;
import me.luci.main.wearing.Leggings;

public class Main extends JavaPlugin implements Listener {

	public static Main instance;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);

		// Wearing effects
		getServer().getPluginManager().registerEvents(new Helmets(), this);
		getServer().getPluginManager().registerEvents(new Boots(), this);
		getServer().getPluginManager().registerEvents(new Chestplates(), this);
		getServer().getPluginManager().registerEvents(new Leggings(), this);
		getServer().getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);

		// Prevents anvil usage
		getServer().getPluginManager().registerEvents(new PreventAnvilUse(), this);

		// Effects
		getServer().getPluginManager().registerEvents(new EffectLibTest(), this);

		// GUI
		getServer().getPluginManager().registerEvents(new GUITest(this), this);
		instance = this;

		try {
			// Better way to check for this? Only in 1.13.1+?
			Class.forName("org.bukkit.event.block.BlockDispenseArmorEvent");
			getServer().getPluginManager().registerEvents(new DispenserArmorListener(), this);
		} catch (Exception ignored) {
		}

		// Helmets
		CraniumHelmet craniumHelmet = new CraniumHelmet();
		craniumHelmet.customRecipe();
		TheHelmetOfBeguilingGaze THOBG = new TheHelmetOfBeguilingGaze();
		THOBG.customRecipe();
		TheCapOfEndlessInhalation TCOEI = new TheCapOfEndlessInhalation();
		TCOEI.customRecipe();

		// Boots
		TheClogsOfManicDepressive TCOMD = new TheClogsOfManicDepressive();
		TCOMD.customRecipe();
		TheWellingtonsOfWaterWading TWOFWW = new TheWellingtonsOfWaterWading();
		TWOFWW.customRecipe();
		TheMightyBoots mightyBoots = new TheMightyBoots();
		mightyBoots.customRecipe();

		// Chestplates
		TheBreastplateOfIntimidatingStature TBOIS = new TheBreastplateOfIntimidatingStature();
		TBOIS.customRecipe();
		TheChestplateOfPureDefense TCOPD = new TheChestplateOfPureDefense();
		TCOPD.customRecipe();
		TheChestplateForMagnificentBosoms TCFMB = new TheChestplateForMagnificentBosoms();
		TCFMB.customRecipe();

		// Leggings
		TheLeggingsOfHighSplendor TLOHS = new TheLeggingsOfHighSplendor();
		TLOHS.customRecipe();
		ThePantaloonsOfHellfire TPOHF = new ThePantaloonsOfHellfire();
		TPOHF.customRecipe();
		ThePantyhoseOfPerpetualProtection TPOPP = new ThePantyhoseOfPerpetualProtection();
		TPOPP.customRecipe();

		// Register commands
		this.getCommand("cosmetics").setExecutor(new Cosmetics());

	}

	public static Main getInstance() {
		return instance;
	}

	@Override
	public void onDisable() {
		// Dispose of the effectmanager
	}
}
