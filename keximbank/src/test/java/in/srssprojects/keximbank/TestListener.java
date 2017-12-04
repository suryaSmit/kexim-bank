package in.srssprojects.keximbank;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.ITest;

public class TestListener extends Listener implements ITestListener, ISuiteListener{
	
	
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.FAIL, "test failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "test skipped");
	}

	@Override
	public void onTestStart(ITestResult result) {
		startTest(result.getName());
		test.log(LogStatus.INFO, "test started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, "test passed");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		report = startReport();
		
	}

}
