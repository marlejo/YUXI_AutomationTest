package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class CartPage extends Base{
	
	public By continueShoppingBtn = By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[1]");
	public By checkOutBtn = By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/a[2]");
	public By firstItemRemoveBtn = By.xpath("/html/body/div/div[2]/div[3]/div/div[1]/div[3]/div[2]/div[2]/button");
	public By secondItemRemoveBtn = By.xpath("/html/body/div/div[2]/div[3]/div/div[1]/div[4]/div[2]/div[2]/button");
	public By firstItemLabel = By.cssSelector("a#item_2_title_link > div");
	public By secondItemLabel = By.cssSelector("a#item_0_title_link > div");
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public void removeSecondItem() {
		clic(secondItemRemoveBtn);
	}
	
	public void goToMainPage() {
		clic(continueShoppingBtn);
	}
	
	public void goToCheckOutInformationPage() {
		clic(checkOutBtn);
	}

}
