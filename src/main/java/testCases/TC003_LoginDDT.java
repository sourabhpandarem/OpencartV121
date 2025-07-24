package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;
import utilities.DataProviders;

/*Data is valid --login suuccess -testpass -logout
  Data is valid---login failed -test fail
  
  Data is invalid -logi success -test fail-logout 
  data is invalid -login failed -test pass
 */
public class TC003_LoginDDT extends BaseClass 
{
    
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven") //gettinf data provider from differnt calss 
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException
	{
		logger.info("******starting TC_003_loginDDT****");
		
		try
		{
		//Homepege
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
	
		hp.clickLogin();
		
		//Login
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty(email));
		lp.setpassword(p.getProperty(pwd));
		lp.clickLogin();
		
		//my account 
		MyAccountpage macc=new MyAccountpage(driver);
		boolean targetpage =macc.isMyAccountPageExists();
		
		if (exp.equalsIgnoreCase("Valid"))
		{
			if (targetpage=true)
			{
				macc.ClickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if (targetpage=true)
			{
				macc.ClickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);	
			}
			
		}
		}catch(Exception e)
		{
		 Assert.fail()	;
		}
		Thread.sleep(300);
		logger.info("******END TC_003_loginDDT****");
	}
}
	
