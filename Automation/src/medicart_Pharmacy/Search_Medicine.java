package medicart_Pharmacy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Search_Medicine {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://medikart.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Site launched");
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for products']"));
		search.sendKeys("Blood Pressure Monitor");
		search.sendKeys(Keys.ENTER);
		System.out.println("Blood Pressure Monitor searchdone");

		List<WebElement> totallinks = driver.findElements(By.xpath("//h3[@class='wd-entities-title']/a"));
		List<String> textofeach = new ArrayList<>();
		for (WebElement togettext : totallinks) {
			textofeach.add(togettext.getText());
		}
		for (String containstext : textofeach) {
			if (containstext.contains("Blood Pressure Monitor")) {
				System.out.println(containstext + "-->Search get Successes");
				// break;
			} else {
				System.out.println(containstext + "-->Search get failed");
			}

		}
		driver.quit();
	}
}
