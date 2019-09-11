package yeoldesoupe.dyestuff.common.util;

/**
 * This file is modified from 
 https://github.com/bafomdad/realfilingcabinet/blob/f8b7f192c40431112288d692a9c887e8fb50719b/src/main/java/com/bafomdad/realfilingcabinet/utils/CompoundUtils.java
 which was created by bafomdad and is licensed under the MIT License. 
 */
 
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;

/**
 * Created by bafomdad on 12/13/2018.
 */
public class CompoundUtils {
    public static boolean detectTag(ItemStack stack) {
        return stack.hasTag();
    }
    public static void initTag(ItemStack stack) {
        if (!detectTag(stack)) {
            injectTag(stack, new CompoundTag());
		}
    }
    public static void injectTag(ItemStack stack, CompoundTag tag) {
        stack.setTag(tag);
    }
    public static CompoundTag getCompoundTag(ItemStack stack) {
        initTag(stack);
        return stack.getTag();
    }

    // SETTERS //
    public static void setLong(ItemStack stack, String tag, long l) {
        getCompoundTag(stack).putLong(tag, l);
    }	
    public static void setDouble(ItemStack stack, String tag, double d) {
        getCompoundTag(stack).putDouble(tag, d);
    }
    public static void setCompound(ItemStack stack, String tag, CompoundTag cmp) {
        if (!tag.equalsIgnoreCase("ench")) {
            getCompoundTag(stack).put(tag, cmp);
		}
    }

    // GETTERS //
    public static boolean verifyExistence(ItemStack stack, String tag) {
        return !stack.isEmpty() && getCompoundTag(stack).containsKey(tag);
    }
    public static long getLong(ItemStack stack, String tag, long defaultExpected) {
        return verifyExistence(stack, tag) ? getCompoundTag(stack).getLong(tag) : defaultExpected;
    }
    public static double getDouble(ItemStack stack, String tag, double defaultExpected) {
        return verifyExistence(stack, tag) ? getCompoundTag(stack).getDouble(tag) : defaultExpected;
    }
    public static CompoundTag getCompound(ItemStack stack, String tag, boolean nullifyOnFail) {
        return verifyExistence(stack, tag) ? getCompoundTag(stack).getCompound(tag) : nullifyOnFail ? null: new CompoundTag();
    }
}