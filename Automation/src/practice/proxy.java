package practice;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class proxy {
	public static void main(String[] args) {
		// Create proxy object
		Proxy proxy = new Proxy();
		// Set proxy server
		proxy.setHttpProxy("ipaddress:port");
		// Chrome options
		ChromeOptions options = new ChromeOptions();
		// Add proxy
		options.setProxy(proxy);
		// Launch browser
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
	}
}
