package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class file_Upload {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/upload");
		WebElement fileinput = driver.findElement(By.id("fileInput"));
		// fileinput.click();
		fileinput.sendKeys("C:\\Users\\prahalla.perumalla\\Downloads\\time sheet.txt");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
	}
}
