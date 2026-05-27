package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestions {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/?zx=1770885541424&no_sw_cr=1");
		System.out.println("site launched");
		driver.findElement(By.name("q")).sendKeys("India");
		Thread.sleep(3000);
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='OBMEnb']/ul/li"));
		int count = list.size();
		System.out.println(count);
		list.get(0).click();
		System.out.println("clicked on the link");
	}
}
