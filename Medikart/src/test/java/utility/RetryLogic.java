package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {

	int initialcount = 0;
	int maxcount = 2;

	@Override
	public boolean retry(ITestResult result) {
		if (initialcount < maxcount) { //0<2  1<2  2<2
			initialcount++;  //1  2
			return true;
		} 
		return false;
	}
}
