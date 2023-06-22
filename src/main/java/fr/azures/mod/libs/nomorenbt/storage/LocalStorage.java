package fr.azures.mod.libs.nomorenbt.storage;

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
		private HashMap<String, HashMap<String, Object>> blocksData;
		
		public void storeData(String levelName, BlockPos pos, Data data) {
			if (Minecraft.getInstance().level != null) {
				String key = levelName + "[" + pos.getX() + ";" + pos.getY() + ";" + pos.getZ() + "]";
				this.blocksData.put(key, data.getData());
			}
		}
		
		public Data getData(String levelName, BlockPos pos) {
			if (Minecraft.getInstance().level != null) {
				String key = levelName + "[" + pos.getX() + ";" + pos.getY() + ";" + pos.getZ() + "]";
				if (this.blocksData.get(key) != null) {
					Data data = new Data();
					data.setData(this.blocksData.get(key));
					return data;
				}
				return null;
			}
			return null;
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
		
		public Data getData(Item item, BlockPos pos) {
			if (Minecraft.getInstance().level != null) {
				if (this.itemsData.get(item) != null) {
					Data data = new Data();
					data.setData(this.itemsData.get(item));
					return data;
				}
				return null;
			}
			return null;
		}
	}
	
}
