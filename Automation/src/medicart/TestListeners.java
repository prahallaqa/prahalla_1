package medicart;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getName());

		Object testClass = result.getInstance();
		WebDriver driver = ((BaseClass) testClass).driver;

		if (driver == null) {
			System.out.println("Driver is NULL. Screenshot not captured.");
			return;
		}
		takeScreenshot(driver, result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite Finished");
	}

	public void takeScreenshot(WebDriver driver, String testName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// File dest = new File("screenshots/" + testName + ".png");
		File folder = new File("screenshots");
		if (!folder.exists()) {
			folder.mkdirs();
		}

		File dest = new File(folder, testName + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
