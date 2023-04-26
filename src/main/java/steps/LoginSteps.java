package steps;

import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import pages.LoginPage;
import tests.BaseTest;

public class LoginSteps {
		
		private static WebDriver driver;
		public static LoginPage lp = new LoginPage(driver);
//	@Before	(order = 1)				//hooks
//	public void reportConfig() {
//		System.out.println("report...");
//	}
//	
	@Before	(order = 2)				//hooks
	public void setUp() {
		//System.out.println("Setup method...");
		 driver = BaseTest.getBrowserType("chrome", false);
		
	}
	
	@After					//hooks
	public void tearDown() {
		System.out.println("TearDown method...");
		driver.close();
	}
	
	
	@Given("User launches login page")
	public void user_launches_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		driver.get("https://login.salesforce.com/");
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		lp.username.sendKeys("kpravallika@abc.com");
		lp.password.sendKeys("saikona9");
	}
	
	
	@When("user do not clicks on remember me checkbox")
	public void user_do_not_clicks_on_remember_me_checkbox() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
	}


	@When("user clicks on button login")
	public void user_clicks_on_button_login() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		lp.login.click();
	}

	@Then("user should see the homepage")
	public void user_should_see_the_homepage() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
	}

	@When("user enters invalid username and password")
	public void user_enters_invalid_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}

	@Then("user should see the error message on the login screen")
	public void user_should_see_the_error_message_on_the_login_screen(DataTable errors) {
		//when we have a datatable as a parameter you can convert a datatable to the format you want
		//if wehave 2 set of values in datatable you can use maps now only one right we r using List
		//there is a method called as asList which converts all the given values into arraylist
		List<String> em = errors.asList();
		//we can use either iterator or foreach loop to fetch the values
		for(String string : em) {
			System.out.println(string);
		}
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
		String text = lp.errormessage.getText();
		System.out.println(text);
	}
	
	@When("user enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		System.out.println("UserName: "+string+" password: "+string2 );
	}
}
