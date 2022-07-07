package com.lockers.lockedme.services;

import java.io.File;

public class DirectoryService {
	private static Directory fileDirectory = new Directory();

	// printing files names
	public static void PrintFiles() {
		fileDirectory.fillFiles();
		for (File file : DirectoryService.getFileDirectory().getFiles()) {
			System.out.println(file.getName());

		}

	}

	// getting file directory
	public static Directory getFileDirectory() {
		return fileDirectory;
	}

	// setting file directory
	public static void setFileDirectory(Directory fileDirectory) {
		DirectoryService.fileDirectory = fileDirectory;
	}

}
