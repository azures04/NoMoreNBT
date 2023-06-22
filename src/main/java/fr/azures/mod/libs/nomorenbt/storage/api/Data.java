package fr.azures.mod.libs.nomorenbt.storage.api;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

public class Data {

	private boolean persistentData = false;
	private HashMap<String, Object> data;
	
	public boolean isPersistentData() {
		this.data = new HashMap<String, Object>();
		return persistentData;
	}
	
	public void setPersistentData(boolean isPersistent) {
		this.persistentData = isPersistent;
	}
	
	public void putInt(String key, int value) {
		this.data.put(key, value);
	}
	
	public void putShort(String key, short value) {
		this.data.put(key, value);
	}
	
	public void putLong(String key, long value) {
		this.data.put(key, value);
	}
	
	public void putUUID(String key, UUID value) {
		this.data.put(key, value);
	}
	
	public void putString(String key, String value) {
		this.data.put(key, value);
	}
	
	public void putBoolean(String key, boolean value) {
		this.data.put(key, value);
	}
	
	public void putObject(String key, Object value) {
		this.data.put(key, value);
	}
	
	public int getInt(String key) {
		return (int) this.data.get(key);
	}
	
	public short getShort(String key) {
		return (short) this.data.get(key);
	}
	
	public long getLong(String key) {
		return (long) this.data.get(key);
	}
	
	public UUID getUUID(String key) {
		return (UUID) this.data.get(key);
	}
	
	public String getString(String key) {
		return (String) this.data.get(key);
	}
	
	public boolean getBoolean(String key) {
		return (boolean) this.data.get(key);
	}
	
	public Object getObject(String key) {
		return this.data.get(key);
	}
	
	public HashMap<String, Object> getData() {
		return this.data;	
	}
	
	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	
	public Set<String> getAllKeys() {
		return this.data.keySet();
	}
	
	public void delete(String key) {
		this.data.remove(key);
	}
	
	public void clear() {
		this.data.clear();
	}
}