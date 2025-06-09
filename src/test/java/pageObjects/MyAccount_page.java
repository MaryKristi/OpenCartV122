package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount_page extends BasePage {

	public MyAccount_page(WebDriver driver) {
		super(driver);
		
	}
  
	 @FindBy(xpath="//*[@id=\"content\"]/h2[1]") WebElement msgMyAccount;  // MyAccount heading
	 
	 @FindBy(linkText="Logout")  WebElement clklogout; // added in step 6
	
	public boolean msgMyAccount() 
	{
		msgMyAccount.isDisplayed();
		return true;
		
	}
	
	public void clicklogout()
	{
		clklogout.click();
	}
	
}
