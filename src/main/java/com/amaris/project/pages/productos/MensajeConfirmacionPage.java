package com.amaris.project.pages.productos;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SizeFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.automation.model.testing.objects.PageObject;
import com.amaris.automation.model.utils.DateUtils;
import com.amaris.project.Constants;
import com.amaris.project.utils.DownloadLinkHelper;
import com.google.common.io.Files;

public class MensajeConfirmacionPage extends PageObject {

	// region WebElements
	private By cuerpoFrame = By.name("cuerpo");
	private By imprimirCopiaTomadorBtn = By.cssSelector("#form1 > table.grid.narrowBox > tbody > tr:nth-child(3) > td:nth-child(3) > a > img");

	private By documentRow = By.xpath(".//tr[td//*[@alt='Imprimir']]");

	private By linkDownloadRow = By.xpath(".//td[3]/a");
	private By linkDescriptionRow = By.xpath(".//td[2]");
	// endregion

	public MensajeConfirmacionPage(UserStory userS) {
		super(userS);
	}

	// region Methods
	public MensajeConfirmacionPage downlodadDocumentsToFolder(String path) {
		debugBegin();

		List<DownloadLinkHelper> downloads = getDownloadLinksAndNames();

		File reportFolder = new File(userS.getReportPath());
		String dateTime = DateUtils.getTodayDate("yyyy-mm-dd_hh-mm-ss");
		String folderName = "/Poliza_" + getTestVar(Constants.NUM_POLIZA) + "_Documentos_Suplemento" + dateTime;

		new File(path + '/' + folderName).mkdirs();
		File destinationFolder = new File(path + '/' + folderName);

		downloads.stream().forEach(p -> {
			webDriver.doubleClickInFrame(p.getDownloadLink(), cuerpoFrame);

			if(checkIfFilesInFolderHaveBeenDownloaded(reportFolder)) {
				try {
					Collection<File> files = FileUtils.listFiles(reportFolder, new String[]{ "pdf"}, true);

					Files.move(files.iterator().next(), new File(destinationFolder.getAbsolutePath() + '/' + p.getDescription() + ".pdf"));

					webDriver.closeWindow();
				} catch(IOException e) {
					debugError("Ha habido un error al mover el archivo descargado a la carpeta de destino: " + e);
				}
			}
		});

		debugEnd();

		return this;
	}

	public List<DownloadLinkHelper> getDownloadLinksAndNames() {
		debugBegin();

		List<DownloadLinkHelper> downloads = new ArrayList<>();

		webDriver.getElementsInFrame(documentRow, cuerpoFrame).stream()
			.forEach(p -> downloads.add(new DownloadLinkHelper(p.findElement(linkDescriptionRow).getText(),
				p.findElement(linkDownloadRow))));

		debugEnd();

		return downloads;
	}

	public boolean checkIfFilesInFolderHaveBeenDownloaded(File tempFolder) {
		debugBegin();

		boolean result = false;
		Collection<File> finishedFiles = null;
		LocalDateTime currentDateTimeDownload = LocalDateTime.now();

		do {
			webDriver.waitWithDriver(500L);

			finishedFiles = FileUtils.listFiles(tempFolder, new SizeFileFilter(1, true), TrueFileFilter.TRUE);
		} while(finishedFiles.isEmpty()
			&& currentDateTimeDownload.plusSeconds(webDriver.getImplicitWait()).isAfter(LocalDateTime.now()));

		if(FileUtils.listFiles(tempFolder, new String[]{ "crdownload"}, false).isEmpty()) {
			result = true;
		}

		debugEnd();

		return result;
	}

	public MensajeConfirmacionPage checkIfPageHasLoadedCorrectly() {
		debugBegin();

		Assert.assertTrue(webDriver.getElementsInFrame(documentRow, cuerpoFrame).size() > 2, "La pagina con el listado de documentos no ha cargado correctamente");

		debugEnd();

		return this;
	}

	// Copy contents of Copia Tomador PDF to Notepad and search for the text of the motivos suplemento.
	public MensajeConfirmacionPage searchTextInCopiaTomadorPDF() {
		debugBegin();

		webDriver.clickInFrame(imprimirCopiaTomadorBtn, cuerpoFrame);
		// Pending code that searches for text.

		debugEnd();

		return this;
	}
	// endregion
}