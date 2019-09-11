package yeoldesoupe.dyestuff.common.item;

import yeoldesoupe.dyestuff.common.util.NBTUtil;
import yeoldesoupe.dyestuff.common.util.WeightedDyeColor;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.LiteralText;
import net.minecraft.world.World;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import java.lang.Integer;
import java.util.List;

public class WeightedDye extends Item {
	private static final String DYE_COLOR = "weighted_dye_color";
	private static final String DYE_WEIGHT = "weighted_dye_weight";
	
	public WeightedDye () {
		super(new Item.Settings().group(ItemGroup.MISC).maxCount(1));
	}

    @Environment(EnvType.CLIENT)
	public static class ColorHandler implements ItemColorProvider {
		@Override
		public int getColor(ItemStack stack, int layer) {
			return WeightedDye.getColor(stack);
		}
	}
	
	public static int getColor(ItemStack stack) {
		return (int)NBTUtil.getInt(stack, DYE_COLOR, 0xFFFFFF);
	}
	
	public static int getColorWeight(ItemStack stack) {
		return (int)NBTUtil.getInt(stack, DYE_WEIGHT, 0);
	}
	
	public static WeightedDyeColor getWeightedDyeColor(ItemStack stack) {
		return new WeightedDyeColor(getColor(stack), getColorWeight(stack));
	}
	
	public static void setColor(ItemStack stack, WeightedDyeColor weightedDyeColor) {
		NBTUtil.setInt(stack, DYE_COLOR, weightedDyeColor.getColor());
		NBTUtil.setInt(stack, DYE_WEIGHT, weightedDyeColor.getWeight());
	}

	@Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, World world, List<Text> text, TooltipContext tooltip) {
        text.add(new LiteralText("#" + Integer.toHexString(getColor(stack))));
		text.add(new LiteralText("x" + Integer.toString(getColorWeight(stack))));
    }
}