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
import com.automation.model.utils.objects.HtmlElement;
import com.automation.model.webdriver.configuration.BrowserType;
import com.project.ProjectConstants;

public class CsvToHtml {

	private static final String[] testResults = new String[]{ AutomationConstants.TEST_SUCCESS, AutomationConstants.TEST_FAILURE, AutomationConstants.TEST_UNDONE};

	public static void main(String[] args) {
		if(args.length >= 4 && !args[3].contains(",") && !args[3].contains(".")) {
			String path = System.getProperty("user.dir") + "/" + AutomationConstants.REPORTS_FOLDER + "/T" + args[0] + args[1] + args[2];

			int relevantColumns = args.length > 5 ? Integer.parseInt(args[5]) : args.length > 4 && org.apache.commons.lang3.StringUtils.isNumeric(args[4]) ? Integer.parseInt(args[4]) : -1;

			createJointReport(args[0] + "." + args[1] + "." + args[2] + "." + args[3] +
				(args.length > 4 && !org.apache.commons.lang3.StringUtils.isNumeric(args[4]) ? "." + args[4] : ""), path, args[3], new String[]{ args[3]}, new int[]{ relevantColumns});
		} else if(args.length >= 6 && (args[3].contains(",") || args[3].contains("."))) {

			String year = args[0], month = args[1], day = args[2], browser = args[4];
			String path = System.getProperty("user.dir") + "/" + AutomationConstants.REPORTS_FOLDER + "/T" + year + month + day;

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

			createJointReport(year + "." + month + "." + day + ".[TESTCASE]." + browser, path, args[5], testCases, relevantColInt);
		}
	}

	private static HashMap<String, HashMap<String, int[]>> initializeHashMap(String[][] dataMatrix) {
		HashMap<String, HashMap<String, int[]>> result = new HashMap<String, HashMap<String, int[]>>();

		// Initialize HashMap with the test variables and their values
		for(int i = 0; i < dataMatrix[0].length; i++) {
			HashMap<String, int[]> auxHash = new HashMap<String, int[]>();

			for(int j = 1; j < dataMatrix.length; j++) {
				if(auxHash.get(dataMatrix[j][i]) == null) {
					auxHash.put(dataMatrix[j][i], new int[]{ 0, 0});
				}
			}

			result.put(dataMatrix[0][i], auxHash);
		}

		// Calculate successes and failures for each case
		for(int i = 1; i < dataMatrix.length; i++) {
			if(dataMatrix[i][dataMatrix[0].length - 3] != null && !dataMatrix[i][dataMatrix[0].length - 3].isEmpty()) {
				for(int j = 0; j < dataMatrix[0].length; j++) {
					if(dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS)) {
						result.get(dataMatrix[0][j]).get(dataMatrix[i][j])[0]++;
					} else {
						result.get(dataMatrix[0][j]).get(dataMatrix[i][j])[1]++;
					}
				}
			}
		}

