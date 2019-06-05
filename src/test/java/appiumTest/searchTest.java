package appiumTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class searchTest {
	
	File userFile = new File("users.txt");
	static AppiumDriver driver;
	
	@BeforeTest
	public void setup() {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");
		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mindshare.magnifi");
        //dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".view.SplashScreenActivity");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".view.ExpertSearchActivity");
        dc.setCapability("autoGrantPermissions", true);
        dc.setCapability("autoAcceptAlerts", true);
        dc.setCapability("autoDismissAlerts", true);
        dc.setCapability("noReset", true);

		try {
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
		} catch (MalformedURLException e) {
			System.out.println(e.getCause());
			System.out.println(e.getMessage());;
			e.printStackTrace();
		}

		driver = new AppiumDriver<MobileElement>(dc);
		
	}

	public String getUserFromFile(File file) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String userName;
		
		while ((userName = bufferedReader.readLine()) != null) {
			return userName;
		}
		
		return "";
	}
	
	public void screenshot(String path_screenshot) throws IOException {
	    File srcFile = driver.getScreenshotAs(OutputType.FILE);
	    String filename = UUID.randomUUID().toString(); 
	    File targetFile = new File(path_screenshot + filename +".jpg");
	    FileUtils.copyFile(srcFile, targetFile);
	}
	
	@Test
	public void searchTextFileForUser() throws IOException {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertSearchEditText"))).sendKeys(getUserFromFile(userFile));
		screenshot("C:\\Users\\student\\Desktop\\");
		driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/mainLayout")));
		screenshot("C:\\Users\\student\\Desktop\\");
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
  
}
