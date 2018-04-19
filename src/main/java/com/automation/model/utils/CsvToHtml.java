package com.automation.model.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;


import com.automation.configuration.AutomationConstants;
import com.automation.model.utils.objects.HtmlElement;
import com.project.ProjectConstants;

public class CsvToHtml {
	
	private static String[] testResultColumns = new String[] {AutomationConstants.TEST_SUCCESS, AutomationConstants.TEST_FAILURE, AutomationConstants.TEST_UNDONE, "other"};
	
	public static void main(String[] args) {
		if(args.length >= 4) {
			String path = System.getProperty("user.dir") + "/" + AutomationConstants.REPORTS_FOLDER + "/T" + args[0] + args[1] + args[2];
			
			createReport(args[0] + "." + args[1] + "." + args[2] + "." + args[3] + (args.length > 4 ? "." + args[4] : ""), path, args[3]);
		}
	}

	private static int[] getTestResults(String[][] dataMatrix) {
		int[] result = new int[]{0, 0, 0, 0};

		for(int i = 1; i < dataMatrix.length; i++) {
			if(dataMatrix[i][dataMatrix[0].length - 3] != null && !dataMatrix[i][dataMatrix[0].length - 3].isEmpty()) {
				if(dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS)) {
					result[0]++;
				} else if(dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_FAILURE)) {
					result[1]++;
				} else if(dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_UNDONE)) {
					result[2]++;
				} else {
					result[3]++;
				}
			}
		}
		
		return result;
	}
	
	private static HashMap<String, HashMap<String, int[]>> initializeHashMap(String[][] dataMatrix) {
		HashMap<String, HashMap<String, int[]>> result = new HashMap<String, HashMap<String, int[]>>();
		
		// Initialize HashMap with the test variables and their values
		for(int i = 0; i < dataMatrix[0].length - 4; i++) {
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
			if(dataMatrix[i][dataMatrix[0].length - 3] != null && !dataMatrix[i][dataMatrix[0].length - 3].isEmpty()
				&& !dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_UNDONE)) {
				for(int j = 0; j < dataMatrix[0].length - 4; j++) {
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
	
	private static HtmlElement[] getErrorReportNodes(String[][] dataMatrix, String reportPath, String timeStamp) {
		HtmlElement errorsNode = null, failuresNode = null;
		
		for(int i = 1; i < dataMatrix.length; i++) {
			if(dataMatrix[i][dataMatrix[0].length - 3] != null && !dataMatrix[i][dataMatrix[0].length - 3].isEmpty()
				&& !dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_UNDONE)
				&& !dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_SUCCESS)) {
				try {
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
					
					div.addChild(
						new HtmlElement("p", "", FileUtils.getTextFromFile(reportPath + "/" + AutomationConstants.EXCEPTIONS_FOLDER + "/" + timeStamp + ".e" + (i - 1) + ".txt"))
							.addAttribute("title", dataMatrix[i][dataMatrix[0].length - 3])
							.addAttribute("name", "E" + (i - 1))
							.addAttribute("style", "display: none;"))
						.addChild("script", "", 
							"document.getElementById('" + (failure ? "img" : "err") + (i - 1) + "').addEventListener('click', changeVisibility);\n"
							+ "function changeVisibility(){\n"
							+ "\tvar errorImage = document.querySelector(\"[src*='" + timeStamp + ".i" + (i - 1) + "']\");\n"
							+ "\tvar errorText = document.querySelector(\"[name='E" + (i - 1) + "']\");\n"
							+ "\tif(errorText.getAttribute('style') == '') {\n"
							+ "\t\tif(errorImage != null) errorImage.setAttribute('style','display:none;');\n"
							+ "\t\terrorText.setAttribute('style','display:none;');\n\t}\n"
							+ "\telse{\n \t\tif(errorImage != null) errorImage.setAttribute('style','');\n \t\terrorText.setAttribute('style','');\n\t}\n}");
					
					String imagePath = "images/[ERROR] - " + timeStamp + ".i" + (i - 1) + ".jpg";
					if(failure && new File(reportPath + imagePath).exists()) {
						div.addChild(new HtmlElement("img")
							.addAttribute("title", dataMatrix[i][dataMatrix[0].length - 3])
							.addAttribute("src", imagePath)
							.addAttribute("alt", "Cannot load image")
							.addAttribute("style",	"display: none;"));
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
							failuresNode = new HtmlElement("div")
								.addChild("h3", "", "Page Errors")
								.addChild("hr");
						}
	
						errorsNode.addChild(div);
						errorsNode.addChild("hr");
					}
				} catch(Exception e) {e.printStackTrace();}
			}
		}
		
		return new HtmlElement[]{failuresNode, errorsNode};
	}
	
	public static void createReport(String timeStamp, String reportPath, String testCase) {
		reportPath = reportPath.charAt(reportPath.length() - 1) == '/' ? reportPath : reportPath + "/";
		
		if(new File(reportPath + "/" + timeStamp + ".csv").exists()) {
			HtmlElement body = new HtmlElement("body");	
			HtmlElement htmlNode = new HtmlElement("html")
				.addChild(
					new HtmlElement("head")
						.addChild("title", "", ProjectConstants.CLIENT + " test report " + timeStamp)
						.addChild("meta", "charset=\"UTF-8\"")
						.addChild("style", "", "table {font-family: arial, sans-serif; border-collapse: collapse; width: 100%;}\n"
																+ "td, th {border: 1px solid #dddddd; text-align: left; padding: 8px;}\n"
																+ "tr:nth-child(even) {background-color: #dddddd;}"))
				.addChild(body
					.addChild("hr")
					.addChild("h1", "align=\"center\"", 
						StringUtils.snakeCaseToNatural(testCase) + " test report from " +  timeStamp.split("\\.")[2] + "/" +  timeStamp.split("\\.")[1] + "/" +  timeStamp.split("\\.")[0])
					.addChild("hr"));
	
			String[][] dataMatrix = FileUtils.loadDataFileToArray(reportPath + "/" + timeStamp + ".csv", true);
			
			if(dataMatrix.length > 1) {
				try {
					
					int[] testResultStats = getTestResults(dataMatrix);
					HashMap<String, HashMap<String, int[]>> testStats = initializeHashMap(dataMatrix);
					
					copyImagesFolder(reportPath, testStats);
					
					int totalTableColumns = 2 + (testResultStats[2] > 0 ? 1 : 0) + (testResultStats[3] > 0 ? 1 : 0);
					HtmlElement totalTable = HtmlUtils.createTable(2, totalTableColumns);
					body.addChild(totalTable);
					
					for(int i = 0; i < totalTableColumns; i++) {
						totalTable.getChildByTag("tbody").getChild(0).getChild(i).setContent(StringUtils.snakeCaseToNatural(testResultColumns[i]));
						totalTable.getChildByTag("tbody").getChild(0).getChild(i).addStyle("text-align:center;");
						totalTable.getChildByTag("tbody").getChild(1).getChild(i).setContent(Integer.toString(testResultStats[i]));
						totalTable.getChildByTag("tbody").getChild(1).getChild(i).addStyle("text-align:center;");
						
						if(testResultStats[i] > 0) {
							totalTable.getChildByTag("tbody").getChild(1).getChild(i).addStyle( 
								"color:" + (testResultColumns[i].equals(AutomationConstants.TEST_SUCCESS) ? "green" : "red") + ";");
						}
					}
					
					totalTable.addChildAt(new HtmlElement("caption").addChild("b", "", "Total"), 0);
					body.addChild("hr");
					
					// From 0 to test variables size
					for(int j = 0; j < dataMatrix[0].length - 4; j++) {
						// Calculate the quantity of tables
						int nTables = (int) (testStats.get(dataMatrix[0][j]).size() / 20) + 1, 
							size = testStats.get(dataMatrix[0][j]).size() / nTables,
							initialPos = 0, finalPos = size;
						
						// From 0 to nth quantity of tables
						for(int currentTable = 0; currentTable < nTables; currentTable++) {
							HtmlElement table = HtmlUtils.createTable(3, size);
							body.addChild(table);
							
							for(int i = 0; i < size; i++) {
								String testVariable = testStats.get(dataMatrix[0][j]).keySet().toArray()[initialPos + i].toString();
	
								int successes = testStats.get(dataMatrix[0][j]).get(testStats.get(dataMatrix[0][j]).keySet().toArray()[initialPos + i])[0];
								int failures = testStats.get(dataMatrix[0][j]).get(testStats.get(dataMatrix[0][j]).keySet().toArray()[initialPos + i])[1];
	
								if(new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER + "/" + testVariable + ".png").exists()) {
									table.getChildByTag("tbody").getChild(0).getChild(i).addChild(
										new HtmlElement("img")
											.addAttribute("src", AutomationConstants.THUMBNAILS_FOLDER + testVariable + ".png")
											.addAttribute("alt", testVariable)
											.addAttribute("width", "50")
											.addAttribute("height", "50"));
								} else {
									table.getChildByTag("tbody").getChild(0).getChild(i).setContent(StringUtils.snakeCaseToNatural(testVariable));
								}
								
								table.getChildByTag("tbody").getChild(0).getChild(i).addStyle("text-align:center;");
								table.getChildByTag("tbody").getChild(1).getChild(i).setContent(Integer.toString(successes));
								table.getChildByTag("tbody").getChild(1).getChild(i).addStyle("text-align:center;");
								table.getChildByTag("tbody").getChild(2).getChild(i).setContent(Integer.toString(failures));
								table.getChildByTag("tbody").getChild(2).getChild(i).addStyle("text-align:center;");
								
								if(successes > 0) {
									table.getChildByTag("tbody").getChild(1).getChild(i).addStyle("color: green;");
								}
								
								if(failures > 0) {
									table.getChildByTag("tbody").getChild(2).getChild(i).addStyle("color: red;");
								}
							}
							
							if(currentTable == 0) {
								table.addChildAt(new HtmlElement("caption").addChild("b", "", StringUtils.snakeCaseToNatural(dataMatrix[0][j])), 0);
							}
							
							body.addChild("hr");
							
							initialPos = finalPos;
							finalPos = currentTable + 2 == nTables ? testStats.get(dataMatrix[0][j]).size() : finalPos + size;
						}
						
						
						body.addChild("br");
					}
					
					HtmlElement[] errorReportNodes = getErrorReportNodes(dataMatrix, reportPath, timeStamp);
					
					if(errorReportNodes[0] != null) {
						body.addChild(errorReportNodes[0]);
					}
					
					if(errorReportNodes[1] != null) {
						body.addChild(errorReportNodes[1]);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			File f = new File(reportPath + timeStamp + ".html");
			
			BufferedWriter bw = null;
			
			try {
				bw = new BufferedWriter(new FileWriter(f));
				bw.write(htmlNode.toString());
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
			
			System.out.println("[INFO] - HTML created");
		} else {
			System.out.println("[INFO] - HTML not created, file not found: " + reportPath + "/" + timeStamp + ".csv");
		}
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