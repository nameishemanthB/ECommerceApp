package library;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebActionUtil
{
	public WebDriver driver;
	long ETO;
	public WebDriverWait wait;
	
	public WebActionUtil(WebDriver driver, long ETO)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, ETO);
		this.ETO=ETO;
	}
	
	public void clickOnElement(WebElement target)
	{
		WebDriverWait wait = new WebDriverWait(driver, ETO);
		wait.until(ExpectedConditions.elementToBeClickable(target));
		target.click();
	}
	
	public void enterKeys(WebElement target, String keysToSend)
	{
		wait.until(ExpectedConditions.visibilityOf(target));
		target.clear();
		target.sendKeys(keysToSend);
	}
	
	public void selectDropDownText(WebElement target, String text)
	{
		Select select = new Select(target);
		select.selectByVisibleText(text);
	}
	
	public void mouseHover(WebElement target)
	{
		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
	}
	
	/*
	 * Method should scroll to Top
	 * 
	 */
	public void scrollToTop() {
		
	}
	
	/*
	 * Method should scroll to End of the Page
	 * 
	 */
	public void scrollToEnd() {
		
	}
	
	/*
	 * Method should scroll to Element
	 * 
	 */
	public void scrollToElement() {
		
	}	
}
