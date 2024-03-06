package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObjects.ForEnterprise;
import PageObjects.HomePage;
import PageObjects.LanguageLearnPage;
import PageObjects.WebDevelopPage;
import Utilities.ExtendReports;
import Utilities.XLutilities;


@Listeners(ExtendReports.class)
public class MainTestClass extends BaseClass {
	HomePage homePage;
	WebDevelopPage webDevelop;
	LanguageLearnPage language;
	ForEnterprise Industry;
	
	
	@Test (priority=1,groups= {"Smoke","Regression"})
	  public void courseSearch() throws InterruptedException, IOException {
		logger.info("*******Starting the HOMEPage********");
		homePage=new HomePage(driver);
		homePage.courseSearch();
		Screenshot("HomePage");
		Thread.sleep(5000);  
	}
		  
	@Test (priority=2,groups= {"Smoke","Regression"})
		public void pageInfo() throws InterruptedException, IOException {
			  Thread.sleep(5000);
			  logger.info("PageInfo of WebdevelopmentCourse");
			  webDevelop=new WebDevelopPage(driver);
			  webDevelop.pageInfo();
			  Screenshot("WebDevelop");
			  
	}
	@Test (priority=3,groups= {"Regression"})
	public void languageFilter() {
		
		webDevelop.languageFilter();
		
	}
	@Test (priority=4,groups= {"Regression"})
	public void levelFilter() {
		
		webDevelop.levelFilter();
		
	}
	@Test (priority=5,groups= {"Regression"})
	public void courseResult() throws Exception {
		logger.info("Result for WebDevelopmentCourse");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		webDevelop.CourseName();
		Screenshot("Courses");
		
	}
	@Test (priority=6,groups= {"Regression"})
	public void courseRating() throws Exception {
		logger.info("Rating for WebDevelopmentCourse");
		webDevelop.CourseRating();
	}
	@Test (priority=7,groups= {"Regression"})
	public void courseDuration() throws Exception {
		Thread.sleep(2000);
		logger.info("Duration for WebDevelopmentCourse");
		webDevelop.CourseDuration();
	}
	@Test (priority=8,groups= {"Smoke","Regression"})
	public void clearInput()throws Exception {
		
		webDevelop.ClearInput();
	}
	@Test (priority=9,groups= {"Smoke","Regression"})
	public void SendInput()throws Exception {
		logger.info("***Search for LanguageLearning****");
		webDevelop.sendInput();
		Thread.sleep(3000);
	}
	
	@Test (priority=10,groups= {"Smoke","Regression"})
	public void LanguageFilter()throws Exception {
		language = new LanguageLearnPage(driver);
		
		language.LanguageFilter();
	
	}
	@Test (priority=11,groups= {"Smoke","Regression"})
	public void LanguageResult()throws Exception {
		logger.info("Result for LanguageLearningCourse");
		language.languageResult();
		//takeScreenshot("LanguagePage");
			
	}
	@Test (priority=12,groups= {"Regression"})
	public void ClickShowMore()throws Exception {
		language.clickShowmore();
	
	}
	@Test (priority=13,groups= {"Regression"})
	public void languagecount()throws Exception {
		language.getLanguageCount();
	
	}
	@Test (priority=14,groups= {"Regression"})
	public void languagelist()throws Exception {
		logger.info("Result for Languages");
		language.getLanguageList();
	
	}
	@Test (priority=15,groups= {"Regression"})
	public void languageLevellist()throws Exception {
		logger.info("Result for Different Level");
		language.getLevelList();
	
	}
	@Test (priority=16,groups={"Smoke","Regression"})
	public void navigateHome()throws Exception {
		logger.info("******Navigate HomePage******");
		language.getHomePage();
		//takeScreenshot("BackToHome");
	
	}
	@Test (priority=17,groups={"Smoke","Regression"})
	public void navigateIndustry()throws Exception {
		Industry=new ForEnterprise(driver);
		logger.info("Navigate Enterprise Page");
		Thread.sleep(3000);
		Industry.clickForEnterprise();
		Screenshot("ForEnterprisePage");
	
	}
	@Test (priority=18,groups= {"Regression"})
	public void Scroll()throws Exception {
		Thread.sleep(3000);
		Industry.scrollDown();
	
	}
	@Test (priority=19,groups= {"Regression"})
	public void FillFormDetails()throws Exception {
		Thread.sleep(2000);
		String filePath=System.getProperty("user.dir") + ".\\ExcelData\\HackInput.xlsx";
		String sheetName="Sheet1";
		logger.info("Fill form details using ExcelData");
		String Firstname=XLutilities.getCellData(filePath, sheetName, 1, 0);
		String Lastname=XLutilities.getCellData(filePath, sheetName, 1, 1);
		String EmailId=XLutilities.getCellData(filePath, sheetName, 1, 2);
		String Phoneno=XLutilities.getCellData(filePath, sheetName, 1, 3);
		String Roll=XLutilities.getCellData(filePath, sheetName, 1, 4);
		System.out.println(Firstname+Lastname+EmailId+Phoneno+Roll);
		Industry.FillForm(Firstname,Lastname,EmailId,Phoneno,Roll);
		//takeScreenshot("PrintForm");
		
	}
	@Test (priority=20,groups= {"Regression"})
	public void SubmitForm() throws Exception {
		Thread.sleep(1000);
		System.out.println("DataEnteres");
		Industry.submitForm();
	
	}
	@Test (priority=21,groups= {"Regression"})
	public void GetErrorMsg() throws Exception {
		Thread.sleep(1000);
		logger.info("Print Error Message.....");
		Industry.getErrorMessage();
		//takeScreenshot("ErrorMsg");
	
	}
	public static  String Screenshot(String ScreenshotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		String targetFilePath=("C:\\Users\\2303752\\eclipse-workspace\\CourcesIdentifier\\ScreenShotsFolder\\SC\\"+ScreenshotName+"_"+".png");
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;

	}
	

}
