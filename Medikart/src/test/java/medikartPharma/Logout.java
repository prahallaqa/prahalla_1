package medikartPharma;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import medicartPharma.Logout_Page;

public class Logout {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		Logout_Page lo = new Logout_Page(driver);
		lo.logout();
	}
}
