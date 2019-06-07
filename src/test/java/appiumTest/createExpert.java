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
		
		 navigateToBecomeExpertScreen();
	         
         //Step 1: Create expert profile. Adding tags are optional
		 enterExpertiseInfo();
		 addCategory();       
         // addTags();
         nextStep();
         
         //Step 2: add social feeds (optional)
         //addSocialFeeds();
         nextStep();
         
         //Step 3: Intro video (mandatory): Choose choose the method
         camera.openCamera(driver);
         camera.takePhoto(driver);
         //camera.takeVideo(driver);
         //camera.chooseFromLibrary(driver);
         nextStep();
         
         //Step 4: Set rate and minutes (optional)
         //setRate();
         //setFreeMinutes();
         nextStep();
         
         //Step 5: Set Availability (optional)
         //setAvailability();
         nextStep();
         
         //Step 6: Add bank account (mandatory)
         addBankAccount();
         
         //Step 7: Preview & publish profile
         previewAndPublish();
         
         
	}
	
	public static void navigateToBecomeExpertScreen(){
		//Click Become an expert link
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertTextView")));
        MobileElement becomeExpert = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/expertTextView"));
        becomeExpert.click();
        //Click Skip
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/joinTextView")));
        MobileElement skip = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/joinTextView"));
        skip.click();	
	}
	
	public static void  enterExpertiseInfo() {
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
	}
	
	public static void addCategory() {
		//Add category. Expert has to add at least 1 category (up to 3)
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/categoryTextView")));
        MobileElement addCategory = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/categoryTextView"));
        addCategory.click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Art']")));
        MobileElement category = (MobileElement) driver.findElement(By.xpath("//*[@text='Art']"));
        category.click();
        nextStep();
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
	
	public static void addBankAccount(){
		//Click Add Bank account button
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/addCreditCardButton")));
        MobileElement addBankAccount = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/addCreditCardButton"));
        addBankAccount.click();
        //Click development mode: skip
        new WebDriverWait(driver, 120).until(ExpectedConditions.presenceOfElementLocated(By.id("By.xpath(\"//*[@text='Skip this account form']\")")));
        MobileElement skip = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/Skip this account form"));
        skip.click();
	}
	
	public static void previewAndPublish(){
		//Preview
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/logInButton")));
        MobileElement preview = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/logInButton"));
        preview.click();
        //Publish
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/publishButton")));
        MobileElement publish = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/publishButton"));
        publish.click();       
	}
	
}


















