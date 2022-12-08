package native_apps;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static java.time.Duration.ofSeconds;
import org.antlr.grammar.v3.ANTLRv3Parser.element_return;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;

public class demo_1 {
	 AndroidDriver<AndroidElement> driver;
	 
	 
	 @BeforeTest
	 public void bt() throws MalformedURLException
	 {
		 DesiredCapabilities dc = new DesiredCapabilities();
		 
		 dc.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		 dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		 dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		 dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.appium.android.apis");
		 dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.appium.android.apis.ApiDemos");
		 driver = new AndroidDriver<AndroidElement>(new URL(" http://0.0.0.0:4723/wd/hub"),dc);
		 
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	 }
	 
	 @Test(enabled=false)
	 public void animation() throws InterruptedException
	 {
		 	System.out.println("We're started with native apps");
		 	driver.findElement(MobileBy.AccessibilityId("Animation")).click();
		 	Thread.sleep(3000);
		 	driver.findElements(MobileBy.className("android.widget.TextView")).get(5).click();
		 	Thread.sleep(3000);
		 	driver.findElement(MobileBy.AccessibilityId("Play")).click();
	 }
	 
	 @Test(enabled=false)
	 public void media() throws InterruptedException
	 {
		 	driver.findElement(MobileBy.AccessibilityId("Media")).click();
		 	Thread.sleep(3000);
		 	driver.findElements(MobileBy.className("android.widget.TextView")).get(1).click();
		 	driver.navigate().back();
		 
	 }
	 
