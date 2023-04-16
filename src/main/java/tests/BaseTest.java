package tests;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import file.utils.PropertiesFileutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends PropertiesFileutils{
	
private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();
protected static ExtentReports extent = new ExtentReports();	
protected static ExtentHtmlReporter report = null;	
protected static ExtentTest test = null;
protected static Logger logger = LogManager.getLogger("");	
    @BeforeSuite
    public void Setup() {
    	logger.debug("BaseTest: setup: configuration started ");
    	String sFileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\reports\\"+sFileNamePrefix+"_SFDC.html";	
		report = new ExtentHtmlReporter(filePath);
		extent.attachReporter(report);
		logger.debug("BaseTest: setup: configuration complete");
    }
    @AfterSuite
    public void tearDown() {
    	extent.flush();
    	logger.debug("BaseTest: tearDown: completed ");
    }

    @Parameters({"bName","headless"})
    @BeforeMethod
	public void setDriver(Method name,String bName,boolean headless) {
		WebDriver driver = BaseTest.getBrowserType(bName, headless);
		logger.debug("BaseTest: setDriver: driver configuration done");
		threadLocalDriver.set(driver);
		logger.debug("BaseTest: setDriver: driver saved on to a threadlocal object");
		test = extent.createTest(name.getName());
		logger.debug("BaseTest: setDriver: test object created");
	}
	
	public static WebDriver getDriver() {
		logger.debug("BaseTest: getDriver: driver configuration retrived by the thread");
		return threadLocalDriver.get();
	}

	@AfterMethod
	public void removeDriver() {
		BaseTest.getDriver().close();
		threadLocalDriver.remove();
		logger.debug("BaseTest: removeDriver: driver configuration removed from the thread");
	}

	/**
	 * This method configures the browser dynamically with headless mode.
	 * @param browserName should be either of the string 'chrome', 'firefox', 'edge', 'safari'
	 * @param headless set to true to run in headless mode
	 * @return driver object, on wrong param returns null
	 */
	public static WebDriver getBrowserType(String browserName, boolean headless) {
		
		WebDriver driver = null;
		String browserType = browserName.toLowerCase();
		
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if(headless) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
				logger.debug("BaseTest: getBrowserType: chrome driver in headless mode configured");
			} else {
				driver = new ChromeDriver();
				logger.debug("BaseTest: getBrowserType: chrome driver configured");
			}
			break;
		case "safari":
			driver = new SafariDriver();
			logger.debug("BaseTest: getBrowserType: safari driver configured");
			
	
			/*	WebDriverManager.SafariDriver().setup();
				if(headless) {
					SafariOptions so = new SafariOptions();
					so.addArguments("--headless");
					driver = new SafariDriver(so);
				} else {
				*/
				//	driver = new SafariDriver();
				//}
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			logger.debug("BaseTest: getBrowserType: firefox driver configured");
			break;

		default:
			System.out.println("Provide input either as Chrome or Safari");
			logger.debug("BaseTest: getBrowserType: broswer name input is wrong");
			break;
		}
		return driver;
	}

}
