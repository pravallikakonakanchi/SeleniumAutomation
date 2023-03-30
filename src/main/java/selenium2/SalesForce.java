package selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		String browser = "chrome";
		if(browser == "chrome") {
			WebDriverManager.chromedriver().setup();
			WebDriverManager.chromedriver();
			driver = new ChromeDriver();
		}
		else if (browser == "firefox") {
			WebDriverManager.firefoxdriver().setup();
			WebDriverManager.firefoxdriver();
		    driver = new FirefoxDriver();	
		}
		else {
			WebDriverManager.edgedriver().setup();
			WebDriverManager.edgedriver();
		    driver = new EdgeDriver();
		}
		driver.get("https://www.salesforce.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//WebElement login = driver.FindElement(By.)
	}

}
