package appiumTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class CallTest extends BaseClass {
	
	String screenshotLocation = System.getProperty("user.home") + "/Desktop"; 
	String folderName = Long.toString(System.currentTimeMillis()) + "-callTest";
	String user = "willisstudenttest+ws001@gmail.com";
	String password = "1P@ssw0rd";
	
	@Test
	public void makeCall() throws InterruptedException, IOException {
		
		login(user, password);
		
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
			Thread.sleep(2000);
		} finally {
			screenshot(screenshotLocation, folderName);
		}
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Search']"))).click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertSearchEditText"))).sendKeys("ws002");
		screenshot(screenshotLocation, folderName);
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
		
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.RelativeLayout")));
			Thread.sleep(2000);
		} finally {
			screenshot(screenshotLocation, folderName);
		}
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/phoneImageView"))).click();
		screenshot(screenshotLocation, folderName);
		
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/callImageView"))).click();
			Thread.sleep(2000);
		} finally {
			screenshot(screenshotLocation, folderName);
		}
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/goButton"))).click();
		screenshot(screenshotLocation, folderName);
		
		Thread.sleep(20000);
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/connect_action_fab"))).click();
		screenshot(screenshotLocation, folderName);
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/okButton"))).click();
		screenshot(screenshotLocation, folderName);
		
	}
}