package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import bsh.util.Util;

public class formObjects {

	public WebDriver driver;

	@FindBy(xpath = "//*[@class='lfr-ddm-form-page-description']")
	WebElement lblDescricaoForm;

	@FindBy(xpath = "//*[contains(@class,'field form-control') and contains(@id,'QualÉSeuNome')]")
	WebElement inputNome;

	@FindBy(xpath = "//*[contains(@class,'field form-control') and contains(@id,'PorqueVocêIngressouNaÁreaDeTeste')]")
	WebElement inputMensagem;

	@FindBy(xpath = "//div[@class='input-group input-group-container']//*[contains(@class,'form-control') and contains(@type,'text')]")
	WebElement inputData;

	@FindBy(xpath = "//*[contains(@class,'btn btn-primary lfr-ddm-form-submit pull-right') and contains(@type,'submit')]")
	WebElement butSubmit;

	@FindBy(xpath = "//*[contains(@class,'form-feedback-item help-block')]")
	WebElement lblErro;

	public formObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public WebElement lblDescricaoForm() {
		return (lblDescricaoForm);
	}

	public WebElement inputNome() {
		return (inputNome);
	}

	public WebElement inputMensagem() {
		return (inputMensagem);
	}

	public WebElement inputData() {
		return (inputData);
	}

	public WebElement butSubmit() {
		return (butSubmit);
	}

	public WebElement lblErro() {
		return (lblErro);
	}
}
