package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.XLutilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForEnterprise extends HomePage{
	
	JavascriptExecutor js;
	public ForEnterprise(WebDriver driver) {
		super(driver);
		js=(JavascriptExecutor)driver;
		// TODO Auto-generated constructor stub
	}


	//locators
	
	@FindBy(xpath="//a[contains(text(),'For Enterprise')]")
	WebElement Enterprice;
	
	@FindBy(xpath="//*[@class='css-9c36bz']")
	WebElement Form;
	@FindBy(xpath="//*[@id='FirstName']")
	WebElement FirstName;
	@FindBy(xpath="//*[@id='LastName']")
	WebElement LastName;
	@FindBy(xpath="//*[@id='Email']")
	WebElement Email;
	@FindBy(xpath="//*[@id='Phone']")
	WebElement Phone;
	@FindBy(xpath="//*[@id='Self_reported_employees_to_buy_for__c']")
	WebElement NumberofEmployee;
	@FindBy(xpath="//*[@id='Title']")
	WebElement JobRoll;
	@FindBy(xpath="//*[@id='Country']")
	WebElement Country;
	@FindBy(xpath="	//*[@id='What_the_lead_asked_for_on_the_website__c']")
	WebElement Need;
	@FindBy(xpath="//*[@class='mktoButton']")
	WebElement SubmitButton;
	@FindBy(id="ValidMsgEmail")
	WebElement Message;
	
	
	//ActionMethods
	
	public void clickForEnterprise() {
		
	
		js.executeScript("arguments[0].click();",Enterprice);
		
	}
	
	public void scrollDown() {
		
		js.executeScript("arguments[0].scrollIntoView();",Form);
		
	}
	
	public void FillForm(String Firstname ,String Lastname,String EmailId,String Phoneno,String Roll) {
		FirstName.sendKeys(Firstname);
		LastName.sendKeys(Lastname);
		Email.sendKeys(EmailId);
		Phone.sendKeys(Phoneno);
		
		Select employeeDropdown= new Select(NumberofEmployee);
		employeeDropdown.selectByValue("1-4");
		
		JobRoll.sendKeys(Roll);
		
		Select CountryDropdown= new Select(Country);
		CountryDropdown.selectByValue("India");
		
		Select TouchDropdown= new Select(Need);
		TouchDropdown.selectByValue("Get in touch with sales");
		
		System.out.println("Form DATA Filled");
		
		
		
	}
	public void submitForm() {
		
		js.executeScript("arguments[0].click();",SubmitButton);
	}
	

	public void getErrorMessage() {
		String ERROR=Message.getText();
		System.out.println(ERROR);
	}

	
	
	
	
	
	
	
	
	
	
	
	

}
