package com.qa.adactin.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.adactin.base.TestBase;

public class SelectHotelPage extends TestBase {
	@FindBy(xpath = "//input[@id='radiobutton_0']")
	WebElement radioButton;

	@FindBy(xpath = "//input[@id='continue']")
	WebElement continueButton;

	@FindBy(xpath = "//input[@id='cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath="//img[@alt='AdactIn Group']")
	WebElement adactinLogo;
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	//methods
	public String validatePageTitle() {
		return driver.getTitle();
		
	}
	public boolean validateAdactinLogo() {
		return adactinLogo.isDisplayed();
		
	}
	public boolean validateRadioButton() {
		radioButton.isDisplayed();
		radioButton.click();
		return radioButton.isSelected();
		
		
	}
	public BookAHotelPage validateContinueButton() {
		continueButton.click();
		return new BookAHotelPage();
		
		
	}public SearchHotelPage validateCancelButton() {
		cancelButton.click();
		return new SearchHotelPage();
		
		
	}

}
