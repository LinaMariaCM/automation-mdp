package com.amaris.automation.model.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amaris.automation.data.DataObject;

public class ArrayUtils {

	public static String[][] removeRowsFromMatrix(List<Integer> indexes, String[][] matrix, boolean header) {
		for(int i = matrix.length - 1; i > (header ? 0 : -1); i--) {
			if(indexes.contains(i + (header ? 0 : 1))) {
				matrix = ArrayUtils.removeRowFromMatrix(matrix, i);
			}
		}

		return matrix;
	}

	public static List<Integer> joinIntegerArray(List<Integer> indexes1, List<Integer> indexes2) {
		List<Integer> indexes = new ArrayList<>();

		for(int index : indexes1) {
			indexes.add(index);
		}

		for(int index : indexes2) {
			if(!indexes.contains(index)) {
				indexes.add(index);
			}
		}

		return indexes;
	}

	public static List<Integer> interceptIntegerArray(List<Integer> indexes1, List<Integer> indexes2) {
		List<Integer> indexes = new ArrayList<>();

		for(int index : indexes1) {
			if(indexes2.contains(index)) {
				indexes.add(index);
			}
		}

		return indexes;
	}

	private static List<Integer> getFilterIndex(List<String[]> filters, String[][] matrix) {
		List<Integer> indexes = new ArrayList<>();

		for(int i = 1; i < matrix.length; i++) {
			boolean remove = true;

			for(int j = 0; j < filters.size(); j++) {
				if(ArrayUtils.getPositionInArray(matrix[0], filters.get(j)[0]) < 0 || ((filters.get(j)[1].startsWith("!")
					&& !matrix[i][ArrayUtils.getPositionInArray(matrix[0], filters.get(j)[0])].equals(filters.get(j)[1].substring(1)))
					|| matrix[i][ArrayUtils.getPositionInArray(matrix[0], filters.get(j)[0])].equals(filters.get(j)[1]))) {
					remove = false;
				}
			}

			if(remove) indexes.add(i);
		}

		return indexes;
	}

	private static List<Integer> checkFilter(List<Integer> indexes, String[][] matrix, String unparsedFilter, String div) {
		if(unparsedFilter != null && !unparsedFilter.isEmpty()
			&& unparsedFilter.split("=").length > 1 && unparsedFilter.split("=")[1].split(div).length > 0) {
			String unparsedKey = unparsedFilter.split("=")[0];
			String parsedKey = unparsedKey.substring(unparsedKey.indexOf('[') + 1);
			List<String[]> filters = new ArrayList<>();

			for(int j = 0; j < unparsedFilter.split("=")[1].split(div).length; j++) {
				filters.add(new String[]{ parsedKey, unparsedFilter.split("=")[1].split(div)[j]});
			}

			List<Integer> auxIndexes = getFilterIndex(filters, matrix);

			if(unparsedKey.replace(parsedKey, "").contains("|")) {
				indexes = interceptIntegerArray(indexes, auxIndexes);
			} else if(!unparsedKey.replace(parsedKey, "").contains("|")) {
				indexes = joinIntegerArray(indexes, auxIndexes);
			}
		}

		return indexes;
	}

	public static List<Integer> getFiltersIndexes(String filter, String[][] matrix) {
		String div = filter.contains(",") ? "," : "\\.";
		List<Integer> indexes = new ArrayList<>();

		String[] unparsedFilters = filter.split("\\]");

		if(unparsedFilters.length > 0) {
			unparsedFilters[0] = unparsedFilters[0].replace("[", "");
			unparsedFilters[unparsedFilters.length - 1] = unparsedFilters[unparsedFilters.length - 1].replace("]", "");

			for(int i = 0; i < unparsedFilters.length; i++) {
				indexes = checkFilter(indexes, matrix, unparsedFilters[i], div);
			}
		}

		return indexes;
	}

	public static boolean stringInArray(String[] array, String string) {
		boolean result = false;

		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(string)) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static String[] concat(String[] firstArray, String[] secondArray) {
		String[] result = new String[firstArray.length + secondArray.length];

		for(int i = 0; i < firstArray.length; i++) {
			result[i] = firstArray[i];
		}

		for(int i = 0; i < secondArray.length; i++) {
			result[firstArray.length + i] = secondArray[i];
		}

		return result;
	}

