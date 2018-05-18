package com.automation.model.testing;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import com.automation.model.utils.InitUtils;

public class TestClass {

	protected SuiteManager suiteM;
	protected String translationFile;

	@BeforeSuite
	public synchronized void initializeExecution(ITestContext context) {
		InitUtils.setThreads(context);
	}
}
