package cucumber;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

import utils.constantes;
import utils.seleniumUtils;

import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import actions.actionsForm;
import actions.actionsSentForm;

@RunWith(Cucumber.class)
public class stepDefinition {
	public WebDriver driver;
		// instanciar actions
		actionsForm acoesForm = new actionsForm();
		actionsSentForm acoesSentForm = new actionsSentForm();
		seleniumUtils utilSelenium = new seleniumUtils();
		constantes varConstantes = new constantes();
	
		@Given("^usuario na pagina do formulario$")
		public void usuario_na_pagina_do_formulario() throws Throwable {
			driver = seleniumUtils.startBrowser(driver, "firefox", "http://forms.liferay.com/web/forms/shared/-/form/372406");
		}

		@When("^usuario preenche os campos e submete formulario$")
		public void usuario_preenche_os_campos_e_submete_formulario(DataTable tabela) throws Throwable {
		
			List<Map<String, String>> list = tabela.asMaps(String.class, String.class);
			String nome = null, data = null, mensagem = null;
			for(int i=0; i<list.size(); i++) {
				nome = list.get(i).get("Nome");
				data = list.get(i).get("Data");
				mensagem = list.get(i).get("Mensagem");
			
			
			acoesForm.preencherEnviarFormulario(driver, nome, data, mensagem);
			acoesForm.validaCampoObrigatorio(driver);
			acoesSentForm.validaEnvioForm(driver,30);
			}
		}

}