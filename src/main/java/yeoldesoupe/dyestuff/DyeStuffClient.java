package yeoldesoupe.dyestuff;

import yeoldesoupe.dyestuff.client.RegistryClient;
import net.fabricmc.api.ClientModInitializer;

public class DyeStuffClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		//System.out.println("CLIENT HONK HONK.");
		
		RegistryClient.init();
	}
}