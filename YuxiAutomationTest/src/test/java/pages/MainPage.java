package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.Base;

public class MainPage extends Base{
	
	public By menuBtn = By.cssSelector("div#menu_button_container > div > div:nth-of-type(3) > div > button");
	public By shoppingCartBtn = By.cssSelector("div#shopping_cart_container > a > svg");
	public By fifthAddToCartBtn = By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[5]/div[3]/button");
	public By secondAddToCartBtn = By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/div[2]/div[3]/button");
	public By productsLabel = By.cssSelector("div#inventory_filter_container > div");
	public By logoutSidebarLink = By.id("logout_sidebar_link");

	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	public void logout() {
		clic(menuBtn);
		waitToBeClickable(logoutSidebarLink);
		clic(logoutSidebarLink);
	}

}
