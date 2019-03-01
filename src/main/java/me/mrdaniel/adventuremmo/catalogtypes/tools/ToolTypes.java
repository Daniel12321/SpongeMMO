package me.mrdaniel.adventuremmo.catalogtypes.tools;

import java.util.List;
import java.util.Optional;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;
import me.mrdaniel.adventuremmo.utils.I18N;

public final class ToolTypes {

	private ToolTypes() {
	}

	public static final ToolType PICKAXE = new ToolType(I18N.get("tool.Pickaxe"), "pickaxe");
	public static final ToolType AXE = new ToolType(I18N.get("tool.Axe"), "axe");
	public static final ToolType SHOVEL = new ToolType(I18N.get("tool.Shovel"), "shovel");
	public static final ToolType HOE = new ToolType(I18N.get("tool.Hoe"), "hoe");
	public static final ToolType ROD = new ToolType(I18N.get("tool.Fishing_Rod"), "rod");
	public static final ToolType SWORD = new ToolType(I18N.get("tool.Sword"), "sword");
	public static final ToolType HAND = new ToolType(I18N.get("tool.Hand"), "hand");
	public static final ToolType BOW = new ToolType(I18N.get("tool.Bow"), "bow");

	public static final List<ToolType> VALUES = Lists.newArrayList(PICKAXE, AXE, SHOVEL, HOE, ROD, SWORD, HAND, BOW);

	@Nonnull
	public static Optional<ToolType> of(@Nonnull final String id) {
		for (ToolType type : VALUES) {
			if (type.getId().equalsIgnoreCase(id)) {
				return Optional.of(type);
			}
		}
		return Optional.empty();
	}
}