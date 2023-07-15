package fr.azures.mod.libs.nomorenbt.server;

import java.util.HashMap;

import fr.azures.mod.libs.nomorenbt.common.Data;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("all")
@OnlyIn(Dist.DEDICATED_SERVER)
public class ServerStorage {
	
	public Blocks blocks;
	public Items items;
	public Minecraft mc = Minecraft.getInstance();

	public ServerStorage() {
		this.blocks = new Blocks();
		this.items = new Items();
	}
	
	@OnlyIn(Dist.DEDICATED_SERVER)
	public class Blocks {
		private HashMap<String, HashMap<String, Object>> blocksData;
		
		public Blocks() {
			this.blocksData = new HashMap<String, HashMap<String,Object>>();
		}
		
		public Blocks(HashMap<String, HashMap<String,Object>> blocksData) {
			this.blocksData = blocksData;
		}
		
		public void storeData(String levelName, BlockPos pos, Data data) {
			if (mc.level != null) {
				String key = levelName + "@" + mc.getLevelSource().getBaseDir() + "[" + pos.getX() + ";" + pos.getY() + ";" + pos.getZ() + "]";
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
	
	@OnlyIn(Dist.DEDICATED_SERVER)
	public class Items {
		private HashMap<Item, HashMap<String, Object>> itemsData;

		public Items() {
			this.itemsData = new HashMap<Item, HashMap<String,Object>>();
		}
		
		public Items(HashMap<Item, HashMap<String,Object>> itemsData) {
			this.itemsData = itemsData;
		}
		
		public void storeData(Item item, Data data) {
			if (mc.level != null) {
				this.itemsData.put(item, data.getData());
			}
		}
		
		public Data getData(Item item, BlockPos pos) {
			if (mc.level != null) {
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
