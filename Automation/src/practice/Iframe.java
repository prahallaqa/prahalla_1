package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Iframe {
	public static void main(String[] args) throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		Thread.sleep(2000);
		WebElement frameelement = driver.findElement(By.name("login_page"));
		driver.switchTo().frame(frameelement);
		WebElement e1 = driver.findElement(By.name("fldLoginUserId"));
		e1.sendKeys("Pra");
	}
}
