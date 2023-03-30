package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/");
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		WebElement mousehover = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		WebElement orders = driver.findElement(By.cssSelector("a#nav_prefetch_yourorders"));
		Actions action = new Actions(driver);
		action.moveToElement(mousehover).click(orders).build().perform();
	}

}
