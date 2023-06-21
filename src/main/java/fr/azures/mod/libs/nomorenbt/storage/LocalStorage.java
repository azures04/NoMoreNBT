package fr.azures.mod.libs.nomorenbt.storage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.HashMap;

import fr.azures.mod.libs.nomorenbt.storage.api.Data;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LocalStorage {
	
	@OnlyIn(Dist.CLIENT)
	class Blocks {
		private HashMap<BlockPos, HashMap<String, Object>> blocksData;
		
		public void storeData(BlockPos pos, Data data) {
			if (Minecraft.getInstance().level != null) {
				this.blocksData.put(pos, data.getData());
			}
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	class Items {
		private HashMap<Item, HashMap<String, Object>> itemsData;

		public void storeData(Item item, Data data) {
			if (Minecraft.getInstance().level != null) {
				this.itemsData.put(item, data.getData());
			}
		}
	}
	
}
