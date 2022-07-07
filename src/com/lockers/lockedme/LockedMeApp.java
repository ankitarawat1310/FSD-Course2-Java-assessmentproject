package com.lockers.lockedme;

import com.lockers.lockedme.screens.WelcomeScreen;

/**
 * main method to initiate the run of application
 * 
 * @author ankitarawat
 *
 */
public class LockedMeApp {
	public static void main(String[] args) {

		WelcomeScreen welcome = new WelcomeScreen();
		welcome.introWS();
		welcome.GetUserInput();
	}

}
