package zb;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class JodelProject {

	
	private static final String Ignore = null;
	private WebDriver driver = null;
	static Dimension size;
	 
	@BeforeTest
	public void setup() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Moto G(3rd Generation)");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("app", app.getAbsolutePath());
		
		
//		capabilities.setCapability("deviceName", "Redmi 1s");
//		capabilities.setCapability("platformVersion", "4.4.4");
//		capabilities.setCapability("platformName", "Android");
		
		
		
		capabilities.setCapability("appPackage",
				"com.tellm.android.app");
		capabilities.setCapability("appActivity",
				"com.jodelapp.jodelandroidv3.view.Launcher");
	capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"100");

		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 
	}
 
	@Test(priority=1)
	public void Firsttabdetails () throws Exception {
		//To Click on "Allow Location to fetch Current location
				driver.findElement(By.id("com.tellm.android.app:id/signup_button")).click();
				
				
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.presenceOfElementLocated(By
				            .id("com.tellm.android.app:id/feed_title")));
				
				//To get the current location of the user
			    String Locationfetching = driver.findElement(By.id("com.tellm.android.app:id/feed_title")).getText();
			    System.out.println("Current Location is : " +Locationfetching);
			

			    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			   //To get the Karma points
		    	String karmapoints=driver.findElement(By.id("com.tellm.android.app:id/karma_amount_text")).getText();
				System.out.println("Karma points are : "+ karmapoints);
				
				//To get the first Posted message
				String Firstpostedmessage=driver.findElement(By.id("com.tellm.android.app:id/post_message")).getText();
				System.out.println("First Posted message is :" +Firstpostedmessage);
				
				
				//To get the Number of replies for the posted message or Most Commented messages
				String Numberofreplytofirstmessage=driver.findElement(By.id("com.tellm.android.app:id/replies_count_text")).getText();
				System.out.println("Reply count to first message :" +Numberofreplytofirstmessage);
				
				
				//To get the Number of days before the post was created
				String daysbeforepostcreated=driver.findElement(By.id("com.tellm.android.app:id/post_created")).getText();
				System.out.println("Number of days before the post was created : "+daysbeforepostcreated);
	}
	
	@Test(priority=2)
	public void Secondtabdetails(){
	
		WebElement Display = driver.findElement(By.id("com.tellm.android.app:id/order_by_replies"));
		//Either tap or click on element, tap(webelement el);
		//Display.click();
		TouchAction tc = new TouchAction((MobileDriver) driver);
		tc.tap(Display).perform();
		System.out.println("Clicked on second tab (Message tab)" );
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//To View the Most Replied message in the tab
		String mostrepliedmsg=driver.findElement(By.id("com.tellm.android.app:id/post_message" )).getText();
		System.out.println("Most Replied Messages " +mostrepliedmsg);
		
		//To View the Count of Most Replied messages
		String countofrepliedmsg=driver.findElement(By.id("com.tellm.android.app:id/replies_count_text")).getText();
		System.out.println("The Count of Replied Message is :" +countofrepliedmsg);
		
		
		//To Get Place of the most replied messages
		String Locationofmostreplied=driver.findElement(By.id("com.tellm.android.app:id/corner_text")).getText();
		System.out.println("The palce of most Replied messages from : "+Locationofmostreplied);
		
		
		//To Get the Number of days of post created
		String postcraeteddays=driver.findElement(By.id("com.tellm.android.app:id/post_created")).getText();
		System.out.println("No of days before the Post was created :"+postcraeteddays);
	}
    @Test(priority=3)
	public void thirdtabdetails(){
		WebElement thirdtab=driver.findElement(By.id("com.tellm.android.app:id/order_by_votes"));
		TouchAction tt = new TouchAction((MobileDriver) driver);
		tt.tap(thirdtab).perform();
		System.out.println("Clicked on Third Tab (Vote Tab)" );
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Thread.sleep(5000);
		
		
		WebDriverWait wait2 = new WebDriverWait(driver, 60); 
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.tellm.android.app:id/post_message")));
		
		String tab=driver.findElement(By.id("com.tellm.android.app:id/post_message")).getText();
		System.out.println("The Most Votes for this message: " +tab);
		
		
	    //Post Count
		String countofpost=driver.findElement(By.id("com.tellm.android.app:id/post_vote_count")).getText();
		System.out.println("Number of post Count :" +countofpost);
		
		
		//Place of the Message
		String place=driver.findElement(By.id("com.tellm.android.app:id/corner_text")).getText();
		System.out.println("Place of the message posted from :" +place);
		
		//Post created
		String createdpost=driver.findElement(By.id("com.tellm.android.app:id/post_created")).getText();
		System.out.println("Days of the message posted from :" +createdpost);
	}
	@Test(priority=4)
    public void Backtofirsttab(){
		WebElement firsttab=driver.findElement(By.id("com.tellm.android.app:id/order_by_time"));
		TouchAction ft = new TouchAction((MobileDriver) driver);
		ft.tap(firsttab).perform();
		System.out.println("Clicked on First Tab (Timer Tab)" );
		
		
//		WebDriverWait wait4 = new WebDriverWait(driver, 5); 
//		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.tellm.android.app:id/order_by_replies")));
		
		// This is to click on Plus Icon
		driver.findElement(By.id("com.tellm.android.app:id/add_post_button")).click();
		
		
		//This is to click on " Accept" 
		driver.findElement(By.id("com.tellm.android.app:id/order_by_replies")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// This is to click on Plus Icon
		driver.findElement(By.id("com.tellm.android.app:id/add_post_button")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		WebDriverWait wait3 = new WebDriverWait(driver, 60); 
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.tellm.android.app:id/create_post_edit_text")));
		
		//This is to clear the text present in the Edittext
		driver.findElement(By.id("com.tellm.android.app:id/create_post_edit_text")).clear();
		
		//This is to Enter text is the edittext
		driver.findElement(By.id("com.tellm.android.app:id/create_post_edit_text")).sendKeys(" This is my second message pls update" );
		System.out.println("User has Entered the message");
		
		//This is to click on " Send" Button
		driver.findElement(By.id("com.tellm.android.app:id/toolbar_send")).click();
		System.out.println("Clicked on Send Button");
		
		
		String newpostedmessage=driver.findElement(By.id("com.tellm.android.app:id/post_message")).getText();
		System.out.println("New Posted message is :" +newpostedmessage);
    	
    }
	
	
	
	@Test (priority=5)
	public void Deletejodel(){
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		
		
		WebElement msg=driver.findElement(By.id("com.tellm.android.app:id/v_message_container"));
		System.out.println("Message to get deleted"+msg);
		TouchAction tap = new TouchAction((MobileDriver) driver);
		tap.tap(msg).perform();
		
		
		//This is to click on three dots
		driver.findElement(By.id("com.tellm.android.app:id/context_menu_button")).click();
		System.out.println("Clicked on three Dots");
		
		//This is to click on Delete Jodel
		driver.findElement(By.id("com.tellm.android.app:id/myjodel_dialog_delete_button")).click();
		System.out.println("Clicked On Delete the jodel");
		
	}
	@Test(priority=6)
	public void Swipefunction() throws InterruptedException{
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  size=driver.manage().window().getSize();
		  System.out.println(size);
		  int startx = (int)(size.width*0.10);
		  System.out.println("Start x: "+startx);
		  int endx = (int)(size.width*0.90);
		  System.out.println("End x: "+endx);
		  int starty = size.height/2;
		  System.out.println("Start y: "+starty);
		  int duration;
		  Thread.sleep(8000);
		((AppiumDriver) driver).swipe(endx, starty, startx, starty, 7000);
		
		
		
		Thread.sleep(10000);
		
		//To Click on "My Jodel"
		driver.findElement(By.id("com.tellm.android.app:id/v_me_menu_item")).click();
		System.out.println("Clicked on My Jodels");
		
		//To get My Jodel Message
		String myjodelmsg=driver.findElement(By.id("com.tellm.android.app:id/post_message")).getText();
		System.out.println("My Jodels message :" +myjodelmsg);
		
		//To get My Jodel Message place
		String myjodelmsgplace=driver.findElement(By.id("com.tellm.android.app:id/corner_text")).getText();
		System.out.println("Place of the Jodeller:" +myjodelmsgplace);
		
		//To get My Jodel Message post created
		String myjodelmsgpostcreated=driver.findElement(By.id("com.tellm.android.app:id/post_created")).getText();
		System.out.println("Days Before the Post Was created :" +myjodelmsgpostcreated);
		
		//This is to click on back button
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		
		//This is to click on back button
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		
	}
	
	@Test(priority=9)
	public void camerafunctionholdandview(){
		
		//This is to click on plus icon
		driver.findElement(By.id("com.tellm.android.app:id/add_post_button")).click();
		//To Click on Accept
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		//This is to click on camera icon
		
		driver.findElement(By.id("com.tellm.android.app:id/cameraButton")).click();
		System.out.println("Cliciked on Camera Icon");
		
		//This is to take apic
		
		driver.findElement(By.id("com.tellm.android.app:id/take_pic_button")).click();
		System.out.println("Cliciked on Camera Button present below the image");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//This is to Click on Send Button
		driver.findElement(By.id("com.tellm.android.app:id/order_by_replies")).click();
		System.out.println("Cliciked on Send icon");
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebElement webElement=driver.findElement(By.id("com.tellm.android.app:id/holdToView"));
		TouchAction action = new TouchAction((MobileDriver) driver);
		action.longPress(webElement).release().perform();
		System.out.println("Hold and View");
		
	}
	@Test(priority=7)
	public void replytojodel(){
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//To Click on "Allow Location to fetch Current location
		
				
//				
				
				WebElement firsttab=driver.findElement(By.id("com.tellm.android.app:id/post_message"));
				TouchAction ft = new TouchAction((MobileDriver) driver);
				ft.tap(firsttab).perform();
				System.out.println("Clicked on First message" );
				
				
				
				//Click on Jodel back here
				driver.findElement(By.id("com.tellm.android.app:id/order_by_time")).click();
				System.out.println("Jodel Back here");
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				//This is to enter the data in edittext
				driver.findElement(By.id("com.tellm.android.app:id/order_by_time")).sendKeys("My reply to the jodeller is" );
				System.out.println("Entered the value in Editext");
				
				
				driver.findElement(By.id("com.tellm.android.app:id/btn_reply_send")).click();
				System.out.println("clicked on arrow button ");
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				//This is to click on back button
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	}
//	@Test(Ignore)
//	public void sharejodel(){
//		
//	}
	@Test(priority=8)
	public void Pinthejodel(){
		
		
		WebElement firsttab=driver.findElement(By.id("com.tellm.android.app:id/post_message"));
		TouchAction ft = new TouchAction((MobileDriver) driver);
		ft.tap(firsttab).perform();
		System.out.println("Clicked on First message" );
		
		//To Click on pins icon
		driver.findElement(By.id("com.tellm.android.app:id/post_pin")).click();
		System.out.println("Pin icon Clicked");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// this is to click on The Notification of the pin
		driver.findElement(By.id("com.tellm.android.app:id/md_buttonDefaultNeutral")).click();
		 System.out.println("Clicked on ok ");
		 
		//This is to click on back button
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);		
	}
    
    
	@AfterTest
	public void tearDown() {
		//driver.quit();
	
 
}
}
