package com.enuygundemo.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage { //LoginPage inherits all functions from BasePage
	
	private By mailField = By.id("_0.o6fq4xrrot9");
	private By passwordField = By.id("_0.hz9dgfelmfw");
	private By loginButtonField = By.className("sc-dcJsrY bszgPd");
	private By errorMessageField = By.cssSelector("//*[@id=\"headlessui-description-:r2j:\"]/div/div/div/div");
	
	
	public void setMail(String mail) {
		set(mailField, mail); // inherited func
		
	}
	
	public void setPassword(String password) {
		set(passwordField, password);
	}
	public FlightsPage clickLoginButton() { //transition method
		click(loginButtonField);
		return  new FlightsPage();
	}
	public FlightsPage logIntoApp(String mail, String password) {
		setMail(mail);
		setPassword(password);
		return clickLoginButton();		
	}
	
	public String getErrorMessage() {
		return find(errorMessageField).getText();
	}
	
}
