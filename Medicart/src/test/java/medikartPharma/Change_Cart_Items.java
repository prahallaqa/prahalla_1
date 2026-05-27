package medikartPharma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Change_Cart_Items {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://medikart.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Site launched");
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for products']"));
		search.sendKeys("Blood Pressure Monitor");
		search.sendKeys(Keys.ENTER);
		System.out.println("Blood Pressure Monitor searchdone");
		// WebElement product1=
		// driver.findElement(By.xpath("//div[class='wd-product-grid-slide']"));
		WebElement product1 = driver.findElement(By.xpath("//a[text()='Beurer BC-30 Blood Pressure Monitor']"));
		Actions a = new Actions(driver);
		a.moveToElement(product1);
		WebElement addtocart = driver.findElement(By.xpath(
				"//a[@data-success_message='“Beurer BC-30 Blood Pressure Monitor” has been added to your cart']"));
		addtocart.click();
		System.out.println("add to cart done");
		Thread.sleep(3000);
		WebElement plus=driver.findElement(By.cssSelector(".plus.btn"));
		plus.click();
		System.out.println("Increased 2 times");
		WebElement number=driver.findElement(By.xpath("//input[starts-with(@id,'quantity_')]"));
		System.out.println(number.getAttribute("value"));
	}

}
