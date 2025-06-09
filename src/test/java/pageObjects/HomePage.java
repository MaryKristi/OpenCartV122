package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
		WebDriver driver;
		
		public HomePage(WebDriver driver)
		{
			super(driver);
		}
		
		@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]") WebElement clkMyAccount;
		
		@FindBy(linkText="Register") WebElement clkReg;
		
		@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a") WebElement clicklogin; //add login test in step 5
		
		public void clkMyAccount()
		{
			clkMyAccount.click();
		
		}
		
		public void clkReg()
		{
			clkReg.click();
		}
		
		public void clicklogin()  //added method to login
		{
			clicklogin.click();
		}
	}


