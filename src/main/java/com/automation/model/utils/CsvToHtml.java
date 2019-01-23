package com.automation.model.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

import com.automation.configuration.AutomationConstants;
import com.automation.model.testing.SuiteManager;
import com.automation.data.DataObject;
import com.automation.model.utils.objects.DebugLogger;
import com.automation.model.utils.objects.HtmlElement;
import com.automation.model.webdriver.configuration.BrowserType;

/**
 * The CsvToHtml class is used to manage use a csv report file and transform it into an HTML report
 *
 * @author Alfredo Moises Boullosa Ramones
 */

public class CsvToHtml {

	protected String reportPath = null;
	protected String[][] dataMatrix = null;
	protected String translationFile = null;
	protected HashMap<String, ArrayList<String>> columnCasesOrder = null;
	protected HashMap<String, HashMap<String, int[]>> testStats = null;
	protected DebugLogger logger = new DebugLogger();

	public static void main(String[] args) {
		CsvToHtml converter = new CsvToHtml();
		String translationFile = System.getProperty("translation_file");
		translationFile = translationFile.isEmpty() ? null : translationFile;
		
		if(args.length >= 4 && !args[3].contains(",") && !args[3].contains(".")) {
			converter.setReportPath(System.getProperty("user.dir") + "/" + AutomationConstants.REPORTS_FOLDER + "/T" + args[0] + args[1] + args[2]);

			int relevantColumns = -1;
			
			if(args.length > 5) {
				relevantColumns = Integer.parseInt(args[5]);
			} else if(args.length > 4 && org.apache.commons.lang3.StringUtils.isNumeric(args[4])) {
				relevantColumns = Integer.parseInt(args[4]);
			}

			converter.createJointReport(args[0] + "." + args[1] + "." + args[2] + "." + args[3] + (args.length > 4 
					&& !org.apache.commons.lang3.StringUtils.isNumeric(args[4]) ? "." + args[4] : ""), 
				args[3], new String[]{ args[3]}, new int[]{ relevantColumns}, translationFile);
		} else if(args.length >= 6 && (args[3].contains(",") || args[3].contains("."))) {
			String year = args[0], month = args[1], day = args[2], browser = args[4];
			converter.setReportPath(System.getProperty("user.dir") + "/" + AutomationConstants.REPORTS_FOLDER + "/T" + year + month + day);

			String[] testCases = args[3].contains(",") ? args[3].split(",") : args[3].split("\\.");

			String[] relevantColString;

			if(args.length > 6) {
				relevantColString = args[6].contains(",") ? args[6].split(",") : args[6].split("\\.");
			} else {
				relevantColString = new String[testCases.length];
			}

			int[] relevantColInt = new int[relevantColString.length];

			for(int i = 0; i < relevantColString.length; i++) {
				if(args.length == 7) {
					relevantColInt[i] = Integer.parseInt(relevantColString[i]);
				} else {
					relevantColInt[i] = -1;
				}
			}

			converter.createJointReport(year + "." + month + "." + day + ".[TESTCASE]." + browser, args[5], testCases, relevantColInt, translationFile);
		}
	}

