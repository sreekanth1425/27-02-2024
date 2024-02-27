package com.qa.tests;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.adactin.base.TestBase;
import com.qa.adactin.pages.LoginPage;
import com.qa.adactin.pages.SearchHotelPage;
import com.qa.adactin.pages.SelectHotelPage;

public class SearchHotelPageTest extends TestBase {
	SearchHotelPage searchHotelPage;
	LoginPage loginPage;
	SelectHotelPage selectHotelPage;

	public SearchHotelPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		searchHotelPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test
	public void searchHotelTest() {
		System.out.println("search hotel test");
	}

	// gpt test methods
	@Test
	public void testLocDropdownOptions() {
//        List<String> expectedOptions = List.of("Option 1", "Option 2", "Option 3");
		List<String> expectedOptions = Arrays.asList("- Select Location -", "Sydney", "Melbourne", "Brisbane",
				"Adelaide", "London", "New York", "Los Angeles", "Paris");

		List<String> actualOptions = searchHotelPage.getLocationDropdownOptions();
		Assert.assertEquals(expectedOptions, actualOptions);
		System.out.println(actualOptions);

	}

	@Test
	public void validateHotelsDropDownOptions() {
//		List<String> actualOptions = 
		List<String> actualOptions= searchHotelPage.getDropdownOptions();
		
		String[] expectedOptions = { "- Select Hotel -", "Hotel Creek", "Hotel Sunshine", "Hotel Hervey",
				"Hotel Cornice" };

		// Check if the number of options match
		Assert.assertEquals(actualOptions.size(), expectedOptions.length);

		// Check each option text
		for (int i = 0; i < actualOptions.size(); i++) {
			Assert.assertEquals(actualOptions.get(i), expectedOptions[i]);
		}
		
	}
	@Test
	public void searchHotelButtonTest() throws InterruptedException {
		searchHotelPage.validateSearchHotelButton();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.close();

	}

}

//
//@Test
//public void testSelectOptionByVisibleText() {
//    String optionText = "Sydney";
//    searchHotelPage.selectOptionByVisibleText(optionText);
//    System.out.println(searchHotelPage.getSelectedOptionText());
////    Assert.assertEquals(searchHotelPage.getSelectedOptionText(), optionText);
//}
//@Test
//public void getDropdownOptionsTest() {
//	List<WebElement> ss=	searchHotelPage.getDropdownOptions();
//	System.out.println(ss.size());
//}
//
//@Test	
//public void getSelectedOptionTextTest() {
//	String s=searchHotelPage.getSelectedOptionText();
//	System.out.println(s);
//}
