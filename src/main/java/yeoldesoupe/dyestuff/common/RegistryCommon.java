package yeoldesoupe.dyestuff.common;

import yeoldesoupe.dyestuff.DyeStuff;
import yeoldesoupe.dyestuff.common.item.WeightedDye;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistryCommon {
	public static Item WEIGHTED_DYE = new WeightedDye();
	
	public static void init() {
		Registry.register(Registry.ITEM, new Identifier(DyeStuff.MODID, "weighted_dye"), WEIGHTED_DYE);
	}
}