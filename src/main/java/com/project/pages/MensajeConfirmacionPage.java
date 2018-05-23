package com.project.pages;

import com.automation.model.testing.UserStory;
import com.automation.model.testing.objects.PageObject;

public class MensajeConfirmacionPage extends PageObject {
	
	MensajeConfirmacionPage(UserStory userS) {
		super(userS);
	}
	
	// final static Logger logger =
	// LoggerFactory.getLogger(MensajeConfirmacionPage.class);
	// BrowserContext browserContext;
	// private WebElementHelper wh;
	// TestCaseData tData;
	//
	// // region webelements
	//
	// @FindBy(name = "cuerpo")
	// private WebElement cuerpoFrame;
	//
	// @FindBy(xpath = ".//tr[td//*[@alt='Imprimir']]")
	// private List<WebElement> rowWithDocument;
	//
	// String xpathRowLinkDownloadFilter = ".//td[3]/a";
	// String xpathRowLinkDescriptionFilter = ".//td[2]";
	//
	// @FindBy(css = "#form1 > table.grid.narrowBox > tbody > tr:nth-child(3) >
	// td:nth-child(3) > a > img")
	// private WebElement imprimirCopiaTomador;
	//
	// // endregion
	//
	// public MensajeConfirmacionPage(BrowserContext browserContext)
	// {
	//
	// this.browserContext = browserContext;
	// this.wh = browserContext.webElementHelper;
	// this.tData = browserContext.getTestCaseData();
	// PageFactory.initElements(browserContext.getWebDriver(), this);
	// }
	//
	// // region methods
	// public void DownlodadDocumentsToFolder(
	// String Path) throws IOException
	// {
	// logger.trace("BEGIN - DownlodadDocumentsToFolder");
	//
	// List<DownloadLinkHelper> downloads = this.getDownloadLinksAndNames();
	//
	// File tempFolder = new
	// File(this.browserContext.getProperties().fileDownloadTempPath);
	// FileUtils.cleanDirectory(tempFolder);
	//
	// DateTimeFormatter formatter =
	// DateTimeFormatter.ofPattern("yyyy-mm-dd___hh-mm-ss");
	// String dateTime = LocalDateTime.now().format(formatter).toString();
	//
	// String folderName = "\\polizaNumero_" + this.tData.getNumPoliza() +
	// "_Documentos_Suplemento" + dateTime;
	//
	// FileUtils.forceMkdir(new File(Path + "\\" + folderName));
	// File destinationFolder = new File(Path + "\\" + folderName);
	//
	// downloads.stream().forEach(p ->
	// {
	// this.wh.switchToFrame(this.cuerpoFrame);
	// // p.getDownloadLink().click();
	// this.wh.doubleClickOnWebElement(p.getDownloadLink());
	// this.wh.exitFromFrame();
	// if (this.CheckIfFilesInFolderHaveBeenDownloaded(tempFolder))
	// {
	// try
	// {
	// String[] extensions =
	// { "pdf" };
	// Collection<File> files = FileUtils.listFiles(tempFolder, extensions,
	// true);
	//
	// Files.move(files.iterator().next(), new
	// File(destinationFolder.getAbsolutePath() + "\\" + p.getDescription() +
	// ".pdf"));
	// this.wh.closeSecondWindow(this.tData.getMainWindowHandle());
	// }
	// catch (IOException e)
	// {
	// logger.trace("Ha habido un error al mover el archivo descargado a la
	// carpeta de destino", e);
	// }
	// }
	// });
	// logger.trace("END - DownlodadDocumentsToFolder");
	// }
	//
	// public List<DownloadLinkHelper> getDownloadLinksAndNames()
	// {
	// logger.trace("BEGIN - getDownloadLinksAndNames");
	// List<DownloadLinkHelper> downloads = new ArrayList<>();
	//
	// this.wh.switchToFrame(this.cuerpoFrame);
	//
	// this.rowWithDocument.stream()
	// .forEach(p -> downloads.add(new
	// DownloadLinkHelper(p.findElement(By.xpath(this.xpathRowLinkDescriptionFilter)).getText(),
	// p.findElement(By.xpath(this.xpathRowLinkDownloadFilter)))));
	// this.wh.exitFromFrame();
	// logger.trace("END - getDownloadLinksAndNames");
	// return downloads;
	// }
	//
	// public boolean CheckIfFilesInFolderHaveBeenDownloaded(
	// File tempFolder)
	// {
	// logger.trace("BEGIN - CheckIfFilesInFolderHaveBeenDownloaded");
	// LocalDateTime currentDateTimeDownload = LocalDateTime.now();
	// Collection<File> finishedFiles = null;
	//
	// do
	// {
	// try
	// {
	// Thread.sleep(500L);
	// }
	// catch (InterruptedException e)
	// {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// // String[] extensionsFilter =
	// // { ".pdf" };
	// // String[] tempFilesFilter =
	// // { "crdownload", "part" };
	// // File dir = new File(".");
	// // String[] fileSizeFilter = dir.list(new SizeFileFilter(1, true));
	//
	// finishedFiles = FileUtils.listFiles(tempFolder, new SizeFileFilter(1,
	// true), TrueFileFilter.TRUE);
	// }
	//
	// while (finishedFiles.isEmpty()
	// &&
	// currentDateTimeDownload.plusSeconds(this.browserContext.getProperties().pageLoadTimeout).isAfter(LocalDateTime.now())
	// && finishedFiles.size() == 0);
	// logger.trace("END - CheckIfFilesInFolderHaveBeenDownloaded");
	//
	// if (FileUtils.listFiles(tempFolder, new String[]
	// { "crdownload" }, false).isEmpty())
	// {
	// return true;
	// }
	// return false;
	// }
	//
	// public void CheckIfPageHasLoadedCorrectly()
	// {
	// logger.debug("BEGIN - CheckIfPageHasLoadedCorrectly");
	// this.wh.switchToFrame(this.cuerpoFrame);
	// Assert.assertTrue("La pagina con el listado de documentos no ha cargado
	// correctamente", this.rowWithDocument.size() > 2);
	// this.wh.exitFromFrame();
	// logger.debug("END - CheckIfPageHasLoadedCorrectly");
	// }
	//
	// public void searchTextInCopiaTomadorPDF() // Copy contents of Copia
	// Tomador PDF to Notepad and search for the text of the motivos suplemento.
	// {
	// this.wh.switchToFrame(this.cuerpoFrame);
	// this.wh.clickOnWebElement(this.imprimirCopiaTomador);
	// // Pending code that searches for text.
	// this.wh.exitFromFrame();
	// }

	// endregion
}
