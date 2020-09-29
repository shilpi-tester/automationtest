package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Baseclass {

	public static WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {
		
			// set path to chromedriver.exe
		System.setProperty("webdriver.chrome.driver", "../automationtest/src/test/resources/driver/chromedriver.exe");
		// create chrome instance
		driver = new ChromeDriver();
				
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
		System.out.println(browserName+" "+browserVersion);
		
		driver.manage().window().maximize();	//Maximize the Win
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void teardown() throws Exception {
		Thread.sleep(10000);;
		//driver.quit();
	}
}