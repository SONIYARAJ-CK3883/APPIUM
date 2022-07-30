package hybrid_app_testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class NewtoursTest {
	AndroidDriver driver;
	  @Test
	  public void loginTest() throws InterruptedException {
//		  driver.findElement(By.xpath("//a[text()='SIGN-ON']")).click();
	      driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("invalid");
	      driver.findElement(By.xpath("//input[@name='password']")).sendKeys("invalid");
	      driver.findElement(By.xpath("//input[@name='submit']")).click();
	      System.out.println("Invalid LOGIN successful");
	  }
	  
	  @BeforeTest
	  public void setup() throws MalformedURLException {
		  driver = getDriver();
		  System.out.println("Server connected");
		  driver.get("http://demo.guru99.com/test/newtours/");
	  }

	  @AfterTest
	  public void teardown() throws InterruptedException {
		  // close the app
		  Thread.sleep(5000);
		  driver.close();
	  }

	  private AndroidDriver getDriver() throws MalformedURLException {
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability("chromedriverExecutable", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		  // System.getProperty("user.dir") will fetch the path till drivers folder and execute the chromeDriver iniside.
		  capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		  capabilities.setCapability("deviceName", "Nokia 7.2");
		  capabilities.setCapability("platformName", "Android");
		  capabilities.setCapability("platformVersion", "11");
		  capabilities.setCapability("automationName", "UiAutomator2"); // UiAutomator2 for interacting with the UI of mobile
	      System.out.println("Listening to Appium server...");
	      return new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities); 
	      
	      /*localhost connection or Connecting to appium and then passing the capabilities object with all the capabilities set. 
	       So it will help to connect to that particular mobile.*/
	      }
}
