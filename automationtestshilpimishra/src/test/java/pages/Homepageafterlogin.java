package pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Homepageafterlogin extends Loginpage {

	//HoveroverDressesandcclick
		By dresses1 = By.xpath("//a[@title='Women']");
		By summerDresses1 = By.xpath("//a[@title='T-shirts']");
		
		//Changeviewmodetolist
		By Changeview = By.className("icon-th-list");
		
		//Verifications
		By instock = By.id("layered_quantity_1");
		By Blue = By.xpath("//ul[@id='ul_layered_id_attribute_group_3']/li[5]/label[1]/a[1]");
		
		//Quickview
		By ahower1 = By.xpath("(//a[@itemprop='url']//img)[1]");
		By Quickview = By.xpath("(//a[@class='quick-view'])[1]");
		
		//Share
		By colorblue = By.id("color_14");
		By share =  By.xpath("(//button[@type='button'])[2]");
		String winHandleBefore;

		//Select Qnt
		By Quantity = By.xpath(("/html[1]/body[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/p[1]/a[2]/span[1]"));
		
		//Whishlist
		By wishlist = By.id("wishlist_button");
		By close = By.xpath("//body[@id='product']/div[2]/div/div/a");
		
		//AddtoCart
		By Addtocart = By.xpath("//p[@id='add_to_cart']/button/span");
		
		//checkout
		By proceedtocheckout = By.xpath("//div[@id='layer_cart']/div/div[2]/div[4]/a/span");
		By checkout1 = By.xpath("//div[@id='center_column']/p[2]/a/span");
		By checkout2 = By.xpath("//div[@id='center_column']/form/p/button/span/i");
		By Agree = By.id("cgv");
		By checkout3 = By.xpath("//form[@id='form']/p/button/span");
		By payusing = By.linkText("Pay by bank wire (order processing will be longer)");
		By proceed = By.xpath("//p[@id='cart_navigation']/button/span");
		
		//viewmycustomeraccount
		By account = By.className("account");
		By verify = By.xpath("//span[text()='Order history and details']");
		By scroll = By.xpath("//span[@class='price']");
		
		
		@Test(priority = 1)
		public void Wait() throws InterruptedException {
			Thread.sleep(5000);
		}

		@Test(priority = 2) // Hover over dresses and click on summer dress submenu
		public void HoveroverDressesandcclick() throws InterruptedException {
			
			

			WebElement dresses = driver.findElement(dresses1);
			WebElement summerDresses = driver.findElement(summerDresses1);
			Actions action = new Actions(driver);
			Thread.sleep(2000); // Let the user actually see something!
			action.moveToElement(dresses).click(summerDresses).build().perform();
			
		}

		@Test(priority = 3) // Change mode view to list
		public void Changeviesmodetolist() throws InterruptedException {

			driver.findElement(Changeview).click();
		}

		@Test(priority = 4) // Verify Availability and colors.
		public void Verifications() throws InterruptedException {

			driver.findElement(instock).click();

			//driver.findElement(Blue).click();
		}

		@Test(priority = 5) // Verify Availability and colors.
		public void Quickview() throws InterruptedException {

			Thread.sleep(10000);
			WebElement ahower = driver.findElement(ahower1);
			Actions action = new Actions(driver);
			Thread.sleep(2000); // Let the user actually see something!
			action.moveToElement(ahower).build().perform();

			Thread.sleep(5000);
			driver.findElement(Quickview).click();;
			
		}

		@Test(priority = 6)
		public void share() throws InterruptedException{
			 Thread.sleep(15000);
			   winHandleBefore = driver.getWindowHandle();
			   driver.switchTo().frame(0);	//Switch to child frame.
			   driver.findElement(colorblue).click();
			   
			   driver.findElement(share).click();

			   Set<String> allWindows = driver.getWindowHandles();
			   for(String curWindow : allWindows){
			       driver.switchTo().window(curWindow);
			   }
			
				Thread.sleep(5000);
				if(driver.getCurrentUrl().contains("https://www.facebook.com/")) {
					System.out.println("Wow, Amazing it verifies it.");
					driver.close();
					driver.switchTo().window(winHandleBefore);
					driver.switchTo().frame(0);
				}else {
					System.out.println("Ahh, Something fishi is going.");
				}
		}
		
		@Test(priority = 7) // Select Qnt.
		public void SelectQnt() throws InterruptedException {
			Thread.sleep(2000);
			driver.findElement(Quantity).click();			

		}
		
		@Test(priority = 8) // Add to wishlist.
		public void addtowhishlist() throws InterruptedException {
			driver.findElement(wishlist).click();
		    Thread.sleep(2000);
		    driver.findElement(close).click();
		}
		
		@Test(priority = 9) // Add to Cart.
		public void addtocart() throws InterruptedException {
			driver.findElement(Addtocart).click(); //Click on Add to Cart
		    Thread.sleep(5000);
		}
		
		@Test(priority = 10) //checkout.
		public void checkout() throws InterruptedException {
			
			Thread.sleep(3000);
			
			 driver.findElement(proceedtocheckout).click();
			 Thread.sleep(6000);
			 driver.findElement(checkout1).click();
			 Thread.sleep(6000);
			 driver.findElement(checkout2).click();
			 Thread.sleep(3000);
			 driver.findElement(Agree).click();
			 Thread.sleep(6000);
			 driver.findElement(checkout3).click();
			 Thread.sleep(6000);
			 driver.findElement(payusing).click();
			 driver.findElement(proceed).click();
		}
		
		@Test(priority = 10) //Verify.
		public void viewmycustomeraccount() throws InterruptedException{
			
			
			driver.findElement(account).click();
			driver.findElement(verify).click();
			driver.findElement(scroll).click();
			
			
		}
	}
