package cs;

import static core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

import core.DriverFactory;

public class CamposObrigatorios {

	private CamposObrigatoriosPage page;
	private DSL dsl;

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CamposObrigatoriosPage();
		dsl = new DSL();
	}

	@After
	public void quitar() {
		DriverFactory.killDriver();
	}

	@Test
	public void devoRealizarcadastro() {
		page.setNome("Wagner");
		page.setSobreNome("Costa");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setEscolaridade("Mestrado");
		page.setEsportes("Futebol");
		page.cadastrar();
		
		assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		assertTrue(page.obterNomeCadastro().endsWith("Wagner"));
		assertEquals("Sobrenome: Costa",page.obterSobreNomeCadastro());
		assertEquals("Sexo: Masculino",page.obterSexoCadastro());
		assertEquals("Comida: Carne",page.obterComidaCadastro());page.obterEscolaridadeCadastro();
		assertEquals("Esportes: Futebol",page.obterEsporteCadastro());
	}

	@Test
	public void nomeObrigatorio() {

		page.cadastrar(); 
		Alert alert =getDriver().switchTo().alert();
		assertEquals("Nome eh obrigatorio",alert.getText());
	

	}

	@Test
	public void Sobrenome() {

		page.setNome("Cicrano");
		page.cadastrar();
		Alert alert =getDriver().switchTo().alert();
		assertEquals("Sobrenome eh obrigatorio", alert.getText());

	}

	@Test
	public void CampoSexo() {

		page.setNome("Cicrano");
		page.setSobreNome("pitagoras");
		page.cadastrar();
		Alert alert =getDriver().switchTo().alert();
		assertEquals("Sexo eh obrigatorio", alert.getText());
	}

	@Test
	public void CampoComida() {

		page.setNome("Cicrano");
		page.setSobreNome("pitagoras");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setComidaVegetariano();
		page.cadastrar();
		Alert alert =getDriver().switchTo().alert();
		assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());

	}

	@Test
	public void EsportistaIndeciso() {

		page.setNome("Cicrano");
		page.setSobreNome("pitagoras");
		page.setSexoMasculino();
		page.setComidaCarne();
		page.setEsportes("Karate","O que eh esporte?");

		dsl.clicarBotao("elementosForm:cadastrar");
		Alert alert = getDriver().switchTo().alert();
		assertEquals("Voce faz esporte ou nao?", alert.getText());
	}

}