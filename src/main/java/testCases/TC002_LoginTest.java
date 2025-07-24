package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountpage;


public class TC002_LoginTest  extends BaseClass             //   extends BaseClass
{
	@Test(groups={"sanity","Master"})
	
	public void verify_login()
	{
		logger.info("****startign TC_002_LoginTest******");
		
		try 
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login 
		LoginPage lp=new LoginPage(driver);
		Thread.sleep(500);
		
		lp.setEmail(p.getProperty("email"));
		Thread.sleep(500);
		lp.setpassword(p.getProperty("password"));
		Thread.sleep(500);
		lp.clickLogin();
		
		
		//My Account
		
		MyAccountpage macc=new MyAccountpage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		
		//Assert.assertEquals(targetpage,true,"Login failed");	
		Assert.assertTrue(targetpage);
		}
	     catch(Exception e)
		{
		Assert.fail();
		}
		logger.info("****Finshed TC_002_LoginTest******");
		
		}
}
