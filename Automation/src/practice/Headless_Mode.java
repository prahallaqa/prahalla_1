package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless_Mode {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		System.out.println("page opened");
	}
}















































































