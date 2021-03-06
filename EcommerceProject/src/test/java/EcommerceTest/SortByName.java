package EcommerceTest;
//verify item in mobile List page can be sorted by name.
	/*Steps
	    1.Go to http://live.demoguru99.com
		2. Verify the title of the page
		3. Click on the Mobile Menu
		4. Verify title of the page
		5. In the list of all mobile, select "SORT BY" dropdown as "name".
		6. Verify all the products are sorted by name.*/
	
	/*Results
	 * 1. Text "THIS IS DEMO SITE" shown in home page
	 * 2. Title "MOBILE" is shown on mobile list page 
	 * 3. All 3 products are sorted by name.
	 */

public class SortByName {
	//import static org.junit.Assert.fail;

	import java.io.File;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.Test;
	import org.testng.annotations.BeforeTest;
	import org.testng.AssertJUnit;
	import java.util.concurrent.TimeUnit;
	import org.testng.annotations.*;
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.*;
	import org.openqa.selenium.By;


	public class TestCase1 {
		  private WebDriver driver;
		  private String baseUrl;
		  public int scc = 0;
		  
		  private StringBuffer verificationErrors = new StringBuffer();

		  @BeforeMethod
		@BeforeTest
		public void setUp() throws Exception {
		    driver = new FirefoxDriver();
			// Step 1 Goto http://live.demoguru99.com/
		    baseUrl = "http://live.demoguru99.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		  @Test
		  public void testDay1TestCase1() throws Exception {
			
		    driver.get(baseUrl); 
			//Step 2. Verify Title of the page
		    String demoSite  = driver.findElement(By.cssSelector("h2")).getText();
		    System.out.println(demoSite);
		    try {
		      AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", demoSite);
		    } catch (Error e) {
		      verificationErrors.append(e.toString());
		    }	    
		    

		    // Step 3. Click on �MOBILE� menu
		    driver.findElement(By.linkText("MOBILE")).click();	
	        // Step 5. In the list of all mobile , select �SORT BY� dropdown as �name�		
		    new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");
		    
		    // Step 6. Verify all products are sorted by name
			// this will take a screen shot of the manager's page after a successful login
		    scc = (scc+1);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String png = ("C:\\Guru99 eCommerce Live Project\\Day01_TestCase1\\Mobile Products are sorted" + scc + ".png");
			FileUtils.copyFile(scrFile, new File(png));
	//**************************************************************************************************************************	
		    }	
		  
		@AfterTest
		public void tearDown() throws Exception {
			driver.quit();
		   
		  }
		
		  
		}

	

}
