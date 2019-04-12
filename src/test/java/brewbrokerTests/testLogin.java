package brewbrokerTests;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import brewbrokerPages.Homepage;
import brewbrokerPages.login;

public class testLogin {

	WebDriver driver;
	
	@BeforeTest
    @Parameters({"URL"})
	public void setUp(String URL) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","/home/ucreate-8/Public/ParveenSpace/chromedriver_linux64/chromedriver");
		driver=new ChromeDriver();
		driver.get(URL);	
	}
	  
	@Test(priority=0)
	public void loginBrewWithoutDetails() throws InterruptedException {
		
		Homepage home=PageFactory.initElements(driver, Homepage.class);
		home.clickOnLogin();
		
		login log=PageFactory.initElements(driver, login.class);
	    log.clickOnSignIn();
	   
	    
		boolean actual=driver.findElement(By.xpath("//span[@class='error-msg border-red']")).isDisplayed();
		Assert.assertTrue(actual);
		
	}
	
	@Parameters({"Email","Password"})
	@Test(priority=1)
	public void loginBrewWithInvalidEmail(String Email, String Password) throws InterruptedException {
		
	
		login log=PageFactory.initElements(driver, login.class);
		log.enterInvalidEmail(Email);
		log.enterPassword(Password);
		log.clickOnSignIn();
		
		boolean actual1=driver.findElement(By.xpath("//span[@class='error-msg']")).isDisplayed();
		Assert.assertTrue(actual1);
		
	}
	
   @Parameters({"Email1"})
   @Test(priority=2)
	public void loginBrewwithValidDetails(String Email1) throws InterruptedException {
	
		login log=PageFactory.initElements(driver, login.class);
		log.clearInvalidEmail();
		log.enterEmail(Email1);
		log.clickOnSignIn();
		
		boolean successlogin=driver.findElement(By.xpath("//img[@src='/b59f42661e88e8655577aedb361eb619.svg']")).isDisplayed();
		Assert.assertTrue(successlogin);
		
	}
}
