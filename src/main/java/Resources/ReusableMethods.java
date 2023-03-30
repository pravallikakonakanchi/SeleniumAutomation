package Resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {
	public static WebDriver driver = null;
	//Reusable Method for initiating the driver
	//Arguments - String browser name
	public static void GetDriver(String BrowserName) {
		
		if(BrowserName.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		if(BrowserName.equals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		System.out.println("Launched "+ BrowserName );
	}
	//Reusable method - Entering url
	//Arguments String url
	public static void GetUrl(String url) {
		driver.get(url);
		System.out.println("Accessed the application " +url);
		
	}
	//Reusable method - Enterdata
	//Arguments-WebElement element,String text,String name
	public static void EnterData(WebElement element,String text,String name) {
		element.clear();
		element.sendKeys(text);
		System.out.println("Entered "+ text +" in the "+name+ " field");
	}
	//Reusable method - click
		//Arguments-WebElement
	public static void Click(WebElement element, String button_or_link_name) {
		element.click();
		System.out.println("Clicked on the button or link  " + button_or_link_name);
	}
	//Reusable method - CompareTwoStrings
			//Arguments-WebElement
	public static void CompareTwoStrings(String actual,String expected) {
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("Test Case Passed");
		}
		else {
			System.out.println("Test Case Failed");
		}
	}
	public static void Login(String Username, String Password) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(Username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='rememberUn']")).click();
		driver.findElement(By.xpath("//input[@id='Login']")).click();
	}
}
