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
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	protected static AppiumDriver<MobileElement> driver;
	protected static AppiumDriverLocalService service;
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	String systemPlatform;
	
	@BeforeTest
	public void setup() {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		//dc.setCapability(MobileCapabilityType.UDID, "emulator-5556");
		//dc.setCapability(MobileCapabilityType.UDID, "ce0817183134080403");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mindshare.magnifi");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".view.SplashScreenActivity");
        dc.setCapability("autoGrantPermissions", true);
        dc.setCapability("autoAcceptAlerts", true);
        dc.setCapability("autoDismissAlerts", true);
        dc.setCapability("noReset", true);
		
		driver = new AppiumDriver<MobileElement>(dc);
		
		if (OS.indexOf("win") >= 0) {
			systemPlatform = "_Win";
		} else if (OS.indexOf("mac") >= 0) {
			systemPlatform = "_Mac";
		} else {
			systemPlatform = null;
		}
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		service.stop();
	}
	
	public void screenshot(String screenshotPath, String folderName) {	
		String deviceName = driver.getCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME).toString();
		
		String parentFolderPath, childFolderPath, filename ;
		File parentFolder, childFolder, srcFile = null, targetFile = null;
		
		switch (systemPlatform) {
			case "_Win":	
				   	parentFolderPath = screenshotPath + "\\" + deviceName;
				   	parentFolder = new File(parentFolderPath);
				   	childFolderPath = parentFolder + "\\" + folderName;
				   	childFolder = new File(childFolderPath);
				
				   	try {
				   		parentFolder.mkdir();
				   		childFolder.mkdir();
				   	} finally {}
				
				   	srcFile = driver.getScreenshotAs(OutputType.FILE);	
				   	filename = Long.toString(System.currentTimeMillis()) + systemPlatform;
				   	targetFile = new File(childFolderPath + "\\" + filename +".jpg");
				
				   	break;
		 
			case "_Mac":
					screenshotPath = screenshotPath.replace("\\", "/");
					parentFolderPath = screenshotPath + "/" + deviceName;
					parentFolder = new File(parentFolderPath);
					childFolderPath = parentFolder + "/" + folderName;
					childFolder = new File(childFolderPath);
		
					try {
						parentFolder.mkdir();
						childFolder.mkdir();
					} finally {}
		
					srcFile = driver.getScreenshotAs(OutputType.FILE);	
					filename = Long.toString(System.currentTimeMillis()) + systemPlatform;
					targetFile = new File(childFolderPath + "/" + filename +".jpg");	
		     
					break;
		
			default:break;
		}
	
		try {
			FileUtils.copyFile(srcFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void login(String email, String password) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
		
		if (driver.findElements(By.xpath("//android.widget.TextView[@text='Log in']")).size() != 0) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Log in']"))).click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/txtEmail"))).sendKeys(email);
			driver.hideKeyboard();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/txtPassword"))).sendKeys(password);
			driver.hideKeyboard();
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/logInButton"))).click();
			
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
	}
	
	public void logout() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (driver.findElements(By.xpath("//android.widget.TextView[@text='Log out']")).size() != 0) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Log out']"))).click();
		}
	}
}