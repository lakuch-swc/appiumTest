package appiumTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class SendChatMessages extends BaseClass {
	final String screenshotsFolder = "C:\\Users\\student\\Desktop\\";
	final String userName = "salahdau@yahoo.com";
	final String passWord = "Abcd1234";
	
    @BeforeTest
    // Called from BaseClass
    public void testSetUp() {
  	       setup(); 
    }	

    @Test
    public void testSendChatMessages() throws IOException {
    	//make sure user is logged in, then get a screenshot of activity.
        try 
        {
	 	  login(userName, passWord);
	   	  screenshot(screenshotsFolder);
        } 
        catch (InterruptedException e) 
        {
		  e.printStackTrace();
        }
        
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertSearchEditText"))).sendKeys("lakuch");
        screenshot(screenshotsFolder);
        
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
        screenshot(screenshotsFolder);
        
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/chatImageView"))).click();
        screenshot(screenshotsFolder);

        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/chatImageView"))).click();
        screenshot(screenshotsFolder);

        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/message"))).click();
        screenshot(screenshotsFolder);

        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/message"))).sendKeys("Hi my name is Salah");     
        screenshot(screenshotsFolder);

        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/btn_send"))).click();       
        screenshot(screenshotsFolder);
        
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

	@AfterTest
	public void TestTearDown() {
		teardown(); 
	} 	
}
