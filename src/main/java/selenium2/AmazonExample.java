package selenium2;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://amazon.com/");
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("kindle");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		WebElement amazonsChoice = driver.findElement(By.xpath("//span[contains(@id,'amazons-choice-label')]"));
		amazonsChoice.click();
		WebElement addToCart = driver.findElement(By.xpath("(//div[@id='addToCart_feature_div'])[1]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",addToCart);
		addToCart.click();
		WebElement popupClose = driver.findElement(By.xpath("(//button[@data-action='a-popover-close'])[2]"));
		popupClose.click();
		WebElement cartCount = driver.findElement(By.xpath("//div[@id='nav-cart-count-container']"));
		cartCount.click();
		WebElement verifyItem = driver.findElement(By.xpath("//img[contains(@alt,'Kindle Paperwhite (8 GB)')]"));
		Assert.assertTrue(verifyItem.isDisplayed(), "Added item is not displayed");
		driver.close();
		
	}
	

}
