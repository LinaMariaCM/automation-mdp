package com.amaris.automation.model.testing.objects;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import com.amaris.automation.model.testing.SuiteManager;
import com.amaris.automation.model.utils.InitUtils;

public class TestObject {

	protected SuiteManager suiteM;
	protected String translationFile;

	@BeforeSuite
	public synchronized void initializeExecution(ITestContext context) {
		InitUtils.setThreads(context);
	}
}
