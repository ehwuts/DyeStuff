package yeoldesoupe.dyestuff.common;

import yeoldesoupe.dyestuff.DyeStuff;
import yeoldesoupe.dyestuff.common.item.WeightedDye;
import yeoldesoupe.dyestuff.recipe.WeightedDyeWeighting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.SpecialRecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistryCommon {
	public static Item WEIGHTED_DYE = new WeightedDye();
	public static SpecialRecipeSerializer<WeightedDyeWeighting> WEIGHTED_DYE_WEIGHTING; 
	
	public static void init() {
		Registry.register(Registry.ITEM, new Identifier(DyeStuff.MODID, "weighted_dye"), WEIGHTED_DYE);
		
		WEIGHTED_DYE_WEIGHTING = (SpecialRecipeSerializer)(RecipeSerializer.register("weighted_dye_weighting", new SpecialRecipeSerializer((v) -> { return new WeightedDyeWeighting("weighted_dye_weighting"); })));
	}
}