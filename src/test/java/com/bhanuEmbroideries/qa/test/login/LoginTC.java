package com.bhanuEmbroideries.qa.test.login;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
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
import Com.BhanuEmbroideries.Pages.Users.BEUserManagementPage;
import DataProviders.DataSupplier;
import net.bytebuddy.utility.RandomString;

public class LoginTC extends BaseClass {
	BELoginPage login;
	BESideMenubar sm;
	BEUserManagementPage um;
	BECreateAdminUserPage cau;
	String TCID;
	SoftAssert soft;
	Logger log = LogManager.getLogger(LoginTC.class);
	ExtentReports extent;
	public String sheetName;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		sheetName = "Unit";
		DataSupplier.setSheetName(sheetName, 1, 1);

		initializeBrowser();
		login = new BELoginPage(driver);
		sm = new BESideMenubar(driver);
		um = new BEUserManagementPage(driver);
		cau = new BECreateAdminUserPage(driver);
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
	}

	@BeforeMethod
	public void loginToApp() throws InterruptedException, IOException {
		// for reset soft object for each itertion of @Test
		soft = new SoftAssert();
		sm.clickBESideMenubarUsersBtn();

	}

	@Test(enabled = true, priority = 1, groups = "Unit", dataProvider = "dataContainer", dataProviderClass = DataSupplier.class)
	public void loginTest(String Scenario, String error, String eMail, String password, String toastMsg)
			throws IOException, InterruptedException {

		extent.createTest("SubmitEnquiryForm").log(Status.PASS,
				"This is a logging event for MyFirstTest, and it passed!");

		TCID = RandomString.make(2); // ab cd a1 a5 s4
		// AddProject page method call
		log.info("Filling Form");
		// Login page method call
		log.info("Signing In..");
		login.inpBELoginPageEmail(UtilityClass.getPFData("UN"));
		login.inpBELoginPagePassword(UtilityClass.getPFData("PWD"));
		Thread.sleep(200);
		login.clickBELoginPageLoginBtn();
		log.info("Login succcess");
		Thread.sleep(200);
		getToastMsg(Scenario);

		soft.assertAll();
	}

	@AfterMethod
	public void logoutFromApp(ITestResult s1, Method m) throws IOException, InterruptedException {
		// Get the current date and time
		LocalDateTime date = LocalDateTime.now();

		// Define the format pattern
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HHmmss");

		// Format the date
		String formattedDate = date.format(formatter);

		// Output the formatted date
		System.out.println("Formatted Date: " + formattedDate);

		if (s1.getStatus() == ITestResult.FAILURE) {
			Thread.sleep(5000);
			UtilityClass.captureSS(driver, TCID + m.getName() + formattedDate); // code to capture SS
		}

	}

	@AfterClass
	public void closeBrowser() {
		// driver.close();
	}

	public void getToastMsg(String scen) {
		switch (scen) {
		case "BothTrue":
			scen = "SignIn Success";
			break;
		case "Both False":
		case "False Email":
			scen = "Email is not Registered";
			break;
		case "False Pwd":
			scen = "Invalid Password";
			break;
		default:
			break;
		}
	}
}
