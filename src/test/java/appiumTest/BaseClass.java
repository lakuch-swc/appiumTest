package appiumTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 30);
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mindshare.magnifi");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".view.SplashScreenActivity");
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
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	public void screenshot(String pathScreenshot) throws IOException {
		String deviceName = driver.getCapabilities().getCapability(MobileCapabilityType.DEVICE_NAME).toString();

		String folderPath = pathScreenshot + "\\" + deviceName;
		File folder = new File(folderPath);
		
		try {
			folder.mkdir();
		} finally {}
		
		File srcFile = driver.getScreenshotAs(OutputType.FILE);		
		String filename = Long.toString(System.currentTimeMillis()) + "-" + deviceName;
	    File targetFile = new File(folderPath + "\\" + filename +".jpg");
	    FileUtils.copyFile(srcFile, targetFile);
	}
	
}
