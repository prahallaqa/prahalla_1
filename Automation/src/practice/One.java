package practice;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class One {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("C:\\Users\\prahalla.perumalla\\Downloads\\new.html");
		String parentWindow = driver.getWindowHandle();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) {
			// Re-locate elements to avoid stale element issue
			links = driver.findElements(By.tagName("a"));
			WebElement link = links.get(i);
			link.click();
			Set<String> windows = driver.getWindowHandles();
			if (windows.size() > 1) {
				// New tab opened
				for (String window : windows) {
					if (!window.equals(parentWindow)) {
						driver.switchTo().window(window);
						System.out.println("New Tab Title: " + driver.getTitle());
						driver.close();
					}
				}
				driver.switchTo().window(parentWindow);
			} else {
				// Same tab navigation
				System.out.println("Same Tab Title: " + driver.getTitle());
				driver.navigate().back();
			}
		}
		driver.quit();
	}
}
