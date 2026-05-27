package practice;

import java.awt.AWTException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FluentWait {
	public static void main(String[] args) throws InterruptedException, AWTException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		// ✅ Correct FluentWait
		org.openqa.selenium.support.ui.FluentWait<ChromeDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(
				driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(NullPointerException.class);
		// Wait for title
		wait.until(ExpectedConditions.titleIs("Google"));
		// Wait for Gmail link and click
		WebElement e1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Gmail")));
		e1.click();
		
	
		
		
		
		
		
		
	}
}
