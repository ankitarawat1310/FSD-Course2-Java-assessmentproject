package com.lockers.lockedme.screens;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.lockers.lockedme.services.Directory;

public class FileOptionsScreen implements Screen {

	private Directory dir = new Directory();
	private ArrayList<String> options = new ArrayList<>();

	public FileOptionsScreen() {
		options.add("1. Add a File");
		options.add("2. Delete a File");
		options.add("3. Search a File");
		options.add("4. Return to Menu");
	}

	/**
	 * Show: displaying the file option menu
	 * 
	 * @author ankitarawat
	 *
	 */
	@Override
	public void Show() {
		System.out.println("File options Menu");
		System.out.println("----------------------------");
		for (String s : options) {
			System.out.println(s);
		}

	}

	/**
	 * NavigateOption: navigateing to file menu options
	 * 
	 * @author ankitarawat
	 *
	 */
	@Override
	public void NavigateOption(int option) {

		switch (option) {
		case 1:// call Create file

			System.out.println("----------------------------------");
			this.CreateFile();

			this.Show();
			break;

		case 2:// call Delete file
			System.out.println("----------------------------------");
			this.DeleteFile();

			this.Show();
			break;

		case 3:// call search File
			System.out.println("----------------------------------");
			this.SearchFile();

			this.Show();
			break;

		default:
			System.out.println("----------------------------------");
			System.out.println("Invalid Option");
			break;
		}
	}

	/**
	 * CreateFile: creating file the specified path
	 * 
	 * @author ankitarawat
	 *
	 */
	public void CreateFile() {
		System.out.println("Please Enter the Filename: ");
		String filename = this.getInputString();
		System.out.println("You are adding file named: " + filename);

		try {
			Path path = FileSystems.getDefault().getPath(Directory.name + filename).toAbsolutePath();
			File file = new File(dir.getName() + filename);

			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
				dir.getFiles().add(file);
			} else {
				System.out.println("This file already Exists, no need to add another one");
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	/**
	 * DeleteFile: deleting file where name will be entered by user
	 * 
	 * @author ankitarawat
	 *
	 */
	public void DeleteFile() {
		System.out.println("Please Enter the Filename: ");
		String filename = this.getInputString();
		System.out.println("You are deleting file named: " + filename);

		Path path = FileSystems.getDefault().getPath(Directory.name + filename).toAbsolutePath();
		File file = path.toFile();

		if (file.delete()) {
			System.out.println("Deleted Files: " + file.getName());
			dir.getFiles().remove(file);
		} else {
			System.out.println("Failed to delete file: " + filename + ", file was not found.");
		}

	}

	/**
	 * SearchFile: searching a file where name will be provided by user
	 * 
	 * @author ankitarawat
	 *
	 */
	public void SearchFile() {
		Boolean found = false;
		System.out.println("Please Enter the filename");
		String filename = this.getInputString();

		System.out.println("You are searching for the file namd: " + filename);

		ArrayList<File> files = dir.getFiles();

		for (int i = 0; i < files.size(); i++) {
			if (files.get(i).getName().equals(filename)) {
				System.out.println("Found " + filename);
				found = true;
			}
		}

		if (found == false) {
			System.out.println("File not found");
		}
	}

	/**
	 * GetUserInput: navigate to user defined option entered by user
	 * 
	 * @author ankitarawat
	 *
	 */
	@Override
	public void GetUserInput() {
		// TODO Auto-generated method stub
		int selectedOption;
		while ((selectedOption = this.getOption()) != 4) {
			this.NavigateOption(selectedOption);
		}
	}

	/**
	 * getInputString:for file name provided by user
	 * 
	 * @author ankitarawat
	 *
	 */
	private String getInputString() {
		Scanner in = new Scanner(System.in);
		return (in.nextLine());
	}

	/**
	 * getOption: user entered option to navigate to different options
	 * 
	 * @author ankitarawat
	 *
	 */
	private int getOption() {
		Scanner in = new Scanner(System.in);
		int returnOption = 0;
		try {
			returnOption = in.nextInt();
		} catch (InputMismatchException ex) {
			System.out.println("Invalid input");
		}
		return returnOption;

	}

}
