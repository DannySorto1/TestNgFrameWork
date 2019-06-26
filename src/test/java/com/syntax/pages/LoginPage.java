package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommondMethods;

public class LoginPage extends BaseClass {

	@FindBy(id = "txtUsername")
	public WebElement userName;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement loginBtn;

	@FindBy(css = "img[src*='logo.png']")
	public WebElement logo;

	@FindBy(css = "div.dashboardCard-title-for-card")
	public WebElement retrylog;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void Login(String uname, String pwd) {
		CommondMethods.sendText(userName, uname);
		CommondMethods.sendText(password, pwd);
		CommondMethods.click(loginBtn);

	}
}
