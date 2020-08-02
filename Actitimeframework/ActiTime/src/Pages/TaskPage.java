package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericLibrary.WebActionUtil;

public class TaskPage extends BasePage
{
	@FindBy(id="container_tt")
	private WebElement timeTrack;
	
	@FindBy(className="addTasksButton")
	private  WebElement AddTasksfromtheList;
	
	@FindBy(xpath="//*[@id=\"taskSelectControl\"]/div[2]/div[2]/div[1]")
	private WebElement selectCustomerAndProject;
	
	@FindBy(xpath="//*[@id=\"taskSelectControl\"]/div[2]/div[4]/div[4]/table/tbody/tr/td[2]/span[2]/span/span")
	private WebElement selectTasks;
	
	
	@FindBy(className="addSelectedButton")
	private WebElement AddSelected;
	
	
	
	public TaskPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}


	public void clickOnTimeTrack(String text)
	{
		webActionUtil.clickOnElement(timeTrack);
	}
	
	public void clickOnselectCustomerAndProject(String dropdown)
	{
		webActionUtil.clickOnElement(selectCustomerAndProject,dropdown);
	}
	
	public void clickOnselectTasks(String dropdown)
	{
		webActionUtil.selectDropDownText(selectTasks, dropdown);
	}
	
	public void clickOnAddSelected()
	{
		webActionUtil.clickOnElement(AddSelected);
	}
}
