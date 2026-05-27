package Medikart;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	protected WebDriver driver;
	
	Properties prop = new Properties();
	

	@BeforeMethod
	public void setUp() throws IOException {
		
		FileInputStream fs = new FileInputStream("C:\\Users\\prahalla.perumalla\\eclipse-workspace\\Artifact\\src\\main\\resources\\config.properties");
		prop.load(fs);
		
		String browser = prop.getProperty("browser");
		
	//	System.getProperties()
		
		System.out.println(browser);
		
		if(browser.equals("chrome"))
		{
		driver = new ChromeDriver();
		
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Wrong Browser");
		}
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
