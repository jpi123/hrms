import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class HRMS_ExtentReport {

	 ExtentReports extent;
	 //ExtentHtmlReporter htmlReporter;
	 ExtentTest test;
	 public static WebDriver driver; 
	 String baseUrl = "http://192.168.1.124:838/";
	 String expectedteString = "Please select from and to date as a working date.";
	
	@BeforeSuite
	public void beforesuit()
	{
		extent = new ExtentReports("D://extent-reports.html",true);
		extent.loadConfig(new File("D://selenium//extentreports-java-2.41.2//extentreports-java-2.41.2//extent-config.xml"));
		
	}
	
	
	@BeforeMethod
	public void Beforemethod(Method method)
	{
		test = extent.startTest(this.getClass().getSimpleName() +" : :" + method.getName(),method.getName());
		test.assignAuthor("Jignesh");
		test.assignCategory("Extent Report");
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
     
   }
	
	
  @Test
  public void VerifyErrorMessage() throws InterruptedException {
	
	
	  driver.get(baseUrl);
	  driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("blempone@trimantrallp.com");
      
      //Password Xpath
     	//String password = JOptionPane.showInputDialog(null,"Enter Password");
      driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("123456@Aa");

      //Click on Submit
      
      driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
      
      //After Login Gettext
      String username = driver.findElement(By.xpath(".//a//*[@class='username username-hide-on-mobile']")).getText();
      System.out.println(username);
      
//------------------------ Employee Validation Message Check --------------------------------


      driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[4]/a/span[1]")).click();
      driver.findElement(By.xpath("//a[text()='Add Leave Request']")).click();
      
      
      //Click on Apply Leave
      driver.findElement(By.xpath(".//*[@id='btnApplyLeave']")).click();
      
      Thread.sleep(3000);
      
      //Click on Apply Leave
      driver.findElement(By.xpath(".//*[@id='LeaveTypeId']")).click();
      driver.findElement(By.xpath(".//*[@id='LeaveTypeId']/option[2]")).click();
      
      
      //Click on Date Calendar
      driver.findElement(By.xpath(".//*[@id='LeaveRequestFromDate']")).sendKeys("18/11/2017",Keys.ENTER);
      Thread.sleep(3000);
      //driver.findElement(By.xpath("//table/tbody/tr[3]/td[5]")).click();
     
      
      //Apply Half day Leave
      driver.findElement(By.xpath(".//*[@id='half-day-option']//label/span")).click();
      Thread.sleep(3000);
      
      
      
      //Enter Reason for leave
      driver.findElement(By.xpath(".//*[@id='Reason']")).sendKeys("Not Feeling Well");
      Thread.sleep(3000);
      //Click on Submit
      driver.findElement(By.xpath(".//*[@id='ApplyLeaveModal']/div/div/div[3]/button[1]")).click();
      
      
     String validationcheck =  driver.findElement(By.xpath(".//*[@id='errorMessage']")).getText();
     System.out.println(validationcheck);
     
     if(validationcheck.equals(expectedteString))
     {
  	   System.out.println("Matched");
  	   test.log(LogStatus.PASS, "Actual resut Is " +  validationcheck  );
  	   
     }
     
     else
     {
    	 test.log(LogStatus.FAIL, "Actual resut Is :: " +  validationcheck + "Expected Result :: " +  expectedteString);
    	 
     }
  }
     
     @AfterMethod
     public void aftermethod()
     {
    	 
    	 driver.close();
    	 driver.quit();
    	 test.log(LogStatus.PASS, "Browser clossed Successfully");
    	 extent.endTest(test);
    	 
     }
     
     @AfterSuite
     public void end()
     {
    	 
    	 extent.flush();
    	// extent.close();
    	 
    	 
     }

}
