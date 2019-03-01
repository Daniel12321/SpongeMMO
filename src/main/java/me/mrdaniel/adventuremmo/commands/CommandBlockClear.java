package me.mrdaniel.adventuremmo.commands;

import me.mrdaniel.adventuremmo.AdventureMMO;
import me.mrdaniel.adventuremmo.utils.I18N;
import me.mrdaniel.adventuremmo.utils.ServerUtils;
import org.spongepowered.api.block.BlockType;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

import javax.annotation.Nonnull;
import java.util.Optional;

public class CommandBlockClear extends PlayerCommand {

	private final AdventureMMO mmo;

	public CommandBlockClear(@Nonnull final AdventureMMO mmo) {
		this.mmo = mmo;
	}

	@Override
	public void execute(final Player p, final CommandContext args) throws CommandException {
		Optional<Location<World>> loc = ServerUtils.getFirstBlock(p);
		if (!loc.isPresent()) {
			p.sendMessage(Text.of(TextColors.RED, I18N.get("cmd.msg.must_look_at_block")));
			return;
		}

		BlockType block = loc.get().getBlockType();

		this.mmo.getItemDatabase().remove(block);
		this.mmo.getMessages().sendBlockClear(p, block);
	}
}