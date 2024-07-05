package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {
	
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
		
	}
	

@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstname;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastname;
@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmail;
@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;
@FindBy(xpath="//input[@id='input-password']")
WebElement txtpassword;
@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfirmPassword;
@FindBy(xpath="//input[@name='agree']")
WebElement chkdPolicy;
@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement confirmationmsg;
public void setFirstname(String fname) {
	txtFirstname.sendKeys(fname);
	
}
public void setlastname(String lname) {
	txtLastname.sendKeys(lname);
	}

public void setEmail(String email) {
	txtEmail.sendKeys(email);
	}

public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);
}

public void setPassword(String pwd) {
	txtpassword.sendKeys(pwd);	
}

public void setconfirmPassword(String pwd) {
	txtConfirmPassword.sendKeys(pwd);	
}

public void clickPolicy() {
	chkdPolicy.click();	
}

public void clickContinueButton() {
	btnContinue.click();	
}

public String getconfirmationmsg() {
	try{
		return confirmationmsg.getText();
	}catch(Exception e) {
		return(e.getMessage());
	}
	
}
}
