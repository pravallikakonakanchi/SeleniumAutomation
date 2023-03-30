package selenium2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/");
		Thread.sleep(1000);
		WebElement search = driver.findElement(By.xpath("//input[@title='Search']"));
		search.sendKeys("selenium");
		Thread.sleep(5000);
		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='Alh6id']//ul[@role='listbox']//div[contains(@aria-label,'selenium')]"));
		for(WebElement ele: elements )
		{
			System.out.println(ele.getAttribute("aria-label"));
		}
	}
	

}
