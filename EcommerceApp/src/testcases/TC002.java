package testcases;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import library.ExcelLibrary;
import pages.HomePage;
import pages.OrderPage;
import pages.ProductPage;
public class TC002 extends BaseTest 
{
	@DataProvider
	public Object[][] getData()
	{
		return ExcelLibrary.getExcelData(XL_PATH, "TC001");
	}
	
	
	@Test(dataProvider="getData")
	public void addProductToCart(String productId, String size, String color)
	{
		productId=productId.substring(0, 1);
		HomePage home = new HomePage(driver, webActionUtil);
		home.clickOnDressesLink();
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
