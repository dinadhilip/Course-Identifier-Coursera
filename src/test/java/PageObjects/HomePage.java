package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static JavascriptExecutor js;
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(xpath="//*[@class='react-autosuggest__input']")
	WebElement searchBox;
	@FindBy(xpath="//*[@class='nostyle search-button']")
	WebElement searchButton;
	
	
	//Data
	String input1="web development courses";
	
	
	//Action Methods
	
	public void courseSearch() throws InterruptedException {
	
	searchBox.sendKeys(input1);
	Thread.sleep(2000);
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();",searchButton);
	
	}

	
	

}
