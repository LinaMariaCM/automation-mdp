package com.automation.model.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;



import com.automation.model.utils.ArrayUtils;
import com.project.ProjectConstants;


public class ArrayFileUtils {

		/**
		 * Method to find a value in dataset
		 *
		 * @param hMapDataSet
		 * @param key
		 * @param testId
		 * @return String
		 */
		public static String hashMapByIndexToStringTable(
				HashMap<String, HashMap<String, String>> hashMap)
		{
			String value = "";

			return value;
		}
		
		/**
		 * Method to find a value in dataset
		 *
		 * @param hMapDataSet
		 * @param key
		 * @param testId
		 * @return String
		 */
		public static String getValuesDataSet(
				HashMap<String, HashMap<String, String>> hMapDataSet, String key, String testId)
		{
			String value = null;
			if (hMapDataSet.containsKey(testId))
			{
				if (hMapDataSet.get(testId).containsKey(key) && !hMapDataSet.get(testId).get(key).equals(""))
				{
					value = hMapDataSet.get(testId).get(key);
				}
			}

			return value;
		}

		/**
		 * Method to find a value in dataset by index
		 *
		 * @param array
		 * @param string
		 * @param index
		 * @return String
		 */
		public static String getValuesDataSetByID(
				String[][] array, String string, int index)
		{
			String value = null;

			if (getIndexInArray(array[0], string) >= 0)
			{
				value = array[index][getIndexInArray(array[0], string)];
			}

			return value;
		}

		/**
		 * Method to find a value in dataset by index
		 *
		 * @param array
		 * @param string
		 * @param index
		 * @return String
		 */
		public static String[][] setValuesDataSetByID(
				String[][] array, String string, int index, String newValue)
		{

			if (getIndexInArray(array[0], string) >= 0)
			{
				array[index][getIndexInArray(array[0], string)] = newValue;
			}

			return array;
		}

		/**
		 * Method to add a column to an array
		 *
		 * @param array
		 * @param columnName
		 */
		public static String[][] addColumnToArray(
				String[][] array, String columnName)
		{
			String[][] newArray = new String[array.length][array[0].length + 1];

			for (int i = 0; i < array.length; i++)
			{
				for (int j = 0; j < array[i].length; j++)
				{
					newArray[i][j] = array[i][j];
				}
			}
			
			newArray[0][array[0].length] = columnName;

			return newArray;
		}

		/**
		 * Method to find a value in dataset by index
		 *
		 * @param hMapDataSet
		 * @param key
		 * @param index
		 * @return String
		 */
		public static String stringArrayToString(
				String[] array, String divider)
		{
			String result = "";

			for (int i = 0; i < array.length; i++)
			{
				if (i != 0)
					result += divider;
				result += array[i];
			}

			return result;
		}

		/**
		 * Method to find a value in dataset by index
		 *
		 * @param hMapDataSet
		 * @param key
		 * @param index
		 * @return String
		 */
		public static String getValuesDataSetByIndex(
				HashMap<String, HashMap<String, String>> hMapDataSet, String key, int index)
		{
			String value = null;
			if (hMapDataSet.size() > index)
			{
				if (hMapDataSet.get("" + index).containsKey(key) && !hMapDataSet.get("" + index).get(key).equals(""))
				{
					value = hMapDataSet.get("" + index).get(key);
				}
			}

			return value;
		}

		/**
		 * Method to return the index of a string in an array
		 *
		 * @param fileName
		 * @return nLines
		 */
		public static int getIndexInArray(
				String[] array, String compareString)
		{
			for (int i = 0; i < array.length; i++)
			{
				if (array[i] != null && array[i].equals(compareString))
					return i;
			}

			return -1;
		}

		/**
		 * Method to count rows in a file
		 *
		 * @param fileName
		 * @return nLines
		 */
		public static int countLinesInFile(
				String nombreFichero)
		{
			int nLines = 0;

			BufferedReader bufferedReader = null;

			try
			{
				FileInputStream inputStream = new FileInputStream(
						// new File(System.getProperty("user.dir") + "/" + MutuaPropietariosConstants.ResourcesFolder + "/" + nombreFichero));
						new File(nombreFichero));
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8" /* StandardCharsets.ISO_8859_1 */));

				while (bufferedReader.readLine() != null)
				{
					nLines++;
				}
			}
			catch (Exception e)
			{
			}

			return nLines;
		}

		/**
		 * Method to count rows in a file
		 *
		 * @param fileName
		 * @return nLines
		 */
		public static int countRowsInString(
				String string)
		{
			int nRows = 0;

			for (int i = 0; i < string.length(); i++)
			{
				if (string.charAt(i) == ';')
				{
					nRows++;
				}
			}
			nRows++;

			return nRows;
		}

