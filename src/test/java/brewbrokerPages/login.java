package brewbrokerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Helper.WaitHelper;

public class login {
 
	WebDriver driver;

	
	@FindBy(xpath="//input[@name='loginemail']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='loginpassword']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement signIn;
	
	

	public login(WebDriver driver)
	{
	this.driver=driver;
		
	}

    public void enterEmail(String Email) throws InterruptedException
    
	{
		WaitHelper.sendKeys(driver, email, 10, Email);
		
    }
	
	public void enterInvalidEmail(String Email1) throws InterruptedException
	{
		WaitHelper.sendKeys(driver, email, 10, Email1);
		
	}
	
	public void clearInvalidEmail() throws InterruptedException
	{
		email.clear();
		
	}
	
	public void enterPassword(String Password) throws InterruptedException
	{
	WaitHelper.sendKeys(driver, password, 10, Password);
	}
	
	
	
	public void clickOnSignIn() throws InterruptedException
	{
		WaitHelper.clickOn(driver, signIn, 10, null);
	}
}
