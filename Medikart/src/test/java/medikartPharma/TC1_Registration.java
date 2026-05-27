package medikartPharma;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import medicartPharma.Registartion_Page;
import utility.Baseclass;
import utility.RetryLogic;

@Listeners(utility.ListernersLogic.class)
public class TC1_Registration extends Baseclass {
	
	@Test (retryAnalyzer=RetryLogic.class) 
	
	public void Registration_withvalidcredential() throws InterruptedException {
		Reporter.log("Chrome Browser is launched");
		Registartion_Page rp = new Registartion_Page(driver);
		rp.Login_Registor();
		rp.Create_Account_Button();
		rp.LoginThrowWhatsappNo("9963960661", "prahallaqa@gmail.com");
		Reporter.log(" LoginThrowWhatsappNo is done");
	}
}