package medicart_Pharmacy;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logout {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title='My account']//span[@class='wd-tools-inner']")).click();
		driver.findElement(By.xpath(
				"//li[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--customer-logout']//a[contains(text(),'Logout')]"))
				.click();

	}

}
