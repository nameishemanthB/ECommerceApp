package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import library.WebActionUtil;
public class LoginPage extends BasePage
{
	@FindBy(partialLinkText="Sign in")
	private WebElement signInButton;
	
	@FindBy(id="email")
	private WebElement emailTb;
	
	@FindBy(id="passwd")
	private WebElement passwordTb;
	
	@FindBy(id="SubmitLogin")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}
	
	public void login(String un, String pwd)
	{
		webActionUtil.clickOnElement(signInButton);
		webActionUtil.enterKeys(emailTb, un);
		webActionUtil.enterKeys(passwordTb, pwd);
		webActionUtil.clickOnElement(loginButton);
	}
}
