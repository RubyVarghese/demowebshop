package com.demowebshop.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demowebshop.utilities.TestHelperUtility;
import com.demowebshop.utilities.WaitUtility;

public class HomePage extends TestHelperUtility {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	 
	@FindBy(id ="newsletter-email")
	 WebElement subscribeEmailField;
	
	@FindBy(id = "newsletter-subscribe-button")
	 WebElement subscribeButton;
	
	@FindBy(id="newsletter-result-block")
	WebElement subscribeMessage;
	private final String _LoginLink="//a[@class='ico-login']";
	@FindBy(xpath=_LoginLink)
	private WebElement LoginLink;
	

	public void enterSubscribeEmail() {
		String emailId = random.getRandomEmail();
		page.enterText(subscribeEmailField, emailId);

	}

	public void clickOnSubscribeButton() {
		subscribeButton.click();
	}
	public String getSubscribeMessage() throws InterruptedException {
		//wait.waitForElementToBeVisible(driver, subscribeMessage, WaitUtility.LocatorType.Id);
		wait.setHardWait();
		//Thread.sleep(2000);
		wait.waitForElementToBeVisible(driver, subscribeMessage);
		String message= subscribeMessage.getText();
		return message;
	}
	public LoginPage clickOnLoginMenu() {
		page.clickOnElement(LoginLink);
		return new LoginPage(driver);//page traversing
	}
	

}
