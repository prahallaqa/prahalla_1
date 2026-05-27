package medikartPharma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wishlist {
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
	driver.findElement(By.xpath("//ul[@id='menu-main-navigation']")).click();
	WebElement pra=driver.findElement(By.xpath("//a[@title='My account']//span[@class='wd-tools-inner']"));
			pra.click();
			System.out.println(pra.getText());
	
	driver.findElement(By.xpath("//nav[@aria-label='Account pages']//a[normalize-space()='Wishlist']")).click();
	driver.findElement(By.xpath("//a[@class='open-quick-view quick-view-button']")).click();
	driver.findElement(By.xpath("//button[normalize-space(text())='Add to cart']")).click(); 
}}
