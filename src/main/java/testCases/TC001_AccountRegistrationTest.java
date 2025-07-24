package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test(groups={"Regression","Master"})
    public void verify_account_registration() throws InterruptedException {
        logger.info("****** Starting TC001_AccountRegistrationTest *******");

        try {
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on MyAccount link");

            hp.clickRegister();
            logger.info("Clicked on Register link");

            AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
            logger.info("Providing customer details");

            regPage.setFirstName(randomString().toUpperCase());
            regPage.setLastName(randomString().toUpperCase());
            regPage.setEmail(randomString() + "@"+"gmail.com");  // 
            regPage.setTelephone(randomNumber());

            String password = randomAlphanumeric(); // Store generated password
            regPage.setPassword(password);
            Thread.sleep(300);
            regPage.setConfirmPassword(password);
            Thread.sleep(300);

            regPage.setPrivacyPolicy();
            Thread.sleep(300);
            regPage.clickContinue();

            logger.info("Validating confirmation message...");

            String confMsg = regPage.getConfirmationMsg();
            Assert.assertEquals(confMsg, "Your Account Has Been Created!", "Account creation failed!");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            logger.debug("Exception stacktrace: ", e);
            Assert.fail("Test case failed due to exception.");
        }

        logger.info("****** Finished TC001_AccountRegistrationTest *******");
    }
}


	 
	
    	   
   	
    
	


