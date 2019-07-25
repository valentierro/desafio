package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;
import pageObjects.formObjects;
import pageObjects.sentResultObjects;

public class actionsSentForm {

	public boolean validaEnvioForm(WebDriver driver, int timeout) throws InterruptedException {
		sentResultObjects objSentForm = new sentResultObjects(driver);
		boolean sucesso = false;
		try {
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.elementToBeClickable(objSentForm.lblFormName()));

			if (objSentForm.lblFormName().isDisplayed() && objSentForm.lblMsgConfirmacao().getAttribute("innerHTML")
					.toString().equalsIgnoreCase("Informações enviadas com sucesso!")) {
				sucesso = true;
			} else {

				Assert.fail("Erro no envio do formulário.");
			}

		} catch (NoSuchElementException ex) {
			System.out.println("Formulário não enviado!");

		} finally {
			driver.navigate().back();
		}
		return sucesso;
	}
}