	 @Test(enabled=false)
	 public void preferences() throws InterruptedException
	 {
		 	driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		 	Thread.sleep(3000);
		 	driver.findElements(MobileBy.className("android.widget.TextView")).get(3).click();
		 	Thread.sleep(3000);
		 	driver.findElement(MobileBy.id("android:id/checkbox")).click();
		 	Thread.sleep(4000);
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"WiFi settings\")")).click();
		 	Thread.sleep(3000);
		 	driver.findElement(MobileBy.id("android:id/edit")).sendKeys("Welcome");
		 	//driver.navigate().back();
		 	driver.hideKeyboard();
		 	Thread.sleep(2000);
		 	driver.navigate().back();
	 }
	 
	 @Test(enabled=false)
	 public void app() throws InterruptedException
	 {
		 	driver.findElement(MobileBy.AccessibilityId("App")).click();
		 	Thread.sleep(2000);
		 	driver.findElement(MobileBy.AccessibilityId("Notification")).click();
		 	Thread.sleep(2000);
		 	driver.findElement(MobileBy.AccessibilityId("Status Bar")).click();
		 	Thread.sleep(2000);
		 	driver.findElement(MobileBy.AccessibilityId("Sound")).click();
		 	Thread.sleep(2000);
		 	driver.navigate().back();
		 	driver.navigate().back();
		 
	 }
	 
	  
	 @Test(enabled=false)
	 public void open_notification() throws InterruptedException
	 {
		 	driver.openNotifications();
		 	Thread.sleep(3000);
		 	driver.findElement(MobileBy.AccessibilityId("Open quick settings.")).click();
		 	Thread.sleep(3000);
	    // click auto rotate
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Auto-rotate\")")).click();
		 	Thread.sleep(3000);
	   //open settings
		 	driver.findElement(MobileBy.AccessibilityId("Open settings.")).click();
		 	Thread.sleep(3000);
	   //click on display
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Display\")")).click();
		 	Thread.sleep(3000);
	   //click on sleep
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Sleep\")")).click();
	   //click on 2minutes
		 	driver.findElements(MobileBy.className("android.widget.CheckedTextView")).get(3).click();
		 	Thread.sleep(3000);
	   //click on device rotate
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Device rotation\")")).click();
		 	Thread.sleep(2000);
	   //click on checkbox
		 	driver.findElements(MobileBy.className("android.widget.CheckedTextView")).get(1).click();
	   //click on advanced
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Advanced\")")).click();
		 	Thread.sleep(2000);
	   //click on font size
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Font size\")")).click();
		 	Thread.sleep(3000);
	   //click font size
		 	driver.findElement(MobileBy.AccessibilityId("Make larger")).click();
		 	Thread.sleep(2000);
	   
		 	driver.navigate().back();
		 	driver.navigate().back();
		 	driver.navigate().back();
		 	
	 }
	 @Test(enabled=false)
	 public void actions_tap_longpress()
	 {
		 driver.findElement(MobileBy.AccessibilityId("Views")).click();
		 AndroidElement size = driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)");
		 System.out.println(size.getSize());
	//tap
		 driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		 AndroidElement tap = driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter"));
	//actions
		 TouchAction ta = new TouchAction(driver);
		 ta.tap(tapOptions().withElement(element(tap))).perform();
	//long press
		 AndroidElement lo = driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Cat Names\")"));
		 ta.longPress(longPressOptions().withElement(element(lo)).withDuration(ofSeconds(3))).release().perform();
		 driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Sample action\")")).click();;
		 
	 }

	 @Test(enabled=false)
	 public void scroll_action() throws InterruptedException
	 {
		 driver.findElement(MobileBy.AccessibilityId("Views")).click(); 
	   	 Thread.sleep(3000);
	 //scroll
	   	 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();
	   	 
	 }
	 @Test(enabled=false)
	 public void keyboard_act() throws InterruptedException
	 {
		 driver.findElement(MobileBy.AccessibilityId("Views")).click(); 
	   	 Thread.sleep(3000);
	   	 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
	   	 Thread.sleep(2000);
	 //key press
	   	 driver.pressKey(new KeyEvent(AndroidKey.BACK));
	   	 driver.pressKey(new KeyEvent(AndroidKey.HOME));
	 }
	 @Test(enabled=false)
	 public void swipe_action() throws InterruptedException
	 {
		 driver.findElement(MobileBy.AccessibilityId("Views")).click();
		 driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		 driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		 driver.findElement(MobileBy.AccessibilityId("3")).click();
		 Thread.sleep(3000);
	//click on time 
		AndroidElement ele1 = driver.findElement(MobileBy.AccessibilityId("30"));
		AndroidElement ele2 = driver.findElement(MobileBy.AccessibilityId("55"));
	//touch actions
		TouchAction ta = new TouchAction(driver);
	//long press
		ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
	//click on am/pm
		driver.findElementByAndroidUIAutomator("text(\"PM\")").click(); 
		
	 }
	 
	 @Test(enabled=false)
	 public void drag_drop() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 driver.findElement(MobileBy.AccessibilityId("Views")).click();
		 driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
	 //select drag and drop 
		 AndroidElement ele1 = driver.findElements(MobileBy.className("android.view.View")).get(0);
		 AndroidElement ele2 = driver.findElements(MobileBy.className("android.view.View")).get(1);
	//actions 
		 TouchAction ta = new TouchAction(driver);
	//long press 
		 ta.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(3))).moveTo(element(ele2)).release().perform();
	 }
	 @Test(enabled=false)
	 public void switchapp() throws InterruptedException
	 {
		driver.findElement(MobileBy.AccessibilityId("OS")).click();
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(555) 521-5554");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("welcome");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_send_message")).click();
		Thread.sleep(3000);
		 
		driver.activateApp("com.google.android.apps.messaging");
		 
		String text= driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
		System.out.println(text);
		
		driver.pressKey (new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(3000);
		driver.pressKey (new KeyEvent(AndroidKey.APP_SWITCH));
		Thread.sleep(3000);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
		 
		 
	 }
	 
	 @Test(enabled=true,priority=0)
	 public void Graphics() throws InterruptedException
	 {
		 	driver.findElement(MobileBy.AccessibilityId("Graphics")).click();
		 	Thread.sleep(3000);
		 //clicking on alpha bitmap
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"AlphaBitmap\")")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 //clicking animateDrawables
		 	driver.findElements(MobileBy.className("android.widget.TextView")).get(2).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 //clicking arcs
		 	driver.findElement(MobileBy.AccessibilityId("Arcs")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 //clicking bit map mesh
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"BitmapMesh\")")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 //clicking on clipping
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Clipping\")")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 //clicking on color filters
		 	driver.findElement(MobileBy.AccessibilityId("ColorFilters")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 //clicking on color matrix
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ColorMatrix\")")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 //clicking on compass
		 	driver.findElement(MobileBy.AccessibilityId("Compass")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 //clicking on create bitmap
		 	driver.findElement(MobileBy.AccessibilityId("CreateBitmap")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		    Thread.sleep(3000);
		 //clicking on drawables
		 	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Drawable\"))").click();
		 	Thread.sleep(3000);
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"GradientDrawable\")")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ShapeDrawable\")")).click();
		 	Thread.sleep(3000);
		    driver.pressKey(new KeyEvent(AndroidKey.BACK));
		    Thread.sleep(2000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 //clicking on layers
		 	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Layers\"))").click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(3000);
	 }
	 
	 @Test(enabled=true,priority=1)
	 public void transition3d() throws InterruptedException
	 {
		//clicking on views
		 	driver.findElement(MobileBy.AccessibilityId("Views")).click(); 
		 	Thread.sleep(3000);
		//clicking on animation
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Animation\")")).click();
		 	Thread.sleep(3000);
		//clicking on 3d transition
		 	driver.findElements(MobileBy.className("android.widget.TextView")).get(1).click();
		 	Thread.sleep(3000);
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Lyon\")")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
 }
	 
	 @Test(enabled=true,priority=2)
	 public void interpolators() throws InterruptedException
	 {
		//clicking on Interpolators
		 	driver.findElement(MobileBy.AccessibilityId("Interpolators")).click(); 
		 	Thread.sleep(3000);
		//clicking on accelerate
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Accelerate\")")).click();
		 	Thread.sleep(3000);
		//clicking on decelerate
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Decelerate\")")).click();
		 	Thread.sleep(4000);
		//clicking on anticipate
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Decelerate\")")).click();
		 	Thread.sleep(3000);
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Anticipate\")")).click();
		 	Thread.sleep(4000);
	    //clicking on overshoot
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Anticipate\")")).click();
		 	Thread.sleep(2000);
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Overshoot\")")).click();
		 	Thread.sleep(4000);
		//clicking on bounce
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Overshoot\")")).click();
		 	Thread.sleep(3000);
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Bounce\")")).click();
		 	Thread.sleep(4000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
	 }
		 	
	 @Test(enabled=true,priority=3)
	 public void push_shake() throws InterruptedException
	 { 
		//clicking on push
		 	driver.findElement(MobileBy.AccessibilityId("Push")).click(); 
		 	Thread.sleep(3000);
	    //clicking on pushup
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Push up\")")).click();
		 	Thread.sleep(3000);
		//clicking on push left
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Push left\")")).click();
		 	Thread.sleep(4000);
		//clicking on cross fade
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Push left\")")).click();
		 	Thread.sleep(3000);
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Cross fade\")")).click();
		 	Thread.sleep(4000);
		//clicking on hyper space
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Cross fade\")")).click();
		 	Thread.sleep(3000);
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Hyperspace\")")).click();
		 	Thread.sleep(4000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
		//clicking on buttons
		 	driver.findElement(MobileBy.AccessibilityId("Buttons")).click(); 
		 	Thread.sleep(2000);
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"OFF\")")).click();
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
	 }
		 	
	 @Test(enabled=true,priority=4)
	 public void chromatic() throws InterruptedException
	 {
		 //clicking on chronometer
		 	driver.findElements(MobileBy.className("android.widget.TextView")).get(4).click();
		 	Thread.sleep(3000);
		 //clicking on start
		 	driver.findElement(MobileBy.AccessibilityId("Start")).click();
		 	Thread.sleep(8000);
		 //click on stop
		 	driver.findElement(MobileBy.AccessibilityId("Stop")).click();
		 	Thread.sleep(3000);
		 //click on reset
		 	driver.findElement(MobileBy.AccessibilityId("Reset")).click();
		 	Thread.sleep(3000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(3000);
	 }
	 
	 @Test(enabled=true,priority=5)
	 public void controls() throws InterruptedException
	 {
	   	 //clicking on views
	   	 	driver.findElement(MobileBy.AccessibilityId("Views")).click(); 
	   	 	Thread.sleep(3000);
		 //click on contols
	   	 	driver.findElement(MobileBy.AccessibilityId("Controls")).click();
	   	 	Thread.sleep(2000);
		 //click on light theme
	   	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"1. Light Theme\")")).click();
	   	 	Thread.sleep(3000);
		 //send value
	   	 	driver.findElement(MobileBy.id("io.appium.android.apis:id/edit")).sendKeys("welcome");
	   	 	Thread.sleep(2000);
		 //click on box1
	   	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 1\")")).click();
	   	 	Thread.sleep(2000);
		 //click on box2
	   	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 2\")")).click();
	   	 	Thread.sleep(2000);
		 //click on radio1
	   	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 1\")")).click();
	   	 	Thread.sleep(2000);
		 //click on radio2
	   	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 2\")")).click();
	   	 	Thread.sleep(2000);
		 //click on star
	   	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Star\")")).click();
	   	 	Thread.sleep(2000);
		 //click on off 1
	   	 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle1")).click();
	   	 	Thread.sleep(2000);
		 //click on off 2
	   	 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle2")).click();
	   	 	Thread.sleep(2000);
		 //click on mercury
	   	 	driver.findElement(MobileBy.id("android:id/text1")).click();
	   	 	Thread.sleep(2000);
		 //click on venus
	   	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Venus\")")).click();
	   	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	   	    Thread.sleep(2000);
		 //click on save
	   	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Save\")")).click();
	   	 	Thread.sleep(2000);
	   	    driver.pressKey(new KeyEvent(AndroidKey.BACK));
	   	    Thread.sleep(2000);
	 }
	 @Test(enabled=true,priority=6)
	 public void darktheme() throws InterruptedException
	  {
		 
		 //click on dark theme
			 driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"2. Dark Theme\")")).click();
			 Thread.sleep(3000);
		 //send value
			 driver.findElement(MobileBy.id("io.appium.android.apis:id/edit")).sendKeys("welcome all");
			 Thread.sleep(2000);
		 //click on box1
			 driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 1\")")).click();
			 Thread.sleep(2000);
		 //click on box2
			 driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 2\")")).click();
			 Thread.sleep(2000);
		 //click on radio1
			 driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 1\")")).click();
		 	Thread.sleep(2000);
		 //click on radio2
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 2\")")).click();
		 	Thread.sleep(2000);
		 //click on star
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Star\")")).click();
		 	Thread.sleep(2000);
		 //click on off 1
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle1")).click();
		 	Thread.sleep(2000);
		 //click on off 2
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle2")).click();
		 	Thread.sleep(2000);
		 //click on mercury
		 	driver.findElement(MobileBy.id("android:id/text1")).click();
		 	Thread.sleep(2000);
		 //click on venus
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Earth\")")).click();
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
		 //click on save
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Save\")")).click();
		 	Thread.sleep(2000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
	  }
	  @Test(enabled=true,priority=7)
	  public void hololight() throws InterruptedException
	 {
		
		//click on hololight theme
		  	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"3. Holo Light Theme\")")).click();
		  	Thread.sleep(3000);
		//send value
		  	driver.findElement(MobileBy.id("io.appium.android.apis:id/edit")).sendKeys("welcome to all");
		  	Thread.sleep(2000);
		//click on box1
		  	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 1\")")).click();
		 	Thread.sleep(2000);
		//click on box2
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 2\")")).click();
		 	Thread.sleep(2000);
		//click on radio1
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 1\")")).click();
		 	Thread.sleep(2000);
		//click on radio2
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 2\")")).click();
		 	Thread.sleep(2000);
		//click on star
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Star\")")).click();
		 	Thread.sleep(2000);
		//click on off 1
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle1")).click();
		 	Thread.sleep(2000);
		//click on off 2
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle2")).click();
		 	Thread.sleep(2000);
		//click on mercury
		 	driver.findElement(MobileBy.id("android:id/text1")).click();
		 	Thread.sleep(2000);
		//click on venus
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Mars\")")).click();
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
		//click on save
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Save\")")).click();
		 	Thread.sleep(2000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
	 }
	 @Test(enabled=true,priority=8)
	 public void holodark() throws InterruptedException
	 { 
		
		//click on holodark theme
	   	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"4. Holo Dark Theme\")")).click();
	   	 	Thread.sleep(3000);
		//send value
	   	 	driver.findElement(MobileBy.id("io.appium.android.apis:id/edit")).sendKeys("hello");
	   	 	Thread.sleep(2000);
		//click on box1
	   	 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 1\")")).click();
		 	Thread.sleep(2000);
		//click on box2
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 2\")")).click();
		 	Thread.sleep(2000);
		//click on radio1
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 1\")")).click();
		 	Thread.sleep(2000);
		//click on radio2
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 2\")")).click();
		 	Thread.sleep(2000);
		//click on star
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Star\")")).click();
		 	Thread.sleep(2000);
	    //click on off 1
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle1")).click();
		 	Thread.sleep(2000);
		//click on off 2
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle2")).click();
		 	Thread.sleep(2000);
		//click on mercury
		 	driver.findElement(MobileBy.id("android:id/text1")).click();
		 	Thread.sleep(2000);
		//click on venus
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Jupiter\")")).click();
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
		//click on save
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Save\")")).click();
		 	Thread.sleep(2000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
	 }
		 
	 @Test(enabled=true,priority=9)
	 public void customtheme() throws InterruptedException
	 {
		
		//click on custom theme
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"5. Custom Theme\")")).click();
		 	Thread.sleep(3000);
		//send value
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/edit")).sendKeys("hello to all");
		 	Thread.sleep(2000);
		//click on box1
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 1\")")).click();
		 	Thread.sleep(2000);
		//click on box2
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 2\")")).click();
		 	Thread.sleep(2000);
		//click on radio1
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 1\")")).click();
		 	Thread.sleep(2000);
		//click on radio2
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 2\")")).click();
		 	Thread.sleep(2000);
		//click on star
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Star\")")).click();
		 	Thread.sleep(2000);
		//click on off 1
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle1")).click();
		 	Thread.sleep(2000);
		//click on off 2
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle2")).click();
		 	Thread.sleep(2000);
		//click on mercury
		 	driver.findElement(MobileBy.id("android:id/text1")).click();
		 	Thread.sleep(2000);
		//click on venus
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Saturn\")")).click();
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
		//click on save
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Save\")")).click();
		 	Thread.sleep(2000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
	 }
		 	
	 @Test(enabled=true,priority=10)
	 public void holo_jold() throws InterruptedException
	 {
		 
	   	//click on holo or old theme
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"6. Holo or Old Theme\")")).click();
		 	Thread.sleep(3000);
		//send value
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/edit")).sendKeys("hello guys");
		 	Thread.sleep(2000);
		//click on box1
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 1\")")).click();
		 	Thread.sleep(2000);
		//click on box2
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Checkbox 2\")")).click();
		 	Thread.sleep(2000);
		//click on radio1
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 1\")")).click();
		 	Thread.sleep(2000);
		//click on radio2
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"RadioButton 2\")")).click();
		 	Thread.sleep(2000);
		//click on star
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Star\")")).click();
		 	Thread.sleep(2000);
		//click on off 1
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle1")).click();
		 	Thread.sleep(2000);
		//click on off 2
		 	driver.findElement(MobileBy.id("io.appium.android.apis:id/toggle2")).click();
		 	Thread.sleep(2000);
		//click on mercury
		 	driver.findElement(MobileBy.id("android:id/text1")).click();
		 	Thread.sleep(2000);
		//click on venus
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Neptune\")")).click();
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
		//click on save
		 	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Save\")")).click();
		 	Thread.sleep(2000);
		 	driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 	Thread.sleep(2000);
	 }
	
	 }
