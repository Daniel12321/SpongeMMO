package me.mrdaniel.adventuremmo.catalogtypes.abilities;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;

import me.mrdaniel.adventuremmo.catalogtypes.abilities.abilities.SuperTool;
import me.mrdaniel.adventuremmo.catalogtypes.tools.ToolTypes;
import me.mrdaniel.adventuremmo.utils.I18N;

public final class Abilities {

	private Abilities() {
	}

	public static final ActiveAbility MAD_MINER = new ActiveAbility(I18N.get("ability.active.Mad_Miner"), "madminer",
			new SuperTool(ToolTypes.PICKAXE));
	public static final ActiveAbility GIGA_DRILL = new ActiveAbility(I18N.get("ability.active.Giga_Drill"), "gigadrill",
			new SuperTool(ToolTypes.SHOVEL));
	public static final ActiveAbility TREE_FELLER = new ActiveAbility(I18N.get("ability.active.Tree_Feller"), "treefeller",
			ActiveAbilityActions.EMPTY);
	public static final ActiveAbility FISH_FRENZY = new ActiveAbility(I18N.get("ability.active.Fish_Frenzy"), "fishfrenzy",
			new SuperTool(ToolTypes.ROD));
	public static final ActiveAbility GREEN_THUMBS = new ActiveAbility(I18N.get("ability.active.Green_Thumbs"), "greenthumbs",
			ActiveAbilityActions.EMPTY);
	public static final ActiveAbility BLOODSHED = new ActiveAbility(I18N.get("ability.active.Bloodshed"), "bloodshed",
			ActiveAbilityActions.EMPTY);
	public static final ActiveAbility SLAUGHTER = new ActiveAbility(I18N.get("ability.active.Slaughter"), "slaughter",
			ActiveAbilityActions.EMPTY);
	public static final ActiveAbility SAITAMA_PUNCH = new ActiveAbility(I18N.get("ability.active.Saitama_Punch"), "saitamapunch",
			ActiveAbilityActions.EMPTY);

	public static final PassiveAbility ROLL = new PassiveAbility(I18N.get("ability.passive.Roll"), "roll");
	public static final PassiveAbility DODGE = new PassiveAbility(I18N.get("ability.passive.Dodge"), "dodge");
	public static final PassiveAbility DISARM = new PassiveAbility(I18N.get("ability.passive.Disarm"), "disarm");
	public static final PassiveAbility DECAPITATE = new PassiveAbility(I18N.get("ability.passive.Decapitate"), "decapitate");
	public static final PassiveAbility ARROW_RAIN = new PassiveAbility(I18N.get("ability.passive.Arrow_Rain"), "arrowrain");
	public static final PassiveAbility TREASURE_HUNT = new PassiveAbility(I18N.get("ability.passive.Treasure_Hunt"), "treasurehunt");
	public static final PassiveAbility WATER_TREASURE = new PassiveAbility(I18N.get("ability.passive.Water_Treasure"), "watertreasure");
	public static final PassiveAbility DOUBLE_DROP = new PassiveAbility(I18N.get("ability.passive.Double_Drop"), "doubledrop");

	public static final List<Ability> VALUES = Lists.newArrayList(MAD_MINER, GIGA_DRILL, TREE_FELLER, FISH_FRENZY,
			GREEN_THUMBS, BLOODSHED, SLAUGHTER, SAITAMA_PUNCH, ROLL, DODGE, DISARM, DECAPITATE, ARROW_RAIN,
			TREASURE_HUNT, WATER_TREASURE, DOUBLE_DROP);

	@Nonnull
	public static Optional<Ability> of(@Nonnull final String id) {
		for (Ability type : VALUES) {
			if (type.getId().equalsIgnoreCase(id)) {
				return Optional.of(type);
			}
		}
		return Optional.empty();
	}
}