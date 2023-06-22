package fr.azures.mod.libs.nomorenbt.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import net.minecraft.item.Item;

public class StorageManager {

    public static void saveBlocksData(HashMap<String, HashMap<String, Object>> data, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }
    
    public static void saveItemsData(HashMap<Item, HashMap<String, Object>> data, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    public static HashMap<Item, HashMap<String, Object>> getItemsData(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = inputStream.readObject();
            if (obj instanceof HashMap) {
            	return (HashMap<Item, HashMap<String, Object>>) obj;
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
            return null;

        }
    }
    
    public static HashMap<String, HashMap<String, Object>> getBlocksData(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Object obj = inputStream.readObject();
            if (obj instanceof HashMap) {
            	return (HashMap<String, HashMap<String, Object>>) obj;
            } else {
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
            return null;

        }
    }
	
}
