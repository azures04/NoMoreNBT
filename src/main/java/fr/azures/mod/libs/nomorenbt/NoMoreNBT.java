package fr.azures.mod.libs.nomorenbt;

import org.apache.commons.lang3.tuple.Pair;

import fr.azures.mod.libs.nomorenbt.data.Constants;
import net.minecraft.client.Minecraft;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.network.FMLNetworkConstants;

@SuppressWarnings("UtilityClassWithPublicConstructor")
@Mod(Constants.MOD_ID)
public class NoMoreNBT {

	public NoMoreNBT() {
		ModLoadingContext.get().registerExtensionPoint(
			ExtensionPoint.DISPLAYTEST,
			() -> Pair.of( () -> FMLNetworkConstants.IGNORESERVERONLY, ( remote, isServer ) -> true )
		);
	}

}
