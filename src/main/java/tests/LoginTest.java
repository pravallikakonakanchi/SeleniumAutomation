package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import constants.FileConstants;
import file.utils.PropertiesFileutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.SfdcListeners;
import pages.HomePage;
import pages.LoginPage;
@Listeners(SfdcListeners.class)
public class LoginTest extends BaseTest {
	
	@Test()
	public void loginTest() throws IOException, InterruptedException {
		WebDriver driver =  BaseTest.getDriver();
		System.out.println("Enter Url");
		driver.get("https://login.salesforce.com/");
		Thread.sleep(4000);
		
		LoginPage lp = new LoginPage(driver);
		System.out.println("Enter valid  username");
		lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		System.out.println("Enter valid  password");
		lp.enterPassword(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
		
		lp.clickLoginButton(driver);
		Thread.sleep(4000);
		
		// Verify login was successful
	    HomePage homePage = new HomePage(driver);
	    String actualTitle = driver.getTitle();
	    String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
	    SoftAssert softAssert = new SoftAssert();
	    softAssert.assertEquals(actualTitle, expectedTitle);
	    
	    // Verify user info is correct
	    String actualUsername = homePage.getUsername(driver);
	    String expectedUsername = "pravallika kona";
	    softAssert.assertEquals(actualUsername, expectedUsername);

	    // Report all assertion failures
	    softAssert.assertAll();
	}
	
	@Test
	public void loginErrorMessage() throws IOException, InterruptedException {
		WebDriver driver =  BaseTest.getDriver();
		driver.get("https://login.salesforce.com");
		logger.info("app is launched");
		Thread.sleep(4000);
		LoginPage lp = new LoginPage(driver);
		logger.info("Enter username");
		lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		test.info("entered username");
		lp.enterPassword(driver, "");
		test.log(Status.INFO, "entered password");
		lp.clickLoginButton(driver);
		Thread.sleep(4000);
		
		// Verify error message is correct
		String expectederror = "Please enter your password.";
		String actualerror = lp.getErrorMessage(driver);
	   
		SoftAssert softAssert = new SoftAssert();
	    softAssert.assertEquals(actualerror, expectederror);

	    // Report all assertion failures
	    softAssert.assertAll();
	    test.log(Status.PASS, "Testcase is passed");
	}
	
	
	@Test
	public void checkRememberMeId() throws IOException, InterruptedException {
		WebDriver driver =  BaseTest.getDriver();
		System.out.println("Enter Url");
		driver.get("https://login.salesforce.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		test.log(Status.INFO, "Username is entered");
		lp.enterPassword(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
		test.info("Password is entered");
		lp.selectRememberMeCheckbox(driver);
		
		lp.clickLoginButton(driver);
		test.info("Login button clicked");
		Thread.sleep(4000);
		
		//logout from the app
	    HomePage homePage = new HomePage(driver);
	    homePage.logout(driver);
	    Thread.sleep(2000);
	    SoftAssert softAssert = new SoftAssert();
	    
	    //verify if Remember me check box is selected or not
	    Assert.assertTrue(lp.verifyRememberMeCheckbox(), "Remember me checkbox should be selected");
	    test.info("Remember me checkbox selected");
	    // Verify username in username field after logout
	    String actualUsername = lp.getUsernameAfterRemember(driver);
	    String expectedUsername = PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username");
	    softAssert.assertEquals(actualUsername, expectedUsername);
	  
	    // Report all assertion failures
	    softAssert.assertAll();
	}
	
	
	@Test(dataProvider = "credentialsProvider")
	public void loginTestWithDataProvider(String susername,String spassword) throws IOException, InterruptedException {
		WebDriver driver =  BaseTest.getDriver();
		System.out.println("Enter Url");
		driver.get("https://login.salesforce.com/");
		Thread.sleep(4000);
		
		LoginPage lp = new LoginPage(driver);
		System.out.println("Enter valid  username");
		lp.enterUsername(driver,susername );
		System.out.println("Enter valid  password");
		lp.enterPassword(driver,spassword);
		
		lp.clickLoginButton(driver);
		Thread.sleep(4000);
		
		// Verify login was successful
	    HomePage homePage = new HomePage(driver);
	    String actualTitle = driver.getTitle();
	    String expectedTitle = "Home Page ~ Salesforce - Developer Edition";
	    SoftAssert softAssert = new SoftAssert();
	    softAssert.assertEquals(actualTitle, expectedTitle);
	    
	    // Verify user info is correct
	    String actualUsername = homePage.getUsername(driver);
	    String expectedUsername = "pravallika kona";
	    softAssert.assertEquals(actualUsername, expectedUsername);

	    // Report all assertion failures
	    softAssert.assertAll();
	}
	
	
	@DataProvider(name = "credentialsProvider")
	  public Object[][] credentialsProvider() {
	    return new Object[][] {
	      {"kpravallika@abc.com", "saikona9" },
	      {"kpravallika@abc.com", "saikona8" },
	      {"pravallika@abc.com", "saikona9" },
	      {"kpravallika@abc.com", "" }
	    };
	  }

	
	@Test
	public void loginTest1() {
		WebDriver driver =  BaseTest.getDriver();
		driver.get("https://google.com");
	}
	
	
	

}
