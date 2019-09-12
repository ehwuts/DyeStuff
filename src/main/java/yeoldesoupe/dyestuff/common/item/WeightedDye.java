package yeoldesoupe.dyestuff.common.item;

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
	public WeightedDye () {
		super(new Item.Settings().group(ItemGroup.MISC).maxCount(1));
	}

    @Environment(EnvType.CLIENT)
	public static class ColorHandler implements ItemColorProvider {
		@Override
		public int getColor(ItemStack stack, int layer) {
			return (new WeightedDyeColor(stack)).getColor();
		}
	}

	@Override
    @Environment(EnvType.CLIENT)
    public void appendTooltip(ItemStack stack, World world, List<Text> text, TooltipContext tooltip) {
		WeightedDyeColor weightedDyeColor = new WeightedDyeColor(stack);
        text.add(new LiteralText("#" + Integer.toHexString(weightedDyeColor.getColor())));
		text.add(new LiteralText("x" + weightedDyeColor.getWeight()));
    }
}