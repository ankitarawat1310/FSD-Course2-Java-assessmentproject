package com.lockers.lockedme.services;

import com.lockers.lockedme.screens.FileOptionsScreen;
import com.lockers.lockedme.screens.Screen;
import com.lockers.lockedme.screens.WelcomeScreen;

/**
 * Screen services will create object of screens and will initialize with the
 * current screen
 * 
 * @author ankitarawat
 *
 */
public class ScreenService {
	public static WelcomeScreen WelcomeScreen = new WelcomeScreen();

	public static FileOptionsScreen FileOptionsScreen = new FileOptionsScreen();

	public static Screen CurrentScreen = WelcomeScreen;

	// getting current screen
	public static Screen getCurrentScreen() {
		return CurrentScreen;
	}

	// setting current screen
	public static void setCurrentScreen(Screen currentScreen) {
		CurrentScreen = currentScreen;

	}

}
