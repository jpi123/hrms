import java.io.File;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Log;

public class HRMS_Automation_Script {

	public static WebDriver driver;
	String randomemail = RandomStringUtils.randomAlphabetic(5); 
	String randomname = RandomStringUtils.randomAlphabetic(4);
	String confirmsuccess = "Employee created successfully";
	String confirmskillsuccess = "Skill Added Successfully";
	String confirmLeaveSuccess = "Leave applied successfully";
	String confirmLeaveApprove = "Leave request approved successfully";
	String confirmAttendance = "Attendance Request Submitted Successfully.";
	String namestore = randomname;
	String emailstore = randomemail;
	ExtentReports extent;
	ExtentTest test;
	
	//Initializing Logger for Display in Console
	Logger log = Logger.getLogger("devpinoyLogger");
	
		//------------------ Setting Up Chrome browser---------------------------------------
		
		@BeforeSuite
		public void setup()
		{
		
			//-------------------- PhantomJs Code ------------------------------------------
			
			File file = new File("C:\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");				
            System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
            driver = new PhantomJSDriver();	
            driver.manage().window().maximize();
           
			
			
			
			//-----------------------------------------------------------------------------
			
			
			
			//Setting Path for Chrome Browser to Open
			//System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
			//driver = new ChromeDriver();
			
			//Initializing Extent Report path to Generate
			extent = new ExtentReports("D://extent-reports.html",true);
			extent.loadConfig(new File("D://selenium//extentreports-java-2.41.2//extentreports-java-2.41.2//extent-config.xml"));
		
			
			//Maximize Chrome
			driver.manage().window().maximize();
		
			//Set URL to Open 
	        String baseUrl = "http://192.168.1.124:838/";
	       
	        // launch Chrome and direct it to the Base URL
	        driver.get(baseUrl);
	        
	        //Log Message
	       log.info("Open Website");
		}
		
		@BeforeMethod
		public void Beforemethod(Method method)
		{
			//Used For Exent Report Purpose
			test = extent.startTest(this.getClass().getSimpleName() +" : :" + method.getName(),method.getName());
			test.assignAuthor("Jignesh");
			test.assignCategory("Extent Report");    
			
		}
       
        //---------------------------- ADMIN ADD NEW EMPLOYEE ---------------------------------------------
        
