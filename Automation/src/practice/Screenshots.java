package practice;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {
	public static void main(String[] args) throws IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		LocalDateTime obj = LocalDateTime.now();
		System.out.println(obj);
		DateTimeFormatter obj1 = DateTimeFormatter.ofPattern("yyMMdd_hhmmss");
		String timestamp = obj.format(obj1);
		System.out.println(timestamp);
		TakesScreenshot ts = driver; // upcasting
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("D:\\prahalla" + timestamp + ".png");
		FileHandler.copy(source, destination);
		// FileUtils.copyFile(source, destination);
	}
}
