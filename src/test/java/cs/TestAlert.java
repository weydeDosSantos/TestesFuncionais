package cs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAlert {

	@Test
	public void devoInteragirComAlertSimples() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		assertEquals("Alert Simples", texto);
		alert.accept();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);

		driver.quit();
	}

	@Test
	public void AlertConfirmAcept() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Confirm Simples", alert.getText());
		driver.quit();
	}

	@Test
	public void AlertAcept() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		assertEquals("Confirmado", alert.getText());
		alert.accept();
		driver.quit();
	}

	@Test
	public void AlertDismiss() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		assertEquals("Negado", alert.getText());
		alert.accept();
		driver.quit();
	}

	@Test
	public void AlertPrompt() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Digite um numero",alert.getText());
		alert.sendKeys("12");
		alert.accept();
		assertEquals("Era 12?",alert.getText());
		alert.accept();
		assertEquals(":D",alert.getText());
		alert.accept();
		
		driver.quit();
	
	
	}
}