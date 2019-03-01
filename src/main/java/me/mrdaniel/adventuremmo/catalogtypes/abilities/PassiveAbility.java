package me.mrdaniel.adventuremmo.catalogtypes.abilities;

import javax.annotation.Nonnull;

import me.mrdaniel.adventuremmo.utils.I18N;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.text.MessageFormat;

public class PassiveAbility extends Ability {

	public PassiveAbility(@Nonnull final String name, @Nonnull final String id) {
		super(name, id);
	}

	public boolean getChance(final int level) {
		return super.getValue(level) > Math.random() * 100;
	}

	@Override
	public Text getValueLine(int level) {

		return Text.of(TextColors.YELLOW,
				MessageFormat.format(I18N.get("msg.chance.passive_ability"),
						String.format("%.2f", super.getValue(level))));
	}
}