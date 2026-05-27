package spicejet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;
import java.time.Duration;

public class Trip {

	static WebDriver driver;
	static WebDriverWait wait;

	@Test(retryAnalyzer = Retry.class)
	public void retrymethod() throws InterruptedException {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize(); 
		System.out.println("site launched");

		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input")).sendKeys("Hyd");
		driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input")).sendKeys("Goa");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 200);");
		Thread.sleep(5000);

		// Open departure calendar
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//div[normalize-space()='June 2026']/parent::div/following-sibling::div//div[normalize-space()='16']"))
				.click();

		driver.findElement(By.xpath("//div[text()='Select Date']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(
				"//div[normalize-space()='June 2026']/parent::div/following-sibling::div//div[normalize-space()='20']"))
				.click();

		driver.findElement(By.xpath("//div[text()='Passengers']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click();
		driver.findElement(By.xpath("//div[@data-testid='Children-testID-plus-one-cta']")).click();
		driver.findElement(By.className("css-1dbjc4n")).click();
	}
}
//	 class Trips implements IRetryAnalyzer{
//		int retryCount = 0;
//		int maxRetryCount = 2; // retry test 2 times
//	@Override
//	public boolean retry(ITestResult result) {
//		if (retryCount < maxRetryCount) {
//			retryCount++;
//			System.out.println(retryCount);
//			return true; // retry test
//		}
//		return false;
//	}
//	}
