package yeoldesoupe.dyestuff.common.util;

public class ColorUtil {
	public static int MASK_RED = 0xFF0000;
	public static int MASK_GREEN = 0x00FF00;
	public static int MASK_BLUE = 0x0000FF;
	
	public static int SHIFT_RED = 16;
	public static int SHIFT_GREEN = 8;
	public static int SHIFT_BLUE = 0;
	
	public static int floatToHexRed(float i) {
		return (((int)(i * 255.0F)) << SHIFT_RED) & MASK_RED;
	}
	public static int floatToHexGreen(float i) {
		return (((int)(i * 255.0F)) << SHIFT_GREEN) & MASK_GREEN;
	}
	public static int floatToHexBlue(float i) {
		return (((int)(i * 255.0F)) << SHIFT_BLUE) & MASK_BLUE;
	}
	
	public static float hexToFloatRed(int color) {
		return ((float)((color & MASK_RED) >> SHIFT_RED)) / 255.0F;
	}
	public static float hexToFloatGreen(int color) {
		return ((float)((color & MASK_GREEN) >> SHIFT_GREEN)) / 255.0F;
	}
	public static float hexToFloatBlue(int color) {
		return ((float)((color & MASK_BLUE) >> SHIFT_BLUE)) / 255.0F;
	}
	
	public static float[] hexToFloatComponents(int color) {
		return new float[]{hexToFloatRed(color), hexToFloatGreen(color), hexToFloatBlue(color)};
	}
	
	public static int floatComponentsToHex(float[] colorComponents) {
		return floatToHexRed(colorComponents[0]) + floatToHexGreen(colorComponents[1]) + floatToHexGreen(colorComponents[2]);
	}
	public static int floatComponentsToHex(float red, float green, float blue) {
		return floatToHexRed(red) + floatToHexGreen(green) + floatToHexGreen(blue);
	}
}