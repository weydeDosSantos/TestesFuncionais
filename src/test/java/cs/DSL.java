package cs;

import static core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

	public void escrever(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}

	public void obterValorDoCampo(String id_campo) {
		getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}

	public void clicarRadio(String id) {
		getDriver().findElement(By.id(id)).click();

	}

	public boolean isRadioMarcado(String id) {
		return getDriver().findElement(By.id(id)).isSelected();

	}

	public void selecionarCombo(String id, String valor) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public String obterValorCombo(String id) {
		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}

	public void clicarBotao(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void clicarLink(String Link) {
		getDriver().findElement(By.linkText(Link));
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();

	}

	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}

}
