package listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import file.utils.CommonUtils;
import tests.BaseTest;


public class SfdcListeners extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//			CommonUtils.captureScreenShot();
		
//		BaseTest.test.pass(result.getName()+" passed");
		BaseTest.test.pass(MarkupHelper.createLabel(result.getName()+" passed", ExtentColor.GREEN));
		logger.debug("SfdcListeners: onTestSuccess: Test passed  "+result.getName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			String screenShotPath = CommonUtils.captureScreenShot(getDriver());
			logger.debug("SfdcListeners: onTestFailure: screen shot captured for test "+result.getName());
			BaseTest.test.addScreenCaptureFromPath(screenShotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseTest.test.fail(MarkupHelper.createLabel(result.getName()+" failed", ExtentColor.RED));
		logger.debug("SfdcListeners: onTestFailure: Test Failed "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
