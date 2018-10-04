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

import com.itextpdf.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.automation.configuration.AutomationConstants;
import com.automation.model.testing.SuiteManager;
import com.automation.data.DataObject;
import com.automation.model.utils.objects.HtmlElement;
import com.automation.model.webdriver.configuration.BrowserType;

public class CsvToPdf {

	// private static final String[] testResults = new String[]{ AutomationConstants.TEST_SUCCESS, AutomationConstants.TEST_FAILURE, AutomationConstants.TEST_UNDONE};

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
	
	private static String translateOrFormat(String translationFile, String text) {
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

	public static void createReport(String timeStamp, String reportPath, String testCase) {
		createReport(timeStamp, reportPath, testCase, -1);
	}

	public static void createReport(String timeStamp, String reportPath, String testCase, int relevantColumns) {
		createReport(timeStamp, reportPath, testCase, relevantColumns, null);
	}

	public static void createReport(String timeStamp, String reportPath, String testCase, int relevantColumns, String translationFile) {
		reportPath = reportPath.charAt(reportPath.length() - 1) == '/' ? reportPath : reportPath + "/";

		HtmlElement htmlNode = createTestCaseWrapper(timeStamp, reportPath, testCase, relevantColumns, translationFile);

		writePdf(htmlNode, reportPath + timeStamp + ".pdf");
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
		
		if(!new File(reportPath).exists()) new File(reportPath).mkdirs();
		writePdf(htmlNode, reportPath + timeStamp.replace("[TESTCASE]", reportName).replace("_headless", "") + ".pdf");
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

	private static HtmlElement createImagesTable(HashMap<String, int[]> columnResults, ArrayList<String> columnOrder, String translationFile, String reportPath) {
		HtmlElement container = new HtmlElement("div")
			.addAttribute("class", "boxes thumbnails");

		for(int i = 0; i < columnOrder.size(); i++) {
			String testVariable = columnOrder.get(i);

			int successes = columnResults.get(columnOrder.get(i))[0];
			int failures = columnResults.get(columnOrder.get(i))[1];

			container.addChild(new HtmlElement("div")
				.addAttribute("class", "box")
				.addChild(new HtmlElement("div")
						.addAttribute("class", "media")
						.addAttribute("data-src", reportPath + AutomationConstants.THUMBNAILS_FOLDER + testVariable + ".png")
                        .addAttribute("style", "width: 25px; height: 25px;"))
				.addChild(new HtmlElement("div")
					.addAttribute("class", "number")
					.addChild("span", "class=\"success\"" + (successes > 0 ? " style=\"color: green;\"" : " style=\"color: black;\""), Integer.toString(successes))
					.addChild("span", "", "/")
					.addChild("span", "class=\"error\"" + (failures > 0 ? " style=\"color: #CC444B;\"" : " style=\"color: black;\""), Integer.toString(failures))));
		}

		return container;
	}

	private static HtmlElement createTableByIndex(HashMap<String, int[]> columnResults, ArrayList<String> columnOrder, String translationFile) {
		HtmlElement table = HtmlUtils.createTable(columnOrder.size(), 3);

		table.addChildAt(new HtmlElement("thead")
			.addChild("th", "", translateOrFormat(translationFile, "Variable"))
			.addChild("th", "", translateOrFormat(translationFile, "Success"))
			.addChild("th", "", translateOrFormat(translationFile, "Failure")), 0);

		for(int i = 0; i < columnOrder.size(); i++) {
			String testVariable = columnOrder.get(i);

			int successes = columnResults.get(columnOrder.get(i))[0];
			int failures = columnResults.get(columnOrder.get(i))[1];

			HtmlElement rowElement = table.getChildByTag("tbody").getChild(i);

			rowElement.getChild(0).setContent(translateOrFormat(translationFile, testVariable));

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

	private static HtmlElement getErrorReportNode(String[][] dataMatrix, String reportPath, String timeStamp, String translationFile) {
		HtmlElement accordionContent = new HtmlElement("div");

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
						.setContent(translateOrFormat(translationFile, dataMatrix[0][j]) + ": "
							+ translateOrFormat(translationFile, dataMatrix[i][j])));
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
						.getChildByTag("tr")
						.getChildByTag("th")
						.addChild(new HtmlElement("div")
                                .addAttribute("class", "media")
                                .addAttribute("data-src", reportPath + imagePath)
                        .addAttribute("style", "width: 650px; height: 310px;"));
					System.out.println(reportPath + imagePath);
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
				.addChild("h2", "class=\"box\"", translateOrFormat(translationFile, "Page Failures"))
				.addChild(arrow))
			.addChild(accordionContent);

		return errorsNode;
	}

	public static HtmlElement createTestCaseWrapper(String timeStamp, String reportPath, String testCase, int relevantColumns, String translationFile) {
		String finalPath = reportPath + "/" + timeStamp + ".csv";

		if(new File(finalPath).exists()) {
			HtmlElement wrapper = new HtmlElement("div")
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

					String wrapperColor = nSuccess > 0 && nFailures == 0 ? "green" : nFailures > 0 && nSuccess == 0 ? "red" : nSuccess > 0 && nFailures > 0 ? "yellow" : "white";

					wrapper.addAttribute("class", "wrapper column accordion bg-light-" + wrapperColor);

					// Create browser element
					HtmlElement browserElement;
					if(columnCasesOrder.get("browser") != null && columnCasesOrder.get("browser").size() == 1) {
						browserElement = new HtmlElement("h3").setContent(translateOrFormat(translationFile, "Browser") + ": "
							+ translateOrFormat(translationFile, columnCasesOrder.get("browser").get(0).replace("_headless", "")));
					} else if(columnCasesOrder.get("browser") != null && columnCasesOrder.get("browser").size() > 1) {
						HtmlElement select = new HtmlElement("select")
							.addChild(new HtmlElement("option")
								.addAttribute("disabled", "")
								.addAttribute("selected", "")
								.setContent(translateOrFormat(translationFile, "Browser")));

						for(int i = 0; i < columnCasesOrder.get("browser").size(); i++) {
							select.addChild(new HtmlElement("option")
								.setContent(translateOrFormat(translationFile, columnCasesOrder.get("browser").get(i))));
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

					wrapper.addChild(new HtmlElement("section")
						.addAttribute("class", "boxes ac-button")
						.addChild(new HtmlElement("div")
							.addAttribute("class", "box sum-up bg-" + wrapperColor)
							.addChild(new HtmlElement("div")
								.addAttribute("class", "boxes")
								.addChild("h2", "class=\"box subtitle\"", translateOrFormat(translationFile, testCase))
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
								.addChild(arrow))));

					HtmlElement accordionContent = new HtmlElement("section")
						.addAttribute("class", "columns ac-content");

					// Add relevant columns tables from test variables
					for(int i = 0; i < relevantColumns; i++) {
						if(i == 0 || i == 1) {
							accordionContent.addChild("div", "class=\"columns-wrapper\"");
						}

						HtmlElement variableData;

						boolean haveImages = true;
						String[] variables = ArrayUtils.objetArrayToStringArray(columnCasesOrder.get(dataMatrix[0][i]).toArray());

						for(String variable : variables) {
							if(!new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER + "/" + variable + ".png").exists()) {
								haveImages = false;
							}
						}

						if(haveImages) {
							variableData = createImagesTable(testStats.get(dataMatrix[0][i]), columnCasesOrder.get(dataMatrix[0][i]), translationFile, reportPath);
						} else {
							variableData = createTableByIndex(testStats.get(dataMatrix[0][i]), columnCasesOrder.get(dataMatrix[0][i]), translationFile);
						}

						accordionContent.getChild(i % 2).addChild(new HtmlElement("div")
							.addAttribute("class", "column bg-white")
							.addChild("h2", "", translateOrFormat(translationFile, dataMatrix[0][i]))
							.addChild(variableData));
					}

					if(columnCasesOrder.get("result").contains("FAILURE")) {
						accordionContent.addChild(new HtmlElement("div")
							.addAttribute("class", "columns-wrapper exceptions")
							.addChild(new HtmlElement("div")
								.addAttribute("class", "column bg-white")
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

	public static HtmlElement createJointHtmlNode(String timeStamp, String reportPath, String reportName, String[] testCases, int[] relevantColumns, String translationFile) {
		HtmlElement body = new HtmlElement("body");
		HtmlElement htmlNode = new HtmlElement("html")
			.addChild(new HtmlElement("head")
				.addChild("meta", "charset=\"UTF-8\"")
				.addChild("title", "", translateOrFormat(translationFile, "Test report"))
				.addChild("style", "type=\"text/css\"", FileUtils.getTextFromFile(System.getProperty("user.dir") + "/" + AutomationConstants.RESOURCES_FOLDER + "styles/styles.css")))
			.addChild(body
				.addChild(new HtmlElement("header")
					.addChild(new HtmlElement("div")
						.addAttribute("class", "title")
						.addAttribute("align", "center")
						.addChild("h1", "", translateOrFormat(translationFile, "Report [suitename] from [date]")
							.replace("[suitename]", translateOrFormat(translationFile, reportName))
							.replace("[date]", timeStamp.split("\\.")[2] + "/" + timeStamp.split("\\.")[1] + "/" + timeStamp.split("\\.")[0])))));

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

		return htmlNode;
	}

	private static void writePdf(HtmlElement htmlNode, String path) {
		if(htmlNode != null) {
			OutputStream os = null;

			try {
			    os = new FileOutputStream(path);

			    ITextRenderer renderer = new ITextRenderer();
			    renderer.getSharedContext().setReplacedElementFactory(new MediaReplacementHtmlToPdf(renderer.getSharedContext().getReplacedElementFactory()));
			    renderer.setDocumentFromString(htmlNode.toString());
			    
			    renderer.layout();
			    renderer.createPDF(os);
				System.out.println("[INFO] - PDF created");

			    os.close();
			} catch(IOException | DocumentException e) {
				e.printStackTrace();
				if(os != null) {
					try {
						os.close();
					} catch(IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
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