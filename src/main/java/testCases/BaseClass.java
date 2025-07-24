package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger; // add this for log file 


public class BaseClass {

	

public static WebDriver driver;  
public Logger logger;
public Properties p;
private String tname;
private String targetFilepath;
	
	
	@BeforeClass(groups= {"sanity","Regression","Master"})
	@Parameters({"os","browser"})
    public void setup(String os,String br) throws IOException 
	{
		
		//Loading Config.properties file 
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file); 
		
		
		
		
		logger= LogManager.getLogger(this.getClass()); //log4j2
		
		
		if(p.getProperty("excution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities=new DesiredCapabilities();
				
				//os
				
				if(os.equalsIgnoreCase("windows"))
				{
					capabilities.setPlatform(Platform.WIN11);
					
				}
				else if(os.equalsIgnoreCase("mac"))
				{
				   capabilities.setPlatform(Platform.MAC);
				}
				else
				{
					System.out.println("No matching os ");
					return;
				}
				
				//browser 
				
				switch(br.toLowerCase())
				{
				case "chrome":capabilities.setBrowserName("chrome");break;
				case "edge":capabilities.setBrowserName("MicrosoftEdge");break;
				defult:System.out.println("No matching browser");return;
				
				}
				driver=new RemoteWebDriver(new URL("http://localhost:4444/Wd/hub"),capabilities);)
		
			}
		if(p.getProperty("excution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case"chrome":driver=new ChromeDriver();break;
			case"edge":driver=new EdgeDriver();break;
			case"firefox":driver=new FirefoxDriver();break;
			default :System.out.println("Invalid browser name..."); return;
			
			}
			
			
		}		
				
		
       
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL")); // reading URL from properties file 
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
	    	return(generatedstring+"@"+generatednumber);
	    }
	    public String captureScreen(String tname) throws IOException 
		{
			
			String timeStamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
			
			TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
			File sourcefile=takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			 String targetPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilepath);
			
			sourcefile.renameTo(targetFile);
			
			return targetFilepath;	  
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

