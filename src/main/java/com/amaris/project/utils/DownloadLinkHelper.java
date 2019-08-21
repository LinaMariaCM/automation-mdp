package com.amaris.project.utils;

import org.openqa.selenium.WebElement;

public class DownloadLinkHelper {

	private String description;
	private WebElement downloadLink;

	public DownloadLinkHelper(String description, WebElement element) {
		this.description = description;
		this.downloadLink = element;
	}

	// region gettersandsetters
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public WebElement getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(WebElement downloadLink) {
		this.downloadLink = downloadLink;
	}
	// endregion

}