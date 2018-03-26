import javax.swing.JOptionPane;

import junit.framework.Assert;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class HRMS_Negative_Case extends Helper {

	
	public static void temp(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Setting Up Chrome Driver
		
				System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				String expectedteString = "Please select from and to date as a working date.";
				
				String randomemail = RandomStringUtils.randomAlphabetic(5); 
				String randomname = RandomStringUtils.randomAlphabetic(4);
				String namestore =randomname;
				System.out.println(namestore);
				//Randoom Email
				
				
				//Maximize Chrome
				driver.manage().window().maximize();
				
				//Set URL 
		        String baseUrl = "http://192.168.1.124:838/";
		       
		        // launch Chrome and direct it to the Base URL
		        driver.get(baseUrl);
		
		
		        //--------------------------- EMPLOYEE LOGIN -----------------------------------------------------
		        
		        //Username xpath
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
