package extentReporting;

import java.io.File;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.mongodb.MapReduceCommand.OutputType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;

public class TestSummary {
	
	 public static void main( String[] args )
	 {
	 ExtentReports report;
		ExtentTest logger;
		System.setProperty("webdriver.chrome.driver", "D:\\jRS\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
		report=new ExtentReports("D:\\Learnautomation\\samplereport.html");
		logger=report.startTest("Mobile Automation");
		report.addSystemInfo("Selenium Version", "2.46");
		report.addSystemInfo("Environment", "Production (www.netx360.com)");
		logger.assignAuthor("Harikrishnan");
		
		driver.get("http://learn-automation.com");		
			logger.log(LogStatus.INFO,"Browser Invoked-");
			driver.manage().window().maximize();
			logger.log(LogStatus.INFO,"Browser Maximized-");
			
			logger.log(LogStatus.INFO,"Application Running-");
			String title=driver.getTitle();
			Assert.assertTrue(title.contains("Selenium"));
			logger.log(LogStatus.PASS,"Title Verified-");
			//logger.log(LogStatus.FAIL,"Title Verified-"+i);
			//logger.addScreenCapture("F:\\Selenium\\ExtenReport\\Screenshot\\"+logger.getTest().name+i+".png");
			//File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			//String img = logger.addScreenCapture("F:\\Selenium\\ExtenReport\\Screenshot\\"+logger.getTest().name+i+".png");
			
			String img=logger.addScreenCapture("D:\\Learnautomation\\sample.png");
			logger.log(LogStatus.INFO, "Image", "Image example: " + img);
	        
			//logger.log(LogStatus.INFO, "Image", "Image example: " + logger.addScreenCapture("F:\\Selenium\\ExtenReport\\Screenshot\\"+logger.getTest().name+i+".png"));
			
			//String screenshot=Utility.captureScreenshot(driver, result.);
		
		
		report.endTest(logger);
		report.flush();
		driver.get("D:\\Learnautomation\\samplereport.html");
		
		
}

}
