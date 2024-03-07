package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.XLutilities;

public class WebDevelopPage extends HomePage{
	

	public WebDevelopPage(WebDriver driver) {
		super(driver);
	}

	//Locators
	@FindBy(className="rc-SearchResultsHeader")
	WebElement searchResult;
	@FindBy(xpath="//*[@class='react-autosuggest__input']")
	WebElement searchBox;
	@FindBy(xpath="//*[@class='nostyle search-button']")
	WebElement searchButton;
	List<WebElement> CheckBox= driver.findElements(By.xpath("//*[@class='cds-checkboxAndRadio-label']"));
	
	//variables
	
	
	
	
	//Action methods
	
	public void pageInfo() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String Title=searchResult.getText();
		System.out.println(Title);
	}
	
	public void languageFilter() {	
		CheckBox.get(5).click();
				
	}
	
	
	public void levelFilter() {
		CheckBox.get(16).click();
	}
	
	
	public void CourseName() throws Exception {
		
		Thread.sleep(5000);
		
		List<WebElement> Courses = driver.findElements(By.xpath("//*[@class='cds-CommonCard-title css-6ecy9b']"));
		
		String course1=Courses.get(0).getText();
		System.out.println(course1);
		String course2=Courses.get(1).getText();
		System.out.println(course2);
		Thread.sleep(2000);
		
		//PrintExcel
		XLutilities.setcelldata("Sheet1", "COURSES",0 , 0);
		for(int c=0;c<Courses.size();c++)
		{
			String course=Courses.get(c).getText();
			System.out.println(course);
			XLutilities.setcelldata("Sheet1", course, c+1, 0);
		}
		
	}
	
	public void CourseRating() throws Exception {
		
		Thread.sleep(2000);
		
		List<WebElement> rating = driver.findElements(By.xpath("//*[@class='cds-119 css-11uuo4b cds-121']"));
		
		String rating1=rating.get(0).getText();
		System.out.println(rating1);
		String rating2=rating.get(1).getText();
		System.out.println(rating2);
		Thread.sleep(2000);
	}
	
	public void CourseDuration() throws Exception {
		
		Thread.sleep(2000);
		
		List<WebElement> duration = driver.findElements(By.xpath("//*[@class='cds-CommonCard-metadata']"));
		
		int durationsize=duration.size();
		System.out.println(durationsize);
		
		String duration1=duration.get(0).getText();
		System.out.println(duration1);
		
		String duration2=duration.get(1).getText();
		System.out.println(duration2);
		
		Thread.sleep(3000);
		
		String[] words = duration1.split("·");
		
		Thread.sleep(2000);
		System.out.println(words.length);
		
		String time=words[2];
		System.out.println(time);
		
		String[] words1 = duration2.split("·");
		String time1=words1[2];
		System.out.println(time1);
		
	}
	
	public void ClearInput() throws InterruptedException {
		
		searchBox.sendKeys(Keys.CONTROL+"a"+ Keys.DELETE);

		Thread.sleep(3000);
			
		}
     public void sendInput() throws InterruptedException {
	
		Thread.sleep(2000);
		WebElement inputBox=driver.findElement(By.className("react-autosuggest__input"));	
		inputBox.sendKeys("Language Learning");
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",searchButton);
		Thread.sleep(2000);
			
		}

	}
	
	
	
	
	

