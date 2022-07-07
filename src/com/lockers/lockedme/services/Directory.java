package com.lockers.lockedme.services;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Directory class:it will declare the path and initialize with files and
 * contains generic methods to print and get files
 * 
 * @author ankitarawat
 *
 */
public class Directory {

	public static final String name = "src/com/lockers/lockedme/directory/";

	private static ArrayList<File> files = new ArrayList<File>();

	static Path path = FileSystems.getDefault().getPath(name).toAbsolutePath();

	static File Dfiles = path.toFile();

	// Getting the name of path of the directory
	public String getName() {
		return name;
	}

	// printing the files presents in the directory
	public void print() {
		System.out.println("Existing Files: ");
		files.forEach(f -> System.out.println(f));

	}

	// add all the files in the files arrayList
	public ArrayList<File> fillFiles() {
		File[] directoryFiles = Dfiles.listFiles();

		files.clear();

		for (int i = 0; i < directoryFiles.length; i++) {
			if (directoryFiles[i].isFile()) {
				files.add(directoryFiles[i]);
			}
		}
		Collections.sort(files);
		return files;
	}

	// getting all the files
	public ArrayList<File> getFiles() {

		fillFiles();
		return files;
	}

}
