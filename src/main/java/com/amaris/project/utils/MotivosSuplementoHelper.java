package com.amaris.project.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.project.Constants;

public class MotivosSuplementoHelper {
	
	private Boolean selected;
	private String Description;
	private WebElement checkbox;
	private Integer pageNumber;
	private static Map<String, Map<String, Boolean>> motivosSuplementos = new HashMap<>();

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

	public static Map<String, Boolean> getMotivosSuplementos(UserStory userS) {
		if(motivosSuplementos.get(userS.getTestId()) == null) {
			motivosSuplementos.put(userS.getTestId(), new HashMap<String, Boolean>());
		}
		
		return motivosSuplementos.get(userS.getTestId());
	}

	public static void addMotivoSuplemento(String key, boolean value, UserStory userS) {
		getMotivosSuplementos(userS).put(key, value);
	}
	// endregion
}
