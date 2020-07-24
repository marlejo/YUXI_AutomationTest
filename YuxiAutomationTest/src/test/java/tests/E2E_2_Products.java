package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.CartPage;
import pages.CheckOutCompletePage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.MainPage;
import pages.CheckOutOverviewPage;

public class E2E_2_Products {
	
	private static WebDriver driver;
	static LoginPage loginPage;
	static MainPage mainPage;
	static CartPage cartPage;
	static CheckOutPage checkOutPage;
	static CheckOutOverviewPage checkOutOverviewPage;
	static CheckOutCompletePage checkOutCompletePage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		loginPage = new LoginPage(driver);
		driver = loginPage.chromeDriverConnection();
		loginPage.visit("https://www.saucedemo.com/");
		mainPage = new MainPage(driver);
		cartPage = new CartPage(driver);
		checkOutPage = new CheckOutPage(driver);
		checkOutOverviewPage = new CheckOutOverviewPage(driver);
		checkOutCompletePage = new CheckOutCompletePage(driver);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Test
	public void buyTwoItems() {
		/*E2E test to buy two products (The products need to be Sauce Labs Onesie and Sauce Labs Bike
		Light) with the performance_glitch_user and from the products page
		*/
		loginPage.loginPerformanceGlitchUser();
		mainPage.buySauceLabsOnesie();
		mainPage.buySauceLabsBikeLight();

		//Verify the labels in the “Your Cart” page
		mainPage.goToCartPage();
		assertTrue(cartPage.getText(cartPage.firstItemLabel).contains("Sauce Labs Onesie"));
		assertTrue(cartPage.getText(cartPage.secondItemLabel).contains("Sauce Labs Bike Light"));
		
		//Add and remove an item from the cart
		cartPage.removeSecondItem();
		assertFalse(cartPage.isDisplayed(cartPage.secondItemLabel));
		cartPage.goToMainPage();
		mainPage.buySauceLabsBikeLight();
		mainPage.goToCartPage();
		assertTrue(cartPage.getText(cartPage.secondItemLabel).contains("Sauce Labs Bike Light"));
		
		//Validations for the “Checkout your information” fields
		cartPage.goToCheckOutInformationPage();
		checkOutPage.fillCheckoutInformation();
		assertTrue(checkOutPage.getValue(checkOutPage.firstNameInput).equals("Mauricio"));
		assertTrue(checkOutPage.getValue(checkOutPage.lastNameInput).equals("Ramirez"));
		assertTrue(checkOutPage.getValue(checkOutPage.postalCodeInput).equals("630001"));
		
		//Finish the buy process
		checkOutPage.finishCheckOut();
		assertTrue(checkOutOverviewPage.getText(checkOutOverviewPage.totalPriceLabel).contains("19.42"));
		checkOutOverviewPage.finishBuyProcess();
		assertTrue(checkOutCompletePage.getText(checkOutCompletePage.thankyouLabel).equals("THANK YOU FOR YOUR ORDER"));
	}

}
