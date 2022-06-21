package mavendemo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Aparna
 *
 */
public class Keyword {

	public static WebDriver driver = null;

	/**
	 * This keyword is used to launch specified browser
	 * 
	 * @param BrowserName to launch
	 */

	public static void openBrowser(String BrowserName) {

		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (BrowserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else {
			System.out.println("i  have no any browser" + BrowserName);
		}
	}

	/**
	 * This keyword can be used to launch the specified url
	 * 
	 * @param url
	 */
	public static void openURL(String url) {

		driver.get(url);
		// driver.get("https://www.myntra.com/");
	}

	/**
	 * This keyword can be used to return {@code String} representation of the title
	 * of current page
	 * 
	 * @return
	 */
	public static String getTitle() {

		return driver.getTitle();
	}

	/**
	 * use in overloading concept
	 * 
	 * @param element
	 */
	public static void clickOn(WebElement element) {

		element.click();
	}

	public void clickOn(String elementText) {

		driver.findElement(By.xpath("//*[contains(text(),'" + elementText + "')]")).click();
	}

	/**
	 * 
	 * @param element
	 */
	public static void clickOn(By element) {

		driver.findElement(element).click();
	}

	public static void closeWindow(String title) {

		String currentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {

			driver.switchTo().window(window);
			if (driver.getTitle().equalsIgnoreCase(title)) {

				driver.close();
			}
		}

	}
	public static void maximizeWindow() {
		
		driver.manage().window().maximize();
	}
	public static void quiteAllWindow() {
		
       driver.quit();
	}
}
