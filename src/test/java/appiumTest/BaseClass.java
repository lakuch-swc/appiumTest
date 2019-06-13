package appiumTest;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	protected static AppiumDriver<MobileElement> driver;
	
	@BeforeTest
	public void setup() {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		//dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		//dc.setCapability(MobileCapabilityType.UDID, "ce0817183134080403");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mindshare.magnifi");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".view.SplashScreenActivity");
        dc.setCapability("autoGrantPermissions", true);
        dc.setCapability("autoAcceptAlerts", true);
        dc.setCapability("autoDismissAlerts", true);
        dc.setCapability("noReset", true);

		driver = new AppiumDriver<MobileElement>(dc);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	public void screenshot(String pathScreenshot) throws IOException {
		String deviceName = driver.getCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME).toString();

		String parentFolderPath = pathScreenshot + "\\" + deviceName;
		File parentFolder = new File(parentFolderPath);
		
		try {
			parentFolder.mkdir();
		} finally {}
		
		File srcFile = driver.getScreenshotAs(OutputType.FILE);		
		String filename = Long.toString(System.currentTimeMillis()) + "-" + deviceName;
	    File targetFile = new File(parentFolderPath + "\\" + filename +".jpg");
	    FileUtils.copyFile(srcFile, targetFile);
	}
	
	public void screenshot(String pathScreenshot, String folderName) throws IOException {
		String deviceName = driver.getCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME).toString();

		String parentFolderPath = pathScreenshot + "\\" + deviceName;
		File parentFolder = new File(parentFolderPath);
		String childFolderPath = parentFolder + "\\" + folderName;
		File childFolder = new File(childFolderPath);
		
		try {
			parentFolder.mkdir();
			childFolder.mkdir();
		} finally {}
		
		File srcFile = driver.getScreenshotAs(OutputType.FILE);		
		String filename = Long.toString(System.currentTimeMillis()) + "-" + deviceName;
	    File targetFile = new File(childFolderPath + "\\" + filename +".jpg");
	    FileUtils.copyFile(srcFile, targetFile);
	}
	
	public void login(String email, String password) throws InterruptedException {
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
		
		if (driver.findElements(By.xpath("//android.widget.TextView[@text='Log in']")).size() != 0) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Log in']"))).click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/txtEmail"))).sendKeys(email);
			driver.hideKeyboard();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/txtPassword"))).sendKeys(password);
			driver.hideKeyboard();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/logInButton"))).click();
			Thread.sleep(10000);
		} 

	}
	
	public void logout() throws InterruptedException {
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
		Thread.sleep(5000);
		
		if (driver.findElements(By.xpath("//android.widget.TextView[@text='Log out']")).size() != 0) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Log out']"))).click();
		}
	}
	
}
