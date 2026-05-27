
package medikartPharma;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import medicartPharma.AddToCart_Page;
import medicartPharma.Search_Page;
import utility.Baseclass;
import utility.RetryLogic;

public class TC4_AddtoCart extends Baseclass {
	@Test (retryAnalyzer=RetryLogic.class)
	public void adddtoCart() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
//		Registartion_Page rp = new Registartion_Page(driver);
//		rp.GoTo();

		Search_Page sp = new Search_Page(driver);
		sp.searchobject("Blood Pressure Monitor");

		AddToCart_Page ac = new AddToCart_Page(driver);
		ac.AddtoCart();
		ac.Checkout();

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
//=======

		WebElement order_cmpt = driver.findElement(By.xpath("//li[@class='total']/strong/span"));
		System.out.println(order_cmpt.getText());
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		System.out.println("shifted to iframe");
		WebElement recom = driver.findElement(By.xpath("//span[@data-testid='Recommended']"));
		System.out.println(recom.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@data-testid='checkout-close']")).click();
		driver.findElement(By.xpath("//button[@data-testid='confirm-positive']")).click();

	}

}
