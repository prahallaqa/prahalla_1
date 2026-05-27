package medicartPharma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order_page {

	WebDriver driver;

	public Order_page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Hello, perumallaprahallareddy')]")
	WebElement name;

	@FindBy(xpath = "//nav[@aria-label='Account pages']//a[normalize-space()='Orders']")
	WebElement Orders;

	public void Order() {
		name.click();
		Orders.click();
	}

}
