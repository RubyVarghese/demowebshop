package com.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.TestHelperUtility;

public class LoginPage extends TestHelperUtility {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	private final String _emailField="Email";
	@FindBy (id=_emailField)
	private WebElement emailField;
	private final String _passwordField="Password";
	@FindBy (id=_passwordField)
	private WebElement passwordField;
	private final String _LoginButton="//input[@class='button-1 login-button']";
	@FindBy (xpath=_LoginButton)
	private WebElement loginButton;
	private final String _loginErrormsg="//div[@class='validation-summary-errors']//span";
	@FindBy (xpath=_loginErrormsg)
	private WebElement LoginErrormsg;
	
	public void enterUserCredential(String email, String pword) {
		page.enterText(emailField, email);
		page.enterText(passwordField, pword);
	
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public String getLoginErrorMessage() {
		String errorMessage= page.getElementText(LoginErrormsg);
		return errorMessage;
	}

}
