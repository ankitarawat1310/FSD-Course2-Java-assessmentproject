package com.lockers.lockedme.screens;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.lockers.lockedme.services.DirectoryService;
import com.lockers.lockedme.services.ScreenService;

public class WelcomeScreen implements Screen {

	private String welcomeText = "Welcome to LockedMe.com Application";
	private String developerNameText = "Created by Ankita Rawat";

	private ArrayList<String> options = new ArrayList<>();

	/**
	 * constructor to initialize the options Array to options we need
	 */
	public WelcomeScreen() {
		options.add("1. Show Files");
		options.add("2. Show Files Options Menu");
		options.add("3. Quit");
	}

	public void introWS() {
		System.out.println("***************************");
		System.out.println(welcomeText);
		System.out.println(developerNameText);
		System.out.println("\n");
		System.out.println("***************************");
		Show();

	}

	// @NavigateOption method will help the user to navigate to the respective
	// menu***/
	@Override
	public void NavigateOption(int option) {
		// TODO Auto-generated method stub
		switch (option) {
		case 1:// To Show Files
			System.out.println("***************************");
			this.ShowFiles();
			System.out.println("***************************");
			this.Show();

			break;
		case 2:// Show File Option menu
			ScreenService.setCurrentScreen(ScreenService.FileOptionsScreen);
			ScreenService.getCurrentScreen().Show();
			ScreenService.getCurrentScreen().GetUserInput();
			this.Show();
			break;
		case 3:// Quit the application
			System.out.println("****************************");
			System.exit(0);
			System.out.println("Application closed");
			break;
		default:
			System.out.println("Invalid Option");
			break;

		}

	}

	/**
	 * Show files: print list of files
	 * 
	 * @author ankitarawat
	 *
	 */
	public void ShowFiles() {
		System.out.println("List of Files: ");
		System.out.println("---------------------------------");
		DirectoryService.PrintFiles();
	}

	/**
	 * GetUserInput: getting uder input from user
	 * 
	 * @author ankitarawat
	 *
	 */
	@Override
	public void GetUserInput() {
		// TODO Auto-generated method stub
		int selectedOption = 0;
		while ((selectedOption = this.getOption()) != 3) {
			this.NavigateOption(selectedOption);
		}

	}

	/**
	 * Show: displaying Main Menu
	 * 
	 * @author ankitarawat
	 *
	 */
	@Override
	public void Show() {
		System.out.println("Main Menu: ");
		for (String s : options) {
			System.out.println("***************************");
			System.out.println(s);
		}

	}

	/**
	 * getOption: getting input from user
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

		}
		return returnOption;

	}

}
