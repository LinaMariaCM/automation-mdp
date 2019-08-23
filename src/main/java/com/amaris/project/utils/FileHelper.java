package com.amaris.project.utils;

//FileDownload
import java.io.File;
import java.time.LocalDateTime;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SizeFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;

//FileUpload
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileHelper {

	// For Download

	public boolean checkIfFilesInFolderHaveBeenDownloaded(File tempFolder, int timeout) {

		LocalDateTime currentDateTimeDownload = LocalDateTime.now();
		Collection<File> finishedFiles = null;

		do {
			try {
				Thread.sleep(500L);
			} catch(InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// String[] extensionsFilter =
			// { ".pdf" };
			// String[] tempFilesFilter =
			// { "crdownload", "part" };
			// File dir = new File(".");
			// String[] fileSizeFilter = dir.list(new SizeFileFilter(1, true));

			// tempFiles = FileUtils.listFiles(tempFolder, tempFilesFilter,
			// true);
			finishedFiles = FileUtils.listFiles(tempFolder, new SizeFileFilter(1, true), TrueFileFilter.TRUE);

		} while(finishedFiles.isEmpty()
			&& currentDateTimeDownload.plusSeconds(timeout).isAfter(LocalDateTime.now())
			&& finishedFiles.size() == 0);

		if(FileUtils.listFiles(tempFolder, new String[]{ "crdownload"}, false).isEmpty()) { return true; }
		return false;
	}

	// For UpLoad

	public static void setClipboardData(String filePath) {
		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void uploadFIle(String fileNameAndPath) {
		setClipboardData(fileNameAndPath);
		// native key strokes for CTRL, V and ENTER keys

		try {
			Robot robot = new Robot();
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch(AWTException e) {
			System.out.println("Error usando el objeto Robot");
		}
	}
}
