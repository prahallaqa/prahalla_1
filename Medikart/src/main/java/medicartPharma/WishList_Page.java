package medicartPharma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishList_Page {
	WebDriver driver;
	public WishList_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder='Search for products']")
	WebElement Search_Product;
	@FindBy(xpath="//a[@title='My account']//span[@class='wd-tools-inner']")
	WebElement MyAccount;
	@FindBy(xpath="//nav[@aria-label='Account pages']//a[normalize-space()='Wishlist']")
	WebElement WishList;
	@FindBy(xpath="//a[@class='open-quick-view quick-view-button']")
	WebElement QuickViewbutton;
	@FindBy(xpath="//button[normalize-space(text())='Add to cart']")
	WebElement AddToCart;
	
	
}
