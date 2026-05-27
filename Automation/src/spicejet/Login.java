package spicejet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://www.spicejet.com/");
		System.out.println("site launched");
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1jkjb']")).click();
		Thread.sleep(3000);
		driver.findElement( 
				By.xpath("//div[@class='css-76zvg2 r-homxoj r-ubezar r-1ozqkpa'][normalize-space()='Email']")).click();
		driver.findElement(By.xpath("//input[@data-testid='user-mobileno-input-box']"))
				.sendKeys("perumallaprahallareddy@gmail.com");
		driver.findElement(By.xpath("//input[@data-testid='password-input-box-cta']")).sendKeys("Prahalla@1993");
		driver.findElement(By.xpath("//div[@data-testid='login-cta']")).click();
		System.out.println("Login done successfully");
	}
}
