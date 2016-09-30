package subaraki.petbuddy.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import subaraki.petbuddy.network.PacketSyncOtherInventory.PacketSyncOtherInventoryHandler;
import subaraki.petbuddy.network.PacketSyncOwnInventory.PacketSyncOwnInventoryHandler;

public class NetworkHandler {
	public static final String CHANNEL = "petbuddy_channel";
	public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(CHANNEL);

	public NetworkHandler() {
		NETWORK.registerMessage(PacketSyncOtherInventoryHandler.class, PacketSyncOtherInventory.class, 0, Side.CLIENT);
		NETWORK.registerMessage(PacketSyncOwnInventoryHandler.class, PacketSyncOwnInventory.class, 0, Side.CLIENT);
	}
}
