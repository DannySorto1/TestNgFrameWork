package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(css = "li.page-title")
	public WebElement dashboard;

	@FindBy(partialLinkText = "PIM")
	public WebElement Pim;

	@FindBy(css = "a#menu_pim_addEmployee")
	public WebElement AddEmp;
	
	

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
}
