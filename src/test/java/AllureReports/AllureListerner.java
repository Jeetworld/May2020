package AllureReports;


 import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListerner   implements ITestListener  {
	
	//WebDriver driver = BaseClass.getDriver();
	
	private static String getTestMethodName(ITestResult iTestResult)   //user deifned method
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
		
		
	}
	
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "{0}" , type= "text/plain")		//user defined 
	public static String saveTestxLog(String message)
	{
		
		return message;
		
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext iTestContext) {
		// TODO Auto-generated method stub
		System.out.println("Ï am in StartOn Mathod" + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", BaseClass.getDriver());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void onTestFailure(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		System.out.println("I am in onTestFailure method"+ getTestMethodName(iTestResult)+ "failed");
		
		Object testClass = iTestResult.getInstance();
		WebDriver driver = BaseClass.getDriver();
		if(driver instanceof WebDriver)
		{
			
			System.out.println("Screenshot captured for test case" +  getTestMethodName(iTestResult));
			saveFailureScreenShot(driver);
			
		}
		saveTestxLog(getTestMethodName(iTestResult)+ "failed and screenshot taken !");
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
