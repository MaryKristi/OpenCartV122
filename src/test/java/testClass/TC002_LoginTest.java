package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Login_Tc;
import pageObjects.MyAccount_page;
import testBase.Base_tests;

public class TC002_LoginTest extends Base_tests {
	
	
	@Test(groups= {"Sanity","master"})
	public void verify_login()
	{
		logger.info("***** Starting the testcase ******");
		try
		{
			//taking method from homepage
			 
			HomePage hp=new HomePage(driver);
			hp.clkMyAccount();
			hp.clicklogin();
			
			logger.info("Validating the values");
			
			//validating methos from Login Test
			
			Login_Tc lg= new Login_Tc(driver);
			lg.setEmail(p.getProperty("e-mail"));  // readib=ng email & password from propertiesfile
			lg.setPswd(p.getProperty("Pswd"));
			lg.btnlogin();
			
			//Myaccount
			MyAccount_page myac= new MyAccount_page(driver);
			boolean dis=myac.msgMyAccount();
			
			Assert.assertEquals(dis, true,"Login pass");
			
		} catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("***** finish the testcase ******");
	}

}


