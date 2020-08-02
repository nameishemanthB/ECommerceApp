package TestCases;

import org.testng.annotations.Test;
import Pages.TimeTrackPage;

public class TC001 extends BaseTest
{
	@Test
	public void enterTimeTrack()
	{
		TimeTrackPage timeTrackPage = new TimeTrackPage(driver, webActionUtil);
		
		timeTrackPage.clickOnSelectCustomerAndProjectToAddTasksDropDown("- New Customer -");
		timeTrackPage.clickOnEnterCustomerName("Big Bang Company");
		timeTrackPage.clickOnEnterProjectName("Flight Operations");
		timeTrackPage.clickOnEnterTaskName("Automate 100 Test Cases");
		timeTrackPage.clickOnEstimateHours("5");
		timeTrackPage.clickOnCalenderBoxRightArrowButton("August 2020", "10");
	
	}
}