        @Test (priority = 1)
        public void addnewemployee() throws InterruptedException
        {
        	//Login With Admin
        	log.info("Admin Login");
	        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin@trimantrallp.com");
	        
	        
	        //Password Xpath
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("123456@Aa");
	
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	        Thread.sleep(3000);
	        log.info("Clicked on Submit");
	        
	        String abc = driver.findElement(By.xpath(".//*[@id='header_notification_bar']//*[@class='badge badge-default']")).getText();
	        System.out.println(abc);
	        
	       //-------------Admin Add New Employee
	        
	       //Click on ADD NEW EMPLOYEE Menu
	        log.info("--------------------------- Adding New Employee Details ----------------------------------------");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[3]/a")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']//li[3]/a[@href='/Employee/EmployeeRegistration']")).click();
	        
	        //Enter FirstName 
	        log.info("Entering FirstName");
	        driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys("bl");
	        
	        //Enter MiddleName
	        log.info("Entering MiddleName");
	        driver.findElement(By.xpath(".//*[@id='MiddleName']")).sendKeys("Emp");
	        
	        //Enter lastname
	        log.info("Entering LastName");
	        driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys(namestore);
	        
	        // Enter Random Email
	        log.info("Creating RandomEmail");
	        driver.findElement(By.xpath(".//*[@id='EmailId']")).sendKeys("demo" + emailstore + "@trimantrallp.com");
	        
	        boolean str = driver.findElement(By.xpath(".//*[@id='EmployeeRegistration']//label[@class='mt-radio mt-radio-outline margin-bottom-custom'][1]/span")).isDisplayed();
	       
	        //Click on Radio Buttons
	        driver.findElement(By.xpath(".//*[@id='EmployeeRegistration']//label[@class='mt-radio mt-radio-outline margin-bottom-custom'][1]/span")).click();
	        
	        driver.findElement(By.xpath(".//*[@id='MobileNo']")).sendKeys("9856321456");
	        
	        //Click on Country
	        log.info("Selecting Country");
	        driver.findElement(By.xpath(".//*[@id='CountryId']")).click();
	       WebElement str1 =  driver.findElement(By.xpath(".//*[@id='CountryId']/option[2]"));
	       str1.click();
	       String city = str1.getText();
	       System.out.println("hello" +city);
	        
	        
	        //Click on State,City
	        log.info("Selecting State");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='StateId']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='StateId']/option[2]")).click();
	        
	        log.info("Selecting City");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='CityId']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='CityId']/option[2]")).click();
	        
	        //Click on Bday
	        log.info("Entering Bday");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='BirthDate']")).sendKeys("11/06/1900",Keys.ENTER);
	        
	        //Click on Location
	        log.info("Entering Location");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='LocationId']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='LocationId']/option[4]")).click();
	        
	        //Click  on Joining Date
	        log.info("Selecting Joining Date");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='JoiningDate']")).sendKeys("13/12/2017",Keys.ENTER);
	        
	        //Click on Department
	        log.info("Selecting Department");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='DepartmentId']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='DepartmentId']/option[19]")).click();
	        
	        //Click on Designation
	        log.info("Selecting Designation");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='DesignationId']"));
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='DesignationId']/option[8]")).click();
	        
	        //Scroll Down
	        JavascriptExecutor jse = (JavascriptExecutor)driver;
	        jse.executeScript("scroll(0, 250);");
	        
	        //Click on CTC
	        log.info("Entering CTC"); 
	        driver.findElement(By.xpath(".//*[@id='CTC']")).sendKeys("10000");
	        
	        //Click on Source Hire
	        log.info("Source of Hire");
	        driver.findElement(By.xpath(".//*[@id='SourceOfHireId']")).click();
	        driver.findElement(By.xpath(".//*[@id='SourceOfHireId']/option[2]")).click();
	        
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='AddEmployeebtn']")).click();
	        //Thread.sleep(5000);
	        log.info("Click on Submit Add Button");
	        
	        //Confirmation Dialog Box 
	        log.info("Click on Confirmation Button");
	        Thread.sleep(5000);
	        driver.findElement(By.xpath(".//*[@id='AddEmployeeModalSubmitbtn']")).click();
	        Thread.sleep(3000);
	        String sucessmessage = driver.findElement(By.xpath(".//*[@id='my-msg']")).getText();
	        System.out.println("Printed messsage" + sucessmessage);
	       
		    driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
		    driver.findElement(By.xpath("//a/span/strong[text()='Logout']")).click();
		    log.info("Logout");
	       
	       
	       

