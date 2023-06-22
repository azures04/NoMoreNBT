<img src="readme-logo.png" alt="Logo" title="Logo">

# How to use NoMoreNBT
**Warning: this library currently only works in singleplayer mode**.

## Class Architecture
```ascii
root
├───fr.azures.mod.libs.nomorenbt
│   ├───client
│   │   ├───LocalStorage.java
│   ├───common
│   │   ├───Data.java
│   │   ├───StorageManager.java
│   ├───data
│   │   ├───Constants.java
│   ├───NoMoreNBT.java (Main Mod File)
```
### LocalStorage
**Note: Data storage is currently available for Blocks and is experimental for Items**.
To start with, you need to initialise your mod's main class, like this

#### This example is for dynamic storage, i.e. the data will be deleted once the game is closed.
```java
import fr.azures.mod.libs.nomorenbt.client.LocalStorage;
import fr.azures.mod.libs.nomorenbt.client.LocalStorage.Blocks;
import fr.azures.mod.libs.nomorenbt.client.LocalStorage.Items;
import fr.azures.mod.libs.nomorenbt.common.Data;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;

public class Mod {

	public Minecraft mc = Minecraft.getInstance();
	public LocalStorage localStorage;
	public Blocks blocks;
	public Items items;
	
	public Mod() {
		this.localStorage = new LocalStorage();
		this.blocks = localStorage.blocks;
		this.items = localStorage.items;
	}
	
	public void onSomeEvent() {
		//Store Data
		Data data = new Data();
		data.putString("key", "value");
		this.blocks.storeData(mc.level.dimension().toString(), new BlockPos(0, 4, 0), data);
		//Get Data
		Data data2 = this.blocks.getData(mc.level.dimension().toString(), new BlockPos(0, 4, 0));
		data2.getString("key"); //Return "value"
	}
}

```