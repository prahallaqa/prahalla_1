package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Alerts2 {
	public static void main(String[] args) throws InterruptedException {
		EdgeDriver driver = new EdgeDriver();
		driver.get("file:///C:/Users/MKT/Desktop/learningHTML1.html");
		driver.switchTo().alert().accept();
		driver.manage().window().maximize();
		/*
		 * WebElement e1= driver.findElement(By.id("121")); if(e1.isDisplayed() &&
		 * e1.isEnabled()) { e1.sendKeys("Tiwari"); driver.close(); } else {
		 * System.out.println("Sorry"); driver.close(); }
		 */
		WebElement checkbox = driver.findElement(By.id("123"));
		if (checkbox.isSelected()) {
			System.out.println("Proceed further");
		} else {
			System.out.println("its not selected lets select it");
			checkbox.click();
		}
	}
}
