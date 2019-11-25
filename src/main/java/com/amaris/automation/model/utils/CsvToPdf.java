package com.amaris.automation.model.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;

import javax.imageio.ImageIO;
import com.itextpdf.text.DocumentException;
import org.xhtmlrenderer.pdf.ITextRenderer;
import com.amaris.automation.configuration.AutomationConstants;
import com.amaris.automation.model.utils.objects.HtmlElement;
import com.amaris.automation.model.webdriver.configuration.BrowserType;

public class CsvToPdf extends CsvToHtml {

	public static void main(String[] args) {
		createReportFromArguments(new CsvToPdf(), args);
	}

	@Override
	protected HtmlElement createImagesTable(HashMap<String, int[]> columnResults, ArrayList<String> columnOrder, String tableName) {
		HtmlElement container = new HtmlElement("div")
			.addAttribute("class", "boxes thumbnails");

		for(int i = 0; i < columnOrder.size(); i++) {
			String testVariable = columnOrder.get(i);

			int successes = columnResults.get(columnOrder.get(i))[0];
			int failures = columnResults.get(columnOrder.get(i))[1];

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			try {
				BufferedImage image = ImageIO.read(new File(reportPath + AutomationConstants.THUMBNAILS_FOLDER + testVariable + ".png"));

				ImageIO.write(image, "png", outputStream);
			} catch(IOException e) {
				printStackTrace(e);
			}

			String encodedImage = Base64.getEncoder().encodeToString(outputStream.toByteArray());

			container.addChild(new HtmlElement("div")
				.addAttribute("class", "box selectable")
				.addAttribute("name", testVariable)
				.addChild(new HtmlElement("img")
					.addAttribute("src", "data:image/png;base64," + encodedImage)
					.addAttribute("style", "width: 25px; height: 25px;"))
				.addChild(new HtmlElement("div")
					.addAttribute("class", "number")
					.addChild("span", "class=\"success\"" + (successes > 0 ? " style=\"color: green;\"" : " style=\"color: black;\""), Integer.toString(successes))
					.addChild("span", "", "/")
					.addChild("span", "class=\"error\"" + (failures > 0 ? " style=\"color: #CC444B;\"" : " style=\"color: black;\""), Integer.toString(failures))));
		}

		return container;
	}

	@Override
	protected void addErrorCase(String[][] dataMatrix, String reportPath, String timeStamp, HtmlElement accordionContent, int index, int relevantColumns) {
		HtmlElement table = HtmlUtils.createTable(1, 1);

		HtmlElement caseVariables = new HtmlElement("div")
			.addAttribute("class", "boxes cases");

		for(int j = 0; j < relevantColumns; j++) {
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

		if(new File(reportPath + imagePath).exists()) {
			int newWidth = 640;
			int newHeight = 300;

			try {
				BufferedImage img = ImageIO.read(new File(reportPath + imagePath));
				int imgWidth = img.getWidth();
				int imgHeight = img.getHeight();

				if(imgWidth > imgHeight) {
					newWidth = 640;
					newHeight = 640 * imgHeight / imgWidth;
				} else {
					newHeight = 450;
					newWidth = 450 * imgWidth / imgHeight;
				}
			} catch(Exception e) {
				logger.error("Couldn't read the image file. Applying default image size.");
			}

			table.addAttribute("class", "accordion")
				.getChildByTag("thead")
				.addAttribute("class", "ac-button")
				.getChildByTag("tr")
				.getChildByTag("th")
				.getChildByTag("div")
				.addChild(arrow);

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			try {
				BufferedImage image = ImageIO.read(new File(reportPath + imagePath));

				ImageIO.write(image, "png", outputStream);
			} catch(IOException e) {
				printStackTrace(e);
			}

			String encodedImage = Base64.getEncoder().encodeToString(outputStream.toByteArray());

			table.getChildByTag("tbody")
				.addAttribute("class", "ac-content")
				.getChildByTag("tr")
				.getChildByTag("th")
				.addChild(new HtmlElement("img")
					.addAttribute("src", "data:image/png;base64," + encodedImage)
					.addAttribute("style", "width: " + newWidth + "px; height: " + newHeight + "px; "
						+ "margin: auto; top: 0; right: 0; bottom: 0; left: 0;"));
		} else {
			table.removeChildAt(1);
		}

		accordionContent.addChild(table);
	}

	@Override
	protected HtmlElement getErrorReportNode(String[][] dataMatrix, String reportPath, String timeStamp, int relevantColumns) {
		HtmlElement accordionContent = new HtmlElement("div")
			.addAttribute("class", "ac-content");

		for(int i = 1; i < dataMatrix.length; i++) {
			if(dataMatrix[i][dataMatrix[0].length - 3] != null && !dataMatrix[i][dataMatrix[0].length - 3].isEmpty()
				&& dataMatrix[i][dataMatrix[0].length - 3].equals(AutomationConstants.TEST_FAILURE)) {
				addErrorCase(dataMatrix, reportPath, timeStamp, accordionContent, i, relevantColumns);
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

	@Override
	protected HtmlElement createJointHtmlNode(String timeStamp, String reportName, String[] testCases, int[] relevantColumns) {
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
							.replace("[date]", timeStamp.split("\\.")[2] + '/' + timeStamp.split("\\.")[1] + '/' + timeStamp.split("\\.")[0])))));

		// Create HTMLs
		for(int i = 0; i < testCases.length; i++) {
			currentTestCase = testCases[i];
			currentTimeStamp = timeStamp.replace(AutomationConstants.TESTCASE_REPLACE, currentTestCase);
			String browserTimeStamp = currentTimeStamp.contains("headless") ? currentTimeStamp.replace("_headless", "") : currentTimeStamp;
			String headlessTimeStamp = browserTimeStamp
				.replace(BrowserType.CHROME, BrowserType.CHROME + "_headless")
				.replace(BrowserType.FIREFOX, BrowserType.FIREFOX + "_headless")
				.replace(BrowserType.GALAXYS5, BrowserType.GALAXYS5 + "_headless");

			currentTimeStamp = new File(reportPath + '/' + headlessTimeStamp + ".csv").exists() ? headlessTimeStamp : browserTimeStamp;

			HtmlElement auxNode = createTestCaseWrapper(currentTimeStamp, currentTestCase, relevantColumns[i]);

			if(auxNode != null) {
				htmlNode.getChildByTag("body").addChild(auxNode);
			} else {
				debugInfo("PDF not created, file not found: " + reportPath + '/' + timeStamp + ".csv");
			}

			dataMatrix = null;
			currentTestCase = null;
			currentTimeStamp = null;
		}

		modifyContent(htmlNode, timeStamp, testCases, relevantColumns);

		return htmlNode;
	}

	@Override
	protected void writeToFile(HtmlElement htmlNode, String path) {
		if(htmlNode != null) {
			try(OutputStream os = new FileOutputStream(path + ".pdf")) {
				ITextRenderer renderer = new ITextRenderer();
				renderer.setDocumentFromString(htmlNode.toString());

				renderer.layout();
				renderer.createPDF(os);
				logger.info("PDF created");
			} catch(IOException | DocumentException e) {
				printStackTrace(e);
			}
		}
	}
}