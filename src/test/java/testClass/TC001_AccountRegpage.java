package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationpage;
import pageObjects.HomePage;
import testBase.Base_tests;

public class TC001_AccountRegpage extends Base_tests {
	
	@Test(groups= {"Regression","master"})
	public void Regester() throws InterruptedException
	{
		logger.info("** Starting TC001_AccountRegpage ***");
		try 
		{			
			HomePage hp= new HomePage(driver);
			hp.clkMyAccount();
			logger.info("click on MyAccount button");
			
			hp.clkReg();
			logger.info("click on Regester button");
					
			AccountRegistrationpage  reg= new AccountRegistrationpage(driver);
			
			logger.info("Providing Customer Details");
			
	//		reg.setfirstname("jyothi");
	//		reg.setlastname("jyo");
	//		reg.setEmail("jyo@gmail.com");
	//		reg.settelephone("23456734");
	//		reg.setpswd("jyo123");
	//		reg.setCfmpswd("jyo123");
	//		reg.setchkbox();
	//		reg.setsubmit();
			
			reg.setfirstname(randomString().toUpperCase());
			reg.setlastname(randomString().toUpperCase());
			reg.setEmail(randomString()+"@gmail.com");
			reg.settelephone(randomNumber());
			
			//giving same paswd
			
			String Pswd=randomAlphaNumber();
			reg.setpswd(Pswd);
			reg.setCfmpswd(Pswd);
			
			reg.setchkbox();
			reg.setsubmit();
					
			//msg confm		
			
			String msg = reg.setcnfmMsg();
			logger.error("Test Failed");
			logger.debug("DEBUG LOGS....");
			
			Assert.assertEquals(msg, "Your Account Has Been Created!");
			System.out.println("Succesfully regester your account");
			
			logger.info("Validated Experted msg & Succesfully regestered ");
//			if (msg.equals("Your Account Has Been Created!"))
//			{
//		    	Assert.assertTrue(true);
//		    	System.out.println("Succesfully regester your account");
//			}
//			else
//			{
//				System.out.println("Not regester your account");
//			} 
			
			
			
			//Thread.sleep(2000);
		}
		catch (Exception e)
		{
			
			Assert.fail();
		}
		 logger.info(" *** finished TC001_AccountRegpage ");
		
	}
}