package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import file.utils.CommonUtils;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id = "username")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(id = "Login")
	public WebElement login;
	
	@FindBy(xpath = "//div[@id='error']")
	public WebElement errormessage;
	
	@FindBy(xpath = "//input[@id='rememberUn']")
	public WebElement rememberMe;
	
	@FindBy(id = "idcard-identity")
	public WebElement usernameAfterRemember;
	
	@FindBy(id = "userNavLabel")
	public WebElement homeUserMenu;

	public void enterUsername(WebDriver driver, String userName) {

		if (username.isDisplayed()) {
			username.sendKeys(userName);
		} else {
			System.out.println("User name element is not visible");
		}
	}

	public void enterPassword(WebDriver driver, String pass) {
		if (password.isDisplayed()) {
			password.sendKeys(pass);
		} else {
			System.out.println("password element is not visible");
		}
	}
	
	public void clickLoginButton(WebDriver driver) {
		if (login.isDisplayed()) {
			login.click();
		} else {
			System.out.println("login button is not visible");
		}
	}
	
	public boolean launchApp(WebDriver driver, String sURL) throws IOException {
		boolean isAppLaunched = false;
		driver.get(sURL);
		String actualURL = driver.getCurrentUrl();
		if(actualURL.equals(sURL)) {
			isAppLaunched = true;
		} else {
			CommonUtils.captureScreenShot(driver);
		}
		return isAppLaunched;
	}
	
	public boolean isHomePageDisplayed() {
	
		return homeUserMenu.isDisplayed();
	}
	
	public boolean isLoginPageDisplayed(WebDriver driver) {
		return CommonUtils.waitForElement(driver, login);
	}

	public String getErrorMessage(WebDriver driver) {

		if (errormessage.isDisplayed()) {
			return errormessage.getText();
		} else {
			System.out.println("error message element is not visible");
			return "";
			
		}
	}
	
	public void selectRememberMeCheckbox(WebDriver driver) {
		if (rememberMe.isDisplayed()) {
			rememberMe.click();
		} else {
			System.out.println("checkRememberMe button is not visible");
		}
	}
	
	public boolean verifyRememberMeCheckbox() {
		boolean bIsCheckBoxSelected = false; 
		if(rememberMe.isSelected()) {
			bIsCheckBoxSelected = true;
		} else {
			rememberMe.click();
			bIsCheckBoxSelected = true;
		}
		return bIsCheckBoxSelected;
	}
	
	public String getUsernameAfterRemember(WebDriver driver) {

		if (usernameAfterRemember.isDisplayed()) {
			return usernameAfterRemember.getText();
			
		} else {
			System.out.println("User name element is not visible");
			return "";
		}
	}
}
