package medicart_Pharmacy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Addtocart {
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
		driver.findElement(By.xpath("//a[normalize-space(text())='Proceed to checkout']")).click();
		System.out.println("proceed to checkout done");
		// driver.findElement(By.xpath("//a[text()='Checkout']")).click();
		driver.findElement(By.id("billing_first_name")).sendKeys("prah");
		driver.findElement(By.id("billing_last_name")).sendKeys("p");
		driver.findElement(By.id("billing_address_1")).sendKeys("address1");
		driver.findElement(By.id("billing_address_2")).sendKeys("address2");
		driver.findElement(By.id("billing_city")).sendKeys("city");
		Thread.sleep(2000);
		WebElement options = driver.findElement(By.xpath("//span[@id='select2-billing_state-container']"));
		options.click();
		WebElement options2 = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		options2.sendKeys("telangana");
		options2.sendKeys(Keys.ENTER);
		driver.findElement(By.id("billing_postcode")).sendKeys("506134");
		driver.findElement(By.id("billing_phone")).sendKeys("8797656789");
		driver.findElement(By.id("billing_email")).sendKeys("jhbhjbj@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("place_order")).click();
		System.out.println("place order done");

		
		
		WebElement order_cmpt = driver.findElement(By.xpath("//li[@class='total']/strong/span"));
		System.out.println(order_cmpt.getText());
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		System.out.println("shifted to iframe");
		WebElement recom=driver.findElement(By.xpath("//span[@data-testid='Recommended']"));
		System.out.println(recom.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-testid='checkout-close']")).click();
		driver.findElement(By.xpath("//button[@data-testid='confirm-positive']")).click();
		
		
		//driver.quit();
	}
}
