package medicart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class ProfileEdit extends BaseClass {


	@Test
	public void ProfileEdit1() throws InterruptedException {
		driver.findElement(By.xpath("//img[@alt='signin_icon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("mobile_number_input")).sendKeys("9963960661");
		driver.findElement(By.id("getOtp")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//img[@alt='profile_icon']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='My Profile']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Manage Profiles']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='Add New Member']")).click();
		Thread.sleep(3000);
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("pRAHALLA");
		WebElement relation = driver.findElement(By.xpath("//span[text()='Select']"));
		relation.click();
		driver.findElement(By.xpath("//div[text()='Mother']")).click();
		driver.findElement(By.xpath("//span[text()='Select Gender']")).click();
		driver.findElement(By.xpath("//div[text()='Female']")).click();
		WebElement save = driver.findElement(By.xpath("//button[text()='Save Changes']"));
		save.click();
		System.out.println("added  one detail successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='Edit Address']")).click();
		WebElement username1 = driver.findElement(By.id("username"));
		username1.clear();
		username1.sendKeys("roja");

		WebElement save1 = driver.findElement(By.xpath("//button[text()='Save Changes']"));
		save1.click();
		System.out.println("edited");
		Thread.sleep(3000);

		WebElement delete = driver.findElement(By.xpath("//img[@alt='default alt']"));
		delete.click();
		System.out.println("delete click done successfully");
		Thread.sleep(1000);

		WebElement search = driver.findElement(By.xpath("//a[text()='Search Medicines or wellness']"));
		search.sendKeys("paracetamol");
		search.click();
		driver.findElement(By.className("button-style MAssured-button-style")).click();
		driver.findElement(By.xpath("//img[alt='Cart icon']")).click();
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		driver.findElement(By.id("full_name")).sendKeys("prahalla");
		driver.findElement(By.id("mobile_no")).sendKeys("1234554321");
		driver.findElement(By.id("address_1")).sendKeys("address");
		driver.findElement(By.id("address_2")).sendKeys("address2");
		driver.findElement(By.id("pincode")).sendKeys("506132");
		driver.findElement(By.className("address_label")).click();
		driver.findElement(By.xpath("//button[text()='Save Address']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	}
}
