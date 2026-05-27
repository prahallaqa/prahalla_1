package medicartPharma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registartion_Page {
	WebDriver driver;

	public Registartion_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space(text())='Login / Register']")
	WebElement Registration;

	@FindBy(css = ".btn.create-account-button")
	WebElement Create_Account_Button;

	@FindBy(id = "reg_whatsapp_phone")
	WebElement Reg_Whatsapp_Phone;

	@FindBy(id = "reg_email")
	WebElement Reg_Email;

	@FindBy(id = "send_whatsapp_otp")
	WebElement Send_Whatsapp_Otp;

	@FindBy(xpath = "//button[type='submit']")
	WebElement Submit_Button;

	public void LoginThrowWhatsappNo(Integer Whatsappno, String Email, Integer Otp) {
		Reg_Whatsapp_Phone.sendKeys("Whatsappno");
		Reg_Email.sendKeys("Email");
		Send_Whatsapp_Otp.sendKeys("otp");
		Submit_Button.click();
	}

	public void GoTo() {
		driver.get("https://medikart.co.in//");
	}

}
