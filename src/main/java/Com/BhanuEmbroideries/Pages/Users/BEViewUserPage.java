package Com.BhanuEmbroideries.Pages.Users;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Actions.AllAction;
import Com.BhanuEmbroideries.LibraryFiles.UtilityClass;

public class BEViewUserPage {
	// Step1: Variable declaration
	@FindBy(xpath = "//button[@aria-label='Add user']")
	private WebElement addUserBtn;
	@FindBy(xpath = "//input[@name='name']")
	private WebElement nameInp;
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
	public BEViewUserPage(WebDriver driver) {
		PageFactory.initElements(driver, this); // diffClassName.methodName(webdriverObject, this->Keyword);
		this.act = new Actions(driver);
	}

	// Step3: Variable usage
	
	public void inpBECreateAdminUsersPageName(String name) {
		nameInp.sendKeys(name);
	}
	public void selBECreateAdminUsersPageRole(WebDriver driver ,String role) throws IOException {
		roleSel.click();
		WebElement wb = driver.findElement(By.xpath("//div[text()='"+role+"']"));
		wb.click();
	}
	public void inpBECreateAdminUsersPageEmail(String email) {
		emailInp.sendKeys(email);
	}
	public void inpBECreateAdminUsersPagePassword(String password) {
		pWDInp.sendKeys(password);
	}
	public void inpBECreateAdminUsersPageMobile(String mob) {
		mobInp.sendKeys(mob);
	}

	public void clickBEUsersPageAddUsersBtn() {
		addUserBtn.click();
	}
	public void clickBEUsersPageCancelBtn() {
		cancelBtn.click();
	}
	public void clickBEUsersPageSubmitBtn() {
		submitBtn.click();
	}
	
}
