package brewbrokerPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Helper.WaitHelper;

public class Homepage {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[@class='navbarRight__buttons__signIn']")
	WebElement login;
	

	public Homepage(WebDriver driver)
	{	
	this.driver=driver;
	}
	
	public void clickOnLogin() throws InterruptedException
	{
		WaitHelper.clickOn(driver, login, 3, null);
		
	}

	
	

}
