package medikartPharma;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import medicartPharma.Search_Page;
import utility.Baseclass;
import utility.RetryLogic;

public class TC3_Search  extends Baseclass{
	@Test (retryAnalyzer=RetryLogic.class)
	public void Search() throws InterruptedException {

//		Registartion_Page rp = new Registartion_Page(driver);
//		rp.GoTo();
		Search_Page sp = new Search_Page(driver);
		sp.searchobject("Blood Pressure Monitor");

//		List<WebElement> totallinks = driver.findElements(By.xpath("//h3[@class='wd-entities-title']/a"));
//		List<String> textofeach = new ArrayList<>();
//		for (WebElement togettext : totallinks) {
//			textofeach.add(togettext.getText());
//		}
//		for (String containstext : textofeach) {
//			if (containstext.contains("Blood Pressure Monitor")) {
//				System.out.println(containstext + "-->Search get Successes");
//				// break;
//			} else {
//				System.out.println(containstext + "-->Search get failed");
//			}

		List<WebElement> results = sp.getAllSearchResults();

		for (WebElement result : results) {
			String text = result.getText();
			if (text.contains("Blood Pressure Monitor")) {
				System.out.println(text + " --> Search Success");
			} else {
				System.out.println(text + " --> Search Failed");
			}
		}
	}
}
