package com.amaris.automation.model.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.data.DataObject;
import com.amaris.automation.model.utils.objects.DebugLogger;
import com.amaris.automation.model.utils.objects.HtmlElement;

/**
 * The CsvToHtml class is used to manage use a csv report file and transform it into an HTML report
 *
 * @author Alfredo Moises Boullosa Ramones
 */

public class CsvToHtml {

	protected String currentTestCase = null;
	protected String currentTimeStamp = null;
	protected String reportPath = null;
	protected String[][] dataMatrix = null;
	protected String translationFile = null;
	protected HashMap<String, ArrayList<String>> columnCasesOrder = null;
	protected HashMap<String, HashMap<String, int[]>> testStats = null;
	protected DebugLogger logger = new DebugLogger();
	protected static HtmlElement arrow = new HtmlElement("div")
		.addChild(new HtmlElement("svg")
			.addAttribute("fill", "black")
			.addAttribute("fill-opacity", "0.4")
			.addAttribute("height", "15")
			.addAttribute("width", "30")
			.addChild("path", "d=\"M0 0 L15 15 L30 0 Z\""));

	public static void main(String[] args) {
		createReportFromArguments(new CsvToHtml(), args);
	}

	protected static void createReportFromArguments(CsvToHtml converter, String[] args) {
		String browser = "";
		String day = null;
		String year = null;
		String month = null;
		String reportName = null;
		String[] testCases = null;
		String translationFile = null;
		int[] relevantCol = new int[]{ -1};

		for(String argument : args) {
			if(argument.contains("=") && argument.split("=").length > 1) {
				String key = argument.split("=")[0];
				String value = argument.split("=")[1];

				switch(key) {
					case "year":
						year = value;
						break;
					case "month":
						month = value;
						break;
					case "day":
						day = value;
						break;
					case "date":
						year = value.split("\\.")[0];
						month = value.split("\\.")[1];
						day = value.split("\\.")[2];
						break;
					case AutomationConstants.BROWSER:
						browser = value;
						break;
					case "report_name":
						reportName = value;
						break;
					case "translation_file":
						translationFile = value;
						break;
					case "relevant_columns":
						relevantCol = ArrayUtils.stringArrayToIntArray(splitCommaOrDot(value));
						break;
					case "test_cases":
						testCases = splitCommaOrDot(value);
						break;
					default:
						break;
				}
			}
		}

		String timeStamp = createBaseTimeStamp(testCases, reportName, browser);

		if(testCases == null || testCases.length == 0) testCases = new String[]{ reportName};
		if(year == null || year.isEmpty()) year = getDateFormat("yyyy");
		if(month == null || month.isEmpty()) month = getDateFormat("MM");
		if(day == null || day.isEmpty()) day = getDateFormat("dd");

		converter.setReportPath(System.getProperty("user.dir") + '/' + AutomationConstants.REPORTS_FOLDER + "/T" + year + month + day);
		converter.createJointReport(year + "." + month + "." + day + timeStamp, reportName, testCases, relevantCol, translationFile);
	}

	protected static String createBaseTimeStamp(String[] testCases, String reportName, String browser) {
		return "." + (testCases == null ? AutomationConstants.TESTCASE_REPLACE : reportName) + (browser.isEmpty() ? "" : "." + browser);
	}

	protected static String[] splitCommaOrDot(String value) {
		return value.contains(",") ? value.split(",") : value.split("\\.");
	}

	protected static String getDateFormat(String dateFormat) {
		return new SimpleDateFormat(dateFormat).format(new java.util.Date());
	}

	protected void debugInfo(String message) {
		logger.info(message);
	}

	protected void printStackTrace(Exception exception) {
		logger.printStackTrace(exception);
	}

	public void setReportPath(String path) {
		reportPath = path;
	}

	public void setTranslationFile(String translationFile) {
		this.translationFile = translationFile;
	}

	public void createReport(String timeStamp, String testCase, String path) {
		createReport(timeStamp, testCase, path, -1);
	}

	public void createReport(String timeStamp, String testCase, String path, int relevantColumns) {
		reportPath = path;
		createReport(timeStamp, testCase, relevantColumns, null);
	}

	public void createJointReport(SuiteManager suiteM) {
		createJointReport(suiteM, null);
	}

	public void createJointReport(SuiteManager suiteM, String translationFile) {
		if(suiteM.getTestCases().length > 0) {
			String timeStamp = suiteM.getTestDataManager(suiteM.getTestCases()[0]).getTimeStamp();
			reportPath = suiteM.getTestDataManager(suiteM.getTestCases()[0]).getReportPath();

			createJointReport(timeStamp, suiteM.getName(), suiteM.getTestCases(), suiteM.getRelevantColumns(), translationFile);
		}
	}

