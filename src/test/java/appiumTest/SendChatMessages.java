package appiumTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SendChatMessages extends BaseClass {
	final String screenshotsFolder    = "C:\\Users\\student\\Desktop\\";
	final String screenshotsSubFolder = "Salah";
	
	final String userName   = "salahdau@yahoo.com";
	final String passWord   = "Abcd1234";
	
	final String expertName = "lakuch";

    @Test
    public void testSendChatMessages() throws IOException, InterruptedException {
    	// Make sure user is logged in.
	 	login(userName, passWord);
	   	screenshot(screenshotsFolder, screenshotsSubFolder);
        
	   	// Enter Keyword or Expert_Name to Search
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertSearchEditText"))).sendKeys(expertName);
        screenshot(screenshotsFolder, screenshotsSubFolder);
        
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
        screenshot(screenshotsFolder, screenshotsSubFolder);
        
        // Click Chat image/icon.
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/chatImageView"))).click();
        screenshot(screenshotsFolder, screenshotsSubFolder);

        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/chatImageView"))).click();
        screenshot(screenshotsFolder, screenshotsSubFolder);

        // Enter a text message to send to the Expert.
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText"))).sendKeys("Hi " + expertName + ", my name is Salah.");     
        screenshot(screenshotsFolder, screenshotsSubFolder);

        // Click the Send (Message) button.
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/btn_send"))).click();       
        screenshot(screenshotsFolder, screenshotsSubFolder);
        
        // Return to main menu and Log out
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/backTextView"))).click();   
        screenshot(screenshotsFolder, screenshotsSubFolder);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/backTextView"))).click(); 
        screenshot(screenshotsFolder, screenshotsSubFolder);
        new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
        screenshot(screenshotsFolder, screenshotsSubFolder);
        try 
        {
		  logout();
	      screenshot(screenshotsFolder, screenshotsSubFolder);
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
        screenshot(screenshotsFolder, screenshotsSubFolder);        
    }
}
