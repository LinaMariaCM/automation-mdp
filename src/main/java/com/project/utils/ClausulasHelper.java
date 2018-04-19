package com.project.utils;

import org.openqa.selenium.WebElement;

public class ClausulasHelper
{
	Boolean selected;
	String Number;
	String Description;
	WebElement checkbox;
	Integer pageNumber;

	public ClausulasHelper(Integer pageNumber, boolean selected, String Number, String description, WebElement checkbox)
	{
		this.pageNumber = pageNumber;
		this.selected = selected;
		this.Number = Number;
		this.Description = description;
		this.checkbox = checkbox;
	}

	// BeginGettersAndSetters
	public Boolean getSelected()
	{
		return this.selected;
	}

	public void setSelected(Boolean selected)
	{
		this.selected = selected;
	}

	public String getNumber()
	{
		return this.Number;
	}

	public void setNumber(String number)
	{
		this.Number = number;
	}

	public String getDescription()
	{
		return this.Description;
	}

	public void setDescription(String description)
	{
		this.Description = description;
	}

	public WebElement getCheckbox()
	{
		return this.checkbox;
	}

	public void setCheckbox(WebElement checkbox)
	{
		this.checkbox = checkbox;
	}

	public Integer getPageNumber()
	{
		return this.pageNumber;
	}

	public void setPageNumber(Integer pageNumber)
	{
		this.pageNumber = pageNumber;
	}
	// EndGettersAndSetters
}
