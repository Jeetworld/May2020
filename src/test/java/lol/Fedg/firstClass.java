package lol.Fedg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firstClass {
	
	@Test
	public void abc()
	{
		System.out.println("This is the begining");
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
		
	}

}
