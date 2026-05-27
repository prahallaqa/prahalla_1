package practice;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class abcd {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");

		// Step 1: Enter text
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("india");

		// Step 2: Wait for suggestions to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> suggestions = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li")));

		// Step 3: Loop & select required suggestion
		for (WebElement suggestion : suggestions) {
			System.out.println(suggestion.getText());
			if (suggestion.getText().equalsIgnoreCase("india map")) {
				suggestion.click();
				break; 
			}
		}
	}
}
