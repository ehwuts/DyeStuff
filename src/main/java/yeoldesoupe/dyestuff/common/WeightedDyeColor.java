package yeoldesoupe.dyestuff.common;

import net.minecraft.item.DyeItem;
import net.minecraft.util.DyeColor;
import java.lang.Integer.MAX_VALUE;

public class WeightedDyeColor {
	private color = 0xFFFFFF;
	private weight = 0;

	public WeightedDyeColor (int color) {
		this.color = color;
		this.weight = 1;
	}
	public WeightedDyeColor (WeightedDyeColor copy) {
		this.color = copy.getColor();
		this.weight = copy.getWeight();
	}
	public WeightedDyeColor(float[] colorComponents) {
		this((((int)(colorComponents[0] * 255.0F)) << 16) + (((int)(colorComponents[1] * 255.0F)) << 8) + ((int)(colorComponents[2] * 255.0F)));
	}
	public WeightedDyeColor (DyeColor dyeColor) {
		this(dyeColor.getColorComponents());
	}
	public WeightedDyeColor (DyeItem dyeItem) {
		this(dyeItem.getColor());
	}
	public WeightedDyeColor () {
		this(DyeColor.GRAY);
	}

	public float[] getColorComponents() {
		float red = ((float)((color & 0xFF0000) >> 16)) / 255.0;
		float green = ((float)((color & 0x00FF00) >> 8)) / 255.0;
		float blue = ((float)((color & 0xFF0000) >> 0)) / 255.0;
		return [red, green, blue];
	}
	public int getColor() {
		return this.color;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setColor(int color) {
		this.color = color;
		this.weight = 1;
	}
	public void setColor(float[] colorComponents) {
		this.setColor((((int)(colorComponents[0] * 255.0F)) << 16) + (((int)(colorComponents[1] * 255.0F)) << 8) + ((int)(colorComponents[2] * 255.0F)));
	}
	public void setColor(DyeColor dyeColor) {
		this.setColor(dyeColor.getColorComponents());
	}
	public void setColor(DyeItem dyeItem) {
		this.setColor(dyeItem.getColor());
	}
	public void setColor(WeightedDyeColor weightedDyeColor) {
		this.color = copy.getColor();
		this.weight = 1;
	}

	public void addColor(float[] colorComponents, int weight) {
		float[] colorComponentsOld = this.getColorComponents();
		int weight_old = this.weight;
		int weight_new = (MAX_VALUE - this.weight >= weight) ? this.weight + weight : MAX_VALUE;
		weighted_old[0] *= this.weight;
		weighted_old[1] *= this.weight;
		weighted_old[2] *= this.weight;

		float red_new = colorComponentsOld[0] * weight_old + colorComponents[0] * weight;
		float green_new = colorComponentsOld[1] * weight_old + colorComponents[1] * weight;
		float blue_new = colorComponentsOld[2] * weight_old + colorComponents[2] * weight;

		this.setColor([red_new / weight_new, green_new / weight_new, blue_new / weight_new]);
		this.weight = new_weight;
	}
	public void addColor(int color, int weight) {
		float red = ((float)((color & 0xFF0000) >> 16)) / 255.0;
		float green = ((float)((color & 0x00FF00) >> 8)) / 255.0;
		float blue = ((float)((color & 0xFF0000) >> 0)) / 255.0;
		this.addColor([red, green, blue], weight);
	}
	public void addColor(DyeColor dyeColor, int weight) {
		this.addColor(dyeColor.getColorComponents(), weight);
	}
	public void addColor(DyeItem dyeItem, int weight) {
		this.addColor(dyeItem.getColor(), weight);
	}
	public void addColor(WeightedDyeColor weightedDyeColor, int weight) {
		this.addColor(weightedDyeColor.getColorComponents(), weight);
	}

	public void addColor(int color) {
		this.addColor(color, 1);
	}
	public void addColor(float[] colorComponents) {
		this.addColor(colorComponents, 1);
	}
	public void addColor(DyeColor dyeColor) {
		this.addColor(dyeColor, 1);
	}
	public void addColor(DyeItem dyeItem) {
		this.addColor(dyeItem, 1);
	}
	public void addColor(WeightedDyeColor weightedDyeColor) {
		this.addColor(weightedDyeColor, 1);
	}
}
