package appiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Camera {

	public void takePhoto(AppiumDriver driver) {
		 //Choose option 'Take a photo'
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Take Photo']")));
        driver.findElement(By.xpath("//*[@text='Take Photo']")).click();
        //Inside the camera take a photo
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.camera2:id/shutter_button")));
        MobileElement btn_shutter = (MobileElement) driver.findElement(By.id("com.android.camera2:id/shutter_button"));
        btn_shutter.click();
        // Inside the camera click 'done'
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.camera2:id/done_button")));
        MobileElement btn_done = (MobileElement) driver.findElement(By.id("com.android.camera2:id/done_button"));
        btn_done.click();
	}
	
	public void takeVideo(AppiumDriver driver) {
			
		}
	
	public void chooseFromLibrary(AppiumDriver driver) {
		
	}
}
