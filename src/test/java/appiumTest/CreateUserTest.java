package appiumTest;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Test to register a standard Magnifi user. Registration process consists of 4 steps: step 1 and entering full name are mandatory,
 other steps are optional and can be skipped.
 Before running the test, make sure to adjust the basic credentials and the screenshots path */

public class CreateUserTest extends BaseClass {

	private RandomValuesClass randomValues = new RandomValuesClass();
	private CameraClass camera = new CameraClass();
	
	// Declare basic credentials for alias registration
	private  String testEmailCredentials = "milleroks1992+";
	private String testEmailProvider = "@gmail.com";
	private String enter = "\n";
	
	// Declare screenshots path
	private String screenshotLocation = System.getProperty("user.home") + "\\Desktop"; 
	private String folderName = Long.toString(System.currentTimeMillis()) + "-createStandardUser";
	
	//Date
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDate localDate = LocalDate.now();
	String date = "" + dtf.format(localDate); 

	@Test
	public void createStandartUser() {
		//Test starts from Splash Screen Activity
		//Make sure the user is logged out in order to register a new user
		//logout();
		// Click Join Now and go to Activity_Join_Step_One
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/linearLayoutT"))).click();

		//Step1: Enter Credentials
		enterCredentials();
		driver.hideKeyboard();
		screenshot(screenshotLocation, folderName);
		nextStep();

		//Step 2:
		//Add photo (Choose takePhoto or chooseFromLibrary method):
		camera.openCamera(driver);
		camera.takePhoto(driver);
		//camera.chooseFromLibrary(driver);
		enterFullName();
		driver.hideKeyboard();
		screenshot(screenshotLocation, folderName);
		nextStep();

		//Step 3:
		enableLocation();
		enableNotification();
		screenshot(screenshotLocation, folderName);
		nextStep();

		//Step 4: Add credit card (add a card or skip the step, card is mandatory to make a call)
		addCreditCard();
		//skipAddingCard();
		driver.hideKeyboard();
		screenshot(screenshotLocation, folderName);
		nextStep();

		//Finish
		clickSearch();       
	}

	public void nextStep() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/nextTextView")));
		MobileElement next = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/nextTextView"));
		next.click();
	}

	public void enterCredentials() {
		
		//Email
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/emailAddressEditText")));
		MobileElement txtEmail = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/emailAddressEditText"));
		txtEmail.clear();
		txtEmail.click();
		txtEmail.sendKeys(testEmailCredentials + date + randomValues.getRandomAlias()+testEmailProvider + enter);
		
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

	public void enterFullName() {
		
		//Enter First Name 
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/firstNameEditText")));
		MobileElement txtFirstName = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/firstNameEditText"));
		txtFirstName.clear();
		txtFirstName.sendKeys(randomValues.getRandomName() + enter);
		
		// Enter Last name
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/lastNameEditText")));
		MobileElement txtLastName = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/lastNameEditText"));
		txtLastName.clear();
		txtLastName.sendKeys(randomValues.getRandomName() + date + enter);
	}


	public void enableLocation() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/sbLocation")));
		driver.findElement(By.id("com.mindshare.magnifi:id/sbLocation")).click();
	}

	public void enableNotification() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/sbPushNotification")));
		driver.findElement(By.id("com.mindshare.magnifi:id/sbPushNotification")).click();
	}

	public void addCreditCard() {
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

	public void skipAddingCard() {
		
		//Click 'Remind me later' link
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/txtRemindMeLater")));
		MobileElement remindLater = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/txtRemindMeLater"));
		remindLater.click();
	}

	public void clickSearch() {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/btnSearch")));
		MobileElement btnSearch = (MobileElement) driver.findElement(By.id("com.mindshare.magnifi:id/btnSearch"));
		screenshot(screenshotLocation, folderName);
		btnSearch.click();
	}
}
