package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
		

public class OpportunitiesPage extends BasePage {
	
	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//li//a[text()='Opportunities']")
	public WebElement opportunities ;
	
	@FindBy(xpath = "//span//select[@name='fcf']")
	public WebElement allOpportunitiesDropdown;
	
	@FindBy(xpath = "//input[@title='New']")
	public WebElement newButton;
	
	@FindBy(xpath = "//input[@id='opp3']")
	public WebElement oppourtunitiesName;
	
	@FindBy(xpath = "//input[@id='opp4']")
	public WebElement accountName;
	
	@FindBy(xpath = "//input[@id='opp9']")
	public WebElement closeDate;

	@FindBy(xpath = "//select[@id='opp11']")
	public WebElement stage;
	
	@FindBy(xpath = "//input[@id='opp12']")
	public WebElement probability;
	
	@FindBy(xpath = "//select[@id='opp6']")
	public WebElement leadSource;
	
	@FindBy(xpath = "//input[@id='opp17']")
	public WebElement primaryCampignSource;

	@FindBy(xpath = "(//input[@value=' Save '])[1]")
	public WebElement saveButton;
	
	@FindBy(xpath = "//a[contains(text(),'Opportunity Pipeline')]")
	public WebElement oppourtunityPipeline;
	
	@FindBy(xpath = "//a[contains(text(),'Stuck Opportunities')]")
	public WebElement stuckOppourtunity;
	
	////select[@id='quarter_q']
public void clickOpportunitiesTab(WebDriver driver) {
	if (opportunities.isDisplayed()) {
		opportunities.click();
	} else {
		System.out.println("opportunities tab is not visible");
	}
}

public void AllOpportunitiesSearchBox(WebDriver driver) {
	if (allOpportunitiesDropdown.isDisplayed()) {
		allOpportunitiesDropdown.click();
	} else {
		System.out.println("All opportunities SearchBox is not visible");
	}
}

public void clickOnNewButton(WebDriver driver) {
	if (newButton.isDisplayed()) {
		newButton.click();
	} else {
		System.out.println("new button is not visible");
	}
}

//New Opportunity Edit page is displayed. 
//Enter Opportunity Name,Account Name,Close Date,Stage,Probability,Lead Source ,
//Primary Campaign Source and click on save button.

public void enteroppourtunitiesName(WebDriver driver, String sname) {
	if (oppourtunitiesName.isDisplayed()) {
		oppourtunitiesName.sendKeys(sname);
	} else {
		System.out.println("oppourtunityname element is not visible");
	}
}

public void enterAccountName(WebDriver driver, String sname) {
	if (accountName.isDisplayed()) {
		accountName.sendKeys(sname);
	} else {
		System.out.println("accountName element is not visible");
	}
}
public void enterCloseDate(WebDriver driver, String sname) {
	if (closeDate.isDisplayed()) {
		closeDate.sendKeys(sname);
	} else {
		System.out.println("closeDate element is not visible");
	}
}

public void clickSaveButton(WebDriver driver) {
	if (saveButton.isDisplayed()) {
		saveButton.click();
	} else {
		System.out.println("savebutton is not visible");
	}
}

public void clickOppurtunityPipeLineButton(WebDriver driver) {
	if (oppourtunityPipeline.isDisplayed()) {
		oppourtunityPipeline.click();
	} else {
		System.out.println("oppourtunityPipeline is not visible");
	}
}

/*SalesForce login page is launched and application home page is logged in with correct username.
Opportunities home page is displayed
Report Page with the Opportunities that are pipelined will be displayed.*/

public void clickStuckOppurtunity(WebDriver driver) {
	if (stuckOppourtunity.isDisplayed()) {
		stuckOppourtunity.click();
	} else {
		System.out.println("stuckoppourtunity is not visible");
	}
}
}