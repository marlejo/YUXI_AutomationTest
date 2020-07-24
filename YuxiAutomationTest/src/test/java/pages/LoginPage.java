package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class LoginPage extends Base{

	public By userNameInput = By.id("user-name");
	public By passwordInput = By.id("password");
	public By LoginBtn = By.id("login-button");
	public By erroMessage = By.cssSelector("div#login_button_container > div > form > h3");
	
	public static final String STANDARD_USER = "standard_user";
	public static final String LOCKED_OUT_USER = "locked_out_user";
	public static final String PROBLEM_USER = "problem_user";
	public static final String PERFORMANCE_GLITCH_USER = "performance_glitch_user";
	public static final String PASSWORD = "secret_sauce";
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void loginStandardUser() {
		waitToBeClickable(LoginBtn);
		type(STANDARD_USER, userNameInput);
		type(PASSWORD, passwordInput);
		clic(LoginBtn);
	}
	
	public void loginLockedOutUser() {
		waitToBeClickable(LoginBtn);
		type(LOCKED_OUT_USER, userNameInput);
		type(PASSWORD, passwordInput);
		clic(LoginBtn);
	}
	
	public void loginProblemUser() {
		waitToBeClickable(LoginBtn);
		type(PROBLEM_USER, userNameInput);
		type(PASSWORD, passwordInput);
		clic(LoginBtn);
	}
	
	public void loginPerformanceGlitchUser() {
		waitToBeClickable(LoginBtn);
		type(PERFORMANCE_GLITCH_USER, userNameInput);
		type(PASSWORD, passwordInput);
		clic(LoginBtn);
	}
	
	public void cleanInputs() {
		cleanInput(userNameInput);
		cleanInput(passwordInput);		
	}
	

}
