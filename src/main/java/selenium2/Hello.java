package selenium2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hello {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		//ChromeDriver driver = new ChromeDriver();
		 WebDriver driver = new ChromeDriver();
		//RemoteWebDriver driver = new ChromeDriver();
		//RemoteWebDriver driver = (RemoteWebDriver)new ChromeDriver();
		driver.get("https://google.com/");
		Thread.sleep(1000);
	}

}
