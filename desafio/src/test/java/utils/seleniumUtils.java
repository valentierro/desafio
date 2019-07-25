package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumUtils {

	public static WebDriver startBrowser(WebDriver driver, String browser, String url) {
		constantes varConstantes = new constantes();

		if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", varConstantes.CHROME_DRIVER);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", varConstantes.FIREFOX_DRIVER);
			driver = new FirefoxDriver();
		}

		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

}
