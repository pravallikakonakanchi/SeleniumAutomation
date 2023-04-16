package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='Home Tab']")
	public WebElement home;

	@FindBy(xpath = "//span[@id='userNavLabel']")
	public WebElement usernavlabel;
	
	@FindBy(xpath = "//a[@title='Logout']")
	public WebElement logout;
	
	public String getUsername(WebDriver driver) {

		if (usernavlabel.isDisplayed()) {
			return usernavlabel.getText();
		} else {
			System.out.println("User nav label is not visible");
			return "";
		}
	}
	
	public void clickUserMenu(WebDriver driver) {

		if (usernavlabel.isDisplayed()) {
			usernavlabel.click();
		} else {
			System.out.println("User nav label is not visible");
		}
	}
	
	public void logout(WebDriver driver) {
		 
		Actions actions = new Actions(driver); 
		actions.click(usernavlabel).click(logout).build().perform();
	}
}
