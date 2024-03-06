package StepDefenitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import PageObjects.ForEnterprise;
import PageObjects.HomePage;
import PageObjects.LanguageLearnPage;
import PageObjects.WebDevelopPage;
import TestCases.BaseClass;
import TestCases.MainTestClass;
import Utilities.XLutilities;
import Utilities.driverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IdentifyCourseStep {

	HomePage homePage;
	WebDevelopPage webDevelop;
	LanguageLearnPage language;
	ForEnterprise Industry;
	WebDriver driver;
	@Given("the user is navigated to coursera home page")
	public void the_user_is_navigated_to_coursera_home_page() {
		    driver = driverSetup.getWebDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.coursera.org/");
			driver.manage().window().maximize();
	}

	@When("user searches for webdevelopment courses,it should display all the web development courses")
	public void user_searches_for_webdevelopment_courses_it_should_display_all_the_web_development_courses() throws InterruptedException, IOException {
		homePage=new HomePage(driver);
		homePage.courseSearch();
		 Thread.sleep(5000);
		  webDevelop=new WebDevelopPage(driver);
		  webDevelop.pageInfo();
	}

	@Then("the user clicks on English and Beginner checkbox,it should display the courses according to the filters.")
	public void the_user_clicks_on_english_and_beginner_checkbox_it_should_display_the_courses_according_to_the_filters() throws Exception {
		webDevelop.languageFilter();
		webDevelop.levelFilter();
		webDevelop.CourseName();
		   
	}

	@Then("the user should extract the details of first two courses.")
	public void the_user_should_extract_the_details_of_first_two_courses() throws Exception {
		webDevelop.CourseRating();
        Thread.sleep(2000);
		webDevelop.CourseDuration();

	}

	@Then("the user is navigated to Language learning page.")
	public void the_user_is_navigated_to_language_learning_page() throws Exception {
		webDevelop.ClearInput();
		webDevelop.sendInput();
		Thread.sleep(3000);
	}

	@Then("user clicks on show all button in language section,it should display all the languages.")
	public void user_clicks_on_show_all_button_in_language_section_it_should_display_all_the_languages() throws Exception {
        language = new LanguageLearnPage(driver);
		
		language.LanguageFilter();
		language.languageResult();
		language.clickShowmore();
	}

	@Then("the user should print all the levels with its count.")
	public void the_user_should_print_all_the_levels_with_its_count() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		language.getLanguageCount();
	}

	@Then("the user should print all the languages with its count in the console.")
	public void the_user_should_print_all_the_languages_with_its_count_in_the_console() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		
		language.getLanguageList();
		language.getLevelList();
	}

	@Then("the user is navigated to Home page.")
	public void the_user_is_navigated_to_home_page() throws Exception {
	   
		language.getHomePage();
	}

	@Then("the user is click to enterprises.")
	public void the_user_is_click_to_enterprises() throws Exception {
		Industry=new ForEnterprise(driver);
		Thread.sleep(3000);
		Industry.clickForEnterprise();
	   
	}

	@Then("the user is navigated to enterprises page.")
	public void the_user_is_navigated_to_enterprises_page() throws Exception {
		Thread.sleep(3000);
		Industry.scrollDown();
	    
	}

	@Then("the user should fill the form with valid details except for mail.")
	public void the_user_should_fill_the_form_with_valid_details_except_for_mail() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		String filePath=System.getProperty("user.dir") + ".\\ExcelData\\HackInput.xlsx";
		String sheetName="Sheet1";
		String Firstname=XLutilities.getCellData(filePath, sheetName, 1, 0);
		String Lastname=XLutilities.getCellData(filePath, sheetName, 1, 1);
		String EmailId=XLutilities.getCellData(filePath, sheetName, 1, 2);
		String Phoneno=XLutilities.getCellData(filePath, sheetName, 1, 3);
		String Roll=XLutilities.getCellData(filePath, sheetName, 1, 4);
		System.out.println(Firstname+Lastname+EmailId+Phoneno+Roll);
		Industry.FillForm(Firstname,Lastname,EmailId,Phoneno,Roll);
		Thread.sleep(1000);
		System.out.println("DataEnteres");
		Industry.submitForm();
	    
	}

	@Then("an error msg will be displayed for the mail and user have to capture that msg and display it.")
	public void an_error_msg_will_be_displayed_for_the_mail_and_user_have_to_capture_that_msg_and_display_it() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		
		Thread.sleep(1000);
		Industry.getErrorMessage();
		driver.quit();
	}


}
