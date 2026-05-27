package makeMyTrip;

import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(2000);
		driver.findElement(By.className("commonModal__close")).click();
//		Thread.sleep(3000);
//		WebElement mobile = driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']"));
//		Thread.sleep(2000);
//		mobile.click();
//		mobile.sendKeys("8074872941" +Keys.TAB);
//		System.out.println("phone number enterd");
//		Thread.sleep(2000);
//		WebElement Continuebtn = driver.findElement(By.xpath("//button[@data-cy='continueBtn']"));
//		Continuebtn.click();
//		System.out.println("continue");
		driver.findElement(By.xpath("//span[text()='Flights']")).click();
		Thread.sleep(6000);

		WebElement oneWay = driver.findElement(By.xpath("//li[@data-cy='roundTrip']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", oneWay);

		System.out.println("oneway selected");
		Thread.sleep(3000);

		WebElement from = driver.findElement(By.xpath("//span[text()='From']"));

		js.executeScript("arguments[0].click();", from);
		Thread.sleep(3000);

		WebElement fromcity = driver.findElement(By.xpath("//input[@placeholder='From']"));
		fromcity.sendKeys("Hyderabad");
		Thread.sleep(2000);

		WebElement fromcity1 = driver.findElement(By.xpath("//p[text()='Rajiv Gandhi International Airport']"));
		fromcity1.click();
		System.out.println("From city selected successfully");
		Thread.sleep(2000);

		WebElement To = driver.findElement(By.xpath("//span[text()='To']"));
		To.click();
		// js.executeScript("arguments[0].click();", To);
		Thread.sleep(3000);

		WebElement to1 = driver.findElement(By.xpath("//input[@placeholder='To']"));
		to1.sendKeys("Goa");
		Thread.sleep(2000);

		WebElement to2 = driver.findElement(By.xpath("//p[text()='Goa Dabolim International Airport']"));
		to2.click();
		System.out.println("to city selected successfully");

		WebElement departureLabel = driver.findElement(By.xpath("//label[@for='departure']"));
		js.executeScript("arguments[0].click();", departureLabel);
		System.out.println("departure is clicked");

		WebElement date28 = driver.findElement(By.xpath("//p[text()='27']"));
		js.executeScript("arguments[0].click();", date28);
		System.out.println("date 1 clicked successfully");

		WebElement date = driver.findElement(By.xpath("//p[text()='28']"));
		js.executeScript("arguments[0].click();", date);
		System.out.println("date2 clicked successfully");

		WebElement date2 = driver.findElement(By.xpath("//a[text()='Search']"));
		js.executeScript("arguments[0].click();", date2);
		System.out.println("search clicked successfully");
	}
}
