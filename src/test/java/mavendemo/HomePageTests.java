package mavendemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author soni
 *
 */
public class HomePageTests {

	@Test(description = "without framework")
	public static void verifyTitleOfHomePage() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testingshastra.com");
		String expectedTitle = "Testing Shastra | Training | Placement";
		String actualTitle = driver.getTitle();
	    Assert.assertEquals(actualTitle,expectedTitle );
	}
	@Test(description = "With FrameWork")
	public static void verifyTitleOfTheHomePage() {
	
		String expectedTitle = "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra";
		Keyword.openBrowser("Firefox");
		Keyword.openURL("https://www.myntra.com");
		String actualTitle = Keyword.getTitle();
		
	    Assert.assertEquals(actualTitle,expectedTitle );
	   Keyword.closeWindow("Online Shopping");
	 
	   // Keyword.quiteAllWindow();
	}
}
