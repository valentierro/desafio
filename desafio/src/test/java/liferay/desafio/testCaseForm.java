package liferay.desafio;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.ITestClass;
import org.testng.ITestResult;
import org.testng.annotations.*;

import actions.actionsForm;
import actions.actionsSentForm;
import utils.constantes;
import utils.dataDriven;
import utils.seleniumUtils;

public class testCaseForm {
	public WebDriver driver;
	

	// instanciar actions
	actionsForm acoesForm = new actionsForm();
	actionsSentForm acoesSentForm = new actionsSentForm();
	seleniumUtils utilSelenium = new seleniumUtils();
	constantes varConstantes = new constantes();
	
	@BeforeSuite
	public void inicioSuite() throws SQLException {
		
		driver = seleniumUtils.startBrowser(driver, "firefox", "http://forms.liferay.com/web/forms/shared/-/form/372406");
		
	}

	@Test(dataProvider = "excelData")
	public void enviarForm(String nome, String data, String mensagem) throws InterruptedException  {
	
		acoesForm.preencherEnviarFormulario(driver, nome, data, mensagem);
		acoesForm.validaCampoObrigatorio(driver);
		acoesSentForm.validaEnvioForm(driver,30);

	}
	
	@AfterSuite
	public void finalizarSuite()  {
	   	    driver.close();
	 	
	}
	
	@DataProvider
	public String[][] excelData() throws InvalidFormatException, IOException{
	dataDriven data = new dataDriven();
	return data.getCellData(varConstantes.DATA_DRIVEN, "Sheet1");
	}

}
