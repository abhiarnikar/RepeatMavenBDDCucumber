package stepDefinations;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pageObjects.AddNewCustomers;
import pageObjects.AdminPage;
import utilities.ReadConfig;

public class StepDefinations extends Base {

	@Before
	public void setup() throws Exception {

		readConfig = new ReadConfig();
		System.out.println("Setup method Executed");
		driver = new ChromeDriver();
		// driver=new FirefoxDriver();
		String Browser = readConfig.getBrowser();
		Thread.sleep(2000);

		if (Browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		else if (Browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (Browser.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		}
	}

	@Given("User Lanch Chrome Browser")
	public void user_lanch_chrome_browser() throws Exception {
		// System.setProperty("webdriver.chrome.driver",
		// "E:\\JavaSelenuim\\chromedriver_win32\\chromedriver.exe");

		// driver=new ChromeDriver();

		ad = new AdminPage(driver);

	}

	@When("User open url {string}")
	public void user_open_url(String url) throws Exception {

		driver.get(url);
		Thread.sleep(2000);
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception {
		ad.setUsername(email);
		ad.setPassword(password);
		Thread.sleep(2000);
	}

	@When("User click on Login button")
	public void user_click_on_login_button() throws Exception {
		ad.clickOnLoginButton();
		Thread.sleep(2000);
	}

	@Then("User Verify Page Title should be {string}")
	public void user_verify_page_title_should_be(String title) throws Exception {

		assertEquals(title, driver.getTitle());
		Thread.sleep(2000);
	}

//	@Then("User Verify Page Title should be {string} or Error Msg {string}")
//	public void user_verify_page_title_should_be_or_error_msg(String title, String Error) throws Exception {
//		
//		
//		if(title.equalsIgnoreCase(driver.getTitle())) {
//			assertEquals(title, driver.getTitle());
//			Thread.sleep(2000);
//		}
//		
//		else if(Error.equalsIgnoreCase(ad.ErrorMsg())) {
//			assertEquals(Error, ad.ErrorMsg());
//		}
//
//	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}

	@After
	public void tearDown(Scenario sc) {
		System.out.println("Teardown Executed");

		if (sc.isFailed() == true) {
			String Filepath = "C:\\Users\\Admin\\eclipse-workspace\\RepeatMavenBDDCucumber\\screenshot\\failedScreenshot.png";

			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);

			File dstFile = new File(Filepath);

			try {
				FileUtils.copyFile(scrFile, dstFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		driver.quit();
	}

	// AddNewCustomers

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws Exception {
		AddCust=new pageObjects.AddNewCustomers(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",AddCust.getPageTitle());
	    Thread.sleep(2000);
	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() throws Exception {
		AddCust.clickOnCustomesMenu();
	    Thread.sleep(2000);
	}

	@When("User click on customers menu item")
	public void user_click_on_customers_menu_item() throws Exception {
		AddCust.clickOnCustomesMenuItem();
	    Thread.sleep(2000);
	}

	@When("User click on new add button")
	public void user_click_on_new_add_button() throws Exception {
		
		AddCust.clickOnAddNew();
	    Thread.sleep(2000);
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() throws Exception {
		 Thread.sleep(2000);
	       Assert.assertEquals("Add a new customer / nopCommerce administration", AddCust.getPageTitle());
	}

	@When("user enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
	public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String NewPassword, String firstName,
			String lastName, String gender, String compName, String adminComment) throws Exception {
		AddCust.SetEmail(newEmail);
		  AddCust.SetPassword(NewPassword);
		  AddCust.SetFirstName(firstName);
		  AddCust.SetLastName(lastName);
		  AddCust.SetGender(gender);
		  AddCust.SetCompanyName(compName);
		  AddCust.SetAdminContent(adminComment);
		    Thread.sleep(2000);
	}

	@When("user click on save button")
	public void user_click_on_save_button() throws Exception {
		AddCust.clickOnSave();
		  Thread.sleep(2000);
	}

	@Then("User can view confirmation msg {string}")
	public void user_can_view_confirmation_msg(String string) throws Exception {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	    Thread.sleep(2000);
	}

}
