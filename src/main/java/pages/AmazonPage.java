package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import file.utils.CommonUtils;
public class AmazonPage extends BasePage {

		public AmazonPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
		public WebElement search ;
		
		@FindBy(xpath = "//span[contains(@id,'amazons-choice-label')]")
		public WebElement amazonsChoice;
		
		@FindBy(xpath = "(//div[@id='addToCart_feature_div'])[1]")
		public WebElement addToCart;
		
		@FindBy(xpath = "//div[@id='nav-cart-count-container']")
		public WebElement cartCount;
		
		@FindBy(xpath = "(//button[@data-action='a-popover-close'])[2]")
		public WebElement popupClose;
		
		@FindBy(xpath = "//img[contains(@alt,'Kindle Paperwhite (8 GB)')]")
		public WebElement verifyItem;
		
		public void enterKeywordInSearch(WebDriver driver, String skeyword) {

			if (search.isDisplayed()) {
				search.sendKeys(skeyword);
				search.sendKeys(Keys.ENTER);
			} else {
				System.out.println("search element is not visible");
			}
		}
			
		public void clickOnAmazonsChoice(WebDriver driver) {

			if (amazonsChoice.isDisplayed()) {
				amazonsChoice.click();
			} else {
				System.out.println(" AmazonsChoice element is not visible");
			}
		}
		
		public void clickOnAddToCartButton(WebDriver driver) {

			if (addToCart.isDisplayed()) {
				JavascriptExecutor je = (JavascriptExecutor) driver;
				je.executeScript("arguments[0].scrollIntoView(true);",addToCart);
				addToCart.click();
			} else {
				System.out.println(" AmazonsChoice element is not visible");
			}
		}
}
