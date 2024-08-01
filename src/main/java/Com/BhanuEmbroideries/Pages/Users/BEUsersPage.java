package Com.BhanuEmbroideries.Pages.Users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BEUsersPage {
	// Step1: Variable declaration
	@FindBy(xpath = "//button[@aria-label='Add user']")
	private WebElement addUserBtn;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement pWDInp;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	Actions act;

	// Step2: Variable initialization
	public BEUsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this); // diffClassName.methodName(webdriverObject, this->Keyword);
		this.act = new Actions(driver);
	}

	// Step3: Variable usage
	

	public void inpBEUsersPagePassword(String password) {
		pWDInp.sendKeys(password);
	}

	public void clickBEUsersPageAddUsersBtn() {
		addUserBtn.click();
	}
}
