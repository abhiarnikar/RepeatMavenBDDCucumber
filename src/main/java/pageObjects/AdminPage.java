package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
	public WebDriver ldriver;
	
	

	public AdminPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@id=\"Email\"]")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id=\"Password\"]")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class=\"message-error validation-summary-errors\"]")
	WebElement errorMsg;
	
	public void setUsername(String Email) {
		txtEmail.clear();
		txtEmail.sendKeys(Email);
	}

	public void setPassword(String Password) {
		txtPassword.clear();
		txtPassword.sendKeys(Password);
	}

	public void clickOnLoginButton() {
		loginBtn.click();
	}
	
	public String ErrorMsg() {
		String Msg=errorMsg.getText();
		return Msg;
	}
}
