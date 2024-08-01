package Com.BhanuEmbroideries.Pages.SideMenuBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BESideMenubar {
	// Step1: Variable declaration
	@FindBy(xpath = "//span[text()='Dashboard']")
	private WebElement dashboardBtn;
	@FindBy(xpath = "//span[text()='Users']")
	private WebElement usersBtn;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement pWDInp;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	Actions act;

	// Step2: Variable initialization
	public BESideMenubar(WebDriver driver) {
		PageFactory.initElements(driver, this); // diffClassName.methodName(webdriverObject, this->Keyword);
		this.act = new Actions(driver);
	}

	// Step3: Variable usage
	public void clickBESideMenubarDashboardBtn() {
		dashboardBtn.click();
	}
	
	public void clickBESideMenubarUsersBtn() {
		usersBtn.click();
	}

	public void inpBELoginPagePassword(String password) {
		pWDInp.sendKeys(password);
	}

	public void clickBELoginPageLoginBtn() {
		submitBtn.click();
	}
}
