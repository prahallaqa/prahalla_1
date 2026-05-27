package medikartPharma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class jbhjg {

	
	@Test(dataProvider = "loginData", dataProviderClass = DDTExcel.class)
    public void loginTest(String username, String password) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.in/");

        // Click Sign In
        driver.findElement(By.id("nav-link-accountList")).click();

        // Enter Username
        driver.findElement(By.id("ap_email")).sendKeys(username);
        driver.findElement(By.id("continue")).click();

        Thread.sleep(2000);

        // Enter Password
        driver.findElement(By.id("ap_password")).sendKeys(password);
        driver.findElement(By.id("signInSubmit")).click();

        System.out.println("Testing with: " + username + " | " + password);

        Thread.sleep(3000);
        driver.quit();
}
}
