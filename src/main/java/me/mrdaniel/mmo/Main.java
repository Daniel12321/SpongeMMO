package me.mrdaniel.mmo;

import java.io.File;

import org.slf4j.Logger;
import org.spongepowered.api.Game;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStoppingEvent;
import org.spongepowered.api.plugin.Plugin;

import com.google.inject.Inject;

import me.mrdaniel.mmo.commands.CommandMMOAdmin;
import me.mrdaniel.mmo.commands.CommandMMOReload;
import me.mrdaniel.mmo.commands.CommandShell;
import me.mrdaniel.mmo.commands.CommandSkills;
import me.mrdaniel.mmo.commands.CommandTop;
import me.mrdaniel.mmo.io.AdvancedConfig;
import me.mrdaniel.mmo.io.BlackList;
import me.mrdaniel.mmo.io.Config;
import me.mrdaniel.mmo.io.ModdedBlocks;
import me.mrdaniel.mmo.io.ModdedTools;
import me.mrdaniel.mmo.io.blocktracking.ChunkManager;
import me.mrdaniel.mmo.io.players.MMOPlayerDatabase;
import me.mrdaniel.mmo.io.top.SkillTop;
import me.mrdaniel.mmo.listeners.AbilityListener;
import me.mrdaniel.mmo.listeners.BlockListener;
import me.mrdaniel.mmo.listeners.PlayerListener;
import me.mrdaniel.mmo.listeners.WorldListener;

@Plugin(id = "adventuremmo", name = "AdventureMMO", version = "1.3.0")
public class Main {

	@Inject
	private Logger logger;
	@Inject
	private Game game;
	
	private static Main instance;
	public static Main getInstance() { return instance; }
	public Game getGame() { return game; }
	public Logger getLogger() { return logger; }
	
	@Listener
	public void onEnable(GameInitializationEvent event) {
		logger.info("Preparing plugin");
		Main.instance = this;
		File folder = new File("config/mmo");
		if (!folder.exists()) folder.mkdir();
		
		MMOPlayerDatabase.getInstance().setup();
		Config.setup();
		AdvancedConfig.setup();
		SkillTop.getInstance().setup();
		ModdedBlocks.setup();
		ModdedTools.setup();
		BlackList.setup();
		
		ChunkManager.getInstance().setup();
		
		game.getCommandManager().register(this, new CommandSkills(), "skill", "skills", "stat", "stats", "mmoskills", "mmostats");
		game.getCommandManager().register(this, new CommandTop(), "skilltop", "skillstop", "stattop", "statstop", "mmoskillstop", "mmostatstop");
		game.getCommandManager().register(this, new CommandShell("acrobatics"), "acrobatics");
		game.getCommandManager().register(this, new CommandShell("excavation"), "excavation");
		game.getCommandManager().register(this, new CommandShell("farming"), "farming");
		game.getCommandManager().register(this, new CommandShell("fishing"), "fishing");
		game.getCommandManager().register(this, new CommandShell("mining"), "mining");
		game.getCommandManager().register(this, new CommandShell("salvage"), "salvage");
		game.getCommandManager().register(this, new CommandShell("taming"), "taming");
		game.getCommandManager().register(this, new CommandShell("woodcutting"), "woodcutting");
		game.getCommandManager().register(this, new CommandShell("repair"), "repair");
		game.getCommandManager().register(this, new CommandMMOAdmin(), "mmoadmin");
		game.getCommandManager().register(this, new CommandMMOReload(), "mmoreload");
		
		game.getEventManager().registerListeners(this, new WorldListener());
		game.getEventManager().registerListeners(this, new PlayerListener());
		game.getEventManager().registerListeners(this, new AbilityListener());
		game.getEventManager().registerListeners(this, new BlockListener());
		
		logger.info("Plugin Enabled");
    }
	
	@Listener
	public void onDisable(GameStoppingEvent e) {
		logger.info("Saving All Data");
		MMOPlayerDatabase.getInstance().writeAll();
		ChunkManager.getInstance().writeAll();
	}
}