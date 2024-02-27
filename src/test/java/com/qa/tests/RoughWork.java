package com.qa.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RoughWork {
	public static void main(String[] args) throws InterruptedException {
		dropDown();
		
		
	}

	public static List<String> dropDown() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("chiru1234");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sree@1234");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='hotels']")));
		List<WebElement> options=dropdown.getOptions();
		List<String> optionTexts=new ArrayList<>();
		for(WebElement option:options) {
			optionTexts.add(option.getText());
			
		}
		return optionTexts;
		// job done
		
		
		
		
		

	}
	
}
