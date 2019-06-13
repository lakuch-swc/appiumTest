package appiumTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;

public class FeedbackTest extends BaseClass {
	
	final String screenshotsFolder    = "C:\\Users\\student\\Desktop\\";
	final String screenshotsSubFolder = "Feedback_Testing";

	final String expertName = "lakuch";
	
    @Test
    public void testSendChatMessages() throws IOException, InterruptedException {
        
    	// Click on the Main_Menu Icon.
    	new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
    	screenshot(screenshotsFolder, screenshotsSubFolder);
    	
    	// Click/Select Provide feedback option. 
    	new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Provide feedback']"))).click();
    	screenshot(screenshotsFolder, screenshotsSubFolder);
    
        // Execute Search Command from KB.
        //driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
        //screenshot(screenshotsFolder, screenshotsSubFolder);
        
    	// Next Step.

        
        logout();
	    screenshot(screenshotsFolder, screenshotsSubFolder);
        
        // Pause ...
        try 
        {
		  Thread.sleep(3000);
		} 
        catch (InterruptedException e) 
        {
		  e.printStackTrace();
		}               
        screenshot(screenshotsFolder, screenshotsSubFolder);        
    }		
}
