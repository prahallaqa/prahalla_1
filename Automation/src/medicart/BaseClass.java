package medicart;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	WebDriver driver;
 	@BeforeMethod
 	@Parameters({"Browser", "URL"})
	public void Base(String Browser, String URL) throws InterruptedException
	{
 		if(Browser.equalsIgnoreCase("chrome"))
 		{
 			driver = new ChromeDriver();
 		}
 		if(Browser.equalsIgnoreCase("edge"))
 		{
 			driver = new EdgeDriver();
 		}
 	
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	System.out.println("site launched");
	Thread.sleep(2000);
	
	}

 	 @AfterMethod
     public void tearDown() {
         if (driver != null) {
             driver.quit();
         }
     }}


