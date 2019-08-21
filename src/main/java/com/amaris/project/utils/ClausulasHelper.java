package com.amaris.project.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;

import com.amaris.automation.model.testing.UserStory;
import com.amaris.project.Constants;

public class ClausulasHelper {

	private String Number;
	private boolean selected;
	private String Description;
	private Integer pageNumber;
	private WebElement checkbox;
	private static Map<String, List<String>> clausulas = new HashMap<>();

	public ClausulasHelper(Integer pageNumber, boolean selected, String Number, String description, WebElement checkbox) {
		this.pageNumber = pageNumber;
		this.selected = selected;
		this.Number = Number;
		this.Description = description;
		this.checkbox = checkbox;
	}

	// BeginGettersAndSetters
	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		this.Number = number;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		this.Description = description;
	}

	public WebElement getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(WebElement checkbox) {
		this.checkbox = checkbox;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public static List<String> getClausulas(UserStory userS) {
		if(clausulas.get(userS.getTestId()) == null) {
			clausulas.put(userS.getTestId(), new ArrayList<String>());
		}
		
		return clausulas.get(userS.getTestId());
	}

	public static void addClausula(String clausula, UserStory userS) {
		userS.setTestVar(Constants.MODIFICAR_CLAUSULAS, Constants.ModificarClausulas);
		
		getClausulas(userS).add(clausula);
	}
	// EndGettersAndSetters
}
