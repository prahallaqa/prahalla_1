package Auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class actions {
	public static void main(String[] args) throws InterruptedException {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		Actions a = new Actions(driver);
		a.moveToElement(submit).click().perform();

		System.out.println("Login Successfully done");

		WebElement Access = driver.findElement(By.xpath("//span[text()='Access & Permissions']"));
		Access.click();

		WebElement Groups = driver.findElement(By.xpath("//span[text()='Groups']"));
		Groups.click();

		WebElement newgroup = driver.findElement(By.xpath("//button[@title='Add New Group']"));
		newgroup.click();
		

		WebElement logout = driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		logout.click();
		System.out.println("add new group done");
		
		WebElement SignOut = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		SignOut.click();

		ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'btn-success')]"));
		System.out.println("Logout succesfully done");
		driver.quit();
	}
}
