import static org.testng.Assert.fail;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.Driver;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class HRMS_Login {


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
	String firstname;
	String lastname;
	String var;
	String var2;
	ExtentReports extent;
	ExtentTest test;
	
		//------------------ Setting Up Chrome browser---------------------------------------
		
		@BeforeSuite
		public void setup()
		{
			System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			extent = new ExtentReports("D://extent-reports.html",true);
			extent.loadConfig(new File("D://selenium//extentreports-java-2.41.2//extentreports-java-2.41.2//extent-config.xml"));
		
			//Maximize Chrome
			driver.manage().window().maximize();
		
			//Set URL to Open 
	        String baseUrl = "http://192.168.1.124:838/";
	       
	        // launch Chrome and direct it to the Base URL
	        driver.get(baseUrl);
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
        
        @Test (priority =1)
        public void addnewemployee() throws InterruptedException
        {
	        //Login With Admin
	        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin@trimantrallp.com");
	        
	        //Password Xpath
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("123456@Aa");
	        
	        //Click on Submit
	        
	        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	        Thread.sleep(3000);
	        
	        String abc = driver.findElement(By.xpath(".//*[@id='header_notification_bar']//*[@class='badge badge-default']")).getText();
	        System.out.println(abc);
	        
	       //-------------Admin New Employee
	        
	       //Click on ADD NEW EMPLOYEE Menu
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[3]/a")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']//li[3]/a[@href='/Employee/EmployeeRegistration']")).click();
	        
	        //Enter FirstName 
	        driver.findElement(By.xpath(".//*[@id='FirstName']")).sendKeys("bl");
	        
	        //Enter MiddleName
	        driver.findElement(By.xpath(".//*[@id='MiddleName']")).sendKeys("Emp");
	        
	        //Enter lastname
	        driver.findElement(By.xpath(".//*[@id='LastName']")).sendKeys(namestore);
	        
	        
	        //Email      
	        driver.findElement(By.xpath(".//*[@id='EmailId']")).sendKeys("demo" + emailstore + "@trimantrallp.com");
	        
	        boolean str = driver.findElement(By.xpath(".//*[@id='EmployeeRegistration']//label[@class='mt-radio mt-radio-outline margin-bottom-custom'][1]/span")).isDisplayed();
	       
	        //Click on Radio Buttons
	        driver.findElement(By.xpath(".//*[@id='EmployeeRegistration']//label[@class='mt-radio mt-radio-outline margin-bottom-custom'][1]/span")).click();
	        
	        driver.findElement(By.xpath(".//*[@id='MobileNo']")).sendKeys("9856321456");
	        
	        //Click on Counry
	        driver.findElement(By.xpath(".//*[@id='CountryId']")).click();
	        driver.findElement(By.xpath(".//*[@id='CountryId']/option[2]")).click();
	        
	        //Click on State,City
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='StateId']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='StateId']/option[2]")).click();
	        
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='CityId']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='CityId']/option[2]")).click();
	        
	        //Click on Bday
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='BirthDate']")).sendKeys("11/06/1900",Keys.ENTER);
	        
	        //Click on Location
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='LocationId']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='LocationId']/option[4]")).click();
	        
	        //Click  on Joning Date
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='JoiningDate']")).sendKeys("16/11/2017",Keys.ENTER);
	        
	        //Click on Department
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='DepartmentId']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='DepartmentId']/option[19]")).click();
	        
	        //Click on Desiganation
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='DesignationId']"));
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='DesignationId']/option[8]")).click();
	        
	        //Scroll Down
	        JavascriptExecutor jse = (JavascriptExecutor)driver;
	        jse.executeScript("scroll(0, 250);");
	        
	        //Click on CTC
	        driver.findElement(By.xpath(".//*[@id='CTC']")).sendKeys("10000");
	        
	        //Click on Source Hire
	        driver.findElement(By.xpath(".//*[@id='SourceOfHireId']")).click();
	        driver.findElement(By.xpath(".//*[@id='SourceOfHireId']/option[2]")).click();
	        
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='EmployeeRegistration']//button[@class='btn green']")).click();
	        Thread.sleep(3000);
	       
	        String sucessmessage = driver.findElement(By.xpath(".//*[@id='my-msg']")).getText();
	        Thread.sleep(3000);
	        if(sucessmessage.equals(confirmsuccess))
	        {
	           System.out.println("Success");
	       	   test.log(LogStatus.PASS, "Actual resut Is " +  sucessmessage  );
	        }
	        else
	        {
	        	test.log(LogStatus.FAIL, "Actual resut Is :: " +  sucessmessage + "Expected Result :: " +  confirmsuccess);
	        	Assert.fail();	
	        }
	        
	        //Logout
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath("//a/span/strong[text()='Logout']")).click();
        
        }
        
        //--------------------------- EMPLOYEE LOGIN -----------------------------------------------------
        
        @Test (priority = 2)
        public void employeeLogin() throws InterruptedException
        {
	        //Username xpath
	       driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("demo" + randomemail +"@trimantrallp.com");
	        
	        //Password Xpath
	       	String password = JOptionPane.showInputDialog(null,"Enter Password");
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys(password);
	
	        //Click on Submit
	        
	        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	        
	        //After Login Gettext
	        String username = driver.findElement(By.xpath(".//a//*[@class='username username-hide-on-mobile']")).getText();
	        System.out.println(username);
	        
	     // --------------------------- Edit User Profile ------------------------------------
	       
	        //Edit User Profile
	        driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
	        driver.findElement(By.xpath("//a[@href='/Profile']")).click();
	      
	        //Enter Natinality
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
	        
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='ExperianceMainTab']")).click();
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='EmployeeCertificationEntryForm']//div[2]/a[@href='javascript:;']")).click();
	        
	        //Add Certficate Type
	        driver.findElement(By.xpath(".//*[@id='Certification']")).sendKeys("ISTQBnew");
	        
	        //Click on Submit Button
	        driver.findElement(By.xpath(".//*[@id='SubmitButton']")).click();
	        
	        //------------------------ ADD EXPERINCE DETAILS -----------------------------------
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='ExperienceDetail-tab-1']//ul/li[2]/a[@href='#Experience_Detail_Tab']")).click();
	        Thread.sleep(2000);
	        //Open Experince Menu
	        driver.findElement(By.xpath(".//*[@id='EmployeeExperience']//div[2]/a[@href='javascript:;']")).click();
	        Thread.sleep(2000);
	        
	        //Enter Organiztion Name
	        driver.findElement(By.xpath(".//*[@id='OrganizationName']")).sendKeys("Abc");
	        
	        //Enter Designatio Name
	        driver.findElement(By.xpath(".//*[@id='DesignationName']")).sendKeys("QA");
	        
	        //eNTER ctc
	        driver.findElement(By.xpath(".//*[@id='LastCTC']")).sendKeys("10000");
	        
	        //From Date
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='FromDate']")).sendKeys("13/05/2017");
	       
	        Thread.sleep(2000);
	       
	        //End date
	        driver.findElement(By.xpath(".//*[@id='ToDate']")).sendKeys("13/10/2017");
	        
	        //Job Desscription
	        driver.findElement(By.xpath(".//*[@id='JobDescription']")).sendKeys("estign");
	        
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='btnEmployeeExperience']")).click();
	        
	       //-------------------------------- ADD EDUCATION ---------------------------------
	        
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='ExperienceDetail-tab-1']//a[@href='#Education_Detail_Tab']")).click();
	        Thread.sleep(3000);
	        //Open Education Menu
	        driver.findElement(By.xpath(".//*[@id='test']//a[@href='javascript:;']")).click();
	            
	        //Add qualitfication
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='QualificationId']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='QualificationId']/option[3]")).click();
	      
	        //Add Instittute
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='InstituteId']")).click();
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='InstituteId']/option[3]")).click();
	        
	        //Add Start Dtae
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='StartDate']")).sendKeys("1/2016");
	        
	        //Add End date
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='EndDate']")).sendKeys("11/2017");
	        
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='EducationBtnSubmit']")).click();
	        
	        //----------------------------ADD SKILLS --------------------------------
	        
	        //Click on Skills
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
	        //Open Leave Menu
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[4]/a/span[1]")).click();
	        driver.findElement(By.xpath("//a[text()='Add Leave Request']")).click();
	        
	        //Click on Apply Leave
	        driver.findElement(By.xpath(".//*[@id='btnApplyLeave']")).click();
	        Thread.sleep(3000);
	      
	        //Click on Apply Leave
	        driver.findElement(By.xpath(".//*[@id='LeaveTypeId']")).click();
	        driver.findElement(By.xpath(".//*[@id='LeaveTypeId']/option[2]")).click();
	       
	        //Click on Date Calendar
	        driver.findElement(By.xpath(".//*[@id='LeaveRequestFromDate']")).sendKeys("27/11/2017",Keys.ENTER);
	        Thread.sleep(3000);
	     
	        //Apply Half day Leave
	        driver.findElement(By.xpath(".//*[@id='half-day-option']//label/span")).click();
	        Thread.sleep(3000);
	        
	        //Enter Reason for leave
	        driver.findElement(By.xpath(".//*[@id='Reason']")).sendKeys("Not Feeling Well");
	        Thread.sleep(3000);
	    
	        //Click on Submit
	        driver.findElement(By.xpath(".//*[@id='ApplyLeaveModal']/div/div/div[3]/button[1]")).click();
	        Thread.sleep(3000);
	        
	        
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
	        driver.findElement(By.xpath("//li/a//i[@class='fa fa-angle-down']")).click();
	        driver.findElement(By.xpath("//a/span/strong[text()='Logout']")).click();
	   
    	}
       
      //--------------------------------- Admin Accepting Leave Case ----------------------------------
        
        
        @Test (priority =4)
        public void adminacceptLeave() throws InterruptedException
        {  
	        //Login With Admin
	        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin@trimantrallp.com");
	        
	        //Password Xpath
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys("123456@Aa");
	
	        //Click on Submit  
	        driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	        
	         //Click on Team Approving Leave
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[4]/a")).click();
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[4]//li[1]/a")).click();
	                
	        //Open Search Menu for Leave 
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
  	        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("demo" + emailstore +"@trimantrallp.com");
  	        
  	      //Password Xpath
	       	String password = JOptionPane.showInputDialog(null,"Enter Password");
	        driver.findElement(By.xpath(".//*[@id='txtPassword']")).sendKeys(password);
  	
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
	  @Test (priority = 6)
	  public void adminattendanceapprove() throws InterruptedException
      {
	        //Login With Admin
		  Thread.sleep(2000);
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
	        driver.findElement(By.xpath(".//input[@placeholder='Search']")).sendKeys("bl " + namestore );
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//input[@value='multiselect-all']")).click();
	        
	        //Click to close Employee Dropdown
	        driver.findElement(By.xpath(".//button[@class='multiselect dropdown-toggle mt-multiselect btn btn-default']")).click();
	        
	        //Click on Search Button
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='filtergrid']")).click();
	        
	        //Click on Popup Icon
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='AttendanceApprovalActionLink']/i")).click();
	        
	        
	        //Popup Comment
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='ApprovalComment']")).sendKeys("Attendance Approved");
	        
	        //Approve Button
	        Thread.sleep(2000);
	        driver.findElement(By.xpath(".//*[@id='BtnAttendanceApprove']")).submit();
	  
      }
        
        
      //------------------------------- Admin Change Employee Status -----------------------------------------------------
      @Test(priority =7)
      public void ChangeEmpStatus() throws InterruptedException
      {
    	  
	        //Click on Emp Menu and Change Employee Status
	        Thread.sleep(3000);
	        driver.findElement(By.xpath(".//*[@id='list-to-filter']/li[3]/a/span[1]")).click();
	      	Thread.sleep(3000);
	      	driver.findElement(By.xpath(".//a[@href='/UpdateEmployeeStatus']")).click();
	      	  	  
	        //Click on Employee Dropwdown Menu
	        WebElement element = driver.findElement(By.xpath(".//*[@id='EmployeeDropDown']"));
	        Select oselect = new Select(element);
	    	oselect.selectByVisibleText("bl Emp " + namestore);
	    	   
	    	//Click on Status Button
	    	Thread.sleep(3000);
	    	driver.findElement(By.xpath(".//*[@id='ChangeStatusButton']")).click();;
    		Thread.sleep(2000);
    		
    		//CSelect from Dropdown
    		driver.findElement(By.xpath(".//*[@id='StatusTo']")).click();
    		Thread.sleep(2000);
    		
    		//Change status to Confirm
    		driver.findElement(By.xpath(".//*[@id='StatusTo']/option[text()='Confirm']")).click();
    		Thread.sleep(3000);
    		
    		//Click on Date Picker and select date
    		driver.findElement(By.xpath(".//*[@id='statusEffectiveDatePicker']/span/button")).click();
    		driver.findElement(By.xpath("html/body/div[5]/div[1]/table/tbody/tr[4]/td[@class='day'][last()]")).click();
    		driver.findElement(By.xpath(".//*[@id='StatusTo']/option[text()='Confirm']")).click();
    		Thread.sleep(2000);
    		
    		//Send text in Confirm
    		driver.findElement(By.xpath(".//*[@id='Comment']")).sendKeys("Confirmed");
    		//driver.findElement(By.xpath(".//*[@id='StatusTo']/option[text()='Confirm']")).click();
    		Thread.sleep(2000);
    		
    		// Click on Save Button
    		driver.findElement(By.xpath("//button[@type='submit' and @class='btn green']")).click();
    		//driver.findElement(By.xpath(".//*[@id='StatusTo']/option[text()='Confirm']")).click();
    		Thread.sleep(2000);
    		
    		//Click on Submit Button
    		driver.findElement(By.xpath(".//*[@id='StatusSubmit']")).click();
    		Thread.sleep(2000);
    		
    		//Click on Final Submit
    		driver.findElement(By.xpath(".//*[@id='SubmitEmployeeStatusButton']")).click();
    	 	 
	        driver.close();
		    extent.endTest(test);     
    	   
      }
     
	  @AfterSuite
      public void end()
      { 
     	 	extent.flush();
     	 
      }
          
	
}
