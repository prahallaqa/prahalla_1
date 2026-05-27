//package medikartPharma;
//
//import java.io.IOException;
//import java.util.logging.LogManager;
//
//import org.junit.Test;
//import org.testng.annotations.DataProvider;
//
//import io.opentelemetry.api.logs.Logger;
//import junit.framework.Assert;
//import medicartPharma.LoginPage;
//
//public class BopLogin extends BaseClass{
//
//	private static Logger log = LogManager.getLogger(Login.class);
//	 
//	LoginPage loginobj;
//	@Test(dataProvider = "LoginCredentials", dataProviderClass = Login.class)
//	@Description("Verify that User Login successfully")
//	@Severity(SeverityLevel.BLOCKER)
// 
//	public void verifyLoginData(String username, String password) throws IOException {
//		log.info("Login User method Started");
//		loginobj = new LoginPage(obj);
//		log.info("Login Page Method call");
//		boolean isLoginSucessful = loginobj.loginData(username, password);
//		Assert.assertTrue(isLoginSucessful, "Login Failed For User : " + username);
//		log.info("Login Test Completed Successfully");
//	}
// 
//	@DataProvider(name = "LoginCredentials")
//	public Object[][] loginData() throws IOException {
//		String userpath = System.getProperty("user.dir");
//		ReadExcelData red = new ReadExcelData(userpath + "\\src\\test\\resources\\utilities\\TestData.xlsx","LoginData");
//		 int rowCount = red.getRowCount();
//		 Object[][] data = new Object[rowCount - 1][2]; // Assuming username/password columns
// 
//		    for (int i = 1; i < rowCount; i++) {
//		        data[i - 1][0] = red.getCellData(i, 0);
//		        data[i - 1][1] = red.getCellData(i, 1);
//		    }
// 
//		    return data;
//	}
//}