package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class CheckOutPage extends Base{
	
	public By firstNameInput = By.id("first-name");
	public By lastNameInput = By.id("last-name");
	public By postalCodeInput = By.id("postal-code");
	public By cancelBtn = By.xpath("/html/body/div/div[2]/div[3]/div/form/div[2]/a");
	public By continueBtn = By.xpath("/html/body/div/div[2]/div[3]/div/form/div[2]/input");
	
	public static final String FIRST_NAME = "Mauricio";
	public static final String LAST_NAME = "Ramirez";
	public static final String ZIP_CODE = "630001";

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	public void fillCheckoutInformation() {
		type(FIRST_NAME, firstNameInput);
		type(LAST_NAME, lastNameInput);
		type(ZIP_CODE, postalCodeInput);
	}
	
	public void finishCheckOut() {
		clic(continueBtn);
	}

}
