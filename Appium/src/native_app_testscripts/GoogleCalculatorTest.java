package native_app_testscripts;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class GoogleCalculatorTest {
	AndroidDriver driver;
  @Test
  public void sumOfTwoNumbers() throws InterruptedException {
	  Thread.sleep(3000);
      driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
      driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
      driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
      driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
  	//Check the calculated value on the edit box
      Thread.sleep(6000);
     WebElement results=driver.findElement(By.id("com.google.android.calculator:id/result_final"));	
     if (results.getText().equals("6")) {
   	  System.out.println("Actual value is : "+results.getText()+" matched with expected value: 6");
     }else {
   	  System.out.println("Actual value is : "+results.getText()+" did not match with expected value: 6");
     }
  }
  
  @BeforeTest
  public void setup() throws MalformedURLException {
      driver = getDriver();
      System.out.println("Server connected");
  }

//  @AfterTest
//  public void teardown() throws InterruptedException {
//	  // close the app
//	  Thread.sleep(3000);
//	  driver.quit();
//  }
  private AndroidDriver getDriver() throws MalformedURLException {
	  // Set up desired capabilities and pass the Android app-activity and app-package to Appium
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setCapability("deviceName", "Nokia 7.2");
	  capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("platformVersion", "11");
      capabilities.setCapability("automationName", "UiAutomator2");  //UiAutomator2
      // This package name of your app (you can get it from apk info app)
      capabilities.setCapability("appPackage", "com.google.android.calculator");
      // This is Launcher activity of your app (you can get it from apk info app)
      capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
      // Create RemoteWebDriver instance and connect to the Appium server
      // It will launch the Calculator App in Android Device 
      // using the configurations specified in Desired Capabilities.
      System.out.println("Listening to Appium server...");
      return new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
      /*localhost connection or Connecting to appium and then passing the capabilities object with all the capabilities set. 
      So it will help to connect to that particular mobile.*/
  }

}
