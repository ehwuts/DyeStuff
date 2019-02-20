package yeoldesoupe.dyestuff.common.util;

import yeoldesoupe.dyestuff.common.util.ColorUtil;
import java.lang.Integer;
import net.minecraft.item.DyeItem;
import net.minecraft.util.DyeColor;

public class WeightedDyeColor {
	private int color = 0xFFFFFF;
	private int weight = 0;

	public WeightedDyeColor () {
		//default to the weightless white
	}
	public WeightedDyeColor (int color, int weight) {
		this.color = color;
		this.weight = 1;
	}
	public WeightedDyeColor (int color) {
		this(color, 1);
	}
	public WeightedDyeColor(float[] colorComponents, int weight) {
		this(ColorUtil.floatComponentsToHex(colorComponents), weight);
	}
	public WeightedDyeColor(float[] colorComponents) {
		this(ColorUtil.floatComponentsToHex(colorComponents), 1);
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
		this(weightedDyeColor.getColor(), weightedDyeColor.getWeight());
	}

	public float[] getColorComponents() {
		return ColorUtil.hexToFloatComponents(this.color);
	}
	public int getColor() {
		return this.color;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setColor(int color, int weight) {
		this.color = color;
		this.weight = weight;
	}
	public void setColor(int color) {
		this.setColor(weight, 1);
	}
	public void setColor(float[] colorComponents, int weight) {
		this.setColor(ColorUtil.floatComponentsToHex(colorComponents), weight);
	}
	public void setColor(float[] colorComponents) {
		this.setColor(ColorUtil.floatComponentsToHex(colorComponents), weight);
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
		this.setColor(weightedDyeColor.getColor(), weight);
	}
	public void setColor(WeightedDyeColor weightedDyeColor) {
		this.setColor(weightedDyeColor.getColor(), 1);
	}

	public void addColor(float[] colorComponents, int weight) {
		float[] colorComponentsOld = this.getColorComponents();
		int weight_old = this.weight;
		int weight_new = (Integer.MAX_VALUE - this.weight >= weight) ? this.weight + weight : Integer.MAX_VALUE;

		float red_new = (colorComponentsOld[0] * weight_old + colorComponents[0] * weight) / weight_new;
		float green_new = (colorComponentsOld[1] * weight_old + colorComponents[1] * weight) / weight_new;
		float blue_new = (colorComponentsOld[2] * weight_old + colorComponents[2] * weight) / weight_new;
		
		float[] colorComponents_new = {red_new , green_new, blue_new};
		
		this.setColor(colorComponents_new);
		this.weight = weight_new;
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
		this.addColor(weightedDyeColor, 1);
	}
}
