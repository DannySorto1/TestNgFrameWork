package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommondMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass {

	@Test(enabled = false)
	public void loginToOrangeHrm() {

		LoginPageWithoutPageFactory login = new LoginPageWithoutPageFactory();

		CommondMethods.sendText(login.username, "Admin");
		CommondMethods.sendText(login.password, "IbdRdJC@15");
		CommondMethods.click(login.btnLogin);
	}

	@Test(enabled = false)
	public void doLogin() {
		LoginPage login = new LoginPage();
		CommondMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommondMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommondMethods.click(login.loginBtn);

		HomePage home = new HomePage();
		boolean isDisplayed = home.dashboard.isDisplayed();

		Assert.assertTrue(isDisplayed);
	}

	@Test
	public void negLogin() {
		LoginPage login = new LoginPage();
		CommondMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommondMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommondMethods.click(login.loginBtn);

		LoginPage failed = new LoginPage();
		boolean isDisplayed = failed.retrylog.isDisplayed();

		Assert.assertTrue(isDisplayed);

	}

}
