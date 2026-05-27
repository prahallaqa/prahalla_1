package utility;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Baseclass extends ListernersLogic {
	@Parameters("browserName")
	@BeforeMethod
	public void browserLaunch(@Optional("chrome") String whichBrowser) {
		if (whichBrowser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if (whichBrowser.equals("edge")) {
			driver = new EdgeDriver();
		}
		if (whichBrowser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		   // ✅ VERY IMPORTANT LINE
		ListernersLogic.driver = driver;
	    

		driver.get("https://medikart.co.in//");
		driver.manage().window().maximize();
		System.out.println("Site launched");

	}

	@AfterMethod
	public void browserQuit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
