package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import test.Baseclass;

public class Loginpage extends Baseclass {

	String testing_url = "http://automationpractice.com/index.php";
	By email = By.name("email");
	String email1 ="shilpitripathi56@gmail.com";
	By password = By.name("passwd");
	String password1 = "Test@123456";
	By login = By.name("SubmitLogin");
	
	@Test(priority = 0)
	public void Login() throws InterruptedException{
	
		driver.get(testing_url);
		Thread.sleep(5000); // Let the user actually see something!
		driver.findElement(By.className("login")).click();
		Thread.sleep(5000); // Let the user actually see something!
	
	    driver.findElement(email).sendKeys(email1);	// enter username
		
		driver.findElement(password).sendKeys(password1);	// enter password
		
		driver.findElement(login).click(); //Login
}
}
