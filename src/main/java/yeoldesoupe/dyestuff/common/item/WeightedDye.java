package yeoldesoupe.dyestuff.common.item;

import yeoldesoupe.dyestuff.common.util.CompoundUtils;
import yeoldesoupe.dyestuff.common.util.WeightedDyeColor;
import net.minecraft.client.item.TooltipOptions;
import net.minecraft.client.render.item.ItemColorMapper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.TextComponent;
import net.minecraft.text.StringTextComponent;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import java.lang.Integer;
import java.util.List;

public class WeightedDye extends Item {
	private static final String DYE_COLOR = "weighted_dye_color";
	private static final String DYE_WEIGHT = "weighted_dye_weight";
	
	public WeightedDye () {
		super(new Item.Settings().itemGroup(ItemGroup.MISC).stackSize(1));
	}

    @Environment(EnvType.CLIENT)
	public static class ColorHandler implements ItemColorMapper {
		@Override
		public int getColor(ItemStack stack, int layer) {
			return WeightedDye.getColor(stack);
		}
	}
	
	public static int getColor(ItemStack stack) {
		return (int)CompoundUtils.getLong(stack, DYE_COLOR, 0xFFFFFF);
	}
	
	public static int getColorWeight(ItemStack stack) {
		return (int)CompoundUtils.getLong(stack, DYE_WEIGHT, 0);
	}
	
	public static WeightedDyeColor getWeightedDyeColor(ItemStack stack) {
		return new WeightedDyeColor(getColor(stack), getColorWeight(stack));
	}
	
	public static void setColor(ItemStack stack, WeightedDyeColor weightedDyeColor) {
		CompoundUtils.setLong(stack, DYE_COLOR, (long)weightedDyeColor.getColor());
		CompoundUtils.setLong(stack, DYE_WEIGHT, (long)weightedDyeColor.getWeight());
	}

	@Override
    @Environment(EnvType.CLIENT)
    public void buildTooltip(ItemStack stack, World world, List<TextComponent> text, TooltipOptions tooltip) {
        text.add(new StringTextComponent("#" + Integer.toHexString(getColor(stack))));
		text.add(new StringTextComponent("x" + Integer.toString(getColorWeight(stack))));
    }
}