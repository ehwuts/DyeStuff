package yeoldesoupe.dyestuff.common;

import net.minecraft.item.DyeItem;
import net.minecraft.util.DyeColor;
import java.lang.Integer;

public class WeightedDyeColor {
	private int color = 0xFFFFFF;
	private int weight = 0;

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
		//just default to weightless white?
	}

	public float[] getColorComponents() {
		float red = ((float)((color & 0xFF0000) >> 16)) / 255.0F;
		float green = ((float)((color & 0x00FF00) >> 8)) / 255.0F;
		float blue = ((float)((color & 0xFF0000) >> 0)) / 255.0F;
		
		float[] colorComponents = {red, green, blue};
		return colorComponents;
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
		int red = (((int)(colorComponents[0] * 255.0F)) << 16) & 0xFF0000;
		int green = (((int)(colorComponents[1] * 255.0F)) << 8) & 0x00FF00;
		int blue = ((int)(colorComponents[2] * 255.0F)) & 0x0000FF;
		this.setColor(red + green + blue);
	}
	public void setColor(DyeColor dyeColor) {
		this.setColor(dyeColor.getColorComponents());
	}
	public void setColor(DyeItem dyeItem) {
		this.setColor(dyeItem.getColor());
	}
	public void setColor(WeightedDyeColor weightedDyeColor) {
		this.color = weightedDyeColor.getColor();
		this.weight = 1;
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
	public void addColor(int color, int weight) {
		float red = ((float)((color & 0xFF0000) >> 16)) / 255.0F;
		float green = ((float)((color & 0x00FF00) >> 8)) / 255.0F;
		float blue = ((float)((color & 0xFF0000) >> 0)) / 255.0F;
		
		float[] colorComponents = {red, green, blue};
		this.addColor(colorComponents, weight);
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
