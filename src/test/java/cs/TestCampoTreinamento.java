package cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCampoTreinamento {

	@Test
	public void test() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		assertEquals("Campo de Treinamento", driver.getTitle());
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}

	@Test
	public void devoInteragirComTextoArea() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}

	@Test
	public void devoInteragirComRadioButton() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		driver.quit();
	}

	@Test
	public void devoInteragirComCheckBox() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
	}
	@Test
	public void devoInteragirComCombo() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		//combo.selectByIndex(2);
		//combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau incompleto");
		assertEquals("2o grau incompleto", 	combo.getFirstSelectedOption().getText());
		//driver.quit();
	}
	@Test
	public void devoValidarComboMultiplo() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo  = new Select(element);
		combo.selectByVisibleText("Futebol");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		
		List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
		assertEquals(3,allSelectOptions.size());
		
	
		combo.deselectByVisibleText("Corrida");
		allSelectOptions = combo.getAllSelectedOptions();
		assertEquals(2,allSelectOptions.size());
		driver.quit();
	}
}