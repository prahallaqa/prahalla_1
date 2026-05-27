package practice;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicitwait {
	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		WebElement e1 = driver.findElement(By.name("q"));// search text box
		List<WebElement> e2 = driver.findElements(By.name("input"));// search text box

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleIs("PRA"));
		wait.until(ExpectedConditions.titleContains("Amazon"));
		wait.until(ExpectedConditions.urlContains("cart"));
		wait.until(ExpectedConditions.urlMatches("(.*)cart(.*)"));
		wait.until(ExpectedConditions.urlToBe("https://www.amazon.in"));
		wait.until(ExpectedConditions.visibilityOf(e1));
		wait.until(ExpectedConditions.visibilityOfAllElements(e2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("1")));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input")));
		wait.until(ExpectedConditions.urlToBe("https://www.amazon.in"));
		wait.until(ExpectedConditions.elementToBeClickable(e1));
		e1.sendKeys("India");
	}
} 
