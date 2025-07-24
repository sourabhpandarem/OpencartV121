package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReportManger implements ITestListener {
 public ExtentSparkReporter sparkReporter;
 public ExtentReports extent;
 public ExtentTest test;
 
 String reName;
private String repName;
 
 public void onStart (ITestContext testContext) {
	 
	 /*SimpleDateFormat df =new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	  Date dt=new Date();   
	  String currentdatetimestamo=df.format(dt);
	  */
	 
	 String timeStamp=new SimpleDateFormat("yyyy,mm,dd.HH.mm,ss").format(new Date());
	  repName = "Test-Report-"+timeStamp+".html";
	 sparkReporter=new ExtentSparkReporter(".\\reports\\"+reName); // location of file 
	
	 sparkReporter.config().setDocumentTitle("opencart Automation Report"); //title of th report 
	 sparkReporter.config().setReportName("opencart Functional Testing");// name of the report 
	 sparkReporter.config().setTheme(Theme.DARK);
	 
	 extent=new ExtentReports();
	 extent.attachReporter(sparkReporter);
	 extent.setSystemInfo("Application","opencart");
	 extent.setSystemInfo("Module","Admin");
	 extent.setSystemInfo("sub module","customer");
	 extent.setSystemInfo("User Name",System.getProperty("Sourabh"));
	 extent.setSystemInfo("Environment","QA");
	 
	 String os = testContext.getCurrentXmlTest().getParameter ("os");
	 extent.setSystemInfo("Operating System", os);


	 String browser = testContext.getCurrentXmlTest().getParameter("browser");
	 extent.setSystemInfo("Browser", browser);

	 List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups ();
	 if(!includedGroups.isEmpty()) {
	 extent.setSystemInfo("Groups", includedGroups.toString());
	 }
 }

	 public void onTestSuccess (ITestResult result) {

	 test = extent.createTest(result.getTestClass().getName());
	 test.assignCategory(result.getMethod().getGroups());// to display groups in report test. Log (Status. PASS, result-getName ()+* got successfully executed");
     test.log(Status.PASS,result.getName()+"got successfully executed");
	 
	 }
	 public void onTestFailure(ITestResult result) {
		 test=extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 
		 test.log(Status.FAIL,result.getName()+"got failed");
		 test.log(Status.INFO,result.getThrowable().getMessage());
		 
		 try {
			 String imgpath= new BaseClass().captureScreen(result.getName());
			 test.addScreenCaptureFromPath(imgpath);
			 
		 }catch (IOException e1) {
			 e1.printStackTrace();
		 }
		 
	 }
	 public void onTestSkipped(ITestResult result) { 
		 test=extent.createTest(result.getTestClass().getName());
		 test.assignCategory(result.getMethod().getGroups());
		 test.log(Status.SKIP,result.getName()+"got skipped");
		 test.log(Status.INFO,result.getThrowable().getMessage());
		 
	 }
	 
	 public void onFinish (ITestContext testContext) {
		 
		 extent.flush();
		 
		
		String pathOfExtentReport=System.getProperty("user.dir")+"\\reports\\"+repName; 
		File extentReport= new File (pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e) {
			e.printStackTrace();
		
		}
		 
		
		/*
		  try {
			URL url=new URL("file:////"+System.getProperty("user.dir")+"\\reports\\"+repName);
	     
	     
	     //Create the email message 
	     ImageHtmlEmail email =new ImageHtmlEmail();
	     email.setDataSourceResolver(new DataSourceUrlResolver(url));
	     email.setHostName("smto.googleemail.com");// you chnag comany name 
	     email.setSmtpPort(465);
	     email.setAuthenticator(new DefaultAuthenticator("sourabhpandare.m@gmail.com","Shrisou@4020"));
	     email.setSSLOnConnect(true);
	     email.setFrom("sourabhpandare11@gmail.com"); //sender
         email.setSubject("Test Result ");
         email.setMsg("please find Attached Report....");
         email.addTo("sourabpandare.m@gmail.com"); //reciver
         email.attach(url,"extent report","please check Report.");
         email.send(); //send the email
		}
		catch(Exception e ) 
		{
			e.printStackTrace();
			}
	     */
		}
		
	 }
 
 
 
	
	
	

