package ActiTimeProject;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ExtentRepoertForActiTIme extends BaseClass implements ITestListener{

	 public ExtentSparkReporter sparkreporter;
	 public ExtentTest test;
	 public ExtentReports reports;
	
	@Override
	public void onTestStart(ITestResult result) {
		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/ActiTImeReport.html");
		sparkreporter.config().setDocumentTitle("ActiTime Automation Report");
		sparkreporter.config().setReportName("Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports();
		reports.attachReporter(sparkreporter);
		
		reports.setSystemInfo("Computer Name", "Hp Laptop 15");
		reports.setSystemInfo("OS", "WIndows");
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Teste Name", "Babalu gupta");
		
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test = reports.createTest(result.getName());
		test.log(Status.PASS, "The test case passed is: "+result.getName());
		
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		test = reports.createTest(name);
		test.log(Status.FAIL, "The test case failes is: "+name);
		test.log(Status.FAIL, "The test case fail is: "+result.getThrowable());

		
		TakesScreenshot t =(TakesScreenshot)driver;
		 File src = t.getScreenshotAs(OutputType.FILE);  
		File dest = new File("./ScreenShot/"+name+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		test = reports.createTest(name);
		test.log(Status.SKIP, "The test case skipped is: "+name);
		
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
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
		ITestListener.super.onFinish(context);
	}

	
	
}
