package medikartPharma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import medicartPharma.Order_page;
import medicartPharma.Registartion_Page;

public class Orders {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//		Registartion_Page rp = new Registartion_Page(null);
//		rp.GoTo();
		Order_page op = new Order_page(driver);
		op.Order();
	}
}
