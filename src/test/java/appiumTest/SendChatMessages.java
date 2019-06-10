package appiumTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SendChatMessages extends BaseClass {
	final String screenshotsFolder = "C:\\Users\\student\\Desktop\\";
	final String userName   = "salahdau@yahoo.com";
	final String passWord   = "Abcd1234";
	
	final String expertName = "lakuch";

    @Test
    public void testSendChatMessages() throws IOException, InterruptedException {
    	// Make sure user is logged in.
	 	login(userName, passWord);
	   	screenshot(screenshotsFolder);
        
	   	// Enter Keyword or Expert_Name to Search
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertSearchEditText"))).sendKeys(expertName);
        screenshot(screenshotsFolder);
        
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
        screenshot(screenshotsFolder);
        
        // Click Chat image/icon.
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/chatImageView"))).click();
        screenshot(screenshotsFolder);

        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/chatImageView"))).click();
        screenshot(screenshotsFolder);

        // Enter a text message to send to the Expert.
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText"))).sendKeys("Hi " + expertName + ", my name is Salah.");     
        screenshot(screenshotsFolder);

        // Click the Send (Message) button.
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/btn_send"))).click();       
        screenshot(screenshotsFolder);
        
        // Return to main menu and Log out
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/backTextView"))).click();   
        screenshot(screenshotsFolder);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/backTextView"))).click(); 
        screenshot(screenshotsFolder);
        new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
        screenshot(screenshotsFolder);
        try 
        {
		  logout();
	      screenshot(screenshotsFolder);
        } 
        catch (InterruptedException e) 
        {
		  e.printStackTrace();
		}       
        
        // Pause ...
        try 
        {
		  Thread.sleep(3000);
		} 
        catch (InterruptedException e) 
        {
		  e.printStackTrace();
		}               
        screenshot(screenshotsFolder);        
    }
}
