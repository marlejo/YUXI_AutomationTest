package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class CheckOutOverviewPage extends Base{
	
	public By cancelBtn = By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[8]/a[1]");
	public By finishBtn = By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[8]/a[2]");
	public By totalPriceLabel = By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div[7]");

	public CheckOutOverviewPage(WebDriver driver) {
		super(driver);
	}
	
	public void finishBuyProcess() {
		clic(finishBtn);
	}

}
