package Com.BhanuEmbroideries.Pages.Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BELoginPage {
	// Step1: Variable declaration
	@FindBy(xpath = "//input[@name='email']")
	private WebElement uNInp;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement pWDInp;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitBtn;
	Actions act;

	// Step2: Variable initialization
	public BELoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this); // diffClassName.methodName(webdriverObject, this->Keyword);
		this.act = new Actions(driver);
	}

	// Step3: Variable usage
	public void inpBELoginPageEmail(String username) {
		uNInp.sendKeys(username);
	}

	public void inpBELoginPagePassword(String password) {
		pWDInp.sendKeys(password);
	}

	public void clickBELoginPageLoginBtn() {
		submitBtn.click();
	}
}
