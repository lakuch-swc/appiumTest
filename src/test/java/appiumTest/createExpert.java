package appiumTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class createExpert extends BaseClass {
	public static Camera camera = new Camera();

	public static String strTitle = "AutomationTesting";
	public static String strDescription = "Testing: here should be additional information about the expert";
	public static String strTag = "testingTag";
	public static String enter = "\n";
	
	@Test
	public static void createExpertProfile(){
		//Test is supposed to run after running createUser test, and verifying email address
		// When user is logged in SplashScreen starts at ExpertSearchActivity
		
		//Click Become an expert link
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertTextView")));
         MobileElement becomeExpert = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/expertTextView"));
         becomeExpert.click();
         //Click Skip
         new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/joinTextView")));
         MobileElement skip = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/joinTextView"));
         skip.click();
         
         //Step 1: Create expert profile
         //Enter title
         new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/titleEditText")));
         MobileElement etTitle = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/titleEditText"));
         etTitle.clear();
         etTitle.sendKeys(strTitle + enter);
         //Enter description
         new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/descriptionEditText")));
         MobileElement etDescription = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/descriptionEditText"));
         etDescription.clear();
         etDescription.sendKeys(strDescription + enter);
         driver.hideKeyboard();
         //Add category. Expert has to add at least 1 category (up to 3)
         new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/categoryTextView")));
         MobileElement addCategory = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/categoryTextView"));
//         addCategory.click();
//         new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Art']")));
//         MobileElement category = (MobileElement) driver.findElement(By.xpath("//*[@text='Art']"));
//         category.click();
         nextStep();    
         //Add tags (adding tags are optional)
        // addTags();
         nextStep();
         
         //Step 2: add social feeds (optional)
         //addSocialFeeds();
         nextStep();
         
         //Step 3: Intro video (mandatory)
         new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/cameraLinearLayout")));
         MobileElement addMedia = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/cameraLinearLayout"));
         addMedia.click();
         //camera.takeVideo(driver);
         //camera.takePhoto();
         camera.chooseFromLibrary(driver);
	}
	
	public static void nextStep(){
		   new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/nextTextView")));
	       MobileElement save = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/nextTextView"));
	       save.click();
	}
	
	public static void addTags(){
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/tagTextView")));
        MobileElement addTag = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/tagTextView"));
        addTag.click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/tagEditText")));
        MobileElement etTag = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/tagEditText"));
        etTag.sendKeys(strTag);
        nextStep();
	}
	
	public static void addSocialFeeds(){
		
	}
}


















