package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	@Test(groups={"Regression","Master"})
	public void verify_accountRegistration () {
		try {
		logger.info("*****Started TC001_AccountRegistrationTest ");
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info("*****Clicked on My account ");
		hp.clickRegister();
		logger.info("*****Clicked on Register link ");
		
		AccountRegisterPage regpage=new AccountRegisterPage(driver);
		logger.info("*****Entering Personal Details***** ");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setlastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String passowrd=randomAlphaNumeric();
		regpage.setPassword(passowrd);
		regpage.setconfirmPassword(passowrd);
		regpage.clickPolicy();
		regpage.clickContinueButton();
		
		logger.info("Validating Expected Message");
		String confmsg=regpage.getconfirmationmsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	
		}	catch(Exception e) {
			Assert.fail();
		}
		logger.info("Finished test case execution");
	}
	
	
	

}
