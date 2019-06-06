package appiumTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class searchTest extends BaseClass {
	
	File userFile = new File("users.txt");
	String screenshotLocation = "C:\\Users\\student\\Desktop\\";
	
	public void screenshot(String path_screenshot) throws IOException {
	    File srcFile = driver.getScreenshotAs(OutputType.FILE);
	    String filename = UUID.randomUUID().toString(); 
	    File targetFile = new File(path_screenshot + filename +".jpg");
	    FileUtils.copyFile(srcFile, targetFile);
	}
	
	@Test
	public void searchTextFileForUser() throws IOException, InterruptedException {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(userFile));
		
		try {
			String user;
			while ((user = bufferedReader.readLine()) != null) {
			
				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Search']"))).click();
				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertSearchEditText"))).sendKeys(user);
				driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/mainLayout")));
				Thread.sleep(5000);
				screenshot(screenshotLocation);
			}
			
		} finally {
			bufferedReader.close();
		}
		
	}
  
}
