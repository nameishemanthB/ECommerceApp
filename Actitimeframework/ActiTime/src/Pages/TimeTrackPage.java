package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericLibrary.WebActionUtil;

public class TimeTrackPage extends BasePage
{
	@FindBy(id="container_tt")
	private WebElement timeTrack;
	
	@FindBy(id="addTaskButtonId")
	private WebElement newButton;
	
	@FindBy(xpath="//tr[@class='selectCustomerRow']//div[@class='comboboxButton']//div[@class='dropdownButton']")
	private WebElement selectCustomerAndProjectToAddTasksDropDown;
	
	@FindBy(xpath="////*[@id=\"abId0.42280349585817656\"]/tr[1]/td[1]/div/div/div[1]/div[1]]")
	private WebElement enterCustomerName;
	
	@FindBy(xpath="////*[@id=\"abId0.42280349585817656\"]/tr[3]/td[1]/div/div/div[1]/div[1]")
	private WebElement enterProjectName;
	
	@FindBy(xpath="//input[@placeholder='Enter task name']")
	private WebElement enterTaskName;
	
	@FindBy(xpath="//input[@placeholder='not needed']")
	private WebElement estimateHours;
	
	@FindBy(id="ext-gen72")
	private WebElement setDeadlineDate;
	
	@FindBy(className="x-date-right")
	private WebElement calenderBoxRightArrowButton;
	
	@FindBy(className="components_button withPlusIcon")
	private WebElement createTasks;
	
	
   public TimeTrackPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}


	public void clickOnTimeTrack()
	{
		webActionUtil.clickOnElement(timeTrack);
	}
	
	public void clickOnNewButton()
	{
		webActionUtil.clickOnElement(newButton);
	}
	
	public void clickOnSelectCustomerAndProjectToAddTasksDropDown(String text)
	{
		webActionUtil.selectDropDownText(selectCustomerAndProjectToAddTasksDropDown, text);
	}
	
	public void clickOnEnterCustomerName(String customerName)
	{
		webActionUtil.enterKeys(enterCustomerName, customerName);
	}
	
	public void clickOnEnterProjectName(String projectName)
	{
		webActionUtil.enterKeys(enterProjectName, projectName);
	}
	
	public void clickOnEnterTaskName(String taskName)
	{
		webActionUtil.enterKeys(enterTaskName, taskName);
	}
	
	public void clickOnEstimateHours(String hours)
	{
		webActionUtil.enterKeys(estimateHours, hours);
	}
	
	public void clickOnSetDeadlineDate()
	{
		webActionUtil.clickOnElement(setDeadlineDate);
	}
	
	public void clickOnCalenderBoxRightArrowButton(String month, String day)
	{
		webActionUtil.clickOnElement(calenderBoxRightArrowButton);
		calenderBoxRightArrowButton.click();
		WebElement months = driver.findElement(By.xpath("//button[.='" + month + "']"));
		months.findElement(By.xpath("//span[.='" + day + "']"));
	}
	
	public void clickOnCreateTasks()
	{
		webActionUtil.clickOnElement(createTasks);
	}
}
