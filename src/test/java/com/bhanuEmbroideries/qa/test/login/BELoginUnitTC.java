package com.bhanuEmbroideries.qa.test.login;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Com.BhanuEmbroideries.LibraryFiles.BaseClass;
import Com.BhanuEmbroideries.LibraryFiles.UtilityClass;
import Com.BhanuEmbroideries.Pages.Login.BELoginPage;
import Com.BhanuEmbroideries.Pages.SideMenuBar.BESideMenubar;
import Com.BhanuEmbroideries.Pages.Users.BECreateAdminUserPage;
import Com.BhanuEmbroideries.Pages.Users.BEUsersPage;
import DataProviders.DataSupplier;
import net.bytebuddy.utility.RandomString;

public class BELoginUnitTC extends BaseClass {
	BELoginPage login;
	BESideMenubar sm;
	BEUsersPage um;
	BECreateAdminUserPage cau;
	String TCID;
	SoftAssert soft;
	Logger log = LogManager.getLogger(BELoginUnitTC.class);
	ExtentReports extent;
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		initializeBrowser();
		login = new BELoginPage(driver);
		sm = new BESideMenubar(driver);
		um = new BEUsersPage(driver);
		cau = new BECreateAdminUserPage(driver);
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		}

	@BeforeMethod
	public void loginToApp() throws InterruptedException, IOException {
		//for reset soft object for each itertion of @Test
				soft = new SoftAssert();
		// Login page method call
		log.info("Signing In..");
		login.inpBELoginPageEmail(UtilityClass.getPFData("UN"));
		login.inpBELoginPagePassword(UtilityClass.getPFData("PWD"));
		Thread.sleep(200);
		login.clickBELoginPageLoginBtn();
		log.info("Login succcess");
		Thread.sleep(200);
		sm.clickBESideMenubarUsersBtn();
		um.clickBEUsersPageAddUsersBtn();
		cau.inpBECreateAdminUsersPageName("name");
		cau.inpBECreateAdminUsersPagePassword("pwd");
	}

	@Test(/*enabled = true, priority = 1, dataProvider = "dataContainer", dataProviderClass = DataSupplier.class*/)
	public void SubmitEnquiryForm(/*String Scenario, String error, String custType, String size, String name, String mobNo,
			String add, String city, String bill, String toastMsg*/) throws IOException, InterruptedException {
		extent.createTest("SubmitEnquiryForm")
		  .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
	
		TCID = RandomString.make(2); // ab cd a1 a5 s4
		// AddProject page method call
		log.info("Filling Form");
	/*project.selSolarLadderAddProjectPageCustomerType(custType);
		Thread.sleep(200);
		project.inpSolarLadderAddProjectPageSize(size);
		Thread.sleep(200);
		project.inpSolarLadderAddProjectPageName(name);
		Thread.sleep(200);
		project.inpSolarLadderAddProjectPageMobNo(mobNo);
		Thread.sleep(200);
		project.inpSolarLadderAddProjectPageAddress(add);
		Thread.sleep(200);
		project.inpAndSelSolarLadderAddProjectPageCity(city);
		Thread.sleep(200);
		project.clickSolarLadderAddProjectPageAddOptBtn();
		Thread.sleep(200);
		project.inpSolarLadderAddProjectPageEleBill(bill);
		Thread.sleep(2000);
		project.clickSolarLadderAddProjectPageSubmitBtn();
		log.info("Form Submitted");
		Thread.sleep(5000);
		WebElement wb = home.getToastMsg();
		UtilityClass.drawBorder(driver, wb);
		String tm = wb.getText();
		Reporter.log(tm + "<==>" + toastMsg, true);
		soft.assertEquals(tm, toastMsg);*/
		soft.assertAll();
	}

	@AfterMethod
	public void logoutFromApp(ITestResult s1,Method m) throws IOException, InterruptedException {

		if (s1.getStatus() == ITestResult.FAILURE) {
			Thread.sleep(5000);
			//UtilityClass.drawBorder(driver, home.getCard()); // code to Draw border on card
			UtilityClass.captureSS(driver, m.getName()+TCID); // code to capture SS
		}
	}

	@AfterClass
	public void closeBrowser() {
		// driver.close();
	}
}
