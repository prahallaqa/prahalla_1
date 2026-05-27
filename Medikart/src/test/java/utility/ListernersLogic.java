package utility;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ListernersLogic implements ITestListener {

	ExtentReports extent = ExtentManager.getReport();
	ExtentTest test;

	public static WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName()); // FIX: create test at start
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed"); // log pass

		ITestListener.super.onTestSuccess(result);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"D:\\eclipse-workspace\\Medikart\\Screenshots\\Pass\\Testcase" + Math.random() + ".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable()); // log failure

		ITestListener.super.onTestFailure(result);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(
				"D:\\eclipse-workspace\\Medikart\\Screenshots\\Fail\\Testcase" + Math.random() + ".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(org.testng.ITestContext context) {
		extent.flush(); // generate report
	}
}
