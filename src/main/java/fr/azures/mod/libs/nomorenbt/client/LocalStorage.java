package fr.azures.mod.libs.nomorenbt.client;

import java.util.HashMap;

import fr.azures.mod.libs.nomorenbt.common.Data;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("all")
@OnlyIn(Dist.CLIENT)
public class LocalStorage {
	
	public Blocks blocks;
	public Items items;
	public Minecraft mc = Minecraft.getInstance();

	public LocalStorage() {
		this.blocks = new Blocks();
		this.items = new Items();
	}
	
	@OnlyIn(Dist.CLIENT)
	public class Blocks {
		private HashMap<String, HashMap<String, Object>> blocksData;
		
		public Blocks() {
			this.blocksData = new HashMap<String, HashMap<String,Object>>();
		}
		
		public Blocks(HashMap<String, HashMap<String,Object>> blocksData) {
			this.blocksData = blocksData;
		}
		
		public void storeData(String levelName, BlockPos pos, Data data, boolean persistant) {
			if (mc.level != null) {
				String key = levelName + "@" + mc.getLevelSource().getBaseDir() + "[" + pos.getX() + ";" + pos.getY() + ";" + pos.getZ() + "]";
				if (this.blocksData.get(key) != null && persistant == false) {
					this.blocksData.remove(key);
				}
				this.blocksData.put(key, data.getData());
			}
		}
		
		public Data getData(String levelName, BlockPos pos) {
			if (mc.level != null) {
				String key = levelName + "@" + mc.getLevelSource().getBaseDir() + "[" + pos.getX() + ";" + pos.getY() + ";" + pos.getZ() + "]";
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
	public class Items {
		private HashMap<String, HashMap<String, Object>> itemsData;

		public Items() {
			this.itemsData = new HashMap<String, HashMap<String,Object>>();
		}
		
		public Items(HashMap<String, HashMap<String,Object>> itemsData) {
			this.itemsData = itemsData;
		}
		
		public void storeData(String identifier, Item item, Data data, boolean persistant) {
			if (mc.level != null) {
				if (this.itemsData.get(identifier + item.getItem().getRegistryName()) != null && persistant == false) {
					this.itemsData.remove(item);
				}
				this.itemsData.put(identifier + item.getItem().getRegistryName(), data.getData());
			}
		}
		
		public Data getData(Item item, String identifier, BlockPos pos) {
			if (mc.level != null) {
				if (this.itemsData.get(item) != null) {
					Data data = new Data();
					data.setData(this.itemsData.get(identifier + item.getItem().getRegistryName()));
					return data;
				}
				return null;
			}
			return null;
		}
	}
	
}
