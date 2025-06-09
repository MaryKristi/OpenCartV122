package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.Login_Tc;
import pageObjects.MyAccount_page;
import testBase.Base_tests;
import utilities.Data_providers;

public class TC003_LoginDDT extends Base_tests {
	
	@Test(dataProvider="LoginData", dataProviderClass=Data_providers.class, groups= {"DataDriven","master"}) // geting data provider from different packagre
	public void  verify_loginDDT(String username, String password, String exp)
	{
		logger.info("***** Starting the testcase ******");
		
	   //HomePage
		 
		HomePage hp=new HomePage(driver);
		hp.clkMyAccount();
		hp.clicklogin();
		
		//Login_Tc		
		Login_Tc lp= new Login_Tc(driver);
		lp.setEmail(username);
		lp.setPswd(password);
		lp.btnlogin();
		
		logger.info("Validating the values");
		
		//MyAccount
		
		MyAccount_page myac= new MyAccount_page(driver);
		boolean targetPage=myac.msgMyAccount();
		//Assert.assertEquals(targetPage, true,"Login pass");
		System.out.println(targetPage);
		
		//logout
		//myac.clicklogout();
	
	
		
		if (exp.equals("Valid"))
		{
			if(targetPage==true)
			{
				myac.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				myac.clicklogout();
				Assert.assertTrue(false);
			}
		}
		 
//		if(exp.equals("Invalid")) //alert alert-danger alert-dismissible
//		{
//			
//			if(targetPage==false)
//				{
//					myac.clicklogout();
//					Assert.assertTrue(false);
//				}
//				else
//				{
//					Assert.assertTrue(true);
//				}			
//		}
		
		
		
	 
	}
	
}