//	        Thread.sleep(3000);
//	        String sucessmessage = driver.findElement(By.xpath(".//*[@id='my-msg']")).getText();
//	        Thread.sleep(3000);
//	        if(sucessmessage.equals(confirmsuccess))
//	        {
//	           System.out.println("Success");
//	       	   test.log(LogStatus.PASS, "Actual resut Is " +  sucessmessage  );
//	        }
//	        else
//	        {
//	        	test.log(LogStatus.FAIL, "Actual resut Is :: " +  sucessmessage + "Expected Result :: " +  confirmsuccess);
//	        	Assert.fail();	
//	        }
//	        
	        //Logout
	        
        
        }
        
        //--------------------------- EMPLOYEE LOGIN -----------------------------------------------------
        
        @Test (priority = 2)
        public void employeeLogin() throws InterruptedException
        {
	         //Username xpath
        	 log.info("Employee Login");
	         driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("demo" + randomemail +"@trimantrallp.com");
	        
	        //Password Xpath
	         log.info("Enter Password");
	       	String password = JOptionPane.showInputDialog(null,"Enter Password");
	       	Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys(password);
	
	        //Click on Submit 
	        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	        
	        //After Login Gettext
	        log.info("Succesfull Login");
	        String username = driver.findElement(By.xpath(".//a//*[@class='username username-hide-on-mobile']")).getText();
	        System.out.println(username);
	        
	     // --------------------------- Edit User Profile ------------------------------------
	       
	        //Edit User Profile
	        log.info("Click on User profile and Filling all details");
	        driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
	        driver.findElement(By.xpath("//a[@href='/Profile']")).click();
	      
	        //Enter Nationality
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='Nationality']")).sendKeys("Indian");
	        //Enter Religious
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='Religeous']")).sendKeys("Hindu");
	        
	        //Enter Blood Group
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='BloodGroup']")).click();
	        driver.findElement(By.xpath(".//*[@id='BloodGroup']/option[4]")).click();
	        
	        //Enter Maritial Status
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='MaritalStatus']")).click();
	        driver.findElement(By.xpath(".//*[@id='MaritalStatus']/option[2]")).click();
	        
	        //Enter Hobbies
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='Hobbies']")).sendKeys("Playing Cricket");
	        
	        //Select Language  
	        driver.findElement(By.xpath(".//*[@id='PersonalDetailForm']/div[4]/div[3]/div/div/label[1]/span")).click();
	        //driver.findElement(By.xpath("//label[@class='mt-checkbox mt-checkbox-outline']/input[@id='LanguagesKnown_0__Checked']")).click();
	        driver.findElement(By.xpath(".//*[@id='PersonalDetailForm']/div[6]/button[@type='submit']")).click();
	        
	        
	        //-------------------------- Contact Detail Code --------------------------
	        log.info("Entering all Contact delete");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='Personaldetail-tab-1']//li[3]/a")).click();
	        
	        Thread.sleep(3000);
	        //Entering Address
	        driver.findElement(By.xpath(".//*[@id='Address1']")).sendKeys("Near Carol Baug");
	        
	        //Entering Country
	        driver.findElement(By.xpath(".//*[@id='CountryId1']")).click();
	        driver.findElement(By.xpath(".//*[@id='CountryId1']/option[2]")).click();
	        
	        //Entering State
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='StateId1']/option[11]")).click();
	        
	        //Entering City
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='CityId1']/option[2]")).click();
	        
	        //Entering Mobile No
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='MobileNo']")).sendKeys("9874563215");
	        
	        //----------------------- Emergency Contact Details --------------------------
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='RelativeName1']")).sendKeys("Rohan");
	        driver.findElement(By.xpath(".//*[@id='Relation1']")).sendKeys("Father");
	        driver.findElement(By.xpath(".//*[@id='RelativeContactno1']")).sendKeys("9874563210");
	        
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='ContactDetailForm']//button[@type='submit']")).click();
	        
	        //--------------------------- ADD CERTIFICATION DETAILS -----------------------------
	        
	        log.info("Entering All Certification Details");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='ExperianceMainTab']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='EmployeeCertificationEntryForm']//div[2]/a[@href='javascript:;']")).click();
	        
	        //Add Certificate Type
	        driver.findElement(By.xpath(".//*[@id='Certification']")).sendKeys("ISTQBnew");
	        
	        //Click on Submit Button
	        driver.findElement(By.xpath(".//*[@id='SubmitButton']")).click();
	        
	        //------------------------ ADD EXPERINCE DETAILS -----------------------------------
	        log.info("Entering Experince Details");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='ExperienceDetail-tab-1']//ul/li[2]/a[@href='#Experience_Detail_Tab']")).click();
	        Thread.sleep(2000);
	        //Open Experience Menu
	        driver.findElement(By.xpath(".//*[@id='EmployeeExperience']//div[2]/a[@href='javascript:;']")).click();
	        Thread.sleep(2000);
	        
	        
	        //Enter Organization Name
	        driver.findElement(By.xpath(".//*[@id='OrganizationName']")).sendKeys("Abc");
	        
	        //Enter DesignatioN Name
	        driver.findElement(By.xpath(".//*[@id='DesignationName']")).sendKeys("QA");
	        
	        //Enter CTC
	        driver.findElement(By.xpath(".//*[@id='LastCTC']")).sendKeys("10000");
	        
	        //From Date
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='FromDate']")).sendKeys("13/05/2017");
	       
	        Thread.sleep(2000);
	       
	        //End date
	        driver.findElement(By.xpath(".//*[@id='ToDate']")).sendKeys("13/10/2017");
	        
	        //Job Description
	        driver.findElement(By.xpath(".//*[@id='JobDescription']")).sendKeys("estign");
	        
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='btnEmployeeExperience']")).click();
	        
	       //-------------------------------- ADD EDUCATION ---------------------------------
	        
	        log.info("Entering Education Detials");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='ExperienceDetail-tab-1']//a[@href='#Education_Detail_Tab']")).click();
	        Thread.sleep(3000);
	        //Open Education Menu
	        driver.findElement(By.xpath(".//*[@id='test']//a[@href='javascript:;']")).click();
	            
	        //Add qualification
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='QualificationId']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='QualificationId']/option[3]")).click();
	      
	        //Add Institute
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='InstituteId']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='InstituteId']/option[3]")).click();
	        
	        //Add Start Date
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='StartDate']")).sendKeys("1/2016");
	        
	        //Add End date
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='EndDate']")).sendKeys("11/2017");
	        
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='EducationBtnSubmit']")).click();
	        
	        //----------------------------ADD SKILLS --------------------------------
	        
	        //Click on Skills
	        log.info("Entering Skills Details");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='ExperienceDetail-tab-1']//a[@href='#Skils_Tab']")).click();
	        
	        //Open Technology From Dropwdown
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='TechnologyId']")).click();
	        driver.findElement(By.xpath(".//*[@id='TechnologyId']/option[3]")).click();
	        
	        //Select Skill
	        driver.findElement(By.xpath(".//*[@id='SkillId']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='SkillId']/option[2]")).click();
	        
	        //Select Level
	        driver.findElement(By.xpath(".//*[@id='Level']")).click();
	        driver.findElement(By.xpath(".//*[@id='Level']/option[2]")).click();
	        
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='EmployeeSkillBtnSubmit']")).click();
	        
	       
	        Thread.sleep(3000);
	        String skillsuccess = driver.findElement(By.xpath(".//*[@id='Skill-alert']/strong")).getText();  
	        Thread.sleep(3000);
	        
	        if(skillsuccess.equals(confirmskillsuccess))
	        {
	           System.out.println("Success");
	       	   test.log(LogStatus.PASS, "Actual resut Is " +  skillsuccess  );
	       	  
	        }
	        else
	        {
	        	test.log(LogStatus.FAIL, "Actual resut Is :: " +  skillsuccess + "Expected Result :: " +  confirmskillsuccess);
	        	//Assert.fail();
	        }
	        
     }
        
        ///------------------------------ APPLY LEAVE CODE --------------------------------------
        
        @Test (priority =3)
        public void empApplyLeave() throws InterruptedException
        {
        	Thread.sleep(3000);
        	log.info("---------------------------Leave Menu Module----------------------");
	        //Open Leave Menu
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[4]/a/span[1]")).click();
	        driver.findElement(By.xpath("//a[text()='Add Leave Request']")).click();
	        
	        //Click on Apply Leave
	        log.info("Applying Leave");
	        driver.findElement(By.xpath(".//*[@id='btnApplyLeave']")).click();
	        Thread.sleep(3000);
	      
	        //Click on Apply Leave
	        driver.findElement(By.xpath(".//*[@id='LeaveTypeId']")).click();
	        driver.findElement(By.xpath(".//*[@id='LeaveTypeId']/option[2]")).click();
	       
	        //Click on Date Calendar
	        log.info("Selecting From Date");
	        driver.findElement(By.xpath(".//*[@id='LeaveRequestFromDate']")).sendKeys("27/11/2017",Keys.ENTER);
	        Thread.sleep(3000);
	     
	        //Apply Half day Leave
	        log.info("Selecting HalfDay Leave");
	        driver.findElement(By.xpath(".//*[@id='half-day-option']//label/span")).click();
	        Thread.sleep(3000);
	        
	        //Enter Reason for leave
	        log.info("Entering Reason");
	        driver.findElement(By.xpath(".//*[@id='Reason']")).sendKeys("Not Feeling Well");
	        Thread.sleep(3000);
	    
	        //Click on Submit
	        log.info("Click on Submit");
	        driver.findElement(By.xpath(".//*[@id='ApplyLeaveModal']/div/div/div[3]/button[1]")).click();
	        Thread.sleep(3000);
	        
	        //Validation Message to Compare success or not
	        String leavemessage = driver.findElement(By.xpath("//*[@id='alert']/strong")).getText(); 
	        Thread.sleep(3000);
	        if(leavemessage.equals(confirmLeaveSuccess))
	        {
	           System.out.println("Success");
	       	   test.log(LogStatus.PASS, "Actual resut Is " +  leavemessage  );
	        }
	        else
	        {
	        	test.log(LogStatus.FAIL, "Actual resut Is :: " +  leavemessage + "Expected Result :: " +  confirmLeaveSuccess);
	        	
	        }
	        
	        Thread.sleep(3000);        
	        
	        //Logout
	        log.info("Employee Logout");
	        driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
	        driver.findElement(By.xpath("//a/span/strong[text()='Logout']")).click();
	   
    	}
       
      //--------------------------------- Admin Accepting Leave Case ----------------------------------
        
        @Test (priority =4)
        public void adminacceptLeave() throws InterruptedException
        {  
	        //Login With Admin
        	log.info("----------------------------------- Admin Accepting Leave----------------------------------------");
        	log.info("Admin Login");
	        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin@trimantrallp.com");
	        
	        //Password Xpath
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("123456@Aa");
	
	        //Click on Submit  
	        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	        
	         //Click on Team Approving Leave
	        log.info("Click on Approving Leave Menu");
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[4]/a")).click();
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[4]//li[1]/a")).click();
	                
	        //Open Search Menu for Leave 
	        log.info("Searching User");
	        driver.findElement(By.xpath(".//*[@id='AssignLeaveFilter']//div[@class='tools']")).click();
	        
	        //Click on User Search Dropdown
	        Thread.sleep(4000);
	        driver.findElement(By.xpath(".//*[@id='AssignLeave_AdvanceSearch_Div']//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
	        Thread.sleep(4000);
	        driver.findElement(By.xpath(".//*[@id='AssignLeave_AdvanceSearch_Div']//div/input[@class='form-control multiselect-search']")).sendKeys("bl " + namestore );
	        
	        //Click on Checkbox
	        Thread.sleep(4000);
	        driver.findElement(By.xpath(".//*[@id='AssignLeave_AdvanceSearch_Div']//ul[@class='multiselect-container dropdown-menu']//li[2]/a//label/input")).click();
	            
	        //Click onMenu to close
	        driver.findElement(By.xpath(".//*[@id='AssignLeave_AdvanceSearch_Div']//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
	        
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='AssignLeaveFilterBtnSubmit']")).click();
	                
	       //Click on Leave Menu Icon
	        Thread.sleep(4000);
	        driver.findElement(By.xpath(".//*[@id='1']//a/i")).click();
	        
	        //Comment on leave
	        Thread.sleep(4000);
	        driver.findElement(By.xpath(".//*[@id='Comment']")).sendKeys("Leave Approved");
	        
	        //Approve Leave
	        log.info("Approved Leave By Admin");
	        driver.findElement(By.xpath(".//*[@id='btnApproveLeave']")).click();
	        
	        Thread.sleep(3000);
	        
	        String leaveapprove = driver.findElement(By.xpath(".//*[@id='alert']/strong")).getText();
	        System.out.println(leaveapprove);
	        Thread.sleep(3000);
	        
	        if(leaveapprove.equals(confirmLeaveApprove))
	        {
	           System.out.println("Success");
	       	   test.log(LogStatus.PASS, "Actual resut Is " +  leaveapprove  );
	        }
	        else
	        {	
	        	System.out.println("Failure");
	        	test.log(LogStatus.FAIL, "Actual resut Is :: " +  leaveapprove + "Expected Result :: " +  confirmLeaveApprove);	
	        }
	      
	        //Logout
  	        Thread.sleep(2000);
  	        driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
  	        Thread.sleep(2000);
  	        driver.findElement(By.xpath("//a/span/strong[text()='Logout']")).click();
	                
        }
                 
     //------------------------------------ Employee Attendance Request ----------------------------------
  	  @Test (priority =5)
        public void employeeAddAttendance() throws InterruptedException
        {
  	        //Login With Admin
  		  	log.info("------------------------Employee Attendance Request----------------------------------");
	  		log.info("Employee Login");
  	        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("demo" + emailstore +"@trimantrallp.com");
  	        
  	        //Password Xpath
	       	String password = JOptionPane.showInputDialog(null,"Enter Password");
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys(password);
  	
  	        //Click on Submit	        
  	        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
  	        Thread.sleep(3000);
  	        
  	//--------------------------------- Employee Attendance Menu Click -----------------------------------
  	        
  	        driver.findElement(By.xpath("//span[text()='My Attendance']")).click();
  	        
  	       //Click on Attendance REquest Menu
  	        log.info("Click on Attendance Menu");
  	        Thread.sleep(3000);
  	        driver.findElement(By.xpath("//a[@href='/Attendance/CreateAttendanceRequest']")).click();
  	        
  	        //Click on Attendance Dropdown Type
  	        Thread.sleep(3000);
  	        driver.findElement(By.xpath(".//*[@id='RequestType']")).click();
  	        driver.findElement(By.xpath(".//*[@id='RequestType']/option[text()='Work From Home']")).click();
  	       
  	        //Date of attendance
  	        log.info("Selecting Date of Attendance");
  	        Thread.sleep(2000);
  	        driver.findElement(By.xpath(".//*[@id='DatePickerSpan']")).click();
  	        Thread.sleep(3000);
  	        driver.findElement(By.xpath("//tbody//td[@class='today day']")).click();
  	                
  	        //Total Hour Calculation
  	        log.info("Selecting Total Hours");
  	        Thread.sleep(3000);
  	        driver.findElement(By.xpath(".//*[@id='TotalHourCalculationTypeDiv']//label[1]/span")).click();
  	                
  	        //Start Time Selection
  	        log.info("Selecting Start Time");
  	        driver.findElement(By.xpath(".//*[@id='FirstCheckInTime']")).click();
  	        driver.findElement(By.xpath(".//*[@id='FirstCheckInTime']")).clear();
  	        driver.findElement(By.xpath(".//*[@id='FirstCheckInTime']")).sendKeys("17:16");
  	        driver.findElement(By.xpath(".//*[@id='Comment']")).click();
  	                
  	        //End Time Selection
  	        log.info("End Time Selection");
  	        driver.findElement(By.xpath(".//*[@id='LastCheckOutTime']")).click();
  	        driver.findElement(By.xpath(".//*[@id='LastCheckOutTime']")).clear();
  	        driver.findElement(By.xpath(".//*[@id='LastCheckOutTime']")).sendKeys("17:19");
  	        driver.findElement(By.xpath(".//*[@id='FirstCheckInTime']")).click();
  	        
  	        //Comment
  	        log.info("Comment");
  	        driver.findElement(By.xpath(".//*[@id='Comment']")).sendKeys("Working on Home");
  	        
  	        //File Upload
  	        log.info("Uploading Doc File");
  	        WebElement fileupload = driver.findElement(By.xpath(".//*[@id='DocumentName']"));
  	        fileupload.sendKeys("D:\\Jignesh\\Projects\\HRMS\\HRMS\\1.png");
  	       
  	        //Click on Submit
  	        log.info("Click on Submit");
  	        driver.findElement(By.xpath(".//button[@type='submit']")).submit();
  	        Thread.sleep(3000);
  	        
  	        String attendacne = driver.findElement(By.xpath(".//*[@id='AttendanceRequestAlert']/strong")).getText();
  	        
  	        
  	        if (attendacne.equals(confirmAttendance))
  	        {
  	        	System.out.println("Success");
  	        	test.log(LogStatus.PASS, "Actual resut Is " +  attendacne  );
  	           
  	        }
  	        
  	        else
  	        {	        	
  	        	System.out.println("Failure");
  	        	test.log(LogStatus.FAIL, "Actual resut Is :: " +  attendacne + "Expected Result :: " +  confirmAttendance);
  	        }
  	        	        
  	        //Logout
  	        Thread.sleep(2000);
  	        driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
  	        Thread.sleep(2000);
  	        driver.findElement(By.xpath("//a/span/strong[text()='Logout']")).click();
  	        
        }
  	  	  
  	 //-------------------------------------- Admin Approve Leave -----------------------------------
	  @Test (priority = 6)
	  public void adminattendanceapprove() throws InterruptedException
      {
	        //Login With Admin
		  	log.info("-------------------------- Admin Attendance Request Approve ---------------------------------");
		  	log.info("Login With Admin");
		    Thread.sleep(2000);
	        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin@trimantrallp.com");
	        
	        //Password Xpath
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("123456@Aa");
	
	        //Click on Submit        
	        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	        Thread.sleep(2000);
	          
	        //Click on Attendance Approve Menu
	        log.info("Click on Attendance Approve Menu");
	        driver.findElement(By.xpath("//span[text()='Team']")).click();
	        
	        
	       //Click on Attendance REquest Menu
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//a[@href='/Attendance/AttendanceApprovalView']")).click();
	        
	        
	        //Click on Advance Search
	        log.info("Searching Employee");
	        driver.findElement(By.xpath(".//*[@id='my_portlet1']/div[1]//a")).click();
	        Thread.sleep(2000);
	        
	        //Click on  Employee Dropdown
	        driver.findElement(By.xpath(".//button[@class='multiselect dropdown-toggle mt-multiselect btn btn-default']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//input[@placeholder='Search']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//input[@placeholder='Search']")).sendKeys("bl " + namestore );
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//input[@value='multiselect-all']")).click();
	        
	        //Click to close Employee Dropdown
	        driver.findElement(By.xpath(".//button[@class='multiselect dropdown-toggle mt-multiselect btn btn-default']")).click();
	        
	        //Click on Search Button
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='filtergrid']")).click();
	               
	        //Click on Popup Icon
	        log.info("Click on Popup Icon");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='AttendanceApprovalActionLink']/i")).click();
	               
	        //Popup Comment
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='ApprovalComment']")).sendKeys("Attendance Approved");
	        
	        //Approve Button
	        log.info("Click on Approve Button");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='BtnAttendanceApprove']")).click();
	        test.log(LogStatus.PASS, "Attendance Approved " );
	        	
	       	   
	         
      }
        
      //------------------------------- Admin Change Employee Status -----------------------------------------------------
      @Test(priority =7)
      public void ChangeEmpStatus() throws InterruptedException
      {
            //Click on Emp Menu and Change Employee Status
    	  	//Click on Demo Employee Icon
    	  	log.info("------------------------- Admin Change Status ------------------------------------");
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[3]/a/span[1]")).click();
	      	Thread.sleep(3000);
	      	driver.findElement(By.xpath(".//a[@href='/UpdateEmployeeStatus']")).click();
	      	Thread.sleep(3000);
	      	  	  
	        //Click on Employee Dropwdown Menu
	      	log.info("Search EMployee from Drowdown");
	        WebElement element = driver.findElement(By.xpath(".//*[@id='EmployeeDropDown']"));
	        Select oselect = new Select(element);
	    	oselect.selectByVisibleText("bl Emp " + namestore);
	    	   
	    	//Click on Status Button
	    	log.info("Click on Change Status Button");
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath(".//*[@id='ChangeStatusButton']")).click();
    		Thread.sleep(2000);
    		
    		//Select from Dropdown
    		log.info("Probation Status to");
    		driver.findElement(By.xpath(".//*[@id='StatusTo']")).click();
    		Thread.sleep(2000);
    		
    		//Change status to Confirm
    		log.info("Change status to confirm");
    		driver.findElement(By.xpath(".//*[@id='StatusTo']/option[text()='Confirm']")).click();
    		Thread.sleep(3000);
    		
    		//Click on Date Picker and select date
    		log.info("Select Date for Effective");
    		driver.findElement(By.xpath(".//*[@id='statusEffectiveDatePicker']/span/button")).click();
    		driver.findElement(By.xpath("html/body/div[5]/div[1]/table/tbody/tr[4]/td[@class='day'][last()]")).click();
    		driver.findElement(By.xpath(".//*[@id='StatusTo']/option[text()='Confirm']")).click();
    		Thread.sleep(2000);
    		
    		//Send text in Confirm
    		log.info("Enter Comment");
    		driver.findElement(By.xpath(".//*[@id='Comment']")).sendKeys("Confirmed");
    		Thread.sleep(2000);
    		
    		// Click on Save Button
    		log.info("Click on Save");
    		driver.findElement(By.xpath("//button[@type='submit' and @class='btn green']")).click();
    		Thread.sleep(2000);
    		
    		//Click on Submit Button
    		log.info("Click on Submit");
    		driver.findElement(By.xpath(".//*[@id='StatusSubmit']")).click();
    		Thread.sleep(2000);
    		
    		//Click on Final Submit
    		log.info("Click on Final Submit");
    		driver.findElement(By.xpath(".//*[@id='SubmitEmployeeStatusButton']")).click();
    		
    		 //Logout
    		log.info("Admin LogOut");
  	        Thread.sleep(2000);
  	        driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
  	        Thread.sleep(2000);
  	        driver.findElement(By.xpath("//a/span/strong[text()='Logout']")).click();
  	        test.log(LogStatus.PASS, "Confirmed "  );
        	
       	   
  		   
      }
      
      //------------------------------ Employee Confirm Status Check ----------------------------------------
      
      @Test (priority = 8 )
      public void EmployeeStatusCheck() throws InterruptedException
      {
    	  
    	    //Login With Employee
    	  	log.info("-------------------- Employee Status Check for Confirm --------------------------------------");
    	    driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("demo" + emailstore +"@trimantrallp.com");
    	        
    	    //Password Xpath
  	       	String password = JOptionPane.showInputDialog(null,"Enter Password");
  	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys(password);
  	    
    	   //Click on Submit	        
    	   driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
    	   Thread.sleep(3000);
    	   
    	   //Edit User Profile
    	   log.info("Open Profile Menu");
	       driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
	       driver.findElement(By.xpath("//a[@href='/Profile']")).click();
	       
	       //Click on Professional Tab
	       log.info("Click on Proefessional tab");
	       driver.findElement(By.xpath(".//*[@id='ProfessionalMainTab']")).click();
	       
    	  //Get Text from Status
	       log.info("Verifying Status");
	       String statusmessage = driver.findElement(By.xpath(".//*[@id='Professional_Detail_Tab']//label[text()='Current Status']/..//span")).getText();
	       
	       if(statusmessage.equals("Confirm"))
	       {
	    	   System.out.println("Confirmation Successfull");
	    	   test.log(LogStatus.PASS, "Actual resut Is " +  statusmessage  );
 	          
	       }
	       else
	       {
	    	   System.out.println("Confirmation not Successfull");
	    	   test.log(LogStatus.FAIL, "Actual resut Is :: " +  statusmessage );
	    	   //Assert.fail();
	       }
    	  
      }
      
     //-------------------------------------- Employee Confirm Leave(CL) Check Status ------------------------------------
     @Test(priority = 9)
     public void EmpCLLeaveCheck() throws InterruptedException
     {
    	  
    	 //Open Leave Menu
    	 log.info("-------------------------------------- Employee Verify CL Leave Avaialable after Confirm ---------------------------------");
    	 Thread.sleep(2000);
    	 driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[4]/a/span[1]")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//a[text()='Add Leave Request']")).click();
          
         //Fetch Total Number of Rows and Column
         Thread.sleep(2000);
         List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='ViewLeaveRequest_grid-table']/tbody/tr")); 
         System.out.println("No of rows are : " + rows.size());
                           
         List <WebElement> col = driver.findElements(By.xpath("//table[@class='ui-jqgrid-htable ui-common-table ']/thead/tr/th")); 
         System.out.println("No of col are : " + col.size());
          
	      for (int i =1;i<rows.size();i++)
	      {    
	    	 //Move to next Row if Data not found (i+1) Meaning
	          String getname = driver.findElement(By.xpath(" .//*[@id='ViewLeaveRequest_grid-table']/tbody/tr[" + (i+1)+ "]/td[2]")).getText();
	          System.out.println(getname);
	          
	          if(getname.equals("BL CL"))
	          {
	          	System.out.println("Matched");
	          	test.log(LogStatus.PASS, "Actual resut Is " +  getname  );
	          	
              }
                      
              else
              {
            	System.out.println("Not Matched");
            	test.log(LogStatus.FAIL, "Actual resut Is :: " +  getname );
            	//Assert.fail();
              }
  
	      	//Close Chrome Browser
		    driver.close();
		     	    
	      }	  
   }
     
	  @AfterSuite
      public void end()
      { 
   	  // Used to End Extent Report Functionality	
		  log.info("Test case Ended");
		  extent.endTest(test);       
		  extent.flush();    	 
      }
    
}
