package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class AirInidaShadowRoot {
	public static void main(String[] args) throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.airindia.com/");
		Thread.sleep(2000);
		WebElement e1 = driver.findElement(By.xpath("//button[text()='Accept All']"));
		e1.click();
		String jspath = "return document.querySelector('#ai-booking-widget > ai-tab-group > ai-tab:nth-child(1) > ai-search-flight > slot-fb > div.ai-search-flight-wrapper > div.ai-search-trip > div > div.ai-search-trip-type > ai-radio-group').shadowRoot.querySelector('#radio0')";
		WebElement e2 = (WebElement) driver.executeScript(jspath);
		e2.click();
	}
}
