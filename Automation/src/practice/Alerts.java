package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://grotechminds.com/javascript-popup/");
		// Click button which opens popup
		driver.findElement(By.className("btnjs")).click();
		// Switch to alert
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept(); // click OK
	}
}
