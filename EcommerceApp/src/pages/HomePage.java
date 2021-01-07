package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.WebActionUtil;
public class HomePage extends BasePage
{
	private String xpathForMoreButton="//a[contains(@href,'product=id')]//span[text()='More']";
	
	@FindBy(className="logout")
	private WebElement logoutButton;
	
	@FindBy(linkText="Women")
	private WebElement womenLink;
	
	@FindBy(xpath="(//a[text()='Dresses'])[2]")
	private WebElement dressesLink;
	
	@FindBy(xpath="(//a[text()='T-shirts'])[2]")
	private WebElement tShirtsLink;
	
	@FindBy(id="selectProductSort")
	private WebElement sortDropDown;
	
	@FindBy(linkText="Grid")
	private WebElement gridView;
	
	@FindBy(linkText="List")
	private WebElement listView;
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li")
	private List<WebElement> productsList;
	
	
	
	public HomePage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}
	
	public void clickOnLogout()
	{
		webActionUtil.clickOnElement(logoutButton);
	}
	
	public void clickOnWomensLink()
	{
		webActionUtil.clickOnElement(womenLink);
	}
	
	public void clickOnDressesLink()
	{
		webActionUtil.clickOnElement(dressesLink);
	}
	
	public void clickOnTShirtsLink()
	{
		webActionUtil.clickOnElement(tShirtsLink);
	}
	
	public void selectSortOption(String text)
	{
		webActionUtil.selectDropDownText(sortDropDown, text);
	}
	
	public void clickOnGridView()
	{
		webActionUtil.clickOnElement(gridView);
	}
	
	public void clickOnListView()
	{
		webActionUtil.clickOnElement(listView);
	}
	
	public void selectProduct(String productId)
	{
		for(WebElement product:productsList)
		{
			WebElement target = product.findElement(By.tagName("a"));
			if(target.getAttribute("href").contains(productId))
			{
				webActionUtil.mouseHover(target);
				break;
			}
		}
	}
	
	public ProductPage clickMoreButton(String productId)
	{
		xpathForMoreButton = xpathForMoreButton.replace("id", productId);		
		WebElement moreButton =driver.findElement(By.xpath(xpathForMoreButton));
		webActionUtil.clickOnElement(moreButton);
		return new ProductPage(driver, webActionUtil);
	}
	
	public void scrollingToEnd()
	{
		webActionUtil.scrollToEnd();
	}
	public void scrollingToTop()
	{
		webActionUtil.scrollToTop();
	}
	public void scrollToTarget(WebElement target)
	{
		webActionUtil.scrollToElement(target);
	}
	
}
