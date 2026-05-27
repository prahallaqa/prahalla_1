package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Shadow_DOM2 {

	public static void main(String[] args) throws InterruptedException {

		EdgeDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("https://xqa.io/practice/shadow-dom");

		Thread.sleep(3000);

		// correct shadow host
		WebElement host = driver.findElement(By.cssSelector("#shadowHost"));

		// move inside shadow root
		SearchContext shadowRoot = host.getShadowRoot();

		// locate element inside shadow dom
		WebElement input = shadowRoot.findElement(By.cssSelector("input"));

		input.sendKeys("praha");
	}
}