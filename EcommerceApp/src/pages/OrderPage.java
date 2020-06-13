package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.WebActionUtil;

public class OrderPage extends BasePage
{
	
	@FindBy(className="icon-plus")
	private WebElement plusButton;
	
	@FindBy(xpath="//tbody/tr")
	private List<WebElement> productList;
	
	public OrderPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}
	
	public boolean verifyProductIsDiplayed(String productId)
	{
		for(WebElement product:productList)
		{
			boolean res = product.findElement(By.tagName("a")).getAttribute("href").contains(productId);
			if(res)
			{
				return true;
			}
		}
		return false;
	}
}