	protected void createJointReport(String timeStamp, String reportName, String[] testCases, int[] relevantColumns) {
		createJointReport(timeStamp, reportName, testCases, relevantColumns, null);
	}

	protected void createReport(String timeStamp, String testCase, int relevantColumns, String translationFile) {
		this.translationFile = translationFile;
		reportPath = reportPath.charAt(reportPath.length() - 1) == '/' ? reportPath : reportPath + '/';

		HtmlElement htmlNode = createTestCaseWrapper(timeStamp, testCase, relevantColumns);

		writeToFile(htmlNode, reportPath + timeStamp);
	}

	protected void createJointReport(String timeStamp, String reportName, String[] testCases, int[] relevantColumns, String translationFile) {
		debugInfo("Generating report...");
		this.translationFile = translationFile;
		reportPath = reportPath.charAt(reportPath.length() - 1) == '/' ? reportPath : reportPath + '/';

		String[] timeStampArray = timeStamp.split("\\.");
		for(int i = 0; i < timeStampArray.length; i++) {
			if(!org.apache.commons.lang3.StringUtils.isNumeric(timeStampArray[i])) {
				timeStampArray[i] = AutomationConstants.TESTCASE_REPLACE;
				break;
			}
		}

		timeStamp = ArrayUtils.arrayToString(timeStampArray, ".");

		HtmlElement htmlNode = createJointHtmlNode(timeStamp, reportName, testCases, relevantColumns);

		if(!new File(reportPath).exists()) new File(reportPath).mkdirs();
		writeToFile(htmlNode, reportPath + timeStamp.replace(AutomationConstants.TESTCASE_REPLACE, reportName).replace("_headless", ""));
	}

	protected String translateOrFormat(String text) {
		String result = text;

		if(translationFile != null) {
			DataObject translationObject = new DataObject(FileUtils.fileToMData(AutomationConstants.RESOURCES_FOLDER + translationFile));

			if(translationObject.getValue(text) != null) {
				result = translationObject.getValue(text);
			} else {
				result = StringUtils.snakeCaseToNatural(result);
			}
		} else {
			result = StringUtils.snakeCaseToNatural(result);
		}

		return result;
	}

	protected HashMap<String, HashMap<String, int[]>> initializeHashMap(String[][] dataMatrix) {
		HashMap<String, HashMap<String, int[]>> result = new HashMap<>();

		// Initialize HashMap with the test variables and their values
		for(int i = 0; i < dataMatrix[0].length; i++) {
			HashMap<String, int[]> auxHash = new HashMap<>();

			for(int j = 1; j < dataMatrix.length; j++) {
				if(auxHash.get(dataMatrix[j][i]) == null) {
					auxHash.put(dataMatrix[j][i], new int[]{ 0, 0});
				}

				// Calculate successes and failures for each case
				if(dataMatrix[j][dataMatrix[0].length - 3] != null && !dataMatrix[j][dataMatrix[0].length - 3].isEmpty()) {
					if(dataMatrix[j][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS)) {
						auxHash.get(dataMatrix[j][i])[0]++;
					} else if(dataMatrix[j][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_FAILURE)) {
						auxHash.get(dataMatrix[j][i])[1]++;
					}
				}
			}

			result.put(dataMatrix[0][i], auxHash);
		}

		return result;
	}

	protected static HashMap<String, ArrayList<String>> getColumnOrder(String[][] dataMatrix) {
		HashMap<String, ArrayList<String>> result = new HashMap<>();

		// Initialize HashMap with the test variables and their values
		for(int i = 0; i < dataMatrix[0].length; i++) {
			ArrayList<String> columnOrder = new ArrayList<>();

			for(int j = 1; j < dataMatrix.length; j++) {
				if(!dataMatrix[j][i].isEmpty() && (!columnOrder.contains(dataMatrix[j][i]) || columnOrder.isEmpty())) {
					columnOrder.add(dataMatrix[j][i]);
				}
			}

			result.put(dataMatrix[0][i], columnOrder);
		}

		return result;
	}

