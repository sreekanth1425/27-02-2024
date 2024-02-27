package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.adactin.base.TestBase;
import com.qa.adactin.pages.LoginPage;
import com.qa.adactin.pages.SearchHotelPage;
import com.qa.adactin.pages.SelectHotelPage;

public class SelectHotelPageTest extends TestBase {
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	SelectHotelPage selectHotelPage;

	public SelectHotelPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		searchHotelPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		selectHotelPage = searchHotelPage.validateSearchHotelButton();
		selectHotelPage=new SelectHotelPage();

	}

	@Test
	public void selectHotelPageTitleTest() {
		String s = selectHotelPage.validatePageTitle();
		System.out.println(s);
//		Assert.assertEquals(s, "Adactin.com - Select Hotel");

	}

	@Test
	public void adactinLogoTest() {
		Boolean flag = loginPage.validateAdactinLogo();
		Assert.assertTrue(flag);
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		System.exit(0);
	}

}
