package appiumTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class SendChatMessages extends BaseClass {
	
	String userName = "salahdau@yahoo.com";
	String passWord = "Abcd1234";
	
    @BeforeTest
    // Called from BaseClass
    public void testSetUp() {
  	       setup(); 
    }	

    @Test
    public void testSendChatMessages() {
        try 
        {
	 	  login(userName, passWord);
        } 
        catch (InterruptedException e) 
        {
		  e.printStackTrace();
        }
        
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertSearchEditText"))).sendKeys("lakuch");
       
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
        
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/chatImageView"))).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/chatImageView"))).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/message"))).click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/message"))).sendKeys("Hi my name is Salah");     
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/btn_send"))).click();       
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/backTextView"))).click();   
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/backTextView"))).click(); //com.mindshare.magnifi:id/backImageButton
        new WebDriverWait(driver, 50).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
        
        try 
        {
		  logout();
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
    }

	@AfterTest
	public void TestTearDown() {
		teardown(); 
	} 	
}
