package Utilities;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestCases.BaseClass;
import TestCases.MainTestClass;

public class ExtendReports implements ITestListener {

	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods
	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/Report/myReport.html");//specify location of the report
		sparkReporter.config().setDocumentTitle("Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("CourseIdentify"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","Dhilip R M");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
		
	}

	public void onTestSuccess(ITestResult result){
		test = extent.createTest(result.getName());// create a new enty in the report
		try {
			String img=MainTestClass.Screenshot(result.getName());
			test.addScreenCaptureFromPath(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		test.assignCategory(result.getMethod().getGroups()); 
		test.log(Status.PASS,result.getName()+" got successfully executed");
		}
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable()); 
	}
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	

}
