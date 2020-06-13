package testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import library.GetPhoto;
import library.IAutoConstants;
import library.WebActionUtil;
import pages.HomePage;
import pages.LoginPage;
public class BaseTest implements IAutoConstants
{ 
	public WebDriver driver;
	public WebActionUtil webActionUtil;
	
	@Parameters({"browserName", "appUrl", "ITO", "ETO"})
	@BeforeClass
	public void launchApp(@Optional(BROWSER_NAME)String browserName,
						  @Optional(APP_URL)String appUrl,
						  @Optional(ITO)String ITO,
						  @Optional(ETO)String ETO)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
		}
		else
		{
			throw new IllegalArgumentException(browserName+" Not Supported");
		}
		
		driver.manage().window().maximize();
		long implicit = Long.parseLong(ITO);
		driver.manage().timeouts().implicitlyWait(implicit, TimeUnit.SECONDS);
		driver.get(APP_URL);
		long explicit = Long.parseLong(ETO);
		webActionUtil = new WebActionUtil(driver, explicit);		
	}
	
	@Parameters({"un","pwd"})
	@BeforeMethod
	public void loginToApp(@Optional(USERNAME)String un, @Optional(PASSWORD)String pwd)
	{
		LoginPage l = new LoginPage(driver, webActionUtil);
		l.login(un, pwd);
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult result)
	{
		if(result.getStatus()==2)
		{
			GetPhoto.getPhoto(driver, result.getName());
		}
		HomePage home = new HomePage(driver, webActionUtil);
		home.clickOnLogout();
	}
	
	
	@AfterClass(alwaysRun=true)
	public void closeApp()
	{
		driver.quit();
	}
	
}
