package medicartPharma;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Logout_Page {
	
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
