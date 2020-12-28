package testcases;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import library.ExcelLibrary;
import library.Generic;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;
public class TC003 extends BaseTest 
{
	@DataProvider(name="testdata")
	public Object[][] getData()
	{
		return ExcelLibrary.getExcelData(XL_PATH, "TC001");
	}
	
	
	@Test(dataProvider="testdata")
	public void addProductToCartFromExcel(String productId, String size, String color)
	{
		int a = 100;
		productId=Generic.removeDecimal(productId);
		HomePage home = new HomePage(driver, webActionUtil);
		home.clickOnDressesLink();;;;
		home.selectProduct(productId);
		ProductPage productPage = home.clickMoreButton(productId);
		productPage.clickPlusButton(3);
		productPage.clickMinusButton(1);
		productPage.selectSize(size);
		productPage.selectColor(color);
		productPage.clickOnAddToCart();
		OrderPage orderPage = productPage.clickOnProceedToCheckOut();;
		Assert.assertTrue(orderPage.verifyProductIsDiplayed(productId));
	}
}
