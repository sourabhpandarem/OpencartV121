package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class  TC001_AccountRegistrationTest extends BaseClass
 {

	
/*public WebDriver driver;  
	@BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/"); // ✅ Replace with actual site URL
        driver.manage().window().maximize();
        
	}
	@AfterClass
    public void tearDown()
    {
    	driver.quit();
    }
      */           //  remove and put on base class
    @Test
  public  void verify_account_registration() throws InterruptedException
  {
	 HomePage hp = new HomePage(driver);
	 hp.clickMyAccount();
	 hp.clickRegister();
	 
	 AccountRegistrationPage regpage= new AccountRegistrationPage(driver); 
	  
	 /*regpage.setFirstName("john");
	 regpage.setLastName("David");
	 regpage.setEmail("abcjondavs@gmail.com");
	 regpage.setTelephone("12342314212");
	 
	 regpage.setPassword("xyz1234");
	 regpage.setConfirmPassword("xyz1234");
	 
	 regpage.setPrivacyPolicy();
	 regpage.clickContinue();
	 
	 String confmsg=regpage.getConfirmationMsg();
	 Assert.assertEquals(confmsg,"Your Account Has Been Created!");*/ // importent when just put on euser and run test that time give the data manualy so we use (15-7-2020
	 
	 regpage.setFirstName(randomString().toUpperCase());
	 regpage.setLastName(randomString().toUpperCase());
	 regpage.setEmail(randomString()+"@gamil.com");// randomly generated the email
	 regpage.setTelephone(randomNumber());
	 
	 
	 String password=randomAlphanumeric();  //this impotent bez password should not same so stor first in capture value in variable 
	 regpage.setPassword(password);
	 Thread.sleep(500);
	 regpage.setConfirmPassword(password);
	 Thread.sleep(500);
	 
	 regpage.setPrivacyPolicy();
	 Thread.sleep(500);
	 regpage.clickContinue();
	 
	 String confmsg=regpage.getConfirmationMsg();
	 Assert.assertEquals(confmsg,"Your Account Has Been Created!");
 }
    
   /* public String randomString()
    {
    	String generatedstring= RandomStringUtils.randomAlphabetic(5);
    	return generatedstring;
    }
    
    public String randomNumber()
    {
    	String generatednumber= RandomStringUtils.randomNumeric(10);
    	return generatednumber;
    }
    
    public String randomAlphanumeric()
    {
    	String generatedstring= RandomStringUtils.randomAlphanumeric(5);
    	String generatednumber=RandomStringUtils.randomNumeric(3);
    	return(generatedstring+"#"+generatednumber);
    }*/                                                                    // we use this in base class 
    
    
 } 
	 
	
    	   
   	
    
	


