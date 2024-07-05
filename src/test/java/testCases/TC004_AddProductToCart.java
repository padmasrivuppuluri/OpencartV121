package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.YourStorePage;
import testBase.BaseClass;

public class TC004_AddProductToCart extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_AddProductToCart() throws InterruptedException {
		logger.info("Starting TC002_LoginTest");
		
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		YourStorePage ysp=new YourStorePage(driver);
		ysp.clickOpenStore();
		ysp.selectProduct();
		Thread.sleep(3000);
		
		ProductPage pp=new ProductPage(driver);
		pp.clickAddToCart();
		
		ysp.clickItems();
		Thread.sleep(2000);
		ysp.getItems();
	
		}
	}

