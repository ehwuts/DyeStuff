package yeoldesoupe.dyestuff;

import yeoldesoupe.dyestuff.common.RegistryCommon;
import net.fabricmc.api.ModInitializer;

public class DyeStuff implements ModInitializer {
	public static final String MODID = "dyestuff";
	
	@Override
	public void onInitialize() {
		System.out.println("HONK HONK.");
		
		RegistryCommon.init();
	}
}
