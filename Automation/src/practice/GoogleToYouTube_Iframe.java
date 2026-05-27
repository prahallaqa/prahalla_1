package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleToYouTube_Iframe {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// 🔹 Click 9 dots (Google Apps)
		WebElement apps = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Google apps']")));
		apps.click();

		// 🔹 Switch to iframe (IMPORTANT)
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@role='presentation']")));

		// 🔹 Click YouTube
		WebElement youtube = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='YouTube']")));
		youtube.click();

		// 🔹 Switch back to main content
		driver.switchTo().defaultContent();

		// 🔹 Handle new tab/window
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}
		}

		// 🔹 Click any channel (example: first channel/video)
		WebElement channel = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='channel-name'])[1]")));
		channel.click();

		// 🔹 Take Screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File("C:\\Users\\YourName\\Desktop\\youtube.png");
		FileUtils.copyFile(src, dest);

		System.out.println("Screenshot taken");

		driver.quit();
	}
}
