package cs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Goolge {
	WebDriver driver; 
	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("https://www.google.com.br/");
		assertEquals("Google",driver.getTitle());
		driver.manage().window().maximize();
		driver.quit();
	}
	
}