package com.amaris.automation.data;

import java.util.HashMap;
import java.util.Map;

import com.amaris.automation.model.utils.FileUtils;

/**
 * The DataManagerObject class is used to manage DataObject objects, it can hold several DataObjects and gives access to
 * their variables through this class.
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class DataManagerObject {

	private int size = 0;
	private String key;
	Map<String, DataObject> mappedData = new HashMap<>();

	public DataManagerObject() {}

	public DataManagerObject(String key, DataObject data) {
		this.key = key;
		addData(key, data);
	}

	public DataManagerObject(String key, Map<String, Map<String, String>> data) {
		this.key = key;
		addData(key, new DataObject(data));
	}

	// region Getters
	public DataObject getData(String dataKey) {
		return mappedData.get(dataKey);
	}

	public String[] getKeySet() {
		return mappedData.keySet().toArray(new String[0]);
	}

	public int size() {
		return this.size;
	}

	public boolean containsKey(String dataKey) {
		return mappedData.containsKey(dataKey);
	}
	// endregion

	// region Setters
	public void setKey(String key) {
		this.key = key;
	}

	public void addData(String key, DataObject dataObject) {
		synchronized(mappedData) {
			if(!mappedData.containsKey(key)) {
				size++;
			} else {
				mappedData.remove(key);
			}
			
			mappedData.put(key, dataObject);
		}
	}

	public void removeData(String key) {
		synchronized(mappedData) {
			if(mappedData.containsKey(key)) size--;
			mappedData.remove(key);
		}
	}

	public void addMDataFromFile(String key, String fileName) {
		synchronized(mappedData) {
			addData(key, new DataObject(FileUtils.csvFileToMData(fileName)));
		}
	}

	public void addDMDataFromFile(String key, String fileName) {
		synchronized(mappedData) {
			addData(key, new DataObject(FileUtils.csvFileToDMData(fileName)));
		}
	}

	public String getValue(String key) {
		String result = null;
		String[] mappedKeys = getKeySet();

		for(int i = 0; i < mappedData.size(); i++) {
			String[] setKeys = mappedData.get(mappedKeys[i]).getRow().keySet().toArray(new String[0]);

			for(String setKey : setKeys) {
				if(setKey.equals(key)) {
					result = this.mappedData.get(mappedKeys[i]).getRow().get(key);
				}
			}
		}

		return result;
	}

	public String getValue(String row, String key) {
		String result = null;
		String[] keySet = getKeySet();

		for(String currentData : keySet) {
			if(mappedData.get(currentData).getRow(row) != null && mappedData.get(currentData).getRow(row).get(key) != null) {
				result = mappedData.get(currentData).getValue(row, key);
			}
		}

		return result;
	}

	public void setValue(String key, String value) {
		boolean found = false;
		String dataKey = null;
		String[] mappedKeys = getKeySet();

		for(int i = 0; i < mappedKeys.length && !found; i++) {
			String[] rowKeys = mappedData.get(mappedKeys[i]).getKeySet();
			dataKey = mappedKeys[i];

			for(String row : rowKeys) {
				if(row.equals(key)) {
					mappedData.get(row).setValue(key, value);
					found = true;
					break;
				}
			}
		}

		if(!found) mappedData.get(this.key == null ? dataKey : this.key).setValue(key, value);
	}

	public void setValue(String row, String key, String value) {
		boolean found = false;
		String dataKey = null;
		String[] mappedKeys = getKeySet();

		for(int i = 0; i < mappedKeys.length && !found; i++) {
			if(mappedData.get(mappedKeys[i]).containsKey(row)) {
				dataKey = mappedKeys[i];

				if(mappedData.get(mappedKeys[i]).getRow(row).containsKey(key)) {
					mappedData.get(mappedKeys[i]).setValue(row, key, value);
					found = true;
					break;
				}
			}
		}

		if(!found && dataKey != null) mappedData.get(dataKey).setValue(row, key, value);
	}
	// endregion
}