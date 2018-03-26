import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class HRMSExtent {
	
	 ExtentReports report;
	 ExtentHtmlReporter htmlReporter;
	 ExtentTest logger;
	
	
	 @BeforeTest
	 public void startTest() {

	 report = new ExtentReports();
	 // Provide the Report Path
	 htmlReporter = new ExtentHtmlReporter("D://selenium//extentreports-java-2.41.2//extentreports-java-2.41.2//extent-config.html");
	 report.attachReporter(htmlReporter);
	 test =htmlReporter.star
	 report.setSystemInfo("Host Name", "Anshul-702HK");
	 report.setSystemInfo("Env", "Automation Testing");
	 report.setSystemInfo("User", "Anshul Chauhan");
	 }
	 
	 
	 
	 @Test
	  public void verifyLeaveErrorMessage() throws InterruptedException {
		  
		  
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
	  	   
	     }
	     
	     else
	     {
	  	  Assert.fail();
	  	   
	     }
	 }
}
