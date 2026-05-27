package medicartPharma;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart_Page {
	WebDriver driver;

	public AddToCart_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Beurer BC-30 Blood Pressure Monitor']")
	WebElement BPMonitor;

	public void AddtoCart() throws InterruptedException {
		Actions a = new Actions(driver);
		a.moveToElement(BPMonitor);
		AddtoCart.click();
		System.out.println("add to cart done");
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//a[@data-success_message='“Beurer BC-30 Blood Pressure Monitor” has been added to your cart']")
	WebElement AddtoCart;

	@FindBy(xpath = "/a[normalize-space(text())='Proceed to checkout']")
	WebElement Checkout;

	@FindBy(id = "billing_first_name")
	WebElement Billing_FirstName;

	@FindBy(id = "billing_last_name")
	WebElement Billing_LasttName;

	@FindBy(id = "billing_address_1")
	WebElement Billing_Address_1;

	@FindBy(id = "billing_address_2")
	WebElement Billing_Address_2;

	@FindBy(id = "billing_city")
	WebElement city;

	@FindBy(id = "billing_postcode")
	WebElement Billing_Postcode;

	@FindBy(xpath = "//span[@id='select2-billing_state-container']")
	WebElement Billing_state;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	WebElement state;

	@FindBy(id = "billing_phone")
	WebElement Billing_Phone;

	@FindBy(id = "billing_email")
	WebElement Billing_Email;

	@FindBy(id = "terms")
	WebElement Terms;

	@FindBy(id = "place_order")
	WebElement PlaceOrder;

	@FindBy(xpath = "//li[@class='total']/strong/span")
	WebElement OderCompleted;

	@FindBy(xpath = "//span[@data-testid='Recommended']")
	WebElement Recommended;

	@FindBy(xpath = "//button[@data-testid='checkout-close']")
	WebElement Checkkout_Close;

	@FindBy(xpath = "//button[@data-testid='confirm-positive']")
	WebElement Conform_Positive;

	public void Checkout() {
		Checkout.click();
		System.out.println("proceed to checkout done");
	}

	public void Billing() throws InterruptedException {
		Billing_FirstName.sendKeys(null);
		Billing_LasttName.sendKeys(null);
		Billing_Address_1.sendKeys(null);
		Billing_Address_2.sendKeys(null);
		city.sendKeys(null);
		Thread.sleep(3000);
		Billing_state.click();
		//state.sendKeys(telangana + Keys.ENTER);
		Billing_Postcode.sendKeys(null);

		Billing_Phone.sendKeys(null);
		Billing_Email.sendKeys(null);
		Thread.sleep(2000);
		Terms.click();
		PlaceOrder.click();

	}
}
