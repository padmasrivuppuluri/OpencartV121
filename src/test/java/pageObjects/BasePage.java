package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


//This is the parent of all page object classes--constructor is same for all page object classes
//We created this constructor bcoz every page object class should constructor so no need to write everytime pagefactory we will invoke this constructor and use it
//To call parent class we super keyword
public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