	protected HtmlElement createImagesTable(HashMap<String, int[]> columnResults, ArrayList<String> columnOrder, String tableName) {
		HtmlElement container = new HtmlElement("div")
			.addAttribute("class", "boxes thumbnails")
			.addAttribute("name", "table");

		for(int i = 0; i < columnOrder.size(); i++) {
			String testVariable = columnOrder.get(i);

			int successes = columnResults.get(columnOrder.get(i))[0];
			int failures = columnResults.get(columnOrder.get(i))[1];

			container.addChild(new HtmlElement("div")
				.addAttribute("class", "box selectable")
				.addAttribute("name", testVariable)
				.addChild(new HtmlElement("img")
					.addAttribute("src", AutomationConstants.THUMBNAILS_FOLDER + testVariable + ".png")
					.addAttribute("alt", translateOrFormat(testVariable).toUpperCase())
					.addAttribute("title", translateOrFormat(testVariable).toUpperCase())
					.addAttribute("width", "50")
					.addAttribute("height", "50"))
				.addChild(new HtmlElement("div")
					.addAttribute("class", "number")
					.addChild("span", "class=\"success\"" + (successes > 0 ? " style=\"color: green;\"" : " style=\"color: black;\""), Integer.toString(successes))
					.addChild("span", "", "/")
					.addChild("span", "class=\"error\"" + (failures > 0 ? " style=\"color: #CC444B;\"" : " style=\"color: black;\""), Integer.toString(failures))));
		}

		return container;
	}

	protected HtmlElement createTableByIndex(HashMap<String, int[]> columnResults, ArrayList<String> columnOrder, String tableName) {
		HtmlElement table = HtmlUtils.createTable(columnOrder.size(), 3);

		table.addChildAt(new HtmlElement("thead")
			.addChild("th", "", translateOrFormat(tableName))
			.addChild("th", "", translateOrFormat("Success"))
			.addChild("th", "", translateOrFormat("Failure")), 0);

		table.getChildByTag("tbody").addAttribute("name", "table");

		for(int i = 0; i < columnOrder.size(); i++) {
			String testVariable = columnOrder.get(i);

			int successes = columnResults.get(columnOrder.get(i))[0];
			int failures = columnResults.get(columnOrder.get(i))[1];

			HtmlElement rowElement = table.getChildByTag("tbody").getChild(i);

			rowElement.addAttribute("class", "selectable")
				.addAttribute("name", testVariable);

			rowElement.getChild(0).setContent(translateOrFormat(testVariable));

			rowElement.getChild(1).setContent(Integer.toString(successes));
			rowElement.getChild(2).setContent(Integer.toString(failures));

			if(successes > 0) {
				rowElement.getChild(1).addAttribute("style", "color: green;");
			}

			if(failures > 0) {
				rowElement.getChild(2).addAttribute("style", "color: red;");
			}
		}

		return table;
	}

	protected void addErrorCase(String[][] dataMatrix, String reportPath, String timeStamp, HtmlElement accordionContent, int index) {
		HtmlElement table = HtmlUtils.createTable(1, 1);

		HtmlElement caseVariables = new HtmlElement("div")
			.addAttribute("class", "boxes cases");

		for(int j = 0; j < dataMatrix[0].length - 4; j++) {
			caseVariables.addChild(new HtmlElement("div")
				.addAttribute("class", "box case")
				.setContent(translateOrFormat(dataMatrix[0][j]) + ": "
					+ translateOrFormat(dataMatrix[index][j])));
		}

		table.addChildAt(new HtmlElement("thead")
			.addChild(new HtmlElement("tr")
				.addChild(new HtmlElement("th")
					.addChild(caseVariables))), 0);

		String imagePath = "images/[ERROR] - " + timeStamp + ".i" + (index - 1) + ".jpg";
		String exception = dataMatrix[index][dataMatrix[0].length - 1];
		exception = exception == null ? "" : exception;

		if(!exception.isEmpty() && exception.contains(".")) {
			exception = exception.split("\\.")[exception.split("\\.").length - 1];
		}

		if(!exception.isEmpty()) {
			table.getChildByTag("thead")
				.addAttribute("title", exception);
		}

		if(new File(reportPath + imagePath).exists()) {
			table.addAttribute("class", "accordion")
				.getChildByTag("thead")
				.addAttribute("class", "ac-button")
				.getChildByTag("tr")
				.getChildByTag("th")
				.getChildByTag("div")
				.addChild(arrow);

			table.getChildByTag("tbody")
				.addAttribute("class", "ac-content")
				.addAttribute("style", "display: none;")
				.getChildByTag("tr")
				.getChildByTag("th")
				.addChild(new HtmlElement("img")
					.addAttribute("class", "responsive")
					.addAttribute("src", imagePath)
					.addAttribute("alt", "Cannot load image"));
		} else {
			table.removeChildAt(1);
		}

		accordionContent.addChild(table);
	}

