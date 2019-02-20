package yeoldesoupe.dyestuff.recipe;

import yeoldesoupe.dyestuff.DyeStuff;
import yeoldesoupe.dyestuff.common.RegistryCommon;
import yeoldesoupe.dyestuff.common.item.WeightedDye;
import yeoldesoupe.dyestuff.common.util.WeightedDyeColor;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.DyeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.crafting.SpecialCraftingRecipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class WeightedDyeWeighting extends SpecialCraftingRecipe {
	public WeightedDyeWeighting(String name) {
		super(new Identifier(DyeStuff.MODID, name));
	}
	
	@Override
	public boolean matches(CraftingInventory craftingInventory, World world) {
		boolean found_weighted_dye = false;
		boolean found_vanilla_dye = false;
		
		for(int i = 0; i < craftingInventory.getInvSize(); ++i) {
			ItemStack here = craftingInventory.getInvStack(i);
			if (!here.isEmpty()) {
				if (here.getItem() instanceof WeightedDye) {
					if (found_weighted_dye) {
						return false;
					} else {
						found_weighted_dye = true;
					}
				} else if (here.getItem() instanceof DyeItem) {
					found_vanilla_dye = true;
				} else {
					return false;
				}
			}
		}
		
		return found_weighted_dye && found_vanilla_dye;
	}
	
	@Override
	public ItemStack craft(CraftingInventory craftingInventory) {
		WeightedDyeColor result = new WeightedDyeColor(0, 0);
		ItemStack target = ItemStack.EMPTY;
		
		for(int i = 0; i < craftingInventory.getInvSize(); ++i) {
			ItemStack here = craftingInventory.getInvStack(i);
			if (!here.isEmpty()) {
				if (here.getItem() instanceof WeightedDye) {
					if (!target.isEmpty()) {
						return ItemStack.EMPTY;
					}
					result.addColor(((WeightedDye)here.getItem()).getWeightedDyeColor(here));
					target = here.copy();
				} else if (here.getItem() instanceof DyeItem) {
					result.addColor((DyeItem)here.getItem(), 1);
				} else {
					return ItemStack.EMPTY;
				}
			}
		}
		
		if (target.isEmpty()) {
			return ItemStack.EMPTY;
		}
			
		((WeightedDye)target.getItem()).setColor(target, result);
		return target;
	}
	
	@Override
	@Environment(EnvType.CLIENT)
	public boolean fits(int int_1, int int_2) {
		return int_1 * int_2 >= 2;
	}
	
	@Override
	public RecipeSerializer<?> getSerializer() {
		return RegistryCommon.WEIGHTED_DYE_WEIGHTING;
	}
}