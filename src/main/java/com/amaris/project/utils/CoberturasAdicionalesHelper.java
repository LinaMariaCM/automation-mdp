package com.amaris.project.utils;

import org.openqa.selenium.WebElement;

public class CoberturasAdicionalesHelper {

	Boolean selected;
	String Description;
	WebElement checkbox;

	public CoberturasAdicionalesHelper(boolean selected, String description, WebElement checkbox) {
		this.selected = selected;
		this.Description = description;
		this.checkbox = checkbox;
	}

	// BeginGettersAndSetters
	public Boolean getSelected() {
		return this.selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getDescription() {
		return this.Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public WebElement getCheckbox() {
		return this.checkbox;
	}

	public void setCheckbox(WebElement checkbox) {
		this.checkbox = checkbox;
	}
	// EndGettersAndSetters
}
