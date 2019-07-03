package appiumTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SendChatMessagesTest extends BaseClass {
	final String screenshotsFolder    = System.getProperty("user.home") + "\\Desktop";
	final String screenshotsSubFolder = Long.toString(System.currentTimeMillis()) + "-SendChatMessagesTesting";
	
	String uEmail = "zswhatever+146@gmail.com", pWord = "Test1234", expertName = "ws002";

    @Test
    public void testSendChatMessages() throws IOException, InterruptedException {
    	// Make sure user is logged out at the beginning of the test.
    	logout();
    	
    	// The user must get logged in to send messages.
    	login(uEmail, pWord);
    	screenshot(screenshotsFolder, screenshotsSubFolder);
        
    	// Enter Keyword or Expert_Name to Search
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertSearchEditText"))).sendKeys(expertName);
        screenshot(screenshotsFolder, screenshotsSubFolder);
        
        // Execute Search Command from KB.
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
        
        // Return to main menu ....
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/backTextView"))).click();   
        screenshot(screenshotsFolder, screenshotsSubFolder);
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/backTextView"))).click(); 
        screenshot(screenshotsFolder, screenshotsSubFolder);
        new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
        screenshot(screenshotsFolder, screenshotsSubFolder);

        // and Log out...
        logout();
        screenshot(screenshotsFolder, screenshotsSubFolder);
        
        // Pause ...
        try {
        	Thread.sleep(3000);
        } catch (InterruptedException e) 
        {
        	e.printStackTrace();
        }               
        screenshot(screenshotsFolder, screenshotsSubFolder);        
    }
}