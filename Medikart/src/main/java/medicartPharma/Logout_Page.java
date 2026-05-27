package medicartPharma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_Page {
	WebDriver driver;
	
	public Logout_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@title='My account']//span[@class='wd-tools-inner']")
	WebElement My_Account;
	
	@FindBy(xpath="/li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']//a[contains(text(),'Logout')]")
	WebElement Logout;
	public void logout()
	{
		My_Account.click();
		Logout.click();
	}
	

}
