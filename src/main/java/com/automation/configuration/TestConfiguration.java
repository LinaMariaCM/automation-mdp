package com.automation.configuration;

import com.automation.model.utils.FileUtils;
import com.automation.model.utils.StringUtils;

public class TestConfiguration {
	public static void main(String[] args) {
		if(args.length > 0){
			String content = FileUtils.getTextFromFile(AutomationConstants.TEST_XML_PATH);
			
			for(int i = 0; i < args.length; i++) {
				if(args[i].contains("threads=")) {
					content = changeThreadNumber(content, args[i].substring(args[i].indexOf('=') + 1));
				} else if(args[i].contains("test=")) {
					content = changeClassName(content, args[i].substring(args[i].indexOf('=') + 1));
				}
			}
				
			FileUtils.writeFile(AutomationConstants.TEST_XML_PATH, content);
		}
	}
	
	public static String changeThreadNumber(String content, String n) {
		return StringUtils.replaceTextInBetween(content, n, "data-provider-thread-count=\"", "\"");
	}
	
	public static String changeClassName(String content, String newClassName) {
		return StringUtils.replaceTextInBetween(content, newClassName, "class name=\"tests.", "\"");
	}
}
