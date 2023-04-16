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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import constants.FileConstants;
import file.utils.PropertiesFileutils;
import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.SfdcListeners;
import pages.AmazonPage;
import pages.LoginPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import file.utils.PropertiesFileutils;

public class AmazonTest extends BaseTest{

	@Test()
	public void loginTest() throws IOException, InterruptedException {
		WebDriver driver =  BaseTest.getDriver();
		System.out.println("Enter Url");
		String url1 = readPropertiesFile("C:\\Javaworkspace\\selenium_practice\\testdata\\Prod_Credentials.properties","url1");
		driver.get(url1);
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AmazonPage ap = new AmazonPage(driver);
		ap.enterKeywordInSearch(driver, "kindle");
		Thread.sleep(5000);
		ap.clickOnAmazonsChoice(driver);
		ap.clickOnAddToCartButton(driver);
		WebElement popupClose = driver.findElement(By.xpath("(//button[@data-action='a-popover-close'])[2]"));
		popupClose.click();
		WebElement cartCount = driver.findElement(By.xpath("//div[@id='nav-cart-count-container']"));
		cartCount.click();
		WebElement verifyItem = driver.findElement(By.xpath("//img[contains(@alt,'Kindle Paperwhite (8 GB)')]"));
		Assert.assertTrue(verifyItem.isDisplayed(), "Added item is not displayed");
		driver.close();
		
	}
	

}
