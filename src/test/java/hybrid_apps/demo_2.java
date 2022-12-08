package hybrid_apps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class demo_2 {
	AndroidDriver<AndroidElement> driver;
	 
	 
	 @BeforeTest
	 public void bt() throws MalformedURLException
	 {
		 DesiredCapabilities dc = new DesiredCapabilities();
		 
		 dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		 dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		 dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		 dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.androidsample.generalstore");
		 dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.androidsample.generalstore.SplashActivity ");
		 driver = new AndroidDriver<AndroidElement>(new URL(" http://0.0.0.0:4723/wd/hub"),dc);
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	 @Test(enabled=false)
	 public void negative_case() throws InterruptedException
	 {
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
		 Thread.sleep(3000);
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Male\")")).click();
		 Thread.sleep(3000);
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//android.widget.Toast[1]
		 
		String toast = driver.findElement(MobileBy.xpath("//android.widget.Toast[1]")).getText();
		System.out.println(toast);
	 }
	 
	 @Test(enabled=true)
	 public void positive_case() throws InterruptedException
	 {
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
		 Thread.sleep(3000);
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("sivanesh");
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Male\")")).click();
		 Thread.sleep(3000);
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		 Thread.sleep(3000);
		 driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		 driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		 Thread.sleep(3000);
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		 Thread.sleep(3000);
		//1st product price
		 String price1 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		 price1 = price1.substring(1);
		 
		 Double product1 = Double.parseDouble(price1);
		 System.out.println("product1 price = " + product1);
		//2nd product price
		 String price2 = driver.findElements(MobileBy.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		 price2 = price2.substring(1);
		 
		 Double product2 = Double.parseDouble(price2);
		 System.out.println("product2 price = " + product2);
		 
		 Double Totalprice = product1 + product2;
		 System.out.println("total price = " + Totalprice);
		 Thread.sleep(2000);
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")")).click();
		
		 driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		
	 }

}
