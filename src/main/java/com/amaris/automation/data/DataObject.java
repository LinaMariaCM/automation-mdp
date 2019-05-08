package com.amaris.automation.data;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.utils.ArrayUtils;
import com.amaris.automation.model.utils.FileUtils;
import com.amaris.automation.model.utils.objects.DebugLogger;

/**
 * The DataObject class is used to manage HashMaps<String, HashMap<String, String> objects, this objects usually come
 * from a .csv file and are mapped by column and row, if there is not a unique key for the rows a key is created using
 * the index of the row.
 * 
 * This object is useful to access to .csv data with few parameters, at much 2 parameters are used (column and row), but
 * there is a key String used to set the default row, so only the column key is needed.
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class DataObject {

	private String key;
	private DebugLogger logger = new DebugLogger();
	private Map<String, Map<String, String>> data;
	private static final String NULL_POINTER_MESSAGE = "NullPointerException: There is no row with value";

	// region Constructors
	public DataObject() {
		this.data = new HashMap<>();
	}

	public DataObject(Map<String, Map<String, String>> data) {
		this.data = data;
		if(!data.keySet().isEmpty()) setKey(data.keySet().toArray(new String[0])[0]);
	}
	// endregion

	// region Getters
	public int size() {
		return data.size();
	}

	public boolean containsKey(String key) {
		return data.containsKey(key);
	}

	public boolean containsValue(String value) {
		return data.containsValue(value);
	}

	public String getKey() {
		return key;
	}

	public String[] getKeySet() {
		return data.keySet().toArray(new String[0]);
	}

	public Map<String, String> getRow() {
		return getRow(key);
	}

	public Map<String, Map<String, String>> getMap() {
		return data;
	}

	public Map<String, String> getRow(String valueKey) {
		return data.get(valueKey);
	}

	public String getValue(String valueKey) {
		return getValue(key, valueKey);
	}

	public String getValue(String rowKey, String valueKey) {
		try {
			if(rowKey != null) return getRow(rowKey).get(valueKey);
		} catch(NullPointerException e) {
			logger.error(NULL_POINTER_MESSAGE + " \"" + rowKey + "\"");
		}

		return null;
	}

	public String toString() {
		StringBuilder res = new StringBuilder();

		if(getKeySet().length > 0) {
			res.append(ArrayUtils.arrayToString(getKeySet(), "\t") + "\n");
			String[] rowKeySet = getRow(getKeySet()[0]).keySet().toArray(new String[0]);

			for(int i = 0; i < getKeySet().length; i++) {
				if(i != 0) {
					res.append("\n");
				}

				for(int j = 0; j < rowKeySet.length; j++) {
					if(j != 0) {
						res.append("\t");
					}

					res.append(data.get(getKeySet()[i]).get(rowKeySet[j]));
				}
			}
		}

		return res.toString();
	}
	// endregion

	// region Setters
	public DataObject addRow(String rowKey) {
		if(!data.containsKey(rowKey)) {
			synchronized(data) {
				data.put(rowKey, new HashMap<String, String>());

				if(key == null) {
					key = rowKey;
				}
			}
		}

		return this;
	}

	public DataObject addRow(String rowKey, Map<String, String> row) {
		if(!data.containsKey(rowKey)) {
			synchronized(data) {
				data.put(rowKey, row);
			}
		}

		return this;
	}

	public DataObject setKey(String key) {
		if(!data.containsKey(key)) logger.error(NULL_POINTER_MESSAGE + " \"" + key + "\"");
		this.key = key;

		return this;
	}

	public void setValue(String valueKey, String value) {
		setValue(key, valueKey, value);
	}

	public void setValue(String rowKey, String valueKey, String value) {
		try {
			synchronized(data) {
				if(rowKey != null && getRow(rowKey).containsKey(valueKey)) {
					getRow(rowKey).replace(valueKey, value);
				} else if(rowKey != null) getRow(rowKey).put(valueKey, value);
			}
		} catch(NullPointerException e) {
			logger.error(NULL_POINTER_MESSAGE + " \"" + rowKey + "\"");
		}
	}

	public void duplicateDataByN(int n) {
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < size(); j++) {
				duplicateRow(Integer.toString(((size() * i) + j)), Integer.toString(j));
			}
		}
	}

	public void duplicateRow(String newRow, String rowKey) {
		String[] keys = new String[0];
		HashMap<String, String> auxiliarHash = new HashMap<>();

		try {
			keys = data.get(rowKey).keySet().toArray(new String[0]);
		} catch(NullPointerException e) {
			logger.error(NULL_POINTER_MESSAGE + " \"" + rowKey + "\"");
		}

		for(int i = 0; i < keys.length; i++) {
			auxiliarHash.put(keys[i], data.get(rowKey).get(keys[i]));
		}

		synchronized(data) {
			data.put(newRow, auxiliarHash);
		}
	}

	public DataObject joinMData(String filePath) {
		if(filePath != null && !new File(filePath).isAbsolute()) filePath = AutomationConstants.RESOURCES_FOLDER + filePath;
		DataObject dataObject = new DataObject(FileUtils.fileToMData(filePath));

		return joinData(dataObject);
	}

	public DataObject joinDMData(String filePath) {
		if(filePath != null && !new File(filePath).isAbsolute()) filePath = AutomationConstants.RESOURCES_FOLDER + filePath;
		DataObject dataObject = new DataObject(FileUtils.fileToDMData(filePath));

		return joinData(dataObject);
	}

	public DataObject joinData(DataObject dataObject) {
		String[] keys = dataObject.getKeySet();

		for(String dataObjectKey : keys) {
			addRow(dataObjectKey, dataObject.getRow(dataObjectKey));
		}

		return this;
	}
	// endregion
}