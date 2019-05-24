package com.amaris.project.utils;

import org.openqa.selenium.WebElement;

public class MotivosSuplementoHelper {
	private Boolean selected;
	private String Description;
	private WebElement checkbox;
	private Integer pageNumber;

	public MotivosSuplementoHelper(Boolean selected, String Description, WebElement checkbox, Integer pageNumber) {
		this.selected = selected;
		this.Description = Description;
		this.checkbox = checkbox;
		this.pageNumber = pageNumber;
	}

	// region getters and setters
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

	public Integer getPageNumber() {
		return this.pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	// endregion
}
