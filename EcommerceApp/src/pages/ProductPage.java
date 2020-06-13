package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import library.WebActionUtil;

public class ProductPage extends BasePage 
{
	
	@FindBy(className="icon-plus")
	private WebElement plusButton;
	
	@FindBy(className="icon-minus")
	private WebElement minusButton;
		
	@FindBy(id="group_1")
	private WebElement sizeDropDown;
	
	@FindBy(name="Beige")
	private WebElement beigeColorButton;
	
	@FindBy(name="Orange")
	private WebElement orangeColorButton;
	
	@FindBy(name="White")
	private WebElement whiteColorButton;
	
	@FindBy(name="Green")
	private WebElement greenColorButton;
	
	@FindBy(name="Blue")
	private WebElement blueColorButton;
	
	@FindBy(name="Pink")
	private WebElement pinkColorButton;
	
	@FindBy(name="Submit")
	private WebElement addToCartButton;
	
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutButton;
	
	@FindBy(xpath="//span[contains(.,'Continue shopping')]")
	private WebElement continueShoppingButton;
	
	@FindBy(className="cross")
	private WebElement closePopUp;
	
	public ProductPage(WebDriver driver, WebActionUtil webActionUtil)
	{
		super(driver, webActionUtil);
	}
	
	public void clickPlusButton(int count)
	{
		for(int i=1;i<=count;i++)
		{
			webActionUtil.clickOnElement(plusButton);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void clickMinusButton(int count)
	{
		for(int i=1;i<=count;i++)
		{
			webActionUtil.clickOnElement(minusButton);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void selectSize(String sizeText)
	{
		webActionUtil.selectDropDownText(sizeDropDown, sizeText);
	}
	
	public void selectColor(String color)
	{
		color = color.toLowerCase();
		switch(color)
		{
			case "beige":webActionUtil.clickOnElement(beigeColorButton);
						 break;
			case "pink":webActionUtil.clickOnElement(pinkColorButton);
						 break;
			case "orange":webActionUtil.clickOnElement(orangeColorButton);
						 break;
			case "white":webActionUtil.clickOnElement(whiteColorButton);
						 break;
			case "green":webActionUtil.clickOnElement(greenColorButton);
			 			 break;
			case "blue":webActionUtil.clickOnElement(blueColorButton);
			 			break;
			default:Reporter.log("Sorry, Color not preset", true);
		}
	}
	
	
	public OrderPage clickOnProceedToCheckOut()
	{
		webActionUtil.clickOnElement(proceedToCheckOutButton);
		return new OrderPage(driver, webActionUtil);
		
	}
	
	public void clickOnContinueToShopping()
	{
		webActionUtil.clickOnElement(continueShoppingButton);
		
	}
	
	public void closePopUp()
	{
		webActionUtil.clickOnElement(closePopUp);
		
	}
	
	public void clickOnAddToCart()
	{
		webActionUtil.clickOnElement(addToCartButton);		
	}
	
}




