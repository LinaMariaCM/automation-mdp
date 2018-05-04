package com.automation.model.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import com.automation.configuration.AutomationConstants;
import com.automation.model.utils.objects.HtmlElement;
import com.automation.model.webdriver.configuration.BrowserType;
import com.project.ProjectConstants;

public class CsvToHtml {
	
	private static final String[] testResults = new String[]{AutomationConstants.TEST_SUCCESS, AutomationConstants.TEST_FAILURE, AutomationConstants.TEST_UNDONE};
	
	public static void main(String[] args) {
		if(args.length >= 4 && !args[3].contains(",") && !args[3].contains(".")) {
			String path = System.getProperty("user.dir") + "/" + AutomationConstants.REPORTS_FOLDER + "/T" + args[0] + args[1] + args[2];
			
			int relevantColumns = args.length > 5 ? Integer.parseInt(args[5]) : args.length > 4 && org.apache.commons.lang3.StringUtils.isNumeric(args[4]) ? Integer.parseInt(args[4]) : -1;
			
			createReport(args[0] + "." + args[1] + "." + args[2] + "." + args[3] + 
				(args.length > 4  && !org.apache.commons.lang3.StringUtils.isNumeric(args[4]) ? "." + args[4] : ""), path, args[3], relevantColumns);
		} else if (args.length >= 6 && (args[3].contains(",") || args[3].contains("."))){
			
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
			
			createReport(year + "." + month + "." + day + ".[TESTCASE]." + browser, path, args[5], testCases, relevantColInt);
		}
	}
	
	private static HashMap<String, HashMap<String, int[]>> initializeHashMap(String[][] dataMatrix) {
		HashMap<String, HashMap<String, int[]>> result = new HashMap<String, HashMap<String, int[]>>();
		
		// Initialize HashMap with the test variables and their values
		for(int i = 0; i < dataMatrix[0].length; i++) {
			HashMap<String, int[]> auxHash = new HashMap<String, int[]>();
			
			for(int j = 1; j < dataMatrix.length; j++) {
				if(auxHash.get(dataMatrix[j][i]) == null) {
					auxHash.put(dataMatrix[j][i], new int[]{0, 0});
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
			ArrayList<String> columnOrder = new  ArrayList<String>();
			
			for(int j = 1; j < dataMatrix.length; j++) {
				if(!dataMatrix[j][i].isEmpty() && (!columnOrder.contains(dataMatrix[j][i]) || columnOrder.size() == 0)) {
					columnOrder.add(dataMatrix[j][i]);
				}
			}
			
			result.put(dataMatrix[0][i], columnOrder);
		}
		
		return result;
	}
	
	private static HtmlElement[] getErrorReportNodes(String[][] dataMatrix, String reportPath, String timeStamp) {
		HtmlElement errorsNode = null, failuresNode = null;
		
		for(int i = 1; i < dataMatrix.length; i++) {
			if(dataMatrix[i][dataMatrix[0].length - 3] != null && !dataMatrix[i][dataMatrix[0].length - 3].isEmpty()
				&& !dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_UNDONE)
				&& !dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS)) {
				boolean failure = dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_FAILURE);
				
				HtmlElement div = new HtmlElement("div").addAttribute("id", (failure ? "img" : "err") + (i - 1))
					.addChild(new HtmlElement("p").addAttribute("title", dataMatrix[i][dataMatrix[0].length - 3]));
				
				div.getChildByTag("p")
						.addChild(new HtmlElement("b", "", "[" + (failure ? "Failure": "Error") + " case]").addAttribute("style", "color: red;"));
				
				for(int j = 0; j < dataMatrix[0].length - 4; j++) {
					div.getChildByTag("p")
						.addChild("", "", StringUtils.snakeCaseToNatural(dataMatrix[0][j]) + ": ")
						.addChild("b", "", dataMatrix[i][j] + "; ");
				};
				
				String exceptionText;
				
				try {
					exceptionText = FileUtils.getTextFromFile(reportPath + "/" + AutomationConstants.EXCEPTIONS_FOLDER + "/" + timeStamp + ".e" + (i - 1) + ".txt");
					
					String exceptionMessage = exceptionText.split("\n")[0].contains(".") && exceptionText.split("\n")[0].contains(":") ? 
						exceptionText.split("\n")[0].substring(exceptionText.split("\n")[0].split(":")[0].lastIndexOf(".") + 1) : exceptionText.split("\n")[0];
				} catch(FileNotFoundException e) {
					exceptionText = "";
				}
				
				div.addChild(
					new HtmlElement("div", "", "")
						.addAttribute("class", "dropdown")
						.addStyle("display: none;").addChild(
						new HtmlElement("p", "", exceptionText)
							.addAttribute("title", dataMatrix[i][dataMatrix[0].length - 3])
							.addAttribute("name", "E" + (i - 1))))
					.addChild("script", "", 
						"document.getElementById('" + (failure ? "img" : "err") + (i - 1) + "').addEventListener('click', changeVisibility);\n"
						+ "function changeVisibility(){\n"
						+ "\tvar dropdown = document.querySelector(\"#" + (failure ? "img" : "err") + (i - 1) + " > .dropdown\");\n"
						+ "\tif(dropdown.getAttribute('style') == '') {\n"
						+ "\t\tdropdown.setAttribute('style','display:none;');\n\t}\n"
						+ "\telse{\n \t\tdropdown.setAttribute('style','');\n\t}\n}");
				
				String imagePath = "images/[ERROR] - " + timeStamp + ".i" + (i - 1) + ".jpg";
				if(failure && new File(reportPath + imagePath).exists()) {
					div.getChildByTag("div").addChild(new HtmlElement("img")
						.addAttribute("title", dataMatrix[i][dataMatrix[0].length - 3])
						.addAttribute("src", imagePath)
						.addAttribute("alt", "Cannot load image"));
				}

				if(failure) {
					if(failuresNode == null) {
						failuresNode = new HtmlElement("div")
							.addChild("h3", "", "Page Failures")
							.addChild("hr");
					}
					
					failuresNode.addChild(div);
					failuresNode.addChild("hr");
				} else {
					if(errorsNode == null) {
						errorsNode = new HtmlElement("div")
							.addChild("h3", "", "Page Errors")
							.addChild("hr");
					}

					errorsNode.addChild(div);
					errorsNode.addChild("hr");
				}
			}
		}
		
