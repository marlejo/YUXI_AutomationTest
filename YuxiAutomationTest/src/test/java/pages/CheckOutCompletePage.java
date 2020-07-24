package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class CheckOutCompletePage extends Base{
	
	public By thankyouLabel = By.xpath("/html/body/div/div[2]/div[3]/h2");

	public CheckOutCompletePage(WebDriver driver) {
		super(driver);
	}

}
