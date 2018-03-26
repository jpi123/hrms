import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;


public class HRMS_Attendance {
	public static WebDriver driver;
	
	String confirmAttendance = "Attendance Request Submitted Successfully.";
	
	@BeforeSuite
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	
	
		//Maximize Chrome
		driver.manage().window().maximize();
	
		//Set URL to Open 
        String baseUrl = "http://192.168.1.124:838/";
       
        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
	}
	
	//------------------------------------ Employee Attendance Request ----------------------------------
	  @Test (priority =1)
      public void employeeAddAttendance() throws InterruptedException
      {
	        //Login With Admin
	        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("blempone@trimantrallp.com");
	        
	        //Password Xpath
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("123456@Aa");
	
	        //Click on Submit
	        
	        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	        Thread.sleep(3000);
	        
	//--------------------------------- Employee Attendacne Menu Click -----------------------------------
	        
	        driver.findElement(By.xpath("//span[text()='My Attendance']")).click();
	        
	       //Click on Attendance aREquest Menu
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//a[@href='/Attendance/CreateAttendanceRequest']")).click();
	        
	        //Click on Attendance Dropdown Type
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='RequestType']")).click();
	        driver.findElement(By.xpath(".//*[@id='RequestType']/option[text()='Work From Home']")).click();
	        

	        //Date of attendacne
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='DatePickerSpan']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//tbody//td[@class='today day']")).click();
	        
	        
	        //Total Hour Calculation
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='TotalHourCalculationTypeDiv']//label[1]/span")).click();
	        
	        
	        //Start Time Selection
	        driver.findElement(By.xpath(".//*[@id='FirstCheckInTime']")).click();
	        driver.findElement(By.xpath(".//*[@id='FirstCheckInTime']")).clear();
	        driver.findElement(By.xpath(".//*[@id='FirstCheckInTime']")).sendKeys("17:16");
	        driver.findElement(By.xpath(".//*[@id='Comment']")).click();
	        
	        
	        //End Time Selection
	        driver.findElement(By.xpath(".//*[@id='LastCheckOutTime']")).click();
	        driver.findElement(By.xpath(".//*[@id='LastCheckOutTime']")).clear();
	        driver.findElement(By.xpath(".//*[@id='LastCheckOutTime']")).sendKeys("17:19");
	        driver.findElement(By.xpath(".//*[@id='FirstCheckInTime']")).click();
	        
	        //Comment
	        driver.findElement(By.xpath(".//*[@id='Comment']")).sendKeys("Working on Home");
	        
	        //File Upload
	        WebElement fileupload = driver.findElement(By.xpath(".//*[@id='DocumentName']"));
	        fileupload.sendKeys("D:\\Jignesh\\Projects\\HRMS\\HRMS\\1.png");
	       
	        //Click on Submit
	        driver.findElement(By.xpath(".//button[@type='submit']")).submit();
	        Thread.sleep(3000);
	        
	        String attendacne = driver.findElement(By.xpath(".//*[@id='AttendanceRequestAlert']/strong")).getText();
	        
	        
	        if (attendacne.equals(confirmAttendance))
	        {
	        	System.out.println("Success");
	        }
	        
	        else
	        {
	        	
	        	System.out.println("Failure");
	        }
	        
	        
	        //Logout
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a/span/strong[text()='Logout']")).click();
	   
	        
      }
	  
	  
	  //--------------------- Admin Approve Leave -----------------------------------
	  @Test (priority =2)
	  public void adminattendanceapprove() throws InterruptedException
      {
	        //Login With Admin
	        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin@trimantrallp.com");
	        
	        //Password Xpath
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("123456@Aa");
	
	        //Click on Submit
	        
	        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	        Thread.sleep(2000);
	        
	        
	        //Click on Attendacne Aprove Menu

	        driver.findElement(By.xpath("//span[text()='Team']")).click();
	        
	        
	       //Click on Attendance aREquest Menu
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[@href='/Attendance/AttendanceApprovalView']")).click();
	        
	        
	        //Click on Advance Search
	        driver.findElement(By.xpath(".//*[@id='my_portlet1']/div[1]//a")).click();
	        Thread.sleep(2000);
	        
	        //Click on  Employee Dropdown
	        driver.findElement(By.xpath(".//button[@class='multiselect dropdown-toggle mt-multiselect btn btn-default']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//input[@placeholder='Search']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//input[@placeholder='Search']")).sendKeys("BL one");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//input[@value='multiselect-all']")).click();
	        
	        //Click to close Employee Dropdown
	        driver.findElement(By.xpath(".//button[@class='multiselect dropdown-toggle mt-multiselect btn btn-default']")).click();
	        
	        //Click on Search Button
	        driver.findElement(By.xpath(".//*[@id='filtergrid']")).click();
	        
	        
	        //Click on Popup Icon
	        driver.findElement(By.xpath(".//*[@id='AttendanceApprovalActionLink']/i")).click();
	        
	        
	        //Popup Comment
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='ApprovalComment']")).sendKeys("Attendance Approved");
	        Thread.sleep(3000);
	        //Approve Button
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='BtnAttendanceApprove']")).submit();
	        
	        
	        
	  
      }
	  
	  
	  
	  
}
