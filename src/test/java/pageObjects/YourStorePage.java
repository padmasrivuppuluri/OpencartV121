package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourStorePage extends BasePage {
	
	public YourStorePage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(xpath="//img[@title='Your Store']")
	WebElement openStoreImg;
	
	@FindBy(xpath="//a[text()='iPhone']")
	WebElement lnkProduct;
	
	@FindBy(xpath="//div[@id='cart']")
	WebElement btnItems;
	
	@FindBy(xpath="//p[text()='Your shopping cart is empty!']")
	WebElement itemstxtmsg;
	
	@FindBy(xpath="//table//tbody//tr//td[4]")
	WebElement itemsval;
	
	public void clickOpenStore() {
		openStoreImg.click();		
	}
	public void selectProduct() throws InterruptedException {
		lnkProduct.click();	
	}
	public void clickItems() {
		btnItems.click();
		
	}
	public String getItems() {
	    try {
	        if (itemsval.getText().equals("0")) {
	            return itemstxtmsg.getText();
	        } else {
	            return itemsval.getText();
	        }
	    } catch (Exception e) {
	        return e.getMessage();
	    }
	}

}
