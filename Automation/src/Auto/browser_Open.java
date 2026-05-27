package Auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class browser_Open {

	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Explicit wait Syntax
		// WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		// WebElement element =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(" ")));
		// Fluent Wait Syntax
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//		        .withTimeout(Duration.ofSeconds(30))
//		        .pollingEvery(Duration.ofSeconds(5))
//		        .ignoring(NoSuchElementException.class);
//
//		WebElement element = wait.until(driver -> driver.findElement(By.id("username")));
//		element.sendKeys("admin");

		driver.get("http://192.168.2.27:9091/");

		String title = driver.getTitle();
		System.out.println("Title of the page is: " + title);
		if (title.equals("BackOffice")) {
			System.out.println("UR is in corect page");
		} else {
			System.out.println("UR not corect page");
		}
		// login
		WebElement login = driver.findElement(By.id("LoginId"));
		login.sendKeys("Prahalla");
		WebElement password = driver.findElement(By.id("Password"));
		password.sendKeys("User@123");
		password.click();
		// driver.findElement(By.xpath("//button[contains(@class,'btn-block')]"));
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		System.out.println("Login Successfully done");
		Thread.sleep(3000);
		WebElement logout = driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		logout.click();

		WebElement logout1 = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		logout1.click();

		WebElement yes = driver.findElement(By.xpath("//button[@class='btn btn-sm btn-success']"));
		yes.click();
		System.out.println("Logout succesfully done");
		driver.quit();
	}
}
