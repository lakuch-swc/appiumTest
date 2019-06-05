//package <set your test package>;
package appiumTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class createUser extends BaseClass{
	
	  public static RandomValues randomValues = new RandomValues();
	  // Declare basic credentials for alias registration
	  public static String testEmailCredentials = "milleroks1992+";
	  public static String testEmailProvider = "@gmail.com";
	  public static String enter = "\n";
	
	@BeforeTest
	public void testSetUp() {
		setup(); // from BaseClass
	}
   
	@Test
	 public static void createStandartUser(AppiumDriver<MobileElement>driver){
        //Test starts from Splash Screen Activity
        // Click Join Now and go to Activity_Join_Step_One
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/linearLayoutT")));
        MobileElement join = driver.findElement(By.id("com.mindshare.magnifi:id/linearLayoutT"));
        join.click();

        //Registration process has 4 Steps, step is mandatory, entering name others are optional.
        
        //Step1: Enter Credentials
        enterCredentials();
        nextStep();
        
        //Step 2:
        //Add photo (Choose one of the methods or skip this step):
        takePhoto();  //chooseFromLibrary();    
        enterFullName();
        nextStep();

        //Step 3:
        enableLocation();
        enableNotification();
        nextStep();
       
        //Step 4: Add credit card
        addCreditCard();
        nextStep();
    }
	
	public static void nextStep(){
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/nextTextView")));
        MobileElement next = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/nextTextView"));
        next.click();
	}
	
	public static void enterCredentials(){
		//Email
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/emailAddressEditText")));
        MobileElement txtEmail = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/emailAddressEditText"));
        txtEmail.clear();
        txtEmail.click();
        txtEmail.sendKeys(testEmailCredentials + randomValues.getRandomAlias()+testEmailProvider + enter);
        //Username
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/userNameEditText")));
        MobileElement txtUsername = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/userNameEditText"));
        txtUsername.clear();
        txtUsername.click();
        txtUsername.sendKeys(randomValues.getRandomName() + enter);
        //Password
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/passwordEditText")));
        MobileElement txtPsw = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/passwordEditText"));
        txtPsw.clear();
        txtPsw.click();
        txtPsw.sendKeys(randomValues.getPassword()+ enter);
	}
	
	public static void enterFullName(){
		//Enter First Name 
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/firstNameEditText")));
        MobileElement txtFirstName = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/firstNameEditText"));
        txtFirstName.clear();
        txtFirstName.sendKeys(randomValues.getRandomName() + enter);
        // Enter Last name
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/lastNameEditText")));
        MobileElement txtLastName = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/lastNameEditText"));
        txtLastName.clear();
        txtLastName.sendKeys(randomValues.getRandomName() + enter);
	}
	
	public static void takePhoto(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/cameraLinearLayout")));
        MobileElement camera = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/cameraLinearLayout"));
        camera.click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Take Photo']")));
        driver.findElement(By.xpath("//*[@text='Take Photo']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.camera2:id/shutter_button")));
        driver.findElement(By.id("com.android.camera2:id/shutter_button")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.android.camera2:id/done_button")));
        driver.findElement(By.id("com.android.camera2:id/done_button")).click();
	}
	
	public static void enableLocation() {
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/sbLocation")));
	     driver.findElement(By.id("com.mindshare.magnifi:id/sbLocation")).click();
	}
	
	public static void enableNotification(){
		 new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/sbPushNotification")));
		 driver.findElement(By.id("com.mindshare.magnifi:id/sbPushNotification")).click();
	}
	
	public static void addCreditCard(){
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/addCreditCardButton")));
        MobileElement btnAddCreditCard = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/addCreditCardButton"));
        btnAddCreditCard.click();
        //Choose country
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/countrySelectTextView")));
        MobileElement selectCountry = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/countrySelectTextView"));
        selectCountry.click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView")));
        driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView\n")).click();
        //Enter testing card number
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/et_card_number")));
        MobileElement txtCardNum = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/et_card_number"));
        txtCardNum.setValue("4242424242424242");
        MobileElement txtExpDate = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/et_expiry_date"));
        txtExpDate.setValue("1219");
        MobileElement txtCVV = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/et_cvc_number"));
        txtCVV.setValue("123");
	}
		
	@AfterTest
	public void Testteardown() {
		teardown(); // from BaseClass
	}    
}