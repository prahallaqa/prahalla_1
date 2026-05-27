package medicartPharma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	// Step3: c) Initializing your components inside the constructor using Pagefactoryclass
	WebDriver driver;

	public Login_Page(WebDriver driver) {
		//assign value of local.v to global.v using this keyword
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "wd-tools-text")
	WebElement Login_Text;

	public void Login_Text() throws InterruptedException {
		Login_Text.click();
		Thread.sleep(3000);
	}

	// Step1: a) Locating each component using FindBy Annotation
	@FindBy(id = "username")
	WebElement UserName;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit;

	// Step2: b) Creating separate methods of each component to perform its action
	public void Login(String Username, String password) throws InterruptedException {
		UserName.sendKeys(Username);
		Password.sendKeys(password);
		Submit.click();
		Thread.sleep(3000);
		System.out.println("Login successfully done");
		System.out.println(driver.getTitle());
	}
}