		/**
		 * Method to count lines in a file
		 *
		 * @param fileName
		 * @return nLines
		 */
		public static int countRowsInFile(
				String nombreFichero)
		{
			int nRows = 0;
			//String file = "";

			BufferedReader bufferedReader = null;

			try
			{
				FileInputStream inputStream = new FileInputStream(
						new File(System.getProperty("user.dir") + "/" + ProjectConstants.ResourcesFolder + "/" + nombreFichero));
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8" /* StandardCharsets.ISO_8859_1 */));

				String line;
				if ((line = bufferedReader.readLine()) != null)
				{
					nRows = countRowsInString(line);
				}
			}
			catch (Exception e)
			{
			}

			return nRows;
		}
		
		public static void writeArrayIntoCSVFile(
				String fileName, String[][] matrix)
		{
			writeFile(fileName, stringArrayToStringCSV(matrix));
		}

		public static void writeFile(
				String fileName, String text)
		{
			try
			{
				PrintWriter writer = new PrintWriter("resources/" + fileName, "UTF-8");
				writer.print(text);
				writer.close();
			}
			catch (IOException e)
			{
				System.out.println("Error writing file " + e.toString());
			}
		}
		
		public static String stringArrayToStringCSV(
				String[][] matrix)
		{
			String value = "";
			
			for (int i = 0; i < matrix.length; i++)
			{
				for (int j = 0; j < matrix[0].length; j++)
				{
					if (j != 0)
						value += ";";
					if (matrix[i][j] != null)
						value += matrix[i][j];
				}
				if (i + 1 < matrix.length)
					value += "\n";
			}
			
			return value;
		}

		/**
		 * Method to return a Array of a section of a file "ownId" indicates if the file has a column on the left indicating the row ID - If true, then the
		 * Array have the row ID as the key - Otherwise the key is the number of line
		 *
		 * @param fileName
		 * @param initialLine
		 * @param finalLine
		 * @param ownId
		 * @return hashMap
		 */
		public static String[][] loadDataFileToArray(
				String nombreFichero, boolean ownId)
		{
			int nLines = countLinesInFile(nombreFichero);
			return loadDataFileSectionToArrayByInitialAndFinalLine(nombreFichero, 0, nLines, ownId);
		}

		/**
		 * Method to return a Array of a section of a file, from line "initialLine" to "finalLine" "ownId" indicates if the file has a column on the left
		 * indicating the row ID - If true, then the Array have the row ID as the key - Otherwise the key is the number of line
		 *
		 * @param fileName
		 * @param initialLine
		 * @param finalLine
		 * @param ownId
		 * @return hashMap
		 */
		public static String[][] loadDataFileSectionToArrayByInitialLineAndSize(
				String nombreFichero, int initialLine, int maxSize, boolean ownId)
		{
			return loadDataFileSectionToArrayByInitialAndFinalLine(nombreFichero, initialLine, initialLine + maxSize, ownId);
		}

