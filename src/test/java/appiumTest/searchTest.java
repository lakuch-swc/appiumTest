package appiumTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

public class searchTest extends BaseClass {
	
	File userFile = new File("users.txt");
	String screenshotLocation = "C:\\Users\\student\\Desktop\\";
	
	@Test
	public void searchTextFileForUser() throws IOException, InterruptedException {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(userFile));
		
		try {
			String user;
			while ((user = bufferedReader.readLine()) != null) {
			
				try {
					new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/drawable_left_icon"))).click();
					Thread.sleep(2000);
				} finally {
					screenshot(screenshotLocation);
				}
				
				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Search']"))).click();
				new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.id("com.mindshare.magnifi:id/expertSearchEditText"))).sendKeys(user);
				screenshot(screenshotLocation);
				driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "Search"));
				
				try {
					new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.className("android.widget.RelativeLayout")));
					Thread.sleep(2000);
				} finally {
					screenshot(screenshotLocation);
				}
				
			}
			
		} finally {
			bufferedReader.close();
		}
		
	}
  
}
