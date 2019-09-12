package yeoldesoupe.dyestuff.common.util;

import yeoldesoupe.dyestuff.common.util.ColorUtil;
import java.lang.Integer;
import net.minecraft.item.DyeItem;
import net.minecraft.util.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;

// TODO: clean this up into a tidy temp-use buffer
public class WeightedDyeColor {
	private static final String DYE_TAG_GROUP  = "weighted_dye_color";
	private static final String DYE_TAG_COLOR = "color";
	private static final String DYE_TAG_WEIGHT = "weight";
	private float[] colors = new float[]{1.0f, 1.0f, 1.0f};
	private int weight_v = 0;

	public WeightedDyeColor () {
		//default to weightless white
	}
	public WeightedDyeColor(float[] colorComponents, int weight) {
		this.colors = colorComponents;
		this.weight_v = weight;
	}
	public WeightedDyeColor(float[] colorComponents) {
		this(colorComponents, 1);
	}
	public WeightedDyeColor (int color, int weight) {
		this(ColorUtil.hexToFloatComponents(color), weight);
	}
	public WeightedDyeColor (int color) {
		this(color, 1);
	}
	public WeightedDyeColor (DyeColor dyeColor, int weight) {
		this(dyeColor.getColorComponents(), weight);
	}
	public WeightedDyeColor (DyeColor dyeColor) {
		this(dyeColor.getColorComponents(), 1);
	}
	public WeightedDyeColor (DyeItem dyeItem, int weight) {
		this(dyeItem.getColor(), weight);
	}
	public WeightedDyeColor (DyeItem dyeItem) {
		this(dyeItem.getColor(), 1);
	}
	public WeightedDyeColor (WeightedDyeColor weightedDyeColor) {
		this(weightedDyeColor.getColorComponents(), weightedDyeColor.getWeight());
	}

	public float[] getColorComponents() {
		return this.colors;
	}
	public int getColor() {
		return ColorUtil.floatComponentsToHex(this.colors);
	}

	public int getWeight() {
		return this.weight_v;
	}

	public void setColor(float[] colorComponents, int weight) {
		this.colors = colorComponents;
		this.weight_v = weight;
	}
	public void setColor(int color, int weight) {
		this.setColor(ColorUtil.hexToFloatComponents(color) , weight);
	}
	public void setColor(int color) {
		this.setColor(color, 1);
	}
	public void setColor(float[] colorComponents) {
		this.setColor(colorComponents, 1);
	}
	public void setColor(DyeColor dyeColor, int weight) {
		this.setColor(dyeColor.getColorComponents(), weight);
	}
	public void setColor(DyeColor dyeColor) {
		this.setColor(dyeColor.getColorComponents(), 1);
	}
	public void setColor(DyeItem dyeItem, int weight) {
		this.setColor(dyeItem.getColor(), weight);
	}
	public void setColor(DyeItem dyeItem) {
		this.setColor(dyeItem.getColor(), 1);
	}
	public void setColor(WeightedDyeColor weightedDyeColor, int weight) {
		this.setColor(weightedDyeColor.getColorComponents(), weight);
	}
	public void setColor(WeightedDyeColor weightedDyeColor) {
		this.setColor(weightedDyeColor.getColorComponents(), 1);
	}

	public void addColor(float[] colorComponents, int weight) {
		float[] colorComponents_old = this.getColorComponents();
		int weight_old = this.weight_v;
		int weight_new = (Integer.MAX_VALUE - this.weight_v >= weight) ? this.weight_v + weight : Integer.MAX_VALUE;

		// TODO: figure out appropriate handling for weird inputs
		float red_new = weight_old == 0 ? colorComponents[0] : (colorComponents_old[0] * weight_old + colorComponents[0] * weight) / weight_new;
		float green_new = weight_old == 0 ? colorComponents[1] : (colorComponents_old[1] * weight_old + colorComponents[1] * weight) / weight_new;
		float blue_new = weight_old == 0 ? colorComponents[2] : (colorComponents_old[2] * weight_old + colorComponents[2] * weight) / weight_new;
		
		float[] colorComponents_new = {red_new , green_new, blue_new};
		
		this.setColor(colorComponents_new);
		this.weight_v = weight_new;
	}
	public void addColor(float[] colorComponents) {
		this.addColor(colorComponents, 1);
	}
	public void addColor(int color, int weight) {
		this.addColor(ColorUtil.hexToFloatComponents(color), weight);
	}
	public void addColor(int color) {
		this.addColor(color, 1);
	}
	public void addColor(DyeColor dyeColor, int weight) {
		this.addColor(dyeColor.getColorComponents(), weight);
	}
	public void addColor(DyeColor dyeColor) {
		this.addColor(dyeColor, 1);
	}
	public void addColor(DyeItem dyeItem, int weight) {
		this.addColor(dyeItem.getColor(), weight);
	}
	public void addColor(DyeItem dyeItem) {
		this.addColor(dyeItem, 1);
	}
	public void addColor(WeightedDyeColor weightedDyeColor, int weight) {
		this.addColor(weightedDyeColor.getColorComponents(), weight);
	}
	public void addColor(WeightedDyeColor weightedDyeColor) {
		this.addColor(weightedDyeColor.getColorComponents(), weightedDyeColor.getWeight());
	}
}
