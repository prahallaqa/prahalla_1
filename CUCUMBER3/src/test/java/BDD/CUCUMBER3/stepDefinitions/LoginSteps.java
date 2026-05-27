package BDD.CUCUMBER3.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver;

	@Given("user launches browser")
	public void user_launches_browser() {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
	}

	@When("user opens google")
	public void user_opens_google() {
		//driver.get("https://www.google.com");
	}

	@Then("page title should display")
	public void page_title_should_display() {
//		String title = driver.getTitle();
//		System.out.println("Page Title is: " + title);
//		Assert.assertTrue(title.contains("Google"));
//		driver.quit();
	}
}
