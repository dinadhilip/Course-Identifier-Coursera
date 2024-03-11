package TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import Utilities.ExtendReports;
import Utilities.PropertyReader;
import PageObjects.HomePage;
import PageObjects.WebDevelopPage;
import Utilities.driverSetup;

@Listeners(ExtendReports.class)
public class BaseClass {
	
 static WebDriver driver ;
 public Logger logger;
 static PropertyReader pro = new PropertyReader();
    @Parameters({"os","browser"})
	@BeforeTest(groups={"Smoke","Regression"})
	public void setup(String os,String br) throws MalformedURLException {
		logger=LogManager.getLogger(this.getClass());
		if(pro.getENV().equalsIgnoreCase("remote"))
	 	{	
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		//os
		if(os.equalsIgnoreCase("windows"))
		{
			capabilities.setPlatform(Platform.WIN11);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching os..");
			return;
		}
		
		//browser
		switch(br.toLowerCase())
		{
		case "chrome" : capabilities.setBrowserName("chrome"); break;
		case "edge" : capabilities.setBrowserName("MicrosoftEdge"); break;
		default: System.out.println("No matching browser.."); return;
		}
		
		driver = new RemoteWebDriver(new URL("http://192.168.80.22:4444"), capabilities);
		
	    }
	else if(pro.getENV().equalsIgnoreCase("local"))
	{
		//launching browser based on condition - locally
		switch(br.toLowerCase())
		{
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		default: System.out.println("No matching browser..");
					return;
		}
	}
//		switch(br.toLowerCase())
//		{
//		case"chrome":driver=new ChromeDriver();break;
//		case"edge":driver=new EdgeDriver();break;
//		default:System.out.println("No matching browser...");
//		return;
//		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pro.getUrl());
		driver.manage().window().maximize();	
	}
	@AfterTest(groups={"Smoke","Regression"})
	public void tearDown() {
		driver.quit();
	}
	


}
