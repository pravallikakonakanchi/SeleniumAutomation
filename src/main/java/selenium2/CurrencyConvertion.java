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

public class CurrencyConvertion {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://xe.com/");
		Thread.sleep(1000);
		WebElement fromCurrencyFieldInput = driver.findElement(By.xpath("//input[@id='midmarketFromCurrency']"));
		fromCurrencyFieldInput.sendKeys("USD");
		fromCurrencyFieldInput.sendKeys(Keys.ENTER);
		WebElement toCurrencyFieldInput = driver.findElement(By.xpath("//input[@id='midmarketToCurrency']"));
		toCurrencyFieldInput.sendKeys("IND");
		toCurrencyFieldInput.sendKeys(Keys.ENTER);
		WebElement convertButton = driver.findElement(By.xpath("//div[contains(@class,'currency-converter__Submit')]//button"));
		convertButton.click();
		driver.close();
		
	}
	

}
