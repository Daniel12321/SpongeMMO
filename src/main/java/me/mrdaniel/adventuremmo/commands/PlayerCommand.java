package me.mrdaniel.adventuremmo.commands;

import me.mrdaniel.adventuremmo.utils.I18N;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

public abstract class PlayerCommand implements CommandExecutor {

	@Override
	public CommandResult execute(final CommandSource src, final CommandContext args) throws CommandException {
		if (!(src instanceof Player)) {
			src.sendMessage(Text.of(TextColors.RED, I18N.get("cmd.except.cmd_for_user")));
			return CommandResult.success();
		}
		Player p = (Player) src;

		this.execute(p, args);
		return CommandResult.success();
	}

	public abstract void execute(Player p, CommandContext args) throws CommandException;
}