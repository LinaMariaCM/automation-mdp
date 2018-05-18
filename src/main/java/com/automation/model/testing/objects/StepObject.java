package com.automation.model.testing.objects;

import java.text.SimpleDateFormat;

import com.automation.model.testing.TestDataManager;
import com.automation.model.testing.UserStory;
import com.automation.model.webdriver.DriverHelper;

public class StepObject {

	protected UserStory userS;
	protected DriverHelper webDriver;
	protected TestDataManager testDataM;

	public StepObject(DriverHelper driver) {
		this.webDriver = driver;
	}

	public StepObject(UserStory userStory) {
		this.userS = userStory;
		this.testDataM = userS.getTestDataManager();
		this.webDriver = userS.getDriver();
	}
	
	protected void debugBegin() {
		int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new java.util.Date());
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		className = className.contains(".") ? className.substring(className.lastIndexOf(".") + 1) : className;
		
		System.out.println(timeStamp + " - " + className + ":" + line + " - [BEGIN] (" + userS.getTestId() + ") - " + methodName);
	}
	
	protected void debugEnd() {
		int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new java.util.Date());
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		className = className.contains(".") ? className.substring(className.lastIndexOf(".") + 1) : className;
		
		System.out.println(timeStamp + " - " + className + ":" + line + " - [END] (" + userS.getTestId() + ") - " + methodName);
	}
	
	protected void debugInfo(String message) {
		int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new java.util.Date());
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		className = className.contains(".") ? className.substring(className.lastIndexOf(".") + 1) : className;
		
		System.out.println(timeStamp + " - " + className + ":" + line + " - [INFO] (" + userS.getTestId() + ") - " + message);
	}
	
	protected void debugError(String message) {
		int line = Thread.currentThread().getStackTrace()[2].getLineNumber();
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new java.util.Date());
		String className = Thread.currentThread().getStackTrace()[2].getClassName();
		className = className.contains(".") ? className.substring(className.lastIndexOf(".") + 1) : className;
		
		System.out.println(timeStamp + " - " + className + ":" + line + " - [ERROR] (" + userS.getTestId() + ") - " + message);
	}
}
