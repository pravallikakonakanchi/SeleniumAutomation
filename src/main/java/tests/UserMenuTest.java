package tests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import constants.FileConstants;
import file.utils.PropertiesFileutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.SfdcListeners;
import pages.HomePage;
import pages.LoginPage;
import pages.UserMenuPage;

@Listeners(SfdcListeners.class)
public class UserMenuTest extends BaseTest {

	
	@Test
	public void VerifyMySettingsFromUserMenu() throws IOException, InterruptedException {
		WebDriver driver =  BaseTest.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Enter Url");
		driver.get("https://login.salesforce.com");
		test.log(Status.INFO, "App is launched");
		Thread.sleep(4000);
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		//test.log(Status.INFO, "Username is entered");
		lp.enterPassword(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
		//test.log(Status.INFO, "password is entered");
		lp.clickLoginButton(driver);
		Thread.sleep(4000);
		
		UserMenuPage ump = new UserMenuPage(driver);
		ump.selectOptionFromUserMenuOptions(driver,"My Settings");
	    ump.selectPersonalLink(driver,"Login History");
	    ump.selectDisplayAndLayout(driver,"Customize My Tabs");
	    ump.selectCustomApp(driver,"Salesforce Chatter");
	    ump.selectOptionFromAvailableTab(driver,"Reports");
	    ump.clickAddButton(driver);
	    ump.selectEmailLink(driver,"My Email Settings");
	    ump.enterEmailName(driver, "pravallika k");
	    ump.enterEmailAddress(driver, "pravallika.konakanchi@gmail.com");
	    ump.checkautomaticBCCButton(driver);
	    ump.selectCalendersAndReminders(driver, "Activity Reminders");
	    ump.clickOpenTextReminder(driver);
	    /*// Verify user info is correct
	    String actualUsername = homePage.getUsername(driver);
	    String expectedUsername = "pravallika kona";
	    softAssert.assertEquals(actualUsername, expectedUsername);

	    // Report all assertion failures
	    softAssert.assertAll();*/
	}
	
	public void userMenu_TC06() throws IOException, InterruptedException {
		WebDriver driver = BaseTest.getDriver();
		LoginPage lp = new LoginPage(driver);
		UserMenuPage ump = new UserMenuPage(driver);
		System.out.println("Launch browser");
		Assert.assertTrue(lp.launchApp(driver, "https://login.salesforce.com/"), "Actual URL should match the expected URL");
		lp.enterUsername(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.username"));
		lp.enterPassword(driver, PropertiesFileutils.readPropertiesFile(FileConstants.CREDENTIALS_FILE_PATH, "dev.password"));
		lp.clickLoginButton(driver);
		Assert.assertTrue(lp.isHomePageDisplayed(), "Home page should be displayed");
		ump.clickOnUserMenu();
		Assert.assertTrue(ump.verifyUserMenuItems()," Failed to verify user menu options");
		Assert.assertTrue(ump.selectMyprofile(driver),"Failed to select my profile");
		Assert.assertTrue(ump.isProfilePageVisible(), "Profile page should be visible");
		ump.clickEditProfile(driver);
		Assert.assertTrue(ump.verifyProfilePopUpWindow(driver),"Failed to verify profile pop up");
		Assert.assertTrue(ump.verifyLastNameChangeInAboutTab(driver, PropertiesFileutils.readUserMenuTestData("usermenu.profile.lastname")),"Failed to verify lastname");
		Assert.assertTrue(ump.verifyCreatePost(driver, PropertiesFileutils.readUserMenuTestData("usermenu.post.message")), "Failed to verify create post");
		Assert.assertTrue(ump.verifyFileUpload(driver, FileConstants.USER_MENU_FILE_UPLOAD_PATH), "Failed to upload file upload");
		Assert.assertTrue(ump.uploadPhoto(driver, FileConstants.USER_MENU_PHOTO_UPLOAD_PATH ), "Failed to verify phot upload");
	}

}
