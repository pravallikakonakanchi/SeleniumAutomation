package selenium2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardUse {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com/");
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//WebElement opentab = driver.findElement(By.id("opentab"));
		//opentab.click();
		//WebElement textfield = driver.findElement(By.name("enter-name"));
		//textfield.sendKeys("pravallika");
		WebElement radiobutton = driver.findElement(By.xpath("//input[@id='hondaradio']"));
		radiobutton.click();
		
		
	}

}
