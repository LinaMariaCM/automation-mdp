package com.project.pages;


public class InmueblePage_MAC
{
//	final static Logger logger = LoggerFactory.getLogger(InmueblePage_MAC.class);
//	BrowserContext browserContext;
//	private WebElementHelper wh;
//	TestCaseData tData;
//
//	// region webelements
//	@FindBy(name = "cuerpo")
//	private WebElement cuerpoFrame;
//
//	@FindBy(xpath = ".//*[@id='capaShowInmueble']/div/div[2]/div/div/button")
//	private WebElement btnAnadirInmueblePantallaPrincipal;
//	
//	@FindBy(xpath = ".//*[@class='modal-footer']/button[text()='Añadir Inmueble']")
//	private WebElement btnAnadirInmueble;
//	
//	@FindBy(xpath = "//*[@id='AnyadirInmu']")
//	private WebElement btnAnadir;
//	
//	@FindBy(name = "provincia")
//	private WebElement txtProvincia;
//	
//	@FindBy(name = "poblacion")
//	private WebElement txtPoblacion;
//	
//	@FindBy(xpath = "//*[@id='ALTACLIE_BS_NOMVIA_ARVATO']")
//	private WebElement txtNombreVia;
//	
//	@FindBy(xpath = "//*[@id='ALTACLIE_BS_NUMVIA']")
//	private WebElement txtNumeroVia;
//
//	@FindBy(xpath = ".//*[@id='ui-active-menuitem']")
//	private WebElement itemProvincia;
//
//	@FindBy(xpath = ".//*[@id='ui-active-menuitem']")
//	private WebElement itemPoblacion;
//	
//	@FindBy(xpath = ".//*[@id='ui-active-menuitem']")
//	private WebElement itemNomVia;
//
//	public InmueblePage_MAC(BrowserContext browserContext)
//	{
//		this.wh = browserContext.webElementHelper;
//		this.tData = browserContext.getTestCaseData();
//		PageFactory.initElements(browserContext.getWebDriver(), this);
//	}
//	
//	public void executeActionsInInmueblePage() throws InterruptedException, IOException
//	{
//		// Add datos inmueble
//		this.AddInmuebleByAddress();
//		
//	}
//	
//	public void AddInmuebleByAddress() throws InterruptedException
//	{
//		logger.debug("BEGIN - AddInmuebleByAddress");
//		this.wh.waitForPageLoadToFinish();
//
//		this.wh.clickOnWebElementInFrame(this.btnAnadirInmueblePantallaPrincipal, this.cuerpoFrame);
//		this.wh.sendValueToWebElementInFrame(this.txtProvincia, this.cuerpoFrame, String.valueOf(this.tData.getInmuebleProvincia()));
//		this.wh.clickOnWebElementInFrame(this.itemProvincia, this.cuerpoFrame);
//		
//		this.wh.sendValueToWebElementInFrame(this.txtPoblacion, this.cuerpoFrame, String.valueOf(this.tData.getInmueblePoblacion()));
//		this.wh.clickOnWebElementInFrame(this.itemPoblacion, this.cuerpoFrame);
//
//		this.wh.sendValueToWebElementInFrame(this.txtNombreVia, this.cuerpoFrame, String.valueOf(this.tData.getInmuebleNombreVia()));
//		this.wh.clickOnWebElementInFrame(this.itemNomVia, this.cuerpoFrame);
//		
//		this.wh.sendValueToWebElementInFrame(this.txtNumeroVia, this.cuerpoFrame, String.valueOf(this.tData.getInmuebleNumeroVia()));
//		
//		this.wh.clickOnWebElementInFrame(this.txtNombreVia, this.cuerpoFrame);
//		
//		this.wh.clickOnWebElementInFrame(this.btnAnadir, this.cuerpoFrame);
//		logger.debug("END - AddInmuebleByAddress");
//	}
}