		return new HtmlElement[]{failuresNode, errorsNode};
	}
	
	public static void createReport(String timeStamp, String reportPath, String testCase) {
		createReport(timeStamp, reportPath, testCase, -1);
	}
	
	public static void createReport(String timeStamp, String reportPath, String testCase, int relevantColumns) {
		reportPath = reportPath.charAt(reportPath.length() - 1) == '/' ? reportPath : reportPath + "/";
		
		HtmlElement htmlNode = createHtmlNode(timeStamp, reportPath, testCase, relevantColumns);
		
		writeHtml(htmlNode, reportPath + timeStamp + ".html");
	}
	
	public static void createReport(String timeStamp, String reportPath, String reportName, String[] testCases, int[] relevantColumns) {
		reportPath = reportPath.charAt(reportPath.length() - 1) == '/' ? reportPath : reportPath + "/";
		
		HtmlElement[] htmlNodes = new HtmlElement[testCases.length];
		HtmlElement body = new HtmlElement("body");	
		HtmlElement htmlNode = new HtmlElement("html")
			.addChild(
				new HtmlElement("head")
					.addChild("title", "", ProjectConstants.CLIENT + " test report " + timeStamp)
					.addChild("meta", "charset=\"UTF-8\"")
					.addChild("style", "", "table {font-family: arial, sans-serif; border-collapse: collapse; width: 100%;}\n"
															+ "td, th {border: 1px solid #dddddd; text-align: left; padding: 8px; text-align:center;}\n"
															+ "tr:nth-child(even) {background-color: #dddddd;}"))
			.addChild(body
				.addChild("hr")
				.addChild("h1", "align=\"center\"", 
					StringUtils.snakeCaseToNatural(reportName) + " test report from " 
						+  timeStamp.split("\\.")[2] + "/" +  timeStamp.split("\\.")[1] + "/" +  timeStamp.split("\\.")[0])
				.addChild("hr"));
		
		// Create HTMLs
		for(int i = 0; i < htmlNodes.length; i++) {
			String auxTimeStamp = timeStamp.replace("[TESTCASE]", testCases[i]);
			String browserTimeStamp = auxTimeStamp.contains("headless") ? auxTimeStamp.replace("_headless", "") :  auxTimeStamp;
			String headlessTimeStamp = browserTimeStamp
				.replace(BrowserType.CHROME, BrowserType.CHROME + "_headless")
				.replace(BrowserType.FIREFOX, BrowserType.FIREFOX + "_headless");
			
			auxTimeStamp = new File(reportPath + "/" + browserTimeStamp + ".csv").exists() ? browserTimeStamp : headlessTimeStamp;
			
			HtmlElement auxNode = createHtmlNode(auxTimeStamp, reportPath, testCases[i], relevantColumns[i]);

			if(auxNode != null) {
				htmlNodes[i] = auxNode.getChildByTag("body");
			}
		}
		
		// Join HTMLs
		// Add browser
		if(htmlNodes.length > 0 && htmlNodes[0] != null) {
			HtmlElement table = htmlNodes[0].getChild(4);
			
			if(table.getChildByTag("table").getChildByTag("caption") == null) {
				String content = table.getChildByTag("table").getChild(0).getChild(0).getChild(0).getChild(0).getContent();
				
				table.getChildByTag("table").getChild(0).getChild(0).getChild(0).getChild(0)
					.setContent(content.replace("_headless", ""));
			} else if(table.getChildByTag("table").getChildByTag("caption").equals("Browser")){
				String content = table.getChildByTag("table").getChildByTag("caption").getChild(0).getContent();
				
				table.getChildByTag("table").getChildByTag("caption").getChild(0).setContent(content.replace("_headless", ""));
			}

			htmlNode.addChild("br");
			htmlNode.addChild(table);
		}
		
		// Add results
		/*for(int i = 0; i < htmlNodes.length; i++) {
			if(htmlNodes[i] != null) {
				HtmlElement table = htmlNodes[i].getChild(6);
				
				if(table.getChildByTag("table").getChildByTag("caption") != null) {
					String content = table.getChildByTag("table").getChildByTag("caption").getChild(0).getContent();
					
					table.getChildByTag("table").getChildByTag("caption").getChild(0)
						.setContent(StringUtils.snakeCaseToNatural(testCases[0]) + " " + content);
				}
				
				htmlNode.addChild("br");
				htmlNode.addChild(table);
			}
		}*/
		
		// Add extra tables
		for(int i = 0; i < htmlNodes.length; i++) {
			int tablesAdded = -1;
			
			if(htmlNodes[i] != null) {
				for(int j = 6; j < htmlNodes[i].getChilds().size() && (relevantColumns[i] == -1 || tablesAdded < relevantColumns[i]); j++) {
					HtmlElement table = htmlNodes[i].getChild(j);
				
					if(table.getChildByTag("table") == null || table.getChildByTag("table").getChildByTag("caption") == null) continue;
					
					String content = table.getChildByTag("table").getChildByTag("caption").getChildByTag("b").getContent();
					
					if(!content.contains("Exception")) {
						table.getChildByTag("table").getChildByTag("caption").getChildByTag("b")
							.setContent(StringUtils.snakeCaseToNatural(testCases[i]) + " " + content.toLowerCase());
						
						htmlNode.addChild("br");
						htmlNode.addChild(table);
						tablesAdded++;
					}
				}
			}
		}
		
		// Add exceptions
		for(int i = 0; i < htmlNodes.length; i++) {
			if(htmlNodes[i] != null) {
				HtmlElement table = htmlNodes[i].getChild(htmlNodes[i].getChilds().size() - 3);
			
				String content = table.getChildByTag("table").getChildByTag("caption").getChildByTag("b").getContent();
				
				if(content.contains("Exception")) {
					table.getChildByTag("table").getChildByTag("caption").getChildByTag("b")
						.setContent(StringUtils.snakeCaseToNatural(testCases[i]) + " " + content.toLowerCase());
					
					htmlNode.addChild("br");
					htmlNode.addChild(table);
					
					HtmlElement exceptions = htmlNodes[i].getChild(htmlNodes[i].getChilds().size() - 1);
					String exceptionsText = exceptions.getChildByTag("h3").getContent();
					exceptions.getChildByTag("h3").setContent(StringUtils.snakeCaseToNatural(testCases[i]) + " " + exceptionsText.toLowerCase());
					
					htmlNode.addChild("br");
					htmlNode.addChild(exceptions);
				}
			}
		}		

		writeHtml(htmlNode, reportPath + timeStamp.replace("[TESTCASE]", reportName.toLowerCase()).replace("_headless", "") + ".html");
	}
	
	private static void writeHtml(HtmlElement htmlNode, String path) {
		if(htmlNode != null) {
			File f = new File(path);
			
			BufferedWriter bw = null;
			
			try {
				bw = new BufferedWriter(new FileWriter(f));
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

	public static HtmlElement createHtmlNode(String timeStamp, String reportPath, String testCase, int relevantColumns) {		
		String finalPath = reportPath + "/" + timeStamp + ".csv";
		
		if(new File(finalPath).exists()) {
			HtmlElement body = new HtmlElement("body");	
			HtmlElement htmlNode = new HtmlElement("html")
				.addChild(
					new HtmlElement("head")
						.addChild("title", "", ProjectConstants.CLIENT + " test report " + timeStamp)
						.addChild("meta", "charset=\"UTF-8\"")
						.addChild("style", "", "table {font-family: arial, sans-serif; border-collapse: collapse; width: 100%;}\n"
																+ "td, th {border: 1px solid #dddddd; text-align: left; padding: 8px; text-align:center;}\n"
																+ "tr:nth-child(even) {background-color: #dddddd;}"))
				.addChild(body
					.addChild("hr")
					.addChild("h1", "align=\"center\"", 
						StringUtils.snakeCaseToNatural(testCase) + " test report from " 
							+  timeStamp.split("\\.")[2] + "/" +  timeStamp.split("\\.")[1] + "/" +  timeStamp.split("\\.")[0])
					.addChild("hr"));
	
			String[][] dataMatrix = FileUtils.loadDataFileToArray(finalPath, true);
			
			if(dataMatrix.length > 1) {
				try {
					if(relevantColumns == -1 || relevantColumns > dataMatrix[0].length - 4) {
						relevantColumns = dataMatrix[0].length - 4;
					}
					
					HashMap<String, HashMap<String, int[]>> testStats = initializeHashMap(dataMatrix);
					HashMap<String, ArrayList<String>> columnCasesOrder = getColumnOrder(dataMatrix);
					
					// Copy images needed from resources/thumbnails
					copyImagesFolder(reportPath, testStats);
					
					// Add browser info if only 1 browser
					if(columnCasesOrder.get("browser") != null && columnCasesOrder.get("browser").size() == 1) {
						HtmlElement table = HtmlUtils.createTable(1, 1);
						
						table.getChildByTag("tbody").getChild(0).getChild(0).addChild(
							new HtmlElement("", "", "Browser: " + StringUtils.snakeCaseToNatural(columnCasesOrder.get("browser").get(0))));
						
						body.addChild("br");
						body.addChild(
							new HtmlElement("div")
								.addAttribute("name", "browser_table")
								.addChild(table));
					} else if(columnCasesOrder.get("browser") != null && columnCasesOrder.get("browser").size() > 1) {
						body.addChild("br");
						body.addChild(createTableByIndex(testStats, columnCasesOrder, reportPath, dataMatrix, dataMatrix[0].length - 4));
					}
					
					// Add total results table
					body.addChild("br");
					body.addChild(createResultsTableByIndex(testStats, reportPath, dataMatrix));
					
					// Add relevant columns tables from test variables
					for(int j = 0; j < relevantColumns; j++) {
						body.addChild("br");
						body.addChild(createTableByIndex(testStats, columnCasesOrder, reportPath, dataMatrix, j));
					}
					
					// Add exceptions table
					if(columnCasesOrder.get("exception") != null && columnCasesOrder.get("exception").size() > 0) {
						body.addChild("br");
						HtmlElement exceptionTable = createTableByIndex(testStats, columnCasesOrder, reportPath, dataMatrix, dataMatrix[0].length - 1);
						exceptionTable.getChild(0).getChildByTag("tbody").removeChildAt(1);
						body.addChild(exceptionTable);
					}
					
					HtmlElement[] errorReportNodes = getErrorReportNodes(dataMatrix, reportPath, timeStamp);
					
					if(errorReportNodes[0] != null) {
						body.addChild("br");
						body.addChild(errorReportNodes[0]);
					}
					
					if(errorReportNodes[1] != null) {
						body.addChild("br");
						body.addChild(errorReportNodes[1]);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return htmlNode;
		} else {
			System.out.println("[INFO] - HTML not created, file not found: " + reportPath + "/" + timeStamp + ".csv");
			return null;
		}
	}
	
	private static HtmlElement createResultsTableByIndex(HashMap<String, HashMap<String, int[]>> testStats, String reportPath, String[][] dataMatrix) {
		int columnIndex = dataMatrix[0].length - 3, currentColumn = 0;
		HtmlElement tableContainer = new HtmlElement("div").addAttribute("name", "results_table");
		
		HtmlElement table = HtmlUtils.createTable(2, testStats.get(dataMatrix[0][columnIndex]).size());
		tableContainer.addChild(table);
		
		for(int i = 0; i < testResults.length; i++) {
			String testVariable = testResults[i];
			
			if(testStats.get(dataMatrix[0][columnIndex]).get(testResults[i]) == null) continue;
			
			int nResults = testStats.get(dataMatrix[0][columnIndex]).get(testResults[i])[i];

			if(new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER + "/" + testVariable + ".png").exists()) {
				table.getChildByTag("tbody").getChild(0).getChild(i).addChild(
					new HtmlElement("img")
						.addAttribute("src", AutomationConstants.THUMBNAILS_FOLDER + testVariable + ".png")
						.addAttribute("alt", StringUtils.snakeCaseToNatural(testVariable).toUpperCase())
						.addAttribute("title", StringUtils.snakeCaseToNatural(testVariable).toUpperCase())
						.addAttribute("width", "50")
						.addAttribute("height", "50"));
			} else {
				table.getChildByTag("tbody").getChild(0).getChild(currentColumn).setContent(StringUtils.snakeCaseToNatural(testVariable));
			}
			
			table.getChildByTag("tbody").getChild(1).getChild(currentColumn).setContent(Integer.toString(nResults));
			table.getChildByTag("tbody").getChild(1).getChild(currentColumn).addStyle(testResults[i].equals(AutomationConstants.TEST_SUCCESS) ? "color: green;" : "color: red;");
			
			currentColumn++;
		}
		
		table.addChildAt(new HtmlElement("caption").addChild("b", "", StringUtils.snakeCaseToNatural(dataMatrix[0][columnIndex])), 0);
		
		tableContainer.addChild("hr");
		
		return tableContainer;
	}
	
	private static HtmlElement createTableByIndex(HashMap<String, HashMap<String, int[]>> testStats, HashMap<String, ArrayList<String>> columnCasesOrder, String reportPath, String[][] dataMatrix, int columnIndex) {
		HtmlElement tableContainer = new HtmlElement("div").addAttribute("name", dataMatrix[0][columnIndex] + "_table");
		// Calculate the quantity of tables
		int nTables = (int) (columnCasesOrder.get(dataMatrix[0][columnIndex]).size() / 20) + 1, 
			size = columnCasesOrder.get(dataMatrix[0][columnIndex]).size() / nTables,
			initialPos = 0, finalPos = size;
		
		// From 0 to nth quantity of tables
		for(int currentTable = 0; currentTable < nTables; currentTable++) {
			HtmlElement table = HtmlUtils.createTable(3, size);
			tableContainer.addChild(table);
			
			for(int i = 0; i < size; i++) {
				String testVariable = columnCasesOrder.get(dataMatrix[0][columnIndex]).get(initialPos + i);

				int successes = testStats.get(dataMatrix[0][columnIndex]).get(columnCasesOrder.get(dataMatrix[0][columnIndex]).get(initialPos + i))[0];
				int failures = testStats.get(dataMatrix[0][columnIndex]).get(columnCasesOrder.get(dataMatrix[0][columnIndex]).get(initialPos + i))[1];

				if(new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER + "/" + testVariable + ".png").exists()) {
					table.getChildByTag("tbody").getChild(0).getChild(i).addChild(
						new HtmlElement("img")
							.addAttribute("src", AutomationConstants.THUMBNAILS_FOLDER + testVariable + ".png")
							.addAttribute("alt", StringUtils.snakeCaseToNatural(testVariable).toUpperCase())
							.addAttribute("title", StringUtils.snakeCaseToNatural(testVariable).toUpperCase())
							.addAttribute("width", "50")
							.addAttribute("height", "50"));
				} else {
					// If the index is from the last column, then it is an exception
					if(columnIndex == dataMatrix[0].length - 1) {
						String exception = testVariable.contains(".") ? testVariable.substring(testVariable.lastIndexOf(".") + 1) : testVariable;
						
						table.getChildByTag("tbody").getChild(0).getChild(i).setContent(exception);
					} else {
						table.getChildByTag("tbody").getChild(0).getChild(i).setContent(StringUtils.snakeCaseToNatural(testVariable));
					}
				}
				
				table.getChildByTag("tbody").getChild(1).getChild(i).setContent(Integer.toString(successes));
				table.getChildByTag("tbody").getChild(2).getChild(i).setContent(Integer.toString(failures));
				
				if(successes > 0) {
					table.getChildByTag("tbody").getChild(1).getChild(i).addStyle("color: green;");
				}
				
				if(failures > 0) {
					table.getChildByTag("tbody").getChild(2).getChild(i).addStyle("color: red;");
				}
			}
			
			if(currentTable == 0) {
				table.addChildAt(new HtmlElement("caption").addChild("b", "", StringUtils.snakeCaseToNatural(dataMatrix[0][columnIndex])), 0);
			}
			
			tableContainer.addChild("hr");
			
			initialPos = finalPos;
			finalPos = currentTable + 2 == nTables ? testStats.get(dataMatrix[0][columnIndex]).size() : finalPos + size;
		}
		
		return tableContainer;
	}

	public static void copyImagesFolder(String reportPath, HashMap<String, HashMap<String, int[]>> testStats) {
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