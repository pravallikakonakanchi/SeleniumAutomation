package SalesForceAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Resources.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_4A_ForgotPassword extends ReusableMethods{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		GetDriver("chrome");
		GetUrl("https://login.salesforce.com/");
		Thread.sleep(5000);
		WebElement username_ele = driver.findElement(By.xpath("//input[@id='username']"));
		EnterData(username_ele,"kpravallika@abc.com","username");
		WebElement forgotpassword = driver.findElement(By.xpath("//a[@id='forgot_password_link']"));
		Click(forgotpassword, "forgotpassword");
		Thread.sleep(5000);
		WebElement forgotpasswordform = driver.findElement(By.xpath("//form[@id='forgotPassForm']"));
		if(forgotpasswordform.isDisplayed()) {
			System.out.println("forgotpassword page is displayed ");
			System.out.println("The Testcase is passed");
		}
		else {
			System.out.println("forgotpassword page is not displayed ");
			System.out.println("The Testcase is failed");
		}
		
	}

}
