package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	

	public WebDriver driver;  
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
    
	 public String randomString()
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
	    }
    
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public String randomString() {
        // Generates a random alphabetic string of length 5
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomNumber() {
        // Generates a random numeric string of length 10
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomAlphaNumeric() {
        // Generates a random alphanumeric string of 6 characters, separated with '@'
        String alphabetPart = RandomStringUtils.randomAlphabetic(3);
        String numberPart = RandomStringUtils.randomNumeric(3);
        return alphabetPart + "@" + numberPart;
    }

    // Main method to test output
    public static void main(String[] args) {
        BaseClass base = new BaseClass();
        System.out.println("Random String: " + base.randomString());
        System.out.println("Random Number: " + base.randomNumber());
        System.out.println("Random AlphaNumeric: " + base.randomAlphaNumeric());
    }*/
}

