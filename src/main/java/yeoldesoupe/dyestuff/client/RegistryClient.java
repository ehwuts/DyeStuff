package yeoldesoupe.dyestuff.client;

import yeoldesoupe.dyestuff.common.RegistryCommon;
import yeoldesoupe.dyestuff.common.item.WeightedDye;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;

public class RegistryClient {
	public static void init() {
		ColorProviderRegistry.ITEM.register(new WeightedDye.ColorHandler(), RegistryCommon.WEIGHTED_DYE);
	}
}