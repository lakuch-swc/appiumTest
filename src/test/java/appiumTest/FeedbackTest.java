package appiumTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FeedbackTest extends BaseClass {
	final String screenshotsFolder    = System.getProperty("user.home") + "\\Desktop";
	final String screenshotsSubFolder = "FeedbackTesting_" + Long.toString(System.currentTimeMillis());

	final String expertName = "lakuch";

    @Test
    public void testFeedback() throws IOException, InterruptedException {        
    	// Click on the Main_Menu Icon.
	    new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
	    screenshot(screenshotsFolder, screenshotsSubFolder);
	    
	    // Click/Select Help option. 
	    new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Help']"))).click();
	    screenshot(screenshotsFolder, screenshotsSubFolder);
	    
	    // Execute Search Command from KB.
	    //driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
	    //screenshot(screenshotsFolder, screenshotsSubFolder);
	        
	    // TODO --> Next Steps (Waiting for Bug Fixes) .....
	    
	        
	        
	        
	    logout();
	    screenshot(screenshotsFolder, screenshotsSubFolder);
	        
	    // Pause ...
	    try 
	    {
	    	Thread.sleep(3000);
	    } catch (InterruptedException e) 
	    {
	    	e.printStackTrace();
	    }               
	    screenshot(screenshotsFolder, screenshotsSubFolder);        
    }	
}
