package com.amaris.project.utils;

import org.openqa.selenium.WebElement;

public class DownloadLinkHelper {

	private String Description;
	private WebElement DownloadLink;

	public DownloadLinkHelper(String description, WebElement element) {
		this.Description = description;
		this.DownloadLink = element;
	}

	// region gettersandsetters
	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public WebElement getDownloadLink() {
		return this.DownloadLink;
	}

	public void setDownloadLink(WebElement downloadLink) {
		this.DownloadLink = downloadLink;
	}

	// endregion

}