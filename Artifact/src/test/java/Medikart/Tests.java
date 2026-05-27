package Medikart;
import org.testng.annotations.Test;
public class Tests extends BaseClass {

	@Test
	public void sampleTest() {
		driver.get("https://www.google.com");
		System.out.println("Running test using BaseTest");
	}
}
