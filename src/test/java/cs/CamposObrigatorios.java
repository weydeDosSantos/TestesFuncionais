package cs;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CamposObrigatorios {

	private WebDriver driver;
	
	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void quitar() {
		driver.quit();
	}
	
	@Test
	public void nomeObrigatorio() {

		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Nome eh obrigatorio", alert.getText());

	}

	@Test
	public void Sobrenome() {

		driver.findElement(By.id("elementosForm:nome")).sendKeys("ananias");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Sobrenome eh obrigatorio", alert.getText());

	}

	@Test
	public void CampoSexo() {
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();

		driver.findElement(By.id("elementosForm:nome")).sendKeys("ananias");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("duarte");
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Sexo eh obrigatorio", alert.getText());
	}

	@Test
	public void CampoComida() {

		driver.findElement(By.id("elementosForm:nome")).sendKeys("ananias");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("duarte");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());

	}

	@Test
	public void EsportistaIndeciso() {

		driver.findElement(By.id("elementosForm:nome")).sendKeys("ananias");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("duarte");
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		Select combo = new Select(driver.findElement(By.id("elementosForm:esportes")));
		combo.selectByVisibleText("Karate");
		combo.selectByVisibleText("O que eh esporte?");
		
		driver.findElement(By.id("elementosForm:cadastrar")).click();
		Alert alert = driver.switchTo().alert();
		assertEquals("Voce faz esporte ou nao?", alert.getText());
		}

}