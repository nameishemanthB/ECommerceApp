package library;
import org.openqa.selenium.JavascriptExecutor;
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
	public Actions action ;
	public JavascriptExecutor js;
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
		action= new Actions(driver);
		action.moveToElement(target).perform();
	}
	
	/*
	 * Method should scroll to Top
	 * 
	 */
	public void scrollToTop() {
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(document.body.scrollHeight,0)");
	}
	
	/*
	 * Method should scroll to End of the Page
	 * 
	 */
	public void scrollToEnd() {
		js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	/*
	 * Method should scroll to Element
	 * 
	 */
	public void scrollToElement(WebElement target) {
		 js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",target);
	}	
}
