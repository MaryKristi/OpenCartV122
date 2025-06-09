package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationpage extends BasePage {
	
	WebDriver driver;
	public AccountRegistrationpage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"input-firstname\"]") WebElement firstName;
	@FindBy(xpath="//*[@id=\"input-lastname\"]") WebElement lastName;
	@FindBy(xpath="//*[@id=\"input-email\"]") WebElement Email;
	@FindBy(xpath="//*[@id=\"input-telephone\"]") WebElement telephone;
	@FindBy(xpath="//*[@id=\"input-password\"]") WebElement Pswd;
	@FindBy(xpath="//*[@id=\"input-confirm\"]") WebElement Cfmpswd;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]") WebElement chkbox;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]") WebElement submit;
	
	@FindBy(xpath="//*[@id=\"content\"]/h1") WebElement cnfmMsg;
	//private WebElement msgConfirmation;
	
	public void setfirstname(String fname) 
	{
		firstName.sendKeys(fname);
	}
	
	public void setlastname(String lname) 
	{
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String email) 
	{
		Email.sendKeys(email);
	}
	
	public void settelephone(String tno) 
	{
		telephone.sendKeys(tno);
	}
	
	public void setpswd(String pswd) 
	{
		Pswd.sendKeys(pswd);
	}
	
	public void setCfmpswd(String cfpswd) 
	{
		Cfmpswd.sendKeys(cfpswd);
	}
	
	public void setchkbox() 
	{
		chkbox.click();
	}
	
	public void setsubmit() 
	{
		submit.click();
	}
	
	public String setcnfmMsg()
	{
		 return cnfmMsg.getText();
	}
	
}
