import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;


public class Helper {

	@BeforeSuite()
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String randomemail = RandomStringUtils.randomAlphabetic(5); 
		String randomname = RandomStringUtils.randomAlphabetic(4);
		String namestore =randomname;
		System.out.println(namestore);
		String expectedteString = "Please select from and to date as a working date.";
		//Randoom Email
		
		
		//Maximize Chrome
		driver.manage().window().maximize();
		//Set URL 
        String baseUrl = "http://192.168.1.124:838/";
       
        // launch Chrome and direct it to the Base URL
        driver.get(baseUrl);
        
	}


}
