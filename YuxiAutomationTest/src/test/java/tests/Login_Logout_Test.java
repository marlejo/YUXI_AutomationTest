package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import pages.MainPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Login_Logout_Test {
	
	private static WebDriver driver;
	static LoginPage loginPage;
	static MainPage mainPage;

	@BeforeClass
	public static void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		driver = loginPage.chromeDriverConnection();
		loginPage.visit("https://www.saucedemo.com/");
		mainPage = new MainPage(driver);
	}

	@AfterClass
	public static void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void A_loginStandarUserTest() {
		loginPage.loginStandardUser();
		assertTrue(mainPage.getText(mainPage.productsLabel).equals("Products"));
	}
	
	@Test
	public void B_logoutStandardUserTest() {
		mainPage.logout();
		assertTrue(loginPage.isDisplayed(loginPage.LoginBtn));
	}
	
	@Test
	public void C_loginLockedOutUserTest() {
		loginPage.loginLockedOutUser();
		assertTrue(loginPage.getText(loginPage.erroMessage).contains("Epic sadface: "));
	}
	
	@Test
	public void D_loginProblemUserTest() {
		loginPage.cleanInputs();
		loginPage.loginProblemUser();
		assertTrue(mainPage.getText(mainPage.productsLabel).equals("Products"));
	}
	
	@Test
	public void E_logoutProblemUserTest() {
		mainPage.logout();
		assertTrue(loginPage.isDisplayed(loginPage.LoginBtn));
	}

}
