package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotsA {
	public static void HomePageSC(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File homeSRC = ts.getScreenshotAs(OutputType.FILE);
		File homePageLOC = new File(System.getProperty("user.dir") + "//ScreenShots//HomePage.png");
		try {
			FileUtils.copyFile(homeSRC, homePageLOC);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void IndustryPageSC(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File homeSRC = ts.getScreenshotAs(OutputType.FILE);
		File homePageLOC = new File(System.getProperty("user.dir") + "//ScreenShots//IndustryPage.png");
		try {
			FileUtils.copyFile(homeSRC, homePageLOC);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void LanguagePageSC(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File homeSRC = ts.getScreenshotAs(OutputType.FILE);
		File homePageLOC = new File(System.getProperty("user.dir") + "//ScreenShots//LanguagePage.png");
		try {
			FileUtils.copyFile(homeSRC, homePageLOC);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void 	WebDevelopPage(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File homeSRC = ts.getScreenshotAs(OutputType.FILE);
		File homePageLOC = new File(System.getProperty("user.dir") + "//ScreenShots//WebDevelopPage.png");
		try {
			FileUtils.copyFile(homeSRC, homePageLOC);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
