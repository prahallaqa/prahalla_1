package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


	public class BrowserLanguage {

	    public static void main(String[] args) {

	        ChromeOptions options = new ChromeOptions();

	        // Set browser language
	        options.addArguments("--lang=en");

	        WebDriver driver = new ChromeDriver(options);

	        driver.get("https://www.google.com");
	    }
}
