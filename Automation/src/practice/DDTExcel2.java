package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DDTExcel2 {

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
