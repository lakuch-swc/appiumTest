package appiumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CameraClass {
	
	public void openCamera(AppiumDriver driver) {
		//Add photo or edit the existing one 
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/cameraLinearLayout")));
	        MobileElement openCamera = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/cameraLinearLayout"));
	        openCamera.click();
		}catch(Exception e) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/editPhotoTextView")));
	        MobileElement editPhoto = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/editPhotoTextView"));
	        editPhoto.click();
		}		
	}

	public void takePhoto(AppiumDriver driver) {
		 //Choose option 'Take a photo'
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Take Photo']")));
        driver.findElement(By.xpath("//*[@text='Take Photo']")).click();
        //Inside the camera take a photo
        new WebDriverWait(driver, 40).until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.camera2:id/shutter_button")));
        MobileElement btn_shutter = (MobileElement) driver.findElement(By.id("com.android.camera2:id/shutter_button"));
        btn_shutter.click();
        // Inside the camera click 'done'
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.camera2:id/done_button")));
        MobileElement btn_done = (MobileElement) driver.findElement(By.id("com.android.camera2:id/done_button"));
        btn_done.click();
	}
	
	public  void takeVideo(AppiumDriver driver) {
		//Choose option 'Take Video'
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Take Video']")));
        driver.findElement(By.xpath("//*[@text='Take Video']")).click();
        //Start recording
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.camera2:id/shutter_button")));
        driver.findElement(By.id("com.android.camera2:id/shutter_button")).click();
        //Wait
        try {
			driver.wait(15);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
        //Stop recording
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.camera2:id/shutter_button")));
        driver.findElement(By.id("com.android.camera2:id/shutter_button")).click();
        // Inside the camera click 'done'
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.camera2:id/done_button")));
        MobileElement btn_done = (MobileElement) driver.findElement(By.id("com.android.camera2:id/done_button"));
        btn_done.click();   
	}
	
	public void chooseFromLibrary(AppiumDriver driver) {
		 //Choose option 'Choose from your library'
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Choose from your Library']")));
        driver.findElement(By.xpath("//*[@text='Choose from your Library']")).click();
		//Choose the first folder (Camera)
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.RelativeLayout[@index='1']")));
        driver.findElement(By.xpath("//android.widget.RelativeLayout[@index='1']")).click();
        //Choose the first photo
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@index='1']")));
        driver.findElement(By.xpath("//android.view.ViewGroup[@index='1']")).click();
        
	}
}
