package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class driverSetup {
	public static WebDriver driver;
	static PropertyReader pro = new PropertyReader();
	public static WebDriver getWebDriver() {
		String browser = pro.getBrowserType();
	      System.out.println(browser);
	      WebDriver driver = null;
	      if (browser.equalsIgnoreCase("edge")) {
	         WebDriverManager.edgedriver().setup();
	         driver = new EdgeDriver();
	      } else {
	         if (!browser.equalsIgnoreCase("chrome")) {
	            throw new RuntimeException("Invalid browser provided");
	         }
 
	         WebDriverManager.chromedriver().setup();
	         driver = new ChromeDriver();
	      }
 
	      return (WebDriver)driver;
	   }
}


