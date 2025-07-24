package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountpage extends Basepage{

	private WebElement msgHeading1  ;
	public MyAccountpage(WebDriver driver) {
		super(driver);
		
	}
		@FindBy(xpath= "//h2[text()='My Account']") //MyAccountpage hending 
		
		WebElement msgHeading;
		
		@FindBy(xpath= "//div[@class='list-group']//a[text()='Logout']") //added in step 6  6.3
		WebElement lnkLogout;
		
		
		public boolean isMyAccountPageExists()
		{
		     try
		     {
			return(msgHeading1  .isDisplayed());
		     }
		     catch(Exception e)
		     {
		    	 return false;
		     }
		
	}
		public void ClickLogout()
		{
			lnkLogout.click();
		}

	
	
}
