package SalesForceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Resources.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_4B_WrongUsernameWrongPassword extends ReusableMethods{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		GetDriver("chrome");
		GetUrl("https://login.salesforce.com/");
		Thread.sleep(5000);
		Login("kpr@abc.com","saikona8");
		Thread.sleep(5000);
		String expectederror = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		String actualerror = driver.findElement(By.xpath("//div[@id='error']")).getText();
		//System.out.println("actualerror is "+actualerror);
		if(expectederror.equals(actualerror)) {
			System.out.println("The Testcase is passed");
		}
		else {
			System.out.println("The Testcase is failed");
		}
		
		
	}

}
