package com.lockers.lockedme.screens;

/**
 * Screen: interface which declares the method which needs to be implemented by
 * class for ex- WelcomeScreen and FileOptionScreen
 * 
 * @author ankitarawat
 *
 */
public interface Screen {

	public void Show();

	public void NavigateOption(int option);

	public void GetUserInput();

}
