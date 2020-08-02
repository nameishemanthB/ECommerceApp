package TestCases;

import org.testng.annotations.Test;
import Pages.TaskPage;

public class TC002 extends BaseTest
{
	@Test
	public void Task()
	{
		TaskPage taskPage = new TaskPage(driver, webActionUtil);
		
		taskPage.clickOnselectCustomerAndProject("Big Bang Company/Flight Operations");
		taskPage.clickOnselectTasks("Flight Analysis");
		
	}
}
