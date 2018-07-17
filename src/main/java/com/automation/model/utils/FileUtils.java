package com.automation.model.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import com.automation.configuration.AutomationConstants;

public class FileUtils {

	/**
	 * Method to return a Array of a section of a CSV file "ownId" indicates if the
	 * file has a column on the left indicating the row ID - If true, then the
	 * Array have the row ID as the key - Otherwise the key is the number of
	 * line
	 *
	 * @param fileName
	 * @param ownId
	 * @return hashMap
	 */
	public static String[][] loadCsvFileToArray(String filePath, boolean ownId) {
		String[][] result = null;
		
		String text = getTextFromFile(filePath);

		int nLines = text.isEmpty() ? 0 : StringUtils.countOcurrencesInString(text, "\n") + 1;

		result = loadCsvSectionToArray(text, 0, nLines, ownId);
		
		return result;
	}

	/**
	 * Method to return a Array of a section of a CSV string "ownId" indicates if the
	 * file has a column on the left indicating the row ID - If true, then the
	 * Array have the row ID as the key - Otherwise the key is the number of
	 * line
	 *
	 * @param csvString
	 * @param ownId
	 * @return hashMap
	 */
	public static String[][] loadCsvStringToArray(String csvString, boolean ownId) {
		String[][] result = null;

		int nLines = csvString.isEmpty() ? 0 : StringUtils.countOcurrencesInString(csvString, "\n") + 1;

		result = loadCsvSectionToArray(csvString, 0, nLines, ownId);
		
		return result;
	}

	/**
	 * Method to return a Array of a section of a file, from line "initialLine"
	 * to "finalLine" "ownId" indicates if the file has a column on the left
	 * indicating the row ID - If true, then the HashMap have the row ID as the
	 * key - Otherwise the key is the number of line
	 *
	 * @param fileName
	 * @param initialLine
	 * @param finalLine
	 * @param ownId
	 * @return hashMap
	 */
	public static String[][] loadCsvSectionToArray(String text, int initialLine, int finalLine, boolean ownId) {
		int nId = 0;
		String[] textArray = StringUtils.stringToArray(text, "\n");

		if(textArray.length > 0) {
			String[][] matrix = new String[finalLine - initialLine][StringUtils.countOcurrencesInString(textArray[0], ";") + 1 + (ownId ? 0:1)];

			for(int i = 0; i < finalLine; i++) {
				if(i >= initialLine) {
					matrix[nId++] = StringUtils.stringToArray((ownId ? "" : i - initialLine + ";") + textArray[i], ";");
				}
			}

			return matrix;
		}

		return null;
	}

	public static void writeArrayIntoCSVFile(String fileName, String[][] matrix) {
		writeFile(fileName, ArrayUtils.matrixToStringCSV(matrix));
	}

	public static void writeFile(String fileName, String text) {
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			writer.print(text);
			writer.close();
		} catch(IOException e) {
			System.out.println("Error writing file " + e.toString());
		}
	}

	public static String getTextFromFile(String filePath) {		
		return getTextFromFile(filePath, StandardCharsets.UTF_8);
	}

	public static String getTextFromFile(String filePath, Charset charset) {
		String line, text = null;
		BufferedReader bufferedReader = null;
		FileInputStream inputStream = null;
		
		try {
			inputStream = new FileInputStream(new File(filePath));
			
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset));
			line = bufferedReader.readLine();
	
			if(line != null) text = line;
	
			while((line = bufferedReader.readLine()) != null) text += "\n" + line;
		} catch(IOException e) {
			System.out.println("Error accesing file " + e.toString());
		} finally {
			try {
				if(inputStream != null) inputStream.close();
				if(bufferedReader != null) bufferedReader.close();
			} catch(Exception e) {}
		}
		
		return text;
	}

	public static HashMap<String, HashMap<String, String>> csvFileToMData(String filePath) {
		HashMap<String, HashMap<String, String>> result = null;
		
		if(filePath == null || filePath.isEmpty()) return null;

		if(new File(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + filePath).exists()) {
			filePath = System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + filePath;
		}
		
		result = csvStringToMData(getTextFromFile(filePath));
		
		return result;
	}

	public static HashMap<String, HashMap<String, String>> csvStringToMData(String csvString) {
		String[] csvLines = csvString.split("\n");
		String[] keyArray = StringUtils.stringToArray("row;" + csvLines[0], ";");
		HashMap<String, HashMap<String, String>> result = new HashMap<String, HashMap<String, String>>();
		
		for(int i = 1; i < csvLines.length; i++) {
			result.put(Integer.toString(i - 1), StringUtils.stringToDMRow(keyArray, StringUtils.stringToArray(Integer.toString(i - 1) + ";" + csvLines[i], ";")));
		}

		return result;
	}

	public static HashMap<String, HashMap<String, String>> csvFileToDMData(String filePath) {
		String line, key = null;
		String[] keyArray = null;
		FileInputStream inputStream = null;
		BufferedReader bufferedReader = null;
		HashMap<String, HashMap<String, String>> result = new HashMap<String, HashMap<String, String>>();

		if(new File(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + filePath).exists()) {
			filePath = System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + filePath;
		}

		try {
			inputStream = new FileInputStream(new File(filePath));
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

			while((line = bufferedReader.readLine()) != null) {

				if(line.indexOf(";") >= 0) key = line.substring(0, line.indexOf(";"));
				else if(line.indexOf(";") < 0) key = line;

				if(keyArray == null) keyArray = StringUtils.stringToArray(line, ";");
				else result.put(key, StringUtils.stringToDMRow(keyArray, StringUtils.stringToArray(line, ";")));
			}
		} catch(IOException e) {
			System.out.println("File not found: " + e.toString());
		} finally {
			try {
				if(inputStream != null) inputStream.close();
				if(bufferedReader != null) bufferedReader.close();
			} catch(Exception e) {}
		}

		return result;
	}

	public static HashMap<String, HashMap<String, String>> variablesFileToArray(String filePath) {
		if(new File(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + filePath).exists()) {
			filePath = System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + filePath;
		}
		
		String line;
		FileInputStream inputStream = null;
		BufferedReader bufferedReader = null;
		ArrayList<String> list = new ArrayList<String>();
		HashMap<String, String> auxMap = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> result = new HashMap<String, HashMap<String, String>>();

		try {
			inputStream = new FileInputStream(new File(filePath));
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

			while((line = bufferedReader.readLine()) != null) {
				line = line.trim().substring(0, line.trim().indexOf('#') >= 0 ? line.trim().indexOf('#'):line.trim().length());
				if(!line.isEmpty()) {
					list.add(line);
				}
			}
			
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).contains("=")) {
					auxMap.put(StringUtils.stringToArray(list.get(i), "=")[0], StringUtils.stringToArray(list.get(i), "=")[1]);
				}
			}
			
			result.put("config", auxMap);
		} catch(IOException e) {
			System.out.println("File not found: " + e.toString());
		} finally {
			try {
				if(inputStream != null) inputStream.close();
				if(bufferedReader != null) bufferedReader.close();
			} catch(Exception e) {}
		}

		return result;
	}
}
