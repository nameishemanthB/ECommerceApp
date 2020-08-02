package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import GenericLibrary.WebActionUtil;


public class HomePage extends BasePage
{
	@FindBy(id="logoutLink")
	private WebElement logoutButton;
	
	
	public HomePage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}
	
	public void clickLogout()
	{
		webActionUtil.clickOnElement(logoutButton);
	}
	
	
}