	protected void debugInfo(String message) {
		logger.info(message);
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
			String timeStamp = suiteM.getTestData(suiteM.getTestCases()[0]).getTimeStamp();
			reportPath = suiteM.getTestData(suiteM.getTestCases()[0]).getReportPath();

			createJointReport(timeStamp, suiteM.getName(), suiteM.getTestCases(), suiteM.getRelevantColumns(), translationFile);
		}
	}

	protected void createJointReport(String timeStamp, String reportName, String[] testCases, int[] relevantColumns) {
		createJointReport(timeStamp, reportName, testCases, relevantColumns, null);
	}

	protected void createReport(String timeStamp, String testCase, int relevantColumns, String translationFile) {
		this.translationFile = translationFile;
		reportPath = reportPath.charAt(reportPath.length() - 1) == '/' ? reportPath : reportPath + "/";

		HtmlElement htmlNode = createTestCaseWrapper(timeStamp, testCase, relevantColumns);

		writeHtml(htmlNode, reportPath + timeStamp + ".html");
	}

	protected void createJointReport(String timeStamp, String reportName, String[] testCases, int[] relevantColumns, String translationFile) {
		debugInfo("Generating HTML...");
		this.translationFile = translationFile;
		reportPath = reportPath.charAt(reportPath.length() - 1) == '/' ? reportPath : reportPath + "/";

		String[] timeStampArray = timeStamp.split("\\.");
		for(int i = 0; i < timeStampArray.length; i++) {
			if(!org.apache.commons.lang3.StringUtils.isNumeric(timeStampArray[i])) {
				timeStampArray[i] = "[TESTCASE]";
				break;
			}
		}

		timeStamp = ArrayUtils.arrayToString(timeStampArray, ".");

		HtmlElement htmlNode = createJointHtmlNode(timeStamp, reportName, testCases, relevantColumns);

		if(!new File(reportPath).exists()) new File(reportPath).mkdirs();
		writeHtml(htmlNode, reportPath + timeStamp.replace("[TESTCASE]", reportName).replace("_headless", "") + ".html");
	}

	protected String translateOrFormat(String text) {
		String result = text;

		if(translationFile != null) {
			DataObject translationObject = new DataObject(FileUtils.variablesFileToArray(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + translationFile));

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
		HashMap<String, HashMap<String, int[]>> result = new HashMap<String, HashMap<String, int[]>>();

		// Initialize HashMap with the test variables and their values
		for(int i = 0; i < dataMatrix[0].length; i++) {
			HashMap<String, int[]> auxHash = new HashMap<String, int[]>();

			for(int j = 1; j < dataMatrix.length; j++) {
				if(auxHash.get(dataMatrix[j][i]) == null) {
					auxHash.put(dataMatrix[j][i], new int[]{ 0, 0});
				}

				// Calculate successes and failures for each case
				if(dataMatrix[j][dataMatrix[0].length - 3] != null && !dataMatrix[j][dataMatrix[0].length - 3].isEmpty()) {
					if(dataMatrix[j][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS)) {
						auxHash.get(dataMatrix[j][i])[0]++;
					} else {
						auxHash.get(dataMatrix[j][i])[1]++;
					}
				}
			}

			result.put(dataMatrix[0][i], auxHash);
		}

		return result;
	}

	protected static HashMap<String, ArrayList<String>> getColumnOrder(String[][] dataMatrix) {
		HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();

		// Initialize HashMap with the test variables and their values
		for(int i = 0; i < dataMatrix[0].length; i++) {
			ArrayList<String> columnOrder = new ArrayList<String>();

			for(int j = 1; j < dataMatrix.length; j++) {
				if(!dataMatrix[j][i].isEmpty() && (!columnOrder.contains(dataMatrix[j][i]) || columnOrder.size() == 0)) {
					columnOrder.add(dataMatrix[j][i]);
				}
			}

			result.put(dataMatrix[0][i], columnOrder);
		}

		return result;
	}

	protected HtmlElement createImagesTable(HashMap<String, int[]> columnResults, ArrayList<String> columnOrder) {
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

	protected HtmlElement createTableByIndex(HashMap<String, int[]> columnResults, ArrayList<String> columnOrder) {
		HtmlElement table = HtmlUtils.createTable(columnOrder.size(), 3);

		table.addChildAt(new HtmlElement("thead")
			.addChild("th", "", translateOrFormat("Variable"))
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

	protected HtmlElement getErrorReportNode(String[][] dataMatrix, String reportPath, String timeStamp) {
		HtmlElement accordionContent = new HtmlElement("div")
			.addAttribute("class", "ac-content")
			.addAttribute("style", "display: none;");

		HtmlElement arrow = new HtmlElement("div")
			.addChild(new HtmlElement("svg")
				.addAttribute("fill", "black")
				.addAttribute("fill-opacity", "0.4")
				.addAttribute("height", "15")
				.addAttribute("width", "30")
				.addChild("path", "d=\"M0 0 L15 15 L30 0 Z\""));

		for(int i = 1; i < dataMatrix.length; i++) {
			if(dataMatrix[i][dataMatrix[0].length - 3] != null && !dataMatrix[i][dataMatrix[0].length - 3].isEmpty()
				&& dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_FAILURE)) {
				HtmlElement table = HtmlUtils.createTable(1, 1);

				HtmlElement caseVariables = new HtmlElement("div")
					.addAttribute("class", "boxes cases");

				for(int j = 0; j < dataMatrix[0].length - 4; j++) {
					caseVariables.addChild(new HtmlElement("div")
						.addAttribute("class", "box case")
						.setContent(translateOrFormat(dataMatrix[0][j]) + ": "
							+ translateOrFormat(dataMatrix[i][j])));
				}

				table.addChildAt(new HtmlElement("thead")
					.addChild(new HtmlElement("tr")
						.addChild(new HtmlElement("th")
							.addChild(caseVariables))), 0);

				String imagePath = "images/[ERROR] - " + timeStamp + ".i" + (i - 1) + ".jpg";

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
							.addAttribute("title", dataMatrix[i][dataMatrix[0].length - 3])
							.addAttribute("src", imagePath)
							.addAttribute("alt", "Cannot load image"));
				} else {
					table.removeChildAt(1);
				}

				accordionContent.addChild(table);
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
		if(columnCasesOrder.get("browser") != null && columnCasesOrder.get("browser").size() == 1) {
			browserElement = new HtmlElement("h3").setContent(translateOrFormat("Browser") + ": "
				+ translateOrFormat(columnCasesOrder.get("browser").get(0)));
		} else if(columnCasesOrder.get("browser") != null && columnCasesOrder.get("browser").size() > 1) {
			HtmlElement select = new HtmlElement("select")
				.addChild(new HtmlElement("option")
					.addAttribute("disabled", "")
					.addAttribute("selected", "")
					.setContent(translateOrFormat("Browser")));

			for(int i = 0; i < columnCasesOrder.get("browser").size(); i++) {
				select.addChild(new HtmlElement("option")
					.setContent(translateOrFormat(columnCasesOrder.get("browser").get(i))));
			}

			browserElement = new HtmlElement("div")
				.addAttribute("class", "styled-select")
				.addChild(select);
		} else {
			browserElement = new HtmlElement("");
		}

		HtmlElement arrow = new HtmlElement("div")
			.addChild(new HtmlElement("svg")
				.addAttribute("fill", "black")
				.addAttribute("fill-opacity", "0.4")
				.addAttribute("height", "15")
				.addAttribute("width", "30")
				.addChild("path", "d=\"M0 0 L15 15 L30 0 Z\""));

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
		String[] variables = ArrayUtils.objetArrayToStringArray(columnCasesOrder.get(dataMatrix[0][i]).toArray());

		for(String variable : variables) {
			if(!new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER + "/" + variable + ".png").exists()) {
				haveImages = false;
			}
		}

		if(haveImages) {
			variableData = createImagesTable(testStats.get(dataMatrix[0][i]), columnCasesOrder.get(dataMatrix[0][i]));
		} else {
			variableData = createTableByIndex(testStats.get(dataMatrix[0][i]), columnCasesOrder.get(dataMatrix[0][i]));
		}

		return new HtmlElement("div")
			.addAttribute("class", "column bg-white")
			.addAttribute("name", dataMatrix[0][i])
			.addChild("h2", "", translateOrFormat(dataMatrix[0][i]))
			.addChild(variableData);
	}

	protected HtmlElement modifyAccordionContent(HtmlElement accordionContent, String timeStamp, String testCase, int relevantColumns) {
		return null;
	}

	protected HtmlElement modifyWrapperContent(HtmlElement wrapper, String timeStamp, String testCase, int relevantColumns) {
		return null;
	}

	protected HtmlElement modifyHtmlContent(HtmlElement htmlNode, String timeStamp, String[] testCases, int[] relevantColumns) {
		return null;
	}

	protected HtmlElement createTestCaseWrapper(String timeStamp, String testCase, int relevantColumns) {
		String finalPath = reportPath + "/" + timeStamp + ".csv";

		if(new File(finalPath).exists()) {
			HtmlElement wrapper = new HtmlElement("div")
				.addAttribute("id", testCase);

			dataMatrix = FileUtils.loadCsvFileToArray(finalPath, true);

			if(dataMatrix.length > 1) {
				try {
					testStats = initializeHashMap(dataMatrix);
					columnCasesOrder = getColumnOrder(dataMatrix);

					// Copy images needed from resources/thumbnails
					copyImagesFolder(reportPath, testStats);

					// Set relevant columns
					if(relevantColumns == -1 || relevantColumns > dataMatrix[0].length - 4) {
						relevantColumns = dataMatrix[0].length - 4;
					}

					// Add Result boxes
					HashMap<String, int[]> resultsMap = testStats.get(dataMatrix[0][dataMatrix[0].length - 3]);

					int nSuccess = resultsMap.get(AutomationConstants.TEST_SUCCESS) != null ? resultsMap.get(AutomationConstants.TEST_SUCCESS)[0] : 0;
					int nFailures = resultsMap.get(AutomationConstants.TEST_FAILURE) != null ? resultsMap.get(AutomationConstants.TEST_FAILURE)[1] : 0;

					String wrapperColor = nSuccess > 0 && nFailures == 0 ? "green" : nFailures > 0 && nSuccess == 0 ? "red" : nSuccess > 0 && nFailures > 0 ? "yellow" : "white";
					wrapper.addAttribute("class", "wrapper column accordion bg-light-" + wrapperColor);

					wrapper.addChild(createHeader(testCase, nSuccess, nFailures, wrapperColor));

					HtmlElement accordionContent = new HtmlElement("section")
						.addAttribute("class", "columns ac-content");

					// Add relevant columns tables from test variables
					for(int i = 0; i < relevantColumns; i++) {
						if(i == 0 || i == 1) {
							accordionContent.addChild("div", "class=\"columns-wrapper\"");
						}

						accordionContent.getChild(i % 2).addChild(createTable(i));
					}

					// Add error report
					if(columnCasesOrder.get("result").contains("FAILURE")) {
						accordionContent.addChild(getErrorReportNode(dataMatrix, reportPath, timeStamp));
					}

					HtmlElement auxiliarAccordion = modifyAccordionContent(accordionContent, timeStamp, testCase, relevantColumns);

					if(auxiliarAccordion != null) {
						accordionContent = auxiliarAccordion;
					}

					wrapper.addChild(accordionContent);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

			HtmlElement auxiliarWrapper = modifyWrapperContent(wrapper, timeStamp, testCase, relevantColumns);

			if(auxiliarWrapper != null) {
				wrapper = auxiliarWrapper;
			}

			return wrapper;
		} else {
			debugInfo("HTML not created, file not found: " + reportPath + "/" + timeStamp + ".csv");
			return null;
		}
	}

	protected HtmlElement createJointHtmlNode(String timeStamp, String reportName, String[] testCases, int[] relevantColumns) {
		String matrix = "";
		HtmlElement body = new HtmlElement("body");
		HtmlElement htmlNode = new HtmlElement("html")
			.addChild(new HtmlElement("head")
				.addChild("meta", "charset=\"UTF-8\"")
				.addChild("title", "", translateOrFormat("Test report"))
				.addChild("style", "type=\"text/css\"", FileUtils.getTextFromFile(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + "styles/styles.css")))
			.addChild(body
				.addChild(new HtmlElement("header")
					.addChild(new HtmlElement("div")
						.addAttribute("class", "title")
						.addAttribute("align", "center")
						.addChild("h1", "", translateOrFormat("Report [suitename] from [date]")
							.replace("[suitename]", translateOrFormat(reportName))
							.replace("[date]", timeStamp.split("\\.")[2] + "/" + timeStamp.split("\\.")[1] + "/" + timeStamp.split("\\.")[0])))));

		// Create HTMLs
		for(int i = 0; i < testCases.length; i++) {
			String auxTimeStamp = timeStamp.replace("[TESTCASE]", testCases[i]);
			String browserTimeStamp = auxTimeStamp.contains("headless") ? auxTimeStamp.replace("_headless", "") : auxTimeStamp;
			String headlessTimeStamp = browserTimeStamp
				.replace(BrowserType.CHROME, BrowserType.CHROME + "_headless")
				.replace(BrowserType.FIREFOX, BrowserType.FIREFOX + "_headless")
				.replace(BrowserType.GALAXYS5, BrowserType.GALAXYS5 + "_headless");

			auxTimeStamp = new File(reportPath + "/" + browserTimeStamp + ".csv").exists() ? browserTimeStamp
				: new File(reportPath + "/" + headlessTimeStamp + ".csv").exists() ? headlessTimeStamp : browserTimeStamp;

			HtmlElement auxNode = createTestCaseWrapper(auxTimeStamp, testCases[i], relevantColumns[i]);
			
			int auxRelevantColumns = relevantColumns[i];
			
			if(auxRelevantColumns == -1 || auxRelevantColumns > dataMatrix[0].length - 4) {
				auxRelevantColumns = dataMatrix[0].length - 4;
			}
			
			matrix += testCases[i] + "_matrix = [";

			for(int j = 0; j < dataMatrix.length ; j++) {
				if(j != 0) matrix += ", ";
				matrix += "[";
				
				for(int k = 0; k < auxRelevantColumns; k++) {
					if(k != 0) matrix += ", ";
					matrix += "'" + dataMatrix[j][k] + "'";
				}
				
				matrix += ", '" + (j == 0 ? "result" : dataMatrix[j][dataMatrix[j].length - 3]) + "']";
			}

			matrix += "];\n\n";

			if(testCases.length > 1) {
				auxNode.getChild(1).addAttribute("style", "display: none;");
			}

			if(auxNode != null) {
				htmlNode.getChildByTag("body").addChild(auxNode);
			}
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
			.setContent(matrix
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
				+ "\t\tauxColumns = [];\n\n"
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
				+ "\t\t\t\t\tif(itemsSelected[k].length > 0) {\n"
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
				+ "\t\tfor(var j = 0; j < matrix[0].length - 1; j++) {\n"
				+ "\t\t\tvar foundInSelectedMatrix = false;\n"
				+ "\t\t\tif(selectedMatrix[j].length > 0) {\n"
				+ "\t\t\t\tfor(var k = 0; k < selectedMatrix[j].length; k++) {\n"
				+ "\t\t\t\t\tif(selectedMatrix[j][k] == matrix[i][j]) {\n"
				+ "\t\t\t\t\t\tfoundInSelectedMatrix = true;\n"
				+ "\t\t\t\t\t\tbreak;\n"
				+ "\t\t\t\t\t}\n"
				+ "\t\t\t\t}\n"
				+ "\t\t\t} else foundInSelectedMatrix = true;\n\n"
				+ "\t\t\tif(!foundInSelectedMatrix) found = false;\n"
				+ "\t\t}\n\n"
				+ "\t\tif(found && matrix[i][matrix[i].length - 1] == 'SUCCESS') {\n"
				+ "\t\t\tsuccess++;\n"
				+ "\t\t} else if(found && matrix[i][matrix[i].length - 1] == 'FAILURE') {\n"
				+ "\t\t\tfailure++;\n"
				+ "\t\t}\n"
				+ "\t}\n\n"
				+ "\treturn [success, failure];\n"
				+ "}"));

		HtmlElement auxiliarHtmlNode = modifyHtmlContent(htmlNode, timeStamp, testCases, relevantColumns);

		if(auxiliarHtmlNode != null) {
			htmlNode = auxiliarHtmlNode;
		}

		return htmlNode;
	}

	protected void writeHtml(HtmlElement htmlNode, String path) {
		if(htmlNode != null) {
			BufferedWriter bw = null;

			try {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));
				bw.write(htmlNode.toString());
				debugInfo("HTML created");
				bw.close();
			} catch(IOException e) {
				e.printStackTrace();
				if(bw != null) {
					try {
						bw.close();
					} catch(IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	protected void copyImagesFolder(String reportPath, HashMap<String, HashMap<String, int[]>> testStats) {
		File originPath = new File(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + AutomationConstants.THUMBNAILS_FOLDER);
		File destinationPath = new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER);

		if(originPath.exists()) {
			String[] keys = ArrayUtils.objetArrayToStringArray(testStats.keySet().toArray());
			ArrayList<String> filesNeeded = new ArrayList<String>();

			for(int i = 0; i < keys.length; i++) {
				for(int j = 0; j < testStats.get(keys[i]).size(); j++) {
					filesNeeded.add(testStats.get(keys[i]).keySet().toArray()[j].toString());
				}
			}

			filesNeeded.add("info");

			destinationPath.mkdirs();

			for(String file : originPath.list()) {
				if(ArrayUtils.stringInArray(ArrayUtils.objetArrayToStringArray(filesNeeded.toArray()), file.replace(".jpg", "").replace(".png", ""))
					&& !new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER + file).exists()) {
					InputStream in = null;
					OutputStream out = null;

					try {
						in = new FileInputStream(new File(originPath, file));
						out = new FileOutputStream(new File(destinationPath, file));

						int length;
						byte[] buffer = new byte[1024];

						while((length = in.read(buffer)) > 0) {
							out.write(buffer, 0, length);
						}
					} catch(Exception e) {
						try {
							if(in != null) in.close();
							if(in != null) out.close();
						} catch(IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
	}
}