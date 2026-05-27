package medicart_Pharmacy;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://medikart.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Site launched");
		Thread.sleep(3000);
		driver.findElement(By.className("wd-tools-text")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("perumallaprahallareddy@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Prahalla@2026");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(20000);
		System.out.println("Login successfully done");
		System.out.println(driver.getTitle());
	}
}
