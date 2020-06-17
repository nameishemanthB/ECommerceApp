package testcases;

import org.testng.annotations.Test;

import pages.HomePage;

public class TCscrollingoperation extends BaseTest 
{
	@Test
	public void scrolling()
	{
		HomePage h=new HomePage(driver, webActionUtil);
		h.scrollingToEnd();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.scrollingToTop();
	}
	

}
