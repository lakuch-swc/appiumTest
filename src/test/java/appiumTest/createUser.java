//package <set your test package>;
package appiumTest;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.junit.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class createUser{
    private RandomValues randomValues = new RandomValues();
    private String testEmailCredentials = "milleroks1992+";
    private String testEmailProvider = "@gmail.com";
    private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();

    @Before
    public void setUp() throws MalformedURLException {
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("testName", testName);
        dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        //dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.mindshare.magnifi");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".view.SplashScreenActivity");
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }

    @Test
    public void testUntitled() {
        //Standard User registration with photo, but skip bank account
        driver.findElement(By.xpath("//*[@text=concat('It', \"'\", 's free to join')]")).click();
        //Step 1 : email, user name, password
        driver.findElement(By.xpath("//*[@id='emailAddressEditText']")).sendKeys(testEmailCredentials + randomValues.getRandomAlias() + testEmailProvider);
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='android.widget.FrameLayout' and ./parent::*[@id='key_pos_ime_action']]/*[@class='android.widget.ImageView'])[1]")));
        driver.findElement(By.xpath("(//*[@class='android.widget.FrameLayout' and ./parent::*[@id='key_pos_ime_action']]/*[@class='android.widget.ImageView'])[1]")).sendKeys(randomValues.getRandomName());
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='icon' and ./parent::*[./parent::*[@id='key_pos_ime_action']] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.ImageView']]")));
        driver.findElement(By.xpath("//*[@id='icon' and ./parent::*[./parent::*[@id='key_pos_ime_action']] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.ImageView']]")).sendKeys(randomValues.getPassword());
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='icon' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.ImageView']]")));
        driver.findElement(By.xpath("//*[@id='icon' and (./preceding-sibling::* | ./following-sibling::*)[@class='android.widget.ImageView']]")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        //Step 2: First Name, Last Name, photo
        driver.findElement(By.xpath("//*[@id='firstNameEditText']")).sendKeys(randomValues.getRandomName());
        driver.findElement(By.xpath("//*[@id='lastNameEditText']")).sendKeys(randomValues.getRandomName());
        driver.findElement(By.xpath("//*[@id='cameraImageView']")).click();
        driver.findElement(By.xpath("//*[@text='Take Photo']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='shutter_button']")));
        driver.findElement(By.xpath("//*[@id='shutter_button']")).click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='done_button']")));
        driver.findElement(By.xpath("//*[@id='done_button']")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Next']")));
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        //Step 3: location, notifications 
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='sbLocation']"))); 
        driver.findElement(By.xpath("//*[@id='sbLocation']")).click();
        driver.findElement(By.xpath("//*[@id='sbPushNotification']")).click();
        driver.findElement(By.xpath("//*[@text='Next']")).click();
        //Step 4: add credit card
        //Was not able to add test credit card in a "live mode"
        driver.findElement(By.xpath("//*[@text='Remind me later']")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}