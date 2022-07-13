package cs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestFrames {

	@Test
	public void DevoInteragirComFrame() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		assertEquals("Frame OK!", msg);
		alert.accept();

		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);

	}

	@Test
	public void DevoInteragirComJanelas() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("uhuuu");
		driver.close();
		driver.switchTo().window("");

	}

	@Test
	public void DevoInteragirComJanelasSemTitulo() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("buttonPopUpHard")).click();
		//System.out.println(driver.getWindowHandle());
		//System.out.println(driver.getWindowHandles());
		//driver.switchTo().window("9B7ACA1A7C5CE43D6C688FE10051BCDB");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("aaaa");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("dsds");
		
		driver.quit();
	
	}
}
