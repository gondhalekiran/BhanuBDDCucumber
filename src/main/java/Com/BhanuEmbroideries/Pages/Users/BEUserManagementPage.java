package Com.BhanuEmbroideries.Pages.Users;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Actions.AllAction;
import Com.BhanuEmbroideries.LibraryFiles.UtilityClass;

public class BEUserManagementPage {
	// Step1: Variable declaration
	@FindBy(xpath = "//button[@aria-label='Add user']")
	private WebElement addUserBtn;
	@FindBy(xpath = "//input[@aria-label='Search user']")
	private WebElement searchInpBtn;
	@FindBy(xpath = "//td[2]")
	private List <WebElement> nameColLst;
	@FindBy(xpath = "(//tr[1])[2]")
	private List <WebElement> rowEleLst;
	
	
	@FindBy(xpath = "//div[@role='button']")
	private WebElement roleSel;
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailInp;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement pWDInp;
	@FindBy(xpath = "//input[@name='contact_number']")
	private WebElement mobInp;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement cancelBtn;
	Actions act;

	// Step2: Variable initialization
	public BEUserManagementPage(WebDriver driver) {
		PageFactory.initElements(driver, this); // diffClassName.methodName(webdriverObject, this->Keyword);
		this.act = new Actions(driver);
	}

	// Step3: Variable usage
	
	public void inpBEUserManagementPageSearch(String name) {
		searchInpBtn.sendKeys(name);
	}
	public void clickBEUserManagementPageViewUserBtn(WebDriver driver, String name) {
		driver.findElement(By.xpath("//td[text()='"+name+"']/parent::tr/td[6]/button[1]")).click();
	}
	public void clickBEUserManagementPageEditUserBtn(WebDriver driver, String name) {
		driver.findElement(By.xpath("//td[text()='"+name+"']/parent::tr/td[6]/button[2]")).click();
	}
	public void clickBEUserManagementPageDeleteUserBtn(WebDriver driver, String name) {
		driver.findElement(By.xpath("//td[text()='"+name+"']/parent::tr/td[6]/button[3]")).click();
	}
	
	
	public void clickBEUserManagementPageAddUsersBtn() {
		addUserBtn.click();
	}
	public void clickBEUsersPageCancelBtn() {
		cancelBtn.click();
	}
	public void clickBEUsersPageSubmitBtn() {
		submitBtn.click();
	}

	
	
}
