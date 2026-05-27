package spicejet;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int retryCount = 0;
	int maxRetryCount = 2; // retry test 2 times
public boolean retry(ITestResult result) {
	if (retryCount < maxRetryCount) {
		retryCount++;
		System.out.println(retryCount);
		return true; // retry test
	}
	return false;
}

}
