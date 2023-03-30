package SalesForceAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Resources.ReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_05_UserMenuDropDown extends ReusableMethods{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		GetDriver("chrome");
		GetUrl("https://login.salesforce.com/");
		Thread.sleep(5000);
		Login("kpravallika@abc.com","saikona9");
		Thread.sleep(8000);
		String [] ExpectedMenuOptions = {"My Profile", "My Settings", "Developer Console","Switch to Lightning Experience",
		 "Logout"};
		WebElement usermenu = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		Click(usermenu,"usermenu");
		Thread.sleep(1000);
		ArrayList<String> ActualMenuOptions = new ArrayList();
		List<WebElement> arr1 = driver.findElements(By.xpath("//div[@id='userNav-menuItems']/a"));
		int error=0;
		for(WebElement we:arr1) {
			ActualMenuOptions.add(we.getText().trim());
		}
		for(String we:ExpectedMenuOptions) {
			if (!ActualMenuOptions.contains(we))
			{
				error=1;
				break;
			}
		
		}
		if (error==0) {
			System.out.println("the test case is passed");
		}
		else {
			System.out.println("the test case is failed");
		}
			
	}

}
