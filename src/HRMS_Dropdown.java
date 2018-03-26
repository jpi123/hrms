import java.io.File;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;


public class HRMS_Dropdown {

	public static WebDriver driver;
	String randomname = RandomStringUtils.randomAlphabetic(4);
	String namestore = randomname;
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
	
	
	@Test
	public void empApplyLeave() throws InterruptedException
    {
    	
		 //Login With Admin
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("blempone@trimantrallp.com");
        
        //Password Xpath
        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("123456@Aa");

        //Click on Submit
        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
        Thread.sleep(3000);
		
		
		Thread.sleep(3000);
        //Open Leave Menu
        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[4]/a/span[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Add Leave Request']")).click();
        
        Thread.sleep(2000);
        List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='ViewLeaveRequest_grid-table']/tbody/tr")); 
                System.out.println("No of rows are : " + rows.size());
                
                
                
                List <WebElement> col = driver.findElements(By.xpath("//table[@class='ui-jqgrid-htable ui-common-table ']/thead/tr/th")); 
                        System.out.println("No of col are : " + col.size());
        
                        for (int i =1;i<rows.size();i++)
                        {    //*[@id='ViewLeaveRequest_grid-table']/tbody/tr[" + (i+1)+ "]/td[1]
                            String getname = driver.findElement(By.xpath(" .//*[@id='ViewLeaveRequest_grid-table']/tbody/tr[" + (i+1)+ "]/td[2]")).getText();
                            System.out.println(getname);
                            
                            if(getname.equals("Penalty"))
                            {
                            	System.out.println("matched");
                            	
                            }
                            
                            else
                            {
                            	
                            }
        
                    	}
	         
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	      /*  //Click on Admin Menu
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[3]/a")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[3]/ul/li[1]/a")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='my_portlet1']/div[1]/div[2]/a")).click();
	        
	        
	        //Get DropDown Value
	         
	        Select oselect = new Select(driver.findElement(By.xpath(".//*[@id='DepartmentId']")));
	       
	        List <WebElement> osize = oselect.getOptions();
	        int listsize = osize.size();
	        
	        for(int i=0;i<listsize;i++)
	        {
	        	
	        	String svalue = oselect.getOptions().get(i).getText();
	        	System.out.println(svalue);
	        	if(svalue.equals("Op"))
	        	{
	        		System.out.println("Matched");
	        	}
	        	else 
	        	{
	        		System.out.println("Failed");
	        		
	        	}
	        }*/
     }	
}
