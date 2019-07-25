package actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import pageObjects.formObjects;

public class actionsForm {

	public void preencherEnviarFormulario(WebDriver driver, String nome, String data, String mensagem) throws InterruptedException {
		formObjects objForm = new formObjects(driver);
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'lfr-ddm-form-page-description')]")));
		
		if (objForm.lblDescricaoForm().getAttribute("innerHTML").toString().equalsIgnoreCase("Let's party rock.")) {
		
		objForm.inputNome().sendKeys(nome);
		objForm.inputData().click();
		objForm.inputData().sendKeys(data);
		objForm.inputMensagem().sendKeys(mensagem);
		Thread.sleep(1000);
		objForm.butSubmit().click();
		}else {
			Assert.fail("Erro! o texto 'Let's party rock.' não está presente no formulário.");	
		}
	
	}

	public void validaCampoObrigatorio(WebDriver driver) throws InterruptedException {

		List<WebElement> erros = driver.findElements(By.xpath("//*[contains(@class,'form-feedback-item help-block')]"));
		int totalErros = erros.size();

		if (totalErros > 0) {
			for (int i = 0; i < totalErros; i++) {

				System.out.println("Erro encontrado > " + erros.get(i).getAttribute("innerText").toString());
				Assert.fail("Erro de preenchimento de formulário. Campo obrigatório não preenchido.");
			}

		}

	}

}
