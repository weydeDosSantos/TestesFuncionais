package cs;

public class CamposObrigatoriosPage {

	private DSL dsl;

	public CamposObrigatoriosPage() {
		dsl = new DSL();
	}

	public void setNome(String Nome) {
		dsl.escrever("elementosForm:nome", Nome);

	}

	public void setSobreNome(String sobrenome) {
		dsl.escrever("elementosForm:sobrenome", sobrenome);
	}

	public void setSexoMasculino() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}

	public void setComidaCarne() {
		dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}

	public void setComidaVegetariano() {
		dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}

	public void setEscolaridade(String valor) {
		dsl.selecionarCombo("elementosForm:escolaridade", valor);
	}

	public void setEsportes(String... valores) {
		for (String valor : valores) {
			dsl.selecionarCombo("elementosForm:esportes", valor);
		}

	}

	public void cadastrar() {
		dsl.clicarBotao("elementosForm:cadastrar");
	}

	public String obterResultadoCadastro() {
		return dsl.obterTexto("resultado");
	}

	public String obterNomeCadastro() {
		return dsl.obterTexto("descNome");
	}

	public String obterSobreNomeCadastro() {
		return dsl.obterTexto("descSobrenome");
	}

	public String obterSexoCadastro() {
		return dsl.obterTexto("descSexo");
	}

	public String obterComidaCadastro() {
		return dsl.obterTexto("descComida");
	}

	public String obterEscolaridadeCadastro() {
		return dsl.obterTexto("descEscolaridade");
	}

	public String obterEsporteCadastro() {
		return dsl.obterTexto("descEsportes");
	}

}