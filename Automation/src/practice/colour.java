package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class colour {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		Thread.sleep(3000);
		WebElement e1 = driver.findElement(By.id("nav-search-submit-button"));
		String s1 = e1.getCssValue("color");
		String s2 = e1.getCssValue("background-color");
		System.out.println(s1);
		System.out.println(s2);
	}
}
