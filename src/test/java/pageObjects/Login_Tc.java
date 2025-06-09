package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Tc extends BasePage{

	public Login_Tc(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@id=\"input-email\"]") WebElement txtEmail;
	@FindBy(xpath="//*[@id=\"input-password\"]") WebElement txtPswd;

	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input") WebElement btnlogin;

	
	public void setEmail(String email)
	{
		
		txtEmail.sendKeys(email);
	}
	
	public void setPswd(String pswd)
		{
			txtPswd.sendKeys(pswd);
		}
	
	public void btnlogin()
	{
		btnlogin.click();
	}
	

}
