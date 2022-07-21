package cs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCampoTreinamento {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@After
	public void quitar() {
		driver.quit();
	}

	@Test
	public void test() {
		assertEquals("Campo de Treinamento", driver.getTitle());
	//	driver.manage().window().setSize(new Dimension(1200, 765));
		dsl.escrever("elementosForm:nome", "Teste de escrita");
		assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}

	@Test
	public void devoInteragirComTextoArea() {
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste");
		assertEquals("teste", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}

	@Test
	public void devoInteragirComRadioButton() {
		dsl.clicarRadio("elementosForm:sexo:0");
		assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
		driver.quit();
	}

	@Test
	public void devoInteragirComCheckBox() {
		dsl.clicarRadio("elementosForm:comidaFavorita:2");
		assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
		driver.quit();
	}

	@Test
	public void devoInteragirComCombo() {
		// WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		// Select combo = new Select(element);
		// combo.selectByIndex(2);
		// combo.selectByValue("superior");
		// combo.selectByVisibleText("2o grau incompleto");
		dsl.selecionarCombo("elementosForm:escolaridade", "2o grau incompleto");
		assertEquals("2o grau incompleto", dsl.obterValorCombo("elementosForm:escolaridade"));
		// driver.quit();
	}

	@Test
	public void devoValidarComboMultiplo() {
		dsl.selecionarCombo("elementosForm:esportes", "Futebol");
		dsl.selecionarCombo("elementosForm:esportes", "Corrida");
		dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");

		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);

		List<WebElement> allSelectOptions = combo.getAllSelectedOptions();
		assertEquals(3, allSelectOptions.size());

		combo.deselectByVisibleText("Corrida");
		allSelectOptions = combo.getAllSelectedOptions();
		assertEquals(2, allSelectOptions.size());
		driver.quit();
	}

	@Test
	public void devoInteragirComBotoes() {
		dsl.clicarBotao("buttonSimple");
		
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();
	}

	@Test
	public void devoInteragirComLink() {
		dsl.clicarLink("Voltar");
		assertEquals("Voltar", driver.findElement(By.linkText("Voltar")).getText());
		driver.quit();

	}

	@Test
	public void devoBuscarTextoNaPagina() {
		// assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo
		// de Treinamento"));
		assertEquals("Campo de Treinamento",dsl.obterTexto(By.tagName("h3")));

		driver.quit();

	}
}