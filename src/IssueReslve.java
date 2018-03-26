import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IssueReslve {
	public static WebDriver driver;
	public static void main(String[] args)throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver_win32\\chromedriver.exe");
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("http://198.211.98.212/admin");
		driver.findElement(By.id("email")).sendKeys("admin@admin.com");
	    driver.findElement(By.id("password")).sendKeys("tss@123456");
        driver.findElement(By.xpath("//button[@type='submit'][text()='Sign In']")).click();
        
        
        //After Login
	
	   new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://198.211.98.212/admin/manage/campaigns']")));
	   WebElement element = driver.findElement(By.xpath("//a[@href='http://198.211.98.212/admin/manage/campaigns']"));
	  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	  
	   new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='tbl_list_campaigns']//tr[1]/td[1]//span"))));
	   String campaign = driver.findElement(By.xpath("//table[@id='tbl_list_campaigns']//tr[1]/td[1]//span")).getText();
	   System.out.println("campaign name is:" + campaign);
	   
	   WebElement first_element_raw = driver.findElement(By.xpath("//table[@id='tbl_list_campaigns']//tr[1]/td[1]//span"));
	   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", first_element_raw);
	   
	   
	   new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("pixel_tab"))));
	   WebElement SubCampaign = driver.findElement(By.id("pixel_tab"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", SubCampaign);
	   
	   String cond_name1 = driver.findElement(By.xpath("//div[@id='tbl_list_pixels_js']/div[2]/table//div[1]/div/div[1]/p/strong")).getText();
       System.out.println("Pixel Tracking SubCampaign Name is ..!!!" + cond_name1);
	   
      

       //Edit Pixel Tracking SubCampaign-----------------------------------

       new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='tbl_list_pixels_js']/div[2]/table/tbody/div[1]/div/div[3]/div[2]/div/a[4]/i")));
       WebElement edit = driver.findElement(By.xpath("//div[@id='tbl_list_pixels_js']/div[2]/table/tbody/div[1]/div/div[3]/div[2]/div/a[4]/i"));
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", edit);
   

       new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("pixel_tracker_title")))).clear();
       new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("pixel_tracker_title")))).sendKeys("PT1");
	 
    
	 new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(By.id("edit_pixel_tracking_redirect_url"))).sendKeys("http://www.google.com");
	WebElement Save_pt = driver.findElement(By.id("btnEditCampaign"));
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", Save_pt);
	 
	/*new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(driver.findElement(By.id("pixel_tab"))));
	   WebElement SubCampaign1 = driver.findElement(By.id("pixel_tab"));
		  ((JavascriptExecutor) driver).executeScript("arguments[0].click();", SubCampaign1);
	*/   

}
}