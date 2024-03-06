package PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.XLutilities;

public class LanguageLearnPage extends HomePage{
	
	public LanguageLearnPage(WebDriver driver) {
		super(driver);
		
	}

	String input2="Language Learning";
	String Title2;
	
	//locators
	
	@FindBy(xpath="//*[@class='nostyle search-button']")
	WebElement searchButton;
	@FindBy(className="rc-SearchResultsHeader")
	WebElement searchResult;
	@FindBy(xpath="//*[@class='cds-149 cds-button-disableElevation cds-button-ghost css-1s96oj']")
	WebElement close;
	@FindBy(xpath="//*[@class='cds-119 cds-113 cds-115 css-1t811zk cds-142']")
	WebElement homePage;
	
	
	
	List<WebElement> checkboxlanguages = driver.findElements(By.xpath("//*[@class='cds-checkboxAndRadio-label']"));
	int langcount=checkboxlanguages.size();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	
	//Action Methods
	
	public void LanguageFilter() throws InterruptedException {
		
		List<WebElement> checkboxlanguages = driver.findElements(By.xpath("//*[@class='cds-checkboxAndRadio-label']"));
		WebElement d=checkboxlanguages.get(2);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();",d);
		
	}
	
	public void languageResult() {
		
		Title2=searchResult.getText();
		System.out.println(Title2);
		
	}
	
	public void clickShowmore() throws InterruptedException {
		
		Thread.sleep(2000);
		List<WebElement> showmore = driver.findElements(By.xpath("//*[@class='cds-149 cds-button-disableElevation cds-button-ghost css-l0otf2']"));
		WebElement k=showmore.get(1);
		Thread.sleep(1000);
		js.executeScript("arguments[0].click();",k);
		
	}
	public void getLanguageCount() {
		int langcount=checkboxlanguages.size();
		System.out.println(langcount);
		
	}
	
	public void getLanguageList() throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		List<WebElement> checkboxlanguages1 = driver.findElements(By.xpath("//*[@class='cds-checkboxAndRadio-label']"));
		
	for(int i=31;i<langcount;i++) {
		
		String A=checkboxlanguages1.get(i).getText();
		System.out.println(A);	
		XLutilities.setcelldata("Sheet1", "Languages",0 , 1);
		XLutilities.setcelldata("Sheet1", A, i-30, 1);
		
	}
	
	  	Thread.sleep(3000);
	  	driver.findElement(By.xpath("//*[@class='cds-149 cds-button-disableElevation cds-button-ghost css-1s96oj']")).click();
	  	Thread.sleep(2000);
	}
	
	public void getLevelList() throws IOException {
		List<WebElement> levels = driver.findElements(By.xpath("//*[@class='cds-checkboxAndRadio-label']"));
		int levelscount=levels.size();
		System.out.println(levelscount);
		for(int j=11;j<15;j++)
		{
			String v=levels.get(j).getText();
			System.out.println(v);
			XLutilities.setcelldata("Sheet1", "Levels",0 , 2);
			XLutilities.setcelldata("Sheet1", v, j-10, 2);
			
		}
		
		
	}
	
	public void getHomePage() throws InterruptedException {
       Thread.sleep(3000);
		homePage.click();
	}

}
