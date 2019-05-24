package com.amaris.automation.model.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.rauschig.jarchivelib.IOUtils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FileUtils {

	public static String getFilePathFromRelative(String filePath) {
		return getFilePathFromRelative(filePath, new String[]{ ""});
	}

	public static String getFilePathFromRelative(String filePath, String fileExtension) {
		return getFilePathFromRelative(filePath, new String[]{ fileExtension});
	}

	public static String getFilePathFromRelative(String filePath, String[] fileExtensions) {
		String result = "";

		for(int i = 0; i < fileExtensions.length; i++) {
			String fileTypeToAdd = filePath.endsWith(fileExtensions[i]) ? "" : fileExtensions[i];

			if(new File(filePath + fileTypeToAdd).exists()) {
				result = filePath + fileTypeToAdd;
			} else if(new File(System.getProperty("user.dir") + '/' + filePath + fileTypeToAdd).exists()) {
				result = System.getProperty("user.dir") + '/' + filePath + fileTypeToAdd;
			}

			if(!result.isEmpty()) break;
		}

		return result;
	}

	public static Map<String, Map<String, String>> fileToMData(String filePath) {
		boolean exist = false;
		Map<String, Map<String, String>> result = null;

		if(filePath != null && !filePath.isEmpty()) {
			filePath = getFilePathFromRelative(filePath, new String[]{ ".csv", ".json", ".properties", ".txt"});

			if(!filePath.isEmpty()) {
				exist = true;
			}
		}

		if(exist && filePath.endsWith(".csv")) {
			result = csvFileToMData(filePath);
		} else if(exist && filePath.endsWith(".json")) {
			result = jsonFileToMData(filePath);
		} else if(exist && (filePath.endsWith(".properties") || filePath.endsWith(".txt"))) {
			result = variablesFileToArray(filePath);
		}

		return result;
	}

	public static Map<String, Map<String, String>> fileToDMData(String filePath) {
		boolean exist = false;
		Map<String, Map<String, String>> result = null;

		if(filePath != null && !filePath.isEmpty()) {
			filePath = getFilePathFromRelative(filePath, new String[]{ ".csv", ".json"});

			if(!filePath.isEmpty()) {
				exist = true;
			}
		}

		if(exist && filePath.endsWith(".csv")) {
			result = csvFileToDMData(filePath);
		} else if(exist && filePath.endsWith(".json")) {
			result = jsonFileToDMData(filePath);
		}

		return result;
	}

	public static JsonObject getJsonObjectFromFile(String filePath) {
		return new JsonParser().parse(readFile(getFilePathFromRelative(filePath, ".json"))).getAsJsonObject();
	}

	private static Map<String, String> dMRowFromJsonObject(JsonElement jsonElement) {
		Map<String, String> resultMap = new HashMap<>();

		for(JsonElement element : jsonElement.getAsJsonArray()) {
			resultMap.put(element.getAsJsonObject().get("key").getAsString(), element.getAsJsonObject().get("value").getAsString());
		}

		return resultMap;
	}

	public static Map<String, Map<String, String>> jsonObjectToData(JsonObject json, boolean ownId) {
		int id = 0;
		Map<String, Map<String, String>> result = new HashMap<>();

		if(json != null) {
			if(json.get("rows") == null) {
				result.put(json.get("name").getAsString(), dMRowFromJsonObject(json.get("values")));
			} else {
				for(JsonElement element : json.get("rows").getAsJsonArray()) {
					String key;

					if(ownId) {
						key = element.getAsJsonObject().get("name").getAsString();
					} else {
						key = id + "";
						id++;
					}

					result.put(key, dMRowFromJsonObject(element.getAsJsonObject().get("values")));
				}
			}
		}

		return result;
	}

	public static Map<String, Map<String, String>> jsonFileToMData(String filePath) {
		return jsonObjectToData(getJsonObjectFromFile(filePath), false);
	}

	public static Map<String, Map<String, String>> jsonFileToDMData(String filePath) {
		return jsonObjectToData(getJsonObjectFromFile(filePath), true);
	}

	public static String[][] csvFileToMatrix(String filePath) {
		return csvFileToMatrix(filePath, true);
	}

	/**
	 * Method to return a Array of a section of a CSV file "ownId" indicates if the file has a column on the left
	 * indicating the row ID - If true, then the Array have the row ID as the key - Otherwise the key is the number of
	 * line
	 *
	 * @param fileName
	 * @param ownId
	 * @return hashMap
	 */
	public static String[][] csvFileToMatrix(String filePath, boolean ownId) {
		return csvStringToMatrix(readFile(getFilePathFromRelative(filePath, ".csv")), ownId);
	}

	/**
	 * Method to return a Array of a section of a CSV string "ownId" indicates if the file has a column on the left
	 * indicating the row ID - If true, then the Array have the row ID as the key - Otherwise the key is the number of
	 * line
	 *
	 * @param csvString
	 * @param ownId
	 * @return hashMap
	 */
	public static String[][] csvStringToMatrix(String csvString, boolean ownId) {
		String[][] result = null;

		int nLines = csvString != null && csvString.isEmpty() ? 0 : StringUtils.countOcurrencesInString(csvString, "\n") + 1;

		result = csvSectionToMatrix(csvString, 0, nLines, ownId);

		return result;
	}

	/**
	 * Method to return a Array of a section of a file, from line "initialLine" to "finalLine" "ownId" indicates if the
	 * file has a column on the left indicating the row ID - If true, then the HashMap have the row ID as the key -
	 * Otherwise the key is the number of line
	 *
	 * @param fileName
	 * @param initialLine
	 * @param finalLine
	 * @param ownId
	 * @return hashMap
	 */
	public static String[][] csvSectionToMatrix(String text, int initialLine, int finalLine, boolean ownId) {
		int nId = 0;
		String[] textArray = StringUtils.stringToArray(text, "\n");

		if(textArray.length > 0) {
			String[][] matrix = new String[finalLine - initialLine][StringUtils.countOcurrencesInString(textArray[0], ";") + 1 + (ownId ? 0 : 1)];

			for(int i = 0; i < finalLine; i++) {
				if(i >= initialLine) {
					matrix[nId++] = StringUtils.stringToArray((ownId ? "" : i - initialLine + ";") + textArray[i], ";");
				}
			}

			return matrix;
		}

		return new String[][]{ {}};
	}

	public static void appendMatrixToCsvFile(String filePath, String[][] matrix) {
		String separator = "";

		if(new File(filePath).exists()) {
			String text = readFile(filePath);

			if(text != null && !text.isEmpty()) {
				separator = "\n";
			}
		}

		appendToFile(filePath, separator + ArrayUtils.matrixToCsvString(matrix));
	}

	public static void appendToFile(String filePath, String text) {
		try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), StandardCharsets.UTF_8.name()))) {
			writer.append(text);
		} catch(IOException e) {
			System.out.println("Error appending to file " + e.toString());
		}
	}

	public static void writeMatrixToCsvFile(String filePath, String[][] matrix) {
		writeFile(filePath, ArrayUtils.matrixToCsvString(matrix));
	}

	public static void writeFile(String filePath, String text) {
		try(PrintWriter writer = new PrintWriter(filePath, StandardCharsets.UTF_8.name())) {
			writer.print(text);
		} catch(IOException e) {
			System.out.println("Error writing file " + e.toString());
		}
	}

	public static String readFile(String filePath) {
		return readFile(filePath, StandardCharsets.UTF_8);
	}

	public static String readFile(String filePath, Charset charset) {
		String line;
		String text = null;

		if(filePath != null && !filePath.isEmpty()) {
			BufferedReader bufferedReader = null;
			InputStreamReader inputStreamReader = null;
			filePath = getFilePathFromRelative(filePath);

			try(FileInputStream inputStream = new FileInputStream(new File(filePath))) {
				StringBuilder stringBuilder = new StringBuilder();
				inputStreamReader = new InputStreamReader(inputStream, charset);
				bufferedReader = new BufferedReader(inputStreamReader);

				line = bufferedReader.readLine();

				if(line != null) stringBuilder.append(line);

				while((line = bufferedReader.readLine()) != null) {
					stringBuilder.append("\n" + line);
				}

				text = stringBuilder.toString();
			} catch(IOException e) {
				System.out.println("Error accesing file " + e.toString());
			} finally {
				IOUtils.closeQuietly(inputStreamReader);
				IOUtils.closeQuietly(bufferedReader);
			}
		}

		return text;
	}

	public static boolean deleteFile(String filePath) {
		return new File(filePath).delete();
	}

	public static Map<String, Map<String, String>> csvFileToMData(String filePath) {
		Map<String, Map<String, String>> result = null;

		if(filePath != null && !filePath.isEmpty()) {
			filePath = getFilePathFromRelative(filePath, ".csv");

			result = csvStringToMData(readFile(filePath));
		}

		return result;
	}

	public static Map<String, Map<String, String>> csvStringToMData(String csvString) {
		Map<String, Map<String, String>> result = new HashMap<>();

		if(csvString != null) {
			String[] csvLines = csvString.split("\n");
			String[] keyArray = StringUtils.stringToArray("row;" + csvLines[0], ";");

			for(int i = 1; i < csvLines.length; i++) {
				result.put(Integer.toString(i - 1), StringUtils.stringToDMRow(keyArray, StringUtils.stringToArray(Integer.toString(i - 1) + ";" + csvLines[i], ";")));
			}
		}

		return result;
	}

	public static Map<String, Map<String, String>> csvFileToDMData(String filePath) {
		String line;
		String key = null;
		String[] keyArray = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		Map<String, Map<String, String>> result = new HashMap<>();

		filePath = getFilePathFromRelative(filePath);

		try(FileInputStream inputStream = new FileInputStream(new File(filePath))) {
			inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			bufferedReader = new BufferedReader(inputStreamReader);

			while((line = bufferedReader.readLine()) != null) {
				key = line.substring(0, line.indexOf(';') >= 0 ? line.indexOf(';') : line.length());

				if(keyArray == null) keyArray = StringUtils.stringToArray(line, ";");
				else result.put(key, StringUtils.stringToDMRow(keyArray, StringUtils.stringToArray(line, ";")));
			}
		} catch(IOException e) {
			System.out.println("File not found: " + e.toString());
		} finally {
			IOUtils.closeQuietly(inputStreamReader);
			IOUtils.closeQuietly(bufferedReader);
		}

		return result;
	}

	public static Map<String, Map<String, String>> variablesFileToArray(String filePath) {
		String line;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferedReader = null;
		ArrayList<String> list = new ArrayList<>();
		Map<String, String> auxMap = new HashMap<>();
		Map<String, Map<String, String>> result = new HashMap<>();

		filePath = getFilePathFromRelative(filePath);

		try(FileInputStream inputStream = new FileInputStream(new File(filePath))) {
			inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			bufferedReader = new BufferedReader(inputStreamReader);

			while((line = bufferedReader.readLine()) != null) {
				line = line.trim().substring(0, line.trim().indexOf('#') >= 0 ? line.trim().indexOf('#') : line.trim().length());

				if(!line.isEmpty()) {
					list.add(line);
				}
			}

			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).contains("=") && list.get(i).split("=").length == 2) {
					auxMap.put(StringUtils.stringToArray(list.get(i), "=")[0], StringUtils.stringToArray(list.get(i), "=")[1]);
				}
			}

			result.put("row", auxMap);
		} catch(IOException e) {
			System.out.println("File not found: " + e.toString());
		} finally {
			IOUtils.closeQuietly(inputStreamReader);
			IOUtils.closeQuietly(bufferedReader);
		}

		return result;
	}

	private FileUtils() {}
}