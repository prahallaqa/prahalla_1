package medicartPharma;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search_Page {

	
	WebDriver driver;

	public Search_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Search for products']")
	WebElement SearchField;

	public void searchobject(String SerachObj) {
		SearchField.sendKeys(SerachObj);
		SearchField.sendKeys(Keys.ENTER);
	}

	@FindBy(xpath = "//h3[@class='wd-entities-title']/a")
	List<WebElement> TotalLinks;

	
	
}