		/**
		 * Method to return a Array of a section of a file, from line "initialLine" to "finalLine" "ownId" indicates if the file has a column on the left
		 * indicating the row ID - If true, then the HashMap have the row ID as the key - Otherwise the key is the number of line
		 *
		 * @param fileName
		 * @param initialLine
		 * @param finalLine
		 * @param ownId
		 * @return hashMap
		 */
		public static String[][] loadDataFileSectionToArrayByInitialAndFinalLine(
				String nombreFichero, int initialLine, int finalLine, boolean ownId)
		{
			int nId = 0, nline = 0;
			BufferedReader bufferedReader = null;
			
			String[][] matrix = new String[finalLine - initialLine][countLinesInFile(nombreFichero)];
			
			try
			{
				FileInputStream inputStream = new FileInputStream(new File(nombreFichero));
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8" /* StandardCharsets.ISO_8859_1 */));

				String[] header = splitStringIntoArray(bufferedReader.readLine(), ';');
				matrix[nId++] = header;

				String line;

				while ((line = bufferedReader.readLine()) != null && nline < finalLine)
				{
					if (nline >= initialLine)
					{
						String[] dataFields = splitStringIntoArray(line, ';');

						matrix[nId++] = dataFields;
					}
					nline++;
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					bufferedReader.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			return matrix;
		}

		private static String[] splitStringIntoArray(
				String string, char c)
		{
			int currentIndex = 0;
			String word = null;
			String[] array = new String[countRowsInString(string)];

			for (int i = 0; i < string.length(); i++)
			{
				if (string.charAt(i) != c)
				{
					if (word == null)
						word = string.charAt(i) + "";
					else
						word += string.charAt(i);
				}
				if (string.charAt(i) == c || i + 1 == string.length())
				{
					array[currentIndex++] = word;
					word = null;
				}
			}
			return array;
		}
		
		/**
		 * Method to return a HashMap of a section of a file "ownId" indicates if the file has a column on the left indicating the row ID - If true, then
		 * the HashMap have the row ID as the key - Otherwise the key is the number of line
		 *
		 * @param fileName
		 * @param initialLine
		 * @param finalLine
		 * @param ownId
		 * @return hashMap
		 */
		public static HashMap<String, HashMap<String, String>> loadDataFileToHashMap(
				String nombreFichero, boolean ownId)
		{
			int nLines = countLinesInFile(nombreFichero);
			System.out.println("***Nombre fichero: " + nombreFichero);
			return loadDataFileSectionToHashMapByInitialAndFinalLine(nombreFichero, 0, nLines, ownId);
		}

		/**
		 * Method to return a HashMap of a section of a file, from line "initialLine" to "finalLine" "ownId" indicates if the file has a column on the left
		 * indicating the row ID - If true, then the HashMap have the row ID as the key - Otherwise the key is the number of line
		 *
		 * @param fileName
		 * @param initialLine
		 * @param finalLine
		 * @param ownId
		 * @return hashMap
		 */
		public static HashMap<String, HashMap<String, String>> loadDataFileSectionToHashMapByInitialLineAndSize(
				String nombreFichero, int initialLine, int maxSize, boolean ownId)
		{
			return loadDataFileSectionToHashMapByInitialAndFinalLine(nombreFichero, initialLine, initialLine + maxSize, ownId);
		}

		/**
		 * Method to return a HashMap of a section of a file, from line "initialLine" to "finalLine" "ownId" indicates if the file has a column on the left
		 * indicating the row ID - If true, then the HashMap have the row ID as the key - Otherwise the key is the number of line
		 *
		 * @param fileName
		 * @param initialLine
		 * @param finalLine
		 * @param ownId
		 * @return hashMap
		 */
		public static HashMap<String, HashMap<String, String>> loadDataFileSectionToHashMapByInitialAndFinalLine(
				String nombreFichero, int initialLine, int finalLine, boolean ownId)
		{
			int nId = 0, nline = 0;
			BufferedReader bufferedReader = null;

			HashMap<String, HashMap<String, String>> hashMapAux = new HashMap<>();

			try
			{
				FileInputStream inputStream = new FileInputStream(
						// new File(System.getProperty("user.dir") + "/" + MutuaPropietariosConstants.ResourcesFolder + "/" + nombreFichero));
						new File(nombreFichero));

				bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8" /* StandardCharsets.ISO_8859_1 */));

				String[] header = bufferedReader.readLine().split(";");
				System.out.println("***Header: " + header[0]);
				System.out.println("***StringUtils: " + ArrayUtils.arrayToString(header));
				
				String line;
				
				System.out.println("***nLine: " + nline);
				System.out.println("***finalLine: " + finalLine);

				while ((line = bufferedReader.readLine()) != null && nline < finalLine)

				{
					System.out.println("***Line: " + line);
					System.out.println("***Inicio de While de loadDataFileSectionToHashMapByInitialAndFinalLine");
					if (nline >= initialLine)
					{
						HashMap<String, String> hm = new HashMap<>();
						String[] dataFields = line.split(";", -1);

						for (int i = 0; i < header.length; i++)
						{
							hm.put(header[i], dataFields[i]);
						}

						if (ownId)
							hashMapAux.put(dataFields[0], hm);
						else
							hashMapAux.put("" + nId++, hm);
					}
					nline++;
					System.out.println("***Fin de While de loadDataFileSectionToHashMapByInitialAndFinalLine");
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			/*
			 * finally { try { bufferedReader.close(); } catch (IOException e) { e.printStackTrace(); } }
			 */
			
			// if(bufferedReader != null)
			// {
			try
			{
				bufferedReader.close();
			}
			catch (IOException e)
			{
			}
			// }

			return hashMapAux;
		}

		/**
		 * Method to get scenario identification
		 *
		 * @param scenarioName
		 * @return
		 */
		public static String getScenarioId(
				String scenarioName)
		{
			return scenarioName.contains("[") && scenarioName.contains("]") ? scenarioName.substring(scenarioName.indexOf("[") + 1, scenarioName.indexOf("]"))
					: null;
		}
	
	
}
