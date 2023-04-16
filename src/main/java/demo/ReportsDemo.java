package demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportsDemo {
		
	public static void main(String[] args) {
		
		String sFileNamePrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\reports\\"+sFileNamePrefix+"_SFDC.PNG";
		
		// Report configuration
		ExtentReports extent = new ExtentReports();
		ExtentHtmlReporter report = new ExtentHtmlReporter(filePath);
		extent.attachReporter(report);
		
		//we shall start creating reports for individual testcases
		
		ExtentTest test = extent.createTest("TC01");
		test.log(Status.DEBUG, "username is entered");
		test.log(Status.DEBUG, "password is entered");
		test.log(Status.DEBUG, "login button is clicked");
		test.log(Status.FAIL, "TC01 IS passed");
		
		test = extent.createTest("TC02");
		test.log(Status.DEBUG, "username is entered");
		test.log(Status.DEBUG, "password is entered");
		test.log(Status.DEBUG, "login button is clicked");
		test.log(Status.PASS, "TC02 IS passed");
		extent.flush();
	}
}