		return result;
	}

	private static HashMap<String, ArrayList<String>> getColumnOrder(String[][] dataMatrix) {
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

	private static HtmlElement getErrorReportNode(String[][] dataMatrix, String reportPath, String timeStamp, String translationFile) {
		HtmlElement accordionContent = new HtmlElement("div")
			.addAttribute("class", "ac-content")
			.addAttribute("style", "display: none;");

		for(int i = 1; i < dataMatrix.length; i++) {
			if(dataMatrix[i][dataMatrix[0].length - 3] != null && !dataMatrix[i][dataMatrix[0].length - 3].isEmpty()
				&& dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_FAILURE)) {
				HtmlElement table = HtmlUtils.createTable(1, 1).addAttribute("class", "accordion");

				HtmlElement caseVariables = new HtmlElement("div")
					.addAttribute("class", "boxes cases");

				for(int j = 0; j < dataMatrix[0].length - 4; j++) {
					caseVariables.addChild(new HtmlElement("div")
						.addAttribute("class", "box case")
						.setContent(StringUtils.snakeCaseToNatural(translate(translationFile, dataMatrix[0][j])) + ": "
							+ StringUtils.snakeCaseToNatural(translate(translationFile, dataMatrix[i][j]))));
				}

				table.addChildAt(new HtmlElement("thead")
					.addAttribute("class", "ac-button")
					.addChild(new HtmlElement("tr")
						.addChild(new HtmlElement("th")
							.addChild(caseVariables))), 0);

				String imagePath = "images/[ERROR] - " + timeStamp + ".i" + (i - 1) + ".jpg";

				if(new File(reportPath + imagePath).exists()) {
					table.getChildByTag("thead").addStyle("background: #ffffff;");

					table.getChildByTag("tbody")
						.addAttribute("class", "ac-content")
						.addAttribute("style", "display: none;")
						.getChildByTag("tr")
							.getChildByTag("th")
								.addChild(new HtmlElement("img")
									.addAttribute("title", dataMatrix[i][dataMatrix[0].length - 3])
									.addAttribute("src", imagePath)
									.addAttribute("alt", "Cannot load image"));
				} else {
					table.setAttributes("");
					table.getChildByTag("thead").setAttributes("").addStyle("background: #d6d6d6;");
					table.removeChildAt(1);
				}

				accordionContent.addChild(table);
			}
		}

		HtmlElement errorsNode = new HtmlElement("div")
			.addAttribute("class", "accordion")
			.addChild(new HtmlElement("div")
				.addAttribute("class", "ac-button")
				.addChild("h2", "", translate(translationFile, "Page Failures")))
			.addChild(accordionContent);

		return errorsNode;
	}

	private static String translate(String translationFile, String text) {
		String result = text;

		if(translationFile != null) {
			DataObject translationObject = new DataObject(FileUtils.variablesFileToArray(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + translationFile));

			result = translationObject.getValue(text) != null ? translationObject.getValue(text) : result;
		}

		return result;
	}

	public static void createReport(String timeStamp, String reportPath, String testCase) {
		createReport(timeStamp, reportPath, testCase, -1);
	}

	public static void createReport(String timeStamp, String reportPath, String testCase, int relevantColumns) {
		createReport(timeStamp, reportPath, testCase, relevantColumns, null);
	}

	public static void createReport(String timeStamp, String reportPath, String testCase, int relevantColumns, String translationFile) {
		reportPath = reportPath.charAt(reportPath.length() - 1) == '/' ? reportPath : reportPath + "/";

		HtmlElement htmlNode = createTestCaseWrapper(timeStamp, reportPath, testCase, relevantColumns, translationFile);

		writeHtml(htmlNode, reportPath + timeStamp + ".html");
	}

	public static void createJointReport(SuiteManager suiteM) {
		createJointReport(suiteM, null);
	}

	public static void createJointReport(SuiteManager suiteM, String translationFile) {
		if(suiteM.getTestCases().length > 0) {
			String timeStamp = suiteM.getTestData(suiteM.getTestCases()[0]).getTimeStamp(),
				reportPath = suiteM.getTestData(suiteM.getTestCases()[0]).getReportPath();

			createJointReport(timeStamp, reportPath, suiteM.getName(), suiteM.getTestCases(), suiteM.getRelevantColumns(), translationFile);
		}
	}

	public static void createJointReport(String timeStamp, String reportPath, String reportName, String[] testCases, int[] relevantColumns) {
		createJointReport(timeStamp, reportPath, reportName, testCases, relevantColumns, null);
	}

	public static void createJointReport(String timeStamp, String reportPath, String reportName, String[] testCases, int[] relevantColumns, String translationFile) {
		System.out.println("[INFO] - Generating HTML...");
		reportPath = reportPath.charAt(reportPath.length() - 1) == '/' ? reportPath : reportPath + "/";

		String[] timeStampArray = timeStamp.split("\\.");
		for(int i = 0; i < timeStampArray.length; i++) {
			if(!org.apache.commons.lang3.StringUtils.isNumeric(timeStampArray[i])) {
				timeStampArray[i] = "[TESTCASE]";
				break;
			}
		}

		timeStamp = ArrayUtils.arrayToString(timeStampArray, ".");

		HtmlElement htmlNode = createJointHtmlNode(timeStamp, reportPath, reportName, testCases, relevantColumns, translationFile);

		writeHtml(htmlNode, reportPath + timeStamp.replace("[TESTCASE]", reportName).replace("_headless", "") + ".html");
	}

	public static HtmlElement createJointHtmlNode(String timeStamp, String reportPath, String reportName, String[] testCases, int[] relevantColumns, String translationFile) {
		HtmlElement body = new HtmlElement("body");
		HtmlElement htmlNode = new HtmlElement("html")
			.addAttribute("dir", "ltr")
			.addChild(new HtmlElement("head")
				.addChild("meta", "charset=\"UTF-8\"")
				.addChild("title", "", translate(translationFile, "Test report"))
				.addChild("style", "type=\"text/css\"", FileUtils.getTextFromFile(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + "styles/styles.css")))
			.addChild(body
				.addChild(new HtmlElement("header")
					.addChild(new HtmlElement("div")
						.addAttribute("class", "title")
						.addAttribute("align", "center")
						.addChild("h1", "", translate(translationFile, "Report from [DATE]")
							.replace("[DATE]", timeStamp.split("\\.")[2] + "/" + timeStamp.split("\\.")[1] + "/" + timeStamp.split("\\.")[0])))));

		// Create HTMLs
		for(int i = 0; i < testCases.length; i++) {
			String auxTimeStamp = timeStamp.replace("[TESTCASE]", testCases[i]);
			String browserTimeStamp = auxTimeStamp.contains("headless") ? auxTimeStamp.replace("_headless", "") : auxTimeStamp;
			String headlessTimeStamp = browserTimeStamp
				.replace(BrowserType.CHROME, BrowserType.CHROME + "_headless")
				.replace(BrowserType.FIREFOX, BrowserType.FIREFOX + "_headless");

			auxTimeStamp = new File(reportPath + "/" + browserTimeStamp + ".csv").exists() ? browserTimeStamp : headlessTimeStamp;

			HtmlElement auxNode = createTestCaseWrapper(auxTimeStamp, reportPath, testCases[i], relevantColumns[i], translationFile);

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
				+ "\t})"
				+ "}"));

		return htmlNode;
	}

	private static void writeHtml(HtmlElement htmlNode, String path) {
		if(htmlNode != null) {
			BufferedWriter bw = null;

			try {
				bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8));;
				bw.write(htmlNode.toString());
				System.out.println("[INFO] - HTML created");
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

	public static HtmlElement createTestCaseWrapper(String timeStamp, String reportPath, String testCase, int relevantColumns, String translationFile) {
		String finalPath = reportPath + "/" + timeStamp + ".csv";

		if(new File(finalPath).exists()) {
			HtmlElement wrapper = new HtmlElement("div")
				.addAttribute("class", "wrapper accordion")
				.addAttribute("id", testCase);

			String[][] dataMatrix = FileUtils.loadCsvFileToArray(finalPath, true);

			if(dataMatrix.length > 1) {
				try {
					HashMap<String, HashMap<String, int[]>> testStats = initializeHashMap(dataMatrix);
					HashMap<String, ArrayList<String>> columnCasesOrder = getColumnOrder(dataMatrix);

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

					// Create browser element
					HtmlElement browserElement;
					if(columnCasesOrder.get("browser") != null && columnCasesOrder.get("browser").size() == 1) {
						browserElement = new HtmlElement("h3").setContent(translate(translationFile, "Browser") + ": "
							+ StringUtils.snakeCaseToNatural(translate(translationFile, columnCasesOrder.get("browser").get(0).replace("_headless", ""))));
					} else if(columnCasesOrder.get("browser") != null && columnCasesOrder.get("browser").size() > 1) {
						HtmlElement select = new HtmlElement("select")
							.addChild(new HtmlElement("option")
								.addAttribute("disabled", "")
								.addAttribute("selected", "")
								.setContent(translate(translationFile, "Browser")));

						for(int i = 0; i < columnCasesOrder.get("browser").size(); i++) {
							select.addChild(new HtmlElement("option")
								.setContent(translate(translationFile, columnCasesOrder.get("browser").get(0))));
						}

						browserElement = new HtmlElement("div")
							.addAttribute("class", "styled-select")
							.addChild(select);
					} else {
						browserElement = new HtmlElement("");
					}

					wrapper.addChild(new HtmlElement("section")
						.addAttribute("class", "boxes ac-button")
						.addChild(new HtmlElement("div")
							.addAttribute("class", "box bg-" + (nFailures == 0 ? "green" : nSuccess == 0 ? "pink" : "yellow") + " clr-white")
							.addChild(new HtmlElement("div")
								.addAttribute("class", "number")
								.addChild("span", "class=\"success\"", Integer.toString(nSuccess))
								.addChild(new HtmlElement("span")
									.addAttribute("class", "error")
									.setContent(" / ")
									.addChild("span", "class=\"clr-red\"", Integer.toString(nFailures))))
							.addChild("div", "class=\"subtitle\"", translate(translationFile, "[REPORTNAME] results")
								.replace("[REPORTNAME]", StringUtils.snakeCaseToNatural(translate(translationFile, testCase))))
							.addChild(new HtmlElement("div")
								.addAttribute("align", "right")
								.addChild(browserElement))));

					HtmlElement accordionContent = new HtmlElement("section")
						.addAttribute("class", "columns ac-content");

					// Add relevant columns tables from test variables
					for(int j = 0; j < relevantColumns; j++) {
						if(j == 0) {
							accordionContent.addChild(new HtmlElement("div").addAttribute("class", "columns-wrapper"));
						} else if(j == 1) {
							accordionContent.addChild(new HtmlElement("div").addAttribute("class", "columns-wrapper"));
						}

						HtmlElement variableData;

						boolean haveImages = true;
						String[] variables = ArrayUtils.objetArrayToStringArray(columnCasesOrder.get(dataMatrix[0][j]).toArray());

						for(String variable : variables) {
							if(!new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER + "/" + variable + ".png").exists()) {
								haveImages = false;
							}
						}

						if(haveImages) {
							variableData = createImagesTable(testStats, columnCasesOrder, reportPath, dataMatrix, j, translationFile);
						} else {
							variableData = createTableByIndex(testStats, columnCasesOrder, reportPath, dataMatrix, j, translationFile);
						}

						accordionContent.getChild(j % 2).addChild(new HtmlElement("div")
							.addAttribute("class", "column")
							.addChild("h2", "", StringUtils.snakeCaseToNatural(translate(translationFile, dataMatrix[0][j])))
							.addChild(variableData));
					}

					if(columnCasesOrder.get("result").contains("FAILURE")) {
						accordionContent.addChild(new HtmlElement("div")
							.addAttribute("class", "columns-wrapper exceptions")
							.addChild(new HtmlElement("div")
								.addAttribute("class", "column")
								.addChild(getErrorReportNode(dataMatrix, reportPath, timeStamp, translationFile))));
					}

					wrapper.addChild(accordionContent);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}

			return wrapper;
		} else {
			System.out.println("[INFO] - HTML not created, file not found: " + reportPath + "/" + timeStamp + ".csv");
			return null;
		}
	}

	private static HtmlElement createImagesTable(HashMap<String, HashMap<String, int[]>> testStats, HashMap<String, ArrayList<String>> columnCasesOrder,
		String reportPath, String[][] dataMatrix, int columnIndex, String translationFile) {
		HtmlElement container = new HtmlElement("div")
			.addAttribute("class", "boxes thumbnails");

		for(int i = 0; i < columnCasesOrder.get(dataMatrix[0][columnIndex]).size(); i++) {
			String testVariable = columnCasesOrder.get(dataMatrix[0][columnIndex]).get(i);

			int successes = testStats.get(dataMatrix[0][columnIndex]).get(columnCasesOrder.get(dataMatrix[0][columnIndex]).get(i))[0];
			int failures = testStats.get(dataMatrix[0][columnIndex]).get(columnCasesOrder.get(dataMatrix[0][columnIndex]).get(i))[1];

			container.addChild(new HtmlElement("div")
				.addAttribute("class", "box")
				.addChild(new HtmlElement("img")
					.addAttribute("src", AutomationConstants.THUMBNAILS_FOLDER + testVariable + ".png")
					.addAttribute("alt", StringUtils.snakeCaseToNatural(translate(translationFile, testVariable)).toUpperCase())
					.addAttribute("title", StringUtils.snakeCaseToNatural(translate(translationFile, testVariable)).toUpperCase())
					.addAttribute("width", "50")
					.addAttribute("height", "50"))
				.addChild(new HtmlElement("div")
					.addAttribute("class", "number")
					.addChild("span", "class=\"success\"", Integer.toString(successes))
					.addChild(new HtmlElement("span")
						.addAttribute("class", "error")
						.setContent(" / ")
						.addChild("span", "class=\"clr-red\"", Integer.toString(failures)))));
		}

		return container;
	}

	private static HtmlElement createTableByIndex(HashMap<String, HashMap<String, int[]>> testStats, HashMap<String, ArrayList<String>> columnCasesOrder,
		String reportPath, String[][] dataMatrix, int columnIndex, String translationFile) {
		HtmlElement table = HtmlUtils.createTable(columnCasesOrder.get(dataMatrix[0][columnIndex]).size(), 3);

		table.addChildAt(new HtmlElement("thead")
			.addChild("th", "", "Variable")
			.addChild("th", "", "Success")
			.addChild("th", "", "Failures"), 0);

		for(int i = 0; i < columnCasesOrder.get(dataMatrix[0][columnIndex]).size(); i++) {
			String testVariable = columnCasesOrder.get(dataMatrix[0][columnIndex]).get(i);

			int successes = testStats.get(dataMatrix[0][columnIndex]).get(columnCasesOrder.get(dataMatrix[0][columnIndex]).get(i))[0];
			int failures = testStats.get(dataMatrix[0][columnIndex]).get(columnCasesOrder.get(dataMatrix[0][columnIndex]).get(i))[1];

			table.getChildByTag("tbody").getChild(i).getChild(0).setContent(StringUtils.snakeCaseToNatural(translate(translationFile, testVariable)));

			table.getChildByTag("tbody").getChild(i).getChild(1).setContent(Integer.toString(successes));
			table.getChildByTag("tbody").getChild(i).getChild(2).setContent(Integer.toString(failures));

			if(successes > 0) {
				table.getChildByTag("tbody").getChild(i).getChild(1).addAttribute("style", "color: green;");
			}

			if(failures > 0) {
				table.getChildByTag("tbody").getChild(i).getChild(2).addAttribute("style", "color: red;");
			}
		}

		return table;
	}

	public static String[] getScreenshotsPath(String reportPath) {
		String[] screenshotsPaths = new String[]{};

		File destinationPath = new File(reportPath + AutomationConstants.IMAGES_FOLDER);

		if(destinationPath.exists()) {
			screenshotsPaths = destinationPath.list();

			for(int i = 0; i < screenshotsPaths.length; i++) {
				screenshotsPaths[i] = reportPath.replace("//", "/") + AutomationConstants.IMAGES_FOLDER + screenshotsPaths[i];
			}
		}

		return screenshotsPaths;
	}

	public static String[] getThumbnailsPath(String reportPath) {
		String[] thumbnailsPaths = new String[]{};

		File destinationPath = new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER);

		if(destinationPath.exists()) {
			thumbnailsPaths = destinationPath.list();

			for(int i = 0; i < thumbnailsPaths.length; i++) {
				thumbnailsPaths[i] = reportPath.replace("//", "/") + AutomationConstants.THUMBNAILS_FOLDER + thumbnailsPaths[i];
			}
		}

		return thumbnailsPaths;
	}

	private static void copyImagesFolder(String reportPath, HashMap<String, HashMap<String, int[]>> testStats) {
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