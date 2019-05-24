package com.amaris.automation.model.utils.objects;

import java.text.SimpleDateFormat;

/**
 * The DebugLogger class is used to easily log with time stamp, class name and line number using a verbose variable to
 * activate or deactivate it
 *
 * @author Alfredo Moises Boullosa Ramones
 */
public class DebugLogger {

	private String id = null;
	private boolean verbose = true;

	public DebugLogger() {}

	public DebugLogger(String id) {
		this.id = id;
	}

	public DebugLogger setId(String id) {
		this.id = id;

		return this;
	}

	public DebugLogger setVerbose(boolean verbose) {
		this.verbose = verbose;

		return this;
	}

	// region Methods
	public void begin() {
		if(verbose) {
			debugBegin(id);
		}
	}

	public void end() {
		if(verbose) {
			debugEnd(id);
		}
	}

	public void info(String message) {
		if(verbose) {
			debugInfo(id, message);
		}
	}

	public void error(String message) {
		if(verbose) {
			debugError(id, message);
		}
	}

	public void printStackTrace(Exception exception) {
		if(verbose) {
			exception.printStackTrace();
		}
	}

	public void printStackTrace(Error error) {
		if(verbose) {
			error.printStackTrace();
		}
	}
	// endregion

	// region Static methods
	private static String getClassName(int number) {
		String result = Thread.currentThread().getStackTrace()[number].getClassName();
		return result.contains(".") ? result.substring(result.lastIndexOf('.') + 1) : result;
	}

	private static String getMethodName() {
		int number = 1;

		while(getClassName(number) != null && getClassName(number).equals("DebugLogger")) {
			number++;
		}

		return Thread.currentThread().getStackTrace()[getLayerNumber(Thread.currentThread().getStackTrace())].getMethodName();
	}

	private static int getLineNumber(int number) {
		return Thread.currentThread().getStackTrace()[number].getLineNumber();
	}

	private static int getLayerNumber(StackTraceElement[] stackTrace) {
		int number = 1;
		String className;

		do {
			className = stackTrace[number].getClassName();
			className = className.contains(".") ? className.substring(className.lastIndexOf('.') + 1) : className;

			number++;
		} while(className != null && className.equals("DebugLogger"));

		number--;

		if(stackTrace[number - 2].getMethodName().equals(stackTrace[number].getMethodName())) {
			number++;
		}

		return number;
	}

	private static String getDebugLine() {
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new java.util.Date());

		int line = getLineNumber(getLayerNumber(Thread.currentThread().getStackTrace()) + 1);
		String className = getClassName(getLayerNumber(Thread.currentThread().getStackTrace()) + 1);

		return timeStamp + " - " + className + ":" + line;
	}

	public static void debugBegin() {
		debugBegin(null);
	}

	public static void debugBegin(String id) {
		System.out.println(getDebugLine() + " - [BEGIN] " + (id == null ? "" : "(" + id + ") ") + "- " + getMethodName());
	}

	public static void debugEnd() {
		debugEnd(null);
	}

	public static void debugEnd(String id) {
		System.out.println(getDebugLine() + " - [END] " + (id == null ? "" : "(" + id + ") ") + "- " + getMethodName());
	}

	public static void debugInfo(String message) {
		debugInfo(null, message);
	}

	public static void debugInfo(String id, String message) {
		System.out.println(getDebugLine() + " - [INFO] " + (id == null ? "" : "(" + id + ") ") + "- " + message);
	}

	public static void debugError(String message) {
		debugError(null, message);
	}

	public static void debugError(String id, String message) {
		System.out.println(getDebugLine() + " - [ERROR] " + (id == null ? "" : "(" + id + ") ") + "- " + message);
	}
	// endregion
}
