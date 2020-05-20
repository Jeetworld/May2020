package lol.Fedg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AllureReports.AllureListerner;
import AllureReports.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;


@Listeners({AllureListerner.class})
public class firstClass extends BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass( description="this is description comment from testNG comment from firstClass")

	@Description("This is description from allure") //allure  annotations
	@Epic("Epic from allure report: EPIC:001")
	@Feature("Feature from allure report")
	@Story("Story Name : from allure")
	@Step("stepwsie annotations from allure. Thjis must be included before any method") //we also include {0} , {1} in step for parameters
	@Severity(SeverityLevel.NORMAL)  //allure annotation
	public void abc()
	{
		
		//Tuteja
		System.out.println("This is the begining");
		BaseClass bc = new BaseClass();
		driver = bc.initialize_driver();
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
	
		
	}
	
	
	@Test(priority= 1, description= "this is test methof 2 from Testng annotations")
	@Description("2 description from allure report")
	@Epic("EPIC002: epci from allure report")
	@Feature("feature from allure rport")
	@Story("Story from allure rpeort : 2 test method")
	@Step("step from 2 allure report")
	@Severity(SeverityLevel.BLOCKER)
	public void abc1()
	{
		
		
		System.out.println("This is second method from TestNG second method");
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Stackoverflow");
		driver.findElement(By.name("qtp")).sendKeys("Stackoverflow");
			
	}
	
	

}
