package medicart_Pharmacy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Orders {
public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://medikart.co.in/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	System.out.println("Site launched");
	Thread.sleep(3000);
	
	
	
	
	driver.findElement(By.xpath("//span[contains(text(),'Hello, perumallaprahallareddy')]")).click();
	driver.findElement(By.xpath("//nav[@aria-label='Account pages']//a[normalize-space()='Orders']")).click();
	
}
}