	protected HtmlElement getErrorReportNode(String[][] dataMatrix, String reportPath, String timeStamp) {
		HtmlElement accordionContent = new HtmlElement("div")
			.addAttribute("class", "ac-content")
			.addAttribute("style", "display: none;");

		for(int i = 1; i < dataMatrix.length; i++) {
			if(dataMatrix[i][dataMatrix[0].length - 3] != null && !dataMatrix[i][dataMatrix[0].length - 3].isEmpty()
				&& dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_FAILURE)) {
				addErrorCase(dataMatrix, reportPath, timeStamp, accordionContent, i);
			}
		}

		HtmlElement errorsNode = new HtmlElement("div")
			.addAttribute("class", "accordion")
			.addChild(new HtmlElement("div")
				.addAttribute("class", "boxes ac-button")
				.addChild("h2", "class=\"box\"", translateOrFormat("Page Failures"))
				.addChild(arrow))
			.addChild(accordionContent);

		return new HtmlElement("div")
			.addAttribute("class", "columns-wrapper exceptions")
			.addChild(new HtmlElement("div")
				.addAttribute("class", "column bg-white")
				.addChild(errorsNode));
	}

	protected HtmlElement createHeader(String testCase, int nSuccess, int nFailures, String wrapperColor) {
		// Create browser element
		HtmlElement browserElement;
		if(columnCasesOrder.get(AutomationConstants.BROWSER) != null && columnCasesOrder.get(AutomationConstants.BROWSER).size() == 1) {
			browserElement = new HtmlElement("h3").setContent(translateOrFormat("Browser") + ": "
				+ translateOrFormat(columnCasesOrder.get(AutomationConstants.BROWSER).get(0)));
		} else if(columnCasesOrder.get(AutomationConstants.BROWSER) != null && columnCasesOrder.get(AutomationConstants.BROWSER).size() > 1) {
			HtmlElement select = new HtmlElement("select")
				.addChild(new HtmlElement("option")
					.addAttribute("disabled", "")
					.addAttribute("selected", "")
					.setContent(translateOrFormat("Browser")));

			for(int i = 0; i < columnCasesOrder.get(AutomationConstants.BROWSER).size(); i++) {
				select.addChild(new HtmlElement("option")
					.setContent(translateOrFormat(columnCasesOrder.get(AutomationConstants.BROWSER).get(i))));
			}

			browserElement = new HtmlElement("div")
				.addAttribute("class", "styled-select")
				.addChild(select);
		} else {
			browserElement = new HtmlElement("");
		}

		return new HtmlElement("section")
			.addAttribute("class", "boxes ac-button")
			.addChild(new HtmlElement("div")
				.addAttribute("class", "box sum-up bg-" + wrapperColor)
				.addChild(new HtmlElement("div")
					.addAttribute("class", "boxes")
					.addChild("h2", "class=\"box subtitle\"", translateOrFormat(testCase))
					.addChild(browserElement))
				.addChild(new HtmlElement("div")
					.addAttribute("class", "boxes")
					.addChild(new HtmlElement("div")
						.addAttribute("class", "box number result")
						.addChild("", "", Integer.toString(nSuccess + nFailures) + " (")
						.addChild("span", "class=\"success\"" + (nSuccess == 0 ? " style=\"color: white;\"" : ""), Integer.toString(nSuccess))
						.addChild("", "", "/")
						.addChild("span", "class=\"error\"" + (nFailures == 0 ? " style=\"color: white;\"" : ""), Integer.toString(nFailures))
						.addChild("", "", ")"))
					.addChild(arrow)));
	}

	protected HtmlElement createTable(int i) {
		HtmlElement variableData;

		boolean haveImages = true;
		String[] variables = columnCasesOrder.get(dataMatrix[0][i]).toArray(new String[0]);

		for(String variable : variables) {
			if(!new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER + '/' + variable + ".png").exists()) {
				haveImages = false;
			}
		}

		if(haveImages) {
			variableData = createImagesTable(testStats.get(dataMatrix[0][i]), columnCasesOrder.get(dataMatrix[0][i]), dataMatrix[0][i]);
		} else {
			variableData = createTableByIndex(testStats.get(dataMatrix[0][i]), columnCasesOrder.get(dataMatrix[0][i]), dataMatrix[0][i]);
		}

		return new HtmlElement("div")
			.addAttribute("class", "column bg-white")
			.addAttribute("name", dataMatrix[0][i])
			.addChild("h2", "", translateOrFormat(dataMatrix[0][i]))
			.addChild(variableData);
	}

	protected HtmlElement modifyAccordionContent(HtmlElement accordionContent, String timeStamp, String testCase, int relevantColumns) {
		return accordionContent;
	}

	protected HtmlElement modifyWrapperContent(HtmlElement wrapper, String timeStamp, String testCase, int relevantColumns) {
		return wrapper;
	}

	protected HtmlElement modifyContent(HtmlElement htmlNode, String timeStamp, String[] testCases, int[] relevantColumns) {
		return htmlNode;
	}

	protected int updateRelevantColumns(int relevantColumn) {
		int auxRelevantColumns = relevantColumn;

		if(auxRelevantColumns == -1) {
			auxRelevantColumns = dataMatrix[0].length - 3 - (ArrayUtils.contains(dataMatrix[0], AutomationConstants.BROWSER) ? 1 : 0);
		} else if(auxRelevantColumns > dataMatrix[0].length) {
			auxRelevantColumns = dataMatrix[0].length;
		}

		return auxRelevantColumns;
	}

	protected String getWrapperColor(int nSuccesses, int nFailures) {
		String wrapperColor = "white";

		if(nSuccesses > 0 && nFailures == 0) {
			wrapperColor = "green";
		} else if(nFailures > 0 && nSuccesses == 0) {
			wrapperColor = "red";
		} else if(nSuccesses > 0 && nFailures > 0) {
			wrapperColor = "yellow";
		}

		return wrapperColor;
	}

	protected void addRelevantTables(HtmlElement accordionContent, int relevantColumns) {
		for(int i = 0; i < relevantColumns; i++) {
			if(i == 0 || i == 1) {
				accordionContent.addChild("div", "class=\"columns-wrapper\"");
			}

			accordionContent.getChild(i % 2).addChild(createTable(i));
		}
	}

	protected HtmlElement createTestCaseWrapper(String timeStamp, String testCase, int relevantColumns) {
		HtmlElement wrapper = null;
		String finalPath = reportPath + '/' + timeStamp + ".csv";

		if(new File(finalPath).exists()) {
			wrapper = new HtmlElement("div")
				.addAttribute("id", testCase);

			dataMatrix = FileUtils.csvFileToMatrix(finalPath, true);
			dataMatrix = ArrayUtils.removeRowsContaining(dataMatrix, AutomationConstants.TEST_UNDONE, dataMatrix[0].length - 3);

			if(dataMatrix.length > 1) {
				try {
					testStats = initializeHashMap(dataMatrix);
					columnCasesOrder = getColumnOrder(dataMatrix);

					// Copy images needed from resources/thumbnails
					copyImagesFolder(reportPath, testStats);

					// Set relevant columns
					relevantColumns = updateRelevantColumns(relevantColumns);

					// Add Result boxes
					HashMap<String, int[]> resultsMap = testStats.get(dataMatrix[0][dataMatrix[0].length - 3]);

					int nSuccesses = resultsMap.get(AutomationConstants.TEST_SUCCESS) != null ? resultsMap.get(AutomationConstants.TEST_SUCCESS)[0] : 0;
					int nFailures = resultsMap.get(AutomationConstants.TEST_FAILURE) != null ? resultsMap.get(AutomationConstants.TEST_FAILURE)[1] : 0;

					String wrapperColor = getWrapperColor(nSuccesses, nFailures);

					wrapper.addAttribute("class", "wrapper column accordion bg-light-" + wrapperColor);

					wrapper.addChild(createHeader(testCase, nSuccesses, nFailures, wrapperColor));

					HtmlElement accordionContent = new HtmlElement("section")
						.addAttribute("class", "columns ac-content");

					// Add relevant columns tables from test variables
					addRelevantTables(accordionContent, relevantColumns);

					// Add error report
					if(columnCasesOrder.get(AutomationConstants.RESULT).contains("FAILURE")) {
						accordionContent.addChild(getErrorReportNode(dataMatrix, reportPath, timeStamp));
					}

					modifyAccordionContent(accordionContent, timeStamp, testCase, relevantColumns);

					wrapper.addChild(accordionContent);
				} catch(Exception e) {
					printStackTrace(e);
				}
			}

			modifyWrapperContent(wrapper, timeStamp, testCase, relevantColumns);
		}

		return wrapper;
	}

	protected StringBuilder createScriptMatrix(int revelantColumns) {
		StringBuilder matrixBuilder = new StringBuilder();

		matrixBuilder.append(currentTestCase + "_matrix = [");

		for(int j = 0; j < dataMatrix.length; j++) {
			if(j != 0) matrixBuilder.append(", ");

			matrixBuilder.append("[");

			for(int k = 0; k < revelantColumns; k++) {
				if(k != 0) matrixBuilder.append(", ");

				matrixBuilder.append("'" + dataMatrix[j][k] + "'");
			}

			String result = "";

			if(ArrayUtils.getPositionInArray(dataMatrix[0], AutomationConstants.RESULT) >= revelantColumns) {
				result = ", '" + (j == 0 ? AutomationConstants.RESULT : dataMatrix[j][dataMatrix[j].length - 3]) + "'";
			}

			matrixBuilder.append(result + "]");
		}

		matrixBuilder.append("];\n\n");

		return matrixBuilder;
	}

	protected HtmlElement createJointHtmlNode(String timeStamp, String reportName, String[] testCases, int[] relevantColumns) {
		StringBuilder matrixBuilder = new StringBuilder();
		HtmlElement body = new HtmlElement("body");
		HtmlElement htmlNode = new HtmlElement("html")
			.addChild(new HtmlElement("head")
				.addChild("meta", "charset=\"UTF-8\"")
				.addChild("title", "", translateOrFormat("Test report"))
				.addChild("style", "type=\"text/css\"", FileUtils.readFile(System.getProperty("user.dir") + '/' + AutomationConstants.RESOURCES_FOLDER + "styles/styles.css")))
			.addChild(body
				.addChild(new HtmlElement("header")
					.addChild(new HtmlElement("div")
						.addAttribute("class", "title")
						.addAttribute("align", "center")
						.addChild("h1", "", translateOrFormat("Report [suitename] from [date]")
							.replace("[suitename]", translateOrFormat(reportName))
							.replace("[date]", timeStamp.split("\\.")[2] + "/" + timeStamp.split("\\.")[1] + '/' + timeStamp.split("\\.")[0])))));

		// Create HTMLs
		for(int i = 0; i < testCases.length; i++) {
			currentTestCase = testCases[i];
			currentTimeStamp = timeStamp.replace(AutomationConstants.TESTCASE_REPLACE, currentTestCase);

			HtmlElement auxNode = createTestCaseWrapper(currentTimeStamp, currentTestCase, relevantColumns[i]);

			if(dataMatrix != null) {
				int auxRelevantColumns = updateRelevantColumns(relevantColumns[i]);

				matrixBuilder = createScriptMatrix(auxRelevantColumns);
			}

			if(testCases.length > 1) {
				auxNode.getChild(1).addAttribute("style", "display: none;");
			}

			if(auxNode != null) {
				htmlNode.getChildByTag("body").addChild(auxNode);
			} else {
				debugInfo("HTML not created, file not found: " + reportPath + '/' + timeStamp + ".csv");
			}

			dataMatrix = null;
			currentTestCase = null;
			currentTimeStamp = null;
		}

		htmlNode.getChildByTag("body").addChild(new HtmlElement("script")
			.addAttribute("type", "text/javascript")
			.setContent("var els = document.querySelectorAll('.accordion');\n"
				+ "for(var i = 0; i < els.length; i++) {\n"
				+ "\tels[i].querySelector('.ac-button').addEventListener('click', function() {\n"
				+ "\t\tvar content = this.nextElementSibling;\n"
				+ "\t\tif(content.getAttribute('style') == 'display: none;') {\n"
				+ "\t\t\tcontent.removeAttribute('style');\n"
				+ "\t\t} else {\n"
				+ "\t\t\tcontent.setAttribute('style', 'display: none;');\n"
				+ "\t\t}\n"
				+ "\t});\n"
				+ "}\n\n"
				+ "var imgEls = document.querySelectorAll('img.responsive');\n"
				+ "for(var i = 0; i < imgEls.length; i++) {\n"
				+ "\timgEls[i].addEventListener('click', function() {\n"
				+ "\t\tvar content = this.parentElement.parentElement.parentElement;\n"
				+ "\t\tif(content.getAttribute('style') == 'display: none;') {\n"
				+ "\t\t\tcontent.removeAttribute('style');\n"
				+ "\t\t} else {\n"
				+ "\t\t\tcontent.setAttribute('style', 'display: none;');\n"
				+ "\t\t}\n"
				+ "\t});\n"
				+ "}"));

		htmlNode.getChildByTag("body").addChild(new HtmlElement("script")
			.addAttribute("type", "text/javascript")
			.setContent(matrixBuilder.toString()
				+ "var els = document.querySelectorAll('.selectable');\n"
				+ "for(var i = 0; i < els.length; i++) {\n"
				+ "\tels[i].addEventListener('click', function() {\n"
				+ "\t\tclassName = this.getAttribute('class');\n\n"
				+ "\t\tif(className.indexOf('selected') > 0) {\n"
				+ "\t\t\tthis.setAttribute('class', className.replace(' selected', ''));\n"
				+ "\t\t\tthis.removeAttribute('style');\n"
				+ "\t\t} else {\n"
				+ "\t\t\tthis.setAttribute('class', className + ' selected');\n"
				+ "\t\t\tthis.setAttribute('style', 'border-width: 5; border-color: #6b85af;');\n"
				+ "\t\t}\n\n"
				+ "\t\tvar wrapper = this.parentElement.parentElement;\n\n"
				+ "\t\tif(this.tagName != 'DIV') {\n"
				+ "\t\t\twrapper = wrapper.parentElement;\n"
				+ "\t\t}\n\n"
				+ "\t\tupdateTables(wrapper.parentElement.parentElement.parentElement);\n"
				+ "\t});\n"
				+ "}\n\n"
				+ "function updateTables(wrapper) {\n"
				+ "\tvar columns = [];\n"
				+ "\tvar itemsSelected = [];\n"
				+ "\tvar tables = wrapper.querySelectorAll('[name=\"table\"]');\n"
				+ "\tvar matrix = window[wrapper.getAttribute('id') + '_matrix'];\n\n"
				+ "\tfor(var i = 0; i < matrix[0].length - 1; i++) {\n"
				+ "\t\tvar auxColumns = [];\n\n"
				+ "\t\tfor(var j = 1; j < matrix.length; j++) {\n"
				+ "\t\t\tif(auxColumns.length == 0 || auxColumns.indexOf(matrix[j][i]) < 0) {\n"
				+ "\t\t\t\tauxColumns.push(matrix[j][i]);\n"
				+ "\t\t\t}\n"
				+ "\t\t}\n\n"
				+ "\t\tcolumns.push(auxColumns);\n"
				+ "\t}\n\n"
				+ "\tvar auxTables = [];\n\n"
				+ "\tfor(var i = 0; i < matrix[0].length; i++) {\n"
				+ "\t\tfor(var j = 0; j < tables.length; j++) {\n"
				+ "\t\t\tvar tableContainer = tables[j].parentElement;\n\n"
				+ "\t\t\tif(tables[j].tagName != 'DIV') {\n"
				+ "\t\t\t\ttableContainer = tableContainer.parentElement;\n"
				+ "\t\t\t}\n\n"
				+ "\t\t\tif(tableContainer.getAttribute('name') == matrix[0][i]) {\n"
				+ "\t\t\t\tauxTables.push(tables[j]);\n"
				+ "\t\t\t\tbreak;\n"
				+ "\t\t\t}\n"
				+ "\t\t}\n"
				+ "\t}\n\n"
				+ "\ttables = auxTables;\n\n"
				+ "\tfor(var i = 0; i < tables.length; i++) {\n"
				+ "\t\tvar auxItemsSelected = [];\n"
				+ "\t\tvar elementsSelected = tables[i].querySelectorAll('* > .selected');\n\n"
				+ "\t\tfor(var j = 0; j < elementsSelected.length; j++) {\n"
				+ "\t\t\tauxItemsSelected.push(elementsSelected[j].getAttribute('name'));\n"
				+ "\t\t}\n\n"
				+ "\t\tif(auxItemsSelected.length > 0) {\n"
				+ "\t\t\titemsSelected.push(auxItemsSelected);\n"
				+ "\t\t} else itemsSelected.push(columns[i]);\n"
				+ "\t}\n\n"
				+ "\tfor(var i = 0; i < tables.length; i++) {\n"
				+ "\t\tvar selected = tables[i].querySelectorAll('* > [name].selected').length > 0;\n"
				+ "\t\tvar elements = tables[i].querySelectorAll('* > [name]');\n\n"
				+ "\t\tfor(var j = 0; j < elements.length; j++) {\n"
				+ "\t\t\tvar selectedMatrix = [];\n"
				+ "\t\t\tfor(var k = 0; k < tables.length; k++) {\n"
				+ "\t\t\t\tif(k == i) {\n"
				+ "\t\t\t\t\tselectedMatrix.push([elements[j].getAttribute('name')]);\n"
				+ "\t\t\t\t} else {\n"
				+ "\t\t\t\t\tif(itemsSelected[k] != undefined && itemsSelected[k].length > 0) {\n"
				+ "\t\t\t\t\t\tselectedMatrix.push(itemsSelected[k]);\n"
				+ "\t\t\t\t\t} else {\n"
				+ "\t\t\t\t\t\tselectedMatrix.push(columns[k]);\n"
				+ "\t\t\t\t\t}\n"
				+ "\t\t\t\t}\n"
				+ "\t\t\t}\n\n"
				+ "\t\t\tvar result = countRows(selectedMatrix, columns, matrix);\n"
				+ "\t\t\tvar successSelector, failureSelector;\n\n"
				+ "\t\t\tif(elements[j].tagName == 'DIV') {\n"
				+ "\t\t\t\tsuccessSelector = 'span:nth-of-type(1)';\n"
				+ "\t\t\t\tfailureSelector = 'span:nth-of-type(3)';\n"
				+ "\t\t\t} else {\n"
				+ "\t\t\t\tsuccessSelector = 'th:nth-of-type(2)';\n"
				+ "\t\t\t\tfailureSelector = 'th:nth-of-type(3)';\n"
				+ "\t\t\t}\n\n"
				+ "\t\t\tif(!selected || elements[j].getAttribute('class').indexOf('selected') > 0) {\n"
				+ "\t\t\t\telements[j].querySelector(successSelector).textContent = result[0];\n"
				+ "\t\t\t\telements[j].querySelector(failureSelector).textContent = result[1];\n"
				+ "\t\t\t} else {\n"
				+ "\t\t\t\telements[j].querySelector(successSelector).textContent = '0';\n"
				+ "\t\t\t\telements[j].querySelector(failureSelector).textContent = '0';\n"
				+ "\t\t\t}\n"
				+ "\t\t}\n"
				+ "\t}\n"
				+ "}\n\n"
				+ "function countRows(selectedMatrix, columns, matrix) {\n"
				+ "\tvar success = 0;\n"
				+ "\tvar failure = 0;\n\n"
				+ "\tfor(var i = 1; i < matrix.length; i++) {\n"
				+ "\t\tvar found = true;\n"
				+ "\t\tfor(var j = 0; j < matrix[0].length; j++) {\n"
				+ "\t\t\tvar foundInSelectedMatrix = false;\n"
				+ "\t\t\tif(selectedMatrix[j] != undefined && selectedMatrix[j].length > 0) {\n"
				+ "\t\t\t\tfor(var k = 0; k < selectedMatrix[j].length; k++) {\n"
				+ "\t\t\t\t\tif(selectedMatrix[j][k] == matrix[i][j]) {\n"
				+ "\t\t\t\t\t\tfoundInSelectedMatrix = true;\n"
				+ "\t\t\t\t\t\tbreak;\n"
				+ "\t\t\t\t\t}\n"
				+ "\t\t\t\t}\n"
				+ "\t\t\t} else foundInSelectedMatrix = true;\n\n"
				+ "\t\t\tif(!foundInSelectedMatrix) found = false;\n"
				+ "\t\t}\n\n"
				+ "\t\tif(found && matrix[i][matrix[0].indexOf('result')] == 'SUCCESS') {\n"
				+ "\t\t\tsuccess++;\n"
				+ "\t\t} else if(found && matrix[i][matrix[0].indexOf('result')] == 'FAILURE') {\n"
				+ "\t\t\tfailure++;\n"
				+ "\t\t}\n"
				+ "\t}\n\n"
				+ "\treturn [success, failure];\n"
				+ "}"));

		modifyContent(htmlNode, timeStamp, testCases, relevantColumns);

		return htmlNode;
	}

	protected void writeToFile(HtmlElement htmlNode, String path) {
		if(htmlNode != null) {
			try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + ".html"), StandardCharsets.UTF_8))) {
				bw.write(htmlNode.toString());

				debugInfo("HTML created");
			} catch(IOException e) {
				printStackTrace(e);
			}
		}
	}

	protected void copyImage(String fileName, File originPath, File destinationPath) {
		InputStream in = null;

		try(OutputStream out = new FileOutputStream(new File(destinationPath, fileName))) {
			in = new FileInputStream(new File(originPath, fileName));

			int length;
			byte[] buffer = new byte[1024];

			while((length = in.read(buffer)) > 0) {
				out.write(buffer, 0, length);
			}
		} catch(Exception e) {
			logger.error("Error copying images");
		} finally {
			try {
				if(in != null) in.close();
			} catch(IOException e) {
				printStackTrace(e);
			}
		}
	}

	protected void copyImagesFolder(String reportPath, HashMap<String, HashMap<String, int[]>> testStats) {
		File originPath = new File(System.getProperty("user.dir") + '/' + AutomationConstants.RESOURCES_FOLDER + AutomationConstants.THUMBNAILS_FOLDER);
		File destinationPath = new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER);

		if(originPath.exists()) {
			String[] keys = testStats.keySet().toArray(new String[0]);
			ArrayList<String> filesNeeded = new ArrayList<>();

			for(int i = 0; i < keys.length; i++) {
				for(int j = 0; j < testStats.get(keys[i]).size(); j++) {
					filesNeeded.add(testStats.get(keys[i]).keySet().toArray()[j].toString());
				}
			}

			filesNeeded.add("info");

			destinationPath.mkdirs();

			for(String fileName : originPath.list()) {
				copyImage(fileName, originPath, destinationPath);
			}
		}
	}
}