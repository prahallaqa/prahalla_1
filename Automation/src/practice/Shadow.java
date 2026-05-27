package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Shadow {

	public static void main(String[] args) throws InterruptedException {

		// Launch browser
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Open application
		driver.get("https://www.airindia.com/");
		Thread.sleep(3000);

		// Accept cookies popup
		driver.findElement(By.xpath("//button[text()='Accept All']")).click();
		Thread.sleep(3000);

		// Locate Shadow Host
		WebElement host = driver.findElement(By.cssSelector("ai-radio-group"));

		// Access Shadow Root
		SearchContext shadow = host.getShadowRoot();

		// Locate element inside Shadow DOM
		WebElement radio = shadow.findElement(By.cssSelector("#radio0"));

		// Click radio button
		radio.click();
		System.out.println("Radio button clicked successfully");
		Thread.sleep(3000);
		driver.quit();
	}
}
