package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;



public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven") //getting dataprovider from different class
	public void verify_loginDDT(String email,String pwd,String expres) {
		logger.info("..........Starting TC003_LoginDDT.........");
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		//we need to do all the validations below mentioned
		/*Data is valid  - login success - test pass  - logout
		                  -- login failed - test fail

		Data is invalid - login success - test fail  - logout
		Data is invalid -- login failed - test pass
		*/
		
		if(expres.equalsIgnoreCase("Valid")) 
		{
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(targetPage);//Data is valid,login is succes,Test passed,click logout
				 
			}
			else {
				Assert.assertTrue(false);  //If login is failed
			}
			
		}
		if(expres.equalsIgnoreCase("Invalid")){
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
			
		}
		}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("..........Finished TC003_LoginDDT.........");	
		
	}
	
}
