package medikartPharma;
import org.testng.annotations.Test;
import medicartPharma.Login_Page;
import utility.Baseclass;
import utility.RetryLogic;

public class TC2_Login extends Baseclass {
	
	@Test (retryAnalyzer=RetryLogic.class)
	public void Login() throws InterruptedException {	
//		Registartion_Page rp = new Registartion_Page(driver);
		Login_Page lp = new Login_Page(driver);//parameterized 
		lp.Login_Text();
		lp.Login("perumallaprahallareddy@gmail.com", "Prahalla@2026");
		
				
	}}