	public static String[] removeElementFromArray(String[] array, String element) {
		String[] result = array;

		if(result != null && contains(array, element)) {
			int index = 0;
			result = new String[array.length - 1];

			for(String string : array) {
				if(string != null && !string.equals(element)) {
					result[index++] = string;
				}
			}
		}

		return result;
	}

	public static String[][] addIndexToMatrix(String[][] matrix) {
		String[][] result = matrix;

		if(matrix.length > 0) {
			result = new String[matrix.length][matrix[0].length + 1];

			for(int i = 0; i < matrix.length; i++) {
				result[i][0] = i + "";

				for(int j = 0; j < matrix[i].length; j++)
					result[i][j + 1] = matrix[i][j];
			}
		}

		return result;
	}

	public static String[][] addColumnToMatrix(String[][] matrix, String string) {
		return addColumnToMatrix(matrix, string, -1);
	}

	public static String[][] addColumnToMatrix(String[][] matrix, String string, int index) {
		index = index == -1 ? matrix[0].length : index;

		if(matrix.length > 0) {
			String[][] result = new String[matrix.length][matrix[0].length + 1];

			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					result[i][j + (j >= index ? 1 : 0)] = matrix[i][j];
				}

				result[i][index] = string;
			}

			return result;
		} else {
			return new String[][]{ {}};
		}
	}

	public static String[][] addColumnToMatrix(String[][] matrix, String[] array) {
		return addColumnToMatrix(matrix, array, -1);
	}

	public static String[][] addColumnToMatrix(String[][] matrix, String[] array, int index) {
		index = index == -1 ? matrix[0].length : index;
		String[][] result = matrix;

		if(matrix.length == array.length) {
			result = new String[matrix.length][matrix[0].length + 1];

			for(int i = 0; i < matrix.length; i++) {
				for(int j = 0; j < matrix[i].length; j++) {
					result[i][j + (j >= index ? 1 : 0)] = matrix[i][j];
				}

				result[i][index] = array[i];
			}
		}

		return result;
	}

	public static String[][] addMatrixToMatrix(String[][] matrix, String[][] addedMatrix) {
		if(matrix == null) return addedMatrix;
		if(addedMatrix == null) return matrix;

		if(matrix.length > 0 && addedMatrix.length > 0 && matrix[0].length == addedMatrix[0].length) {
			String[][] result = new String[matrix.length + addedMatrix.length][matrix[0].length];

			for(int i = 0; i < matrix.length; i++) {
				result[i] = matrix[i];
			}

			for(int i = 0; i < addedMatrix.length; i++) {
				result[i + matrix.length] = addedMatrix[i];
			}

			return result;
		}

		return matrix;
	}

	public static String[][] removeRowFromMatrix(String[][] matrix, int row) {
		return removeRowFromMatrix(matrix, row, row);
	}

	public static String[][] removeRowFromMatrix(String[][] matrix, int initialRow, int finalRow) {
		if(initialRow <= finalRow && matrix.length > 0) {
			int line = 0;
			String[][] result = new String[matrix.length - (finalRow - initialRow + 1)][matrix[0].length];

			for(int i = 0; i < matrix.length; i++) {
				if(i < initialRow || i > finalRow) result[line++] = matrix[i];
			}

			return result;
		}
		return matrix;
	}

	public static String[][] removeColumnFromMatrix(String[][] matrix, int row) {
		return removeColumnFromMatrix(matrix, row, row);
	}

	public static String[][] removeColumnFromMatrix(String[][] matrix, int initialRow, int finalRow) {
		if(initialRow <= finalRow && matrix.length > 0) {
			String[][] result = new String[matrix.length][matrix[0].length - (finalRow - initialRow + 1)];

			for(int i = 0; i < matrix.length; i++) {
				int currentColumn = 0;

				for(int j = 0; j < matrix[0].length; j++) {
					if(j < initialRow || j > finalRow) {
						result[i][currentColumn] = matrix[i][j];
						currentColumn++;
					}
				}
			}

			return result;
		}

		return matrix;
	}

	public static String matrixToCsvString(String[][] matrix) {
		StringBuilder value = new StringBuilder();

		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(j != 0) value.append(";");
				if(matrix[i][j] != null) value.append(matrix[i][j]);
			}

			if(i + 1 < matrix.length) value.append("\n");
		}

		return value.toString();
	}

	public static Map<String, String> arrayToDMRow(String[] keyArray, String[] valueArray) {
		Map<String, String> result = new HashMap<>();

		for(int i = 0; i < valueArray.length; i++) {
			result.put(keyArray[i], valueArray[i]);
		}

		return result;
	}

	public static DataObject matrixToDMData(String[][] matrix) {

		return new DataObject(FileUtils.csvStringToMData(ArrayUtils.matrixToString(matrix, "\n", ";")));
	}

	public static String[] subArray(String[] array, int initialPos, int finalPos) {
		int count = 0;
		String[] result = new String[finalPos - initialPos];

		for(int i = initialPos; i < finalPos; i++) {
			result[count++] = array[i];
		}

		return result;
	}

	public static String arrayToString(String[] array) {
		return arrayToString(array, " ");
	}

	public static String arrayToString(String[] array, String divider) {
		StringBuilder result = new StringBuilder();

		for(int i = 0; i < array.length; i++) {
			if(i != 0) result.append(divider);
			result.append(array[i]);
		}

		return result.toString();
	}

	public static String matrixToString(String[][] matrix) {
		return matrixToString(matrix, "\n", "\t");
	}

	public static String matrixToString(String[][] matrix, String lineDiv, String columnDiv) {
		StringBuilder result = new StringBuilder();

		for(int i = 0; i < matrix.length; i++) {
			if(i != 0) result.append(lineDiv);
			result.append(arrayToString(matrix[i], columnDiv));
		}

		return result.toString();
	}

	public static boolean contains(String[] array, String string) {
		boolean result = false;

		for(String compareString : array) {
			if(compareString.equals(string)) {
				result = true;
				break;
			}
		}

		return result;
	}

	public static String[] matrixColumnToRow(String[][] matrix, int rowIndex) {
		String[] result = new String[matrix.length];

		for(int i = 0; i < matrix.length; i++) {
			result[i] = matrix[i][rowIndex];
		}

		return result;
	}

	public static String[][] removeRowsContaining(String[][] matrix, String compareString, int index) {
		return removeRowsContaining(matrix, new String[]{ compareString}, index);
	}

	public static String[][] removeRowsContaining(String[][] matrix, String[] containsArray, int index) {
		List<String[]> newArrays = new ArrayList<>();
		
		if(index < 0) {
			index = matrix[0].length + index;
		}

		for(int i = 0; i < matrix.length; i++) {
			if(!contains(containsArray, matrix[i][index])) {
				newArrays.add(matrix[i]);
			}
		}

		String[][] result = new String[newArrays.size()][];

		for(int i = 0; i < result.length; i++) {
			result[i] = newArrays.get(i);
		}

		return result;
	}

	public static String[][] removeRows(String[][] matrix, List<Integer> list) {
		List<String[]> result = new ArrayList<>();

		for(int i = 0; i < matrix.length; i++) {
			if(!list.contains(i)) {
				result.add(matrix[i]);
			}
		}

		return result.toArray(new String[0][0]);
	}

	public static int countOcurrences(String[][] matrix, String string, int index) {
		int result = 0;

		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i] != null && matrix[i][index] != null && matrix[i][index].equals(string)) {
				result++;
			}
		}

		return result;
	}

	public static int getPositionInArray(String[] array, String string) {
		int index = -1;

		for(int i = 0; i < array.length; i++) {
			if((array[i] != null && array[i].equals(string))
				|| (array[i] == null && string == null)) {
				index = i;
				break;
			}
		}

		return index;
	}

	public static int[] stringArrayToIntArray(String[] array) {
		int[] result = new int[array.length];

		for(int i = 0; i < array.length; i++) {
			result[i] = Integer.parseInt(array[i]);
		}

		return result;
	}

	public static String[] integerArrayToStringArray(Integer[] array) {
		String[] result = new String[array.length];

		for(int i = 0; i < array.length; i++) {
			result[i] = Integer.toString(array[i]);
		}

		return result;
	}
	
	public static List<Integer> listRowsContainingString(String[][] matrix, String string) {		
		return listRowsContainingString(matrix, -1, string);
	}
	
	public static List<Integer> listRowsContainingString(String[][] matrix, int index, String string) {
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < matrix.length; i++) {
			if((index >= 0 && ((string == null && string == matrix[i][index]) || (string != null && string.equals(matrix[i][index]))))
				|| (index < 0 && contains(matrix[i], string))) {
				list.add(i);
			}
		}
		
		return list;
	}

	private ArrayUtils() {}
}