package medicart_Pharmacy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Registration {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://medikart.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Site launched");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space(text())='Login / Register']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn.create-account-button")).click();
		driver.findElement(By.id("reg_whatsapp_phone")).sendKeys("9963960661");
		driver.findElement(By.id("reg_email")).sendKeys("prahallaqa@gmail.com");
		driver.findElement(By.id("send_whatsapp_otp")).click();
		Thread.sleep(15000);
		
		driver.findElement(By.xpath("//button[type='submit']")).click();
		System.out.println("Registration done");
	}
}
