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

public class sentResultObjects {

	public WebDriver driver;

	@FindBy(xpath = "//*[contains(@class,'ddm-form-description')]")
	WebElement lblMsgConfirmacao;

	@FindBy(xpath = "//*[contains(@class,'ddm-form-name')]")
	WebElement lblFormName;

	public sentResultObjects(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public WebElement lblMsgConfirmacao() {
		return (lblMsgConfirmacao);
	}

	public WebElement lblFormName() {
		return (lblFormName);
	}

}
