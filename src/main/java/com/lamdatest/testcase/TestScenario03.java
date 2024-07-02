package com.lamdatest.testcase;

import org.testng.annotations.Test;

import com.lamdatest.basecode.SeleniumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TestScenario03	 extends SeleniumBase {

	@Test
	public void toDoTestScenario03() {

		driver.findElement(By.linkText("Input Form Submit")).click();
		WebElement buttonSubmit = driver.findElement(By.xpath("//button[text()='Submit']"));
		buttonSubmit.click();

		driver.findElement(By.id("name")).sendKeys("Karthikeyan");
		driver.findElement(By.id("inputEmail4")).sendKeys("karthikeyan@gmail.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("Qwerty@12345");
		driver.findElement(By.id("company")).sendKeys("Lambda Test");
		driver.findElement(By.id("websitename")).sendKeys("www.lambdatest.com");	

		WebElement selectCountry = driver.findElement(By.name("country"));
		Select selectValue = new Select(selectCountry);
		selectValue.selectByVisibleText("United States");

		driver.findElement(By.id("inputCity")).sendKeys("Charlotte");	
		driver.findElement(By.id("inputAddress1")).sendKeys("New Street");	
		driver.findElement(By.id("inputAddress2")).sendKeys("Charlotte Town");	
		driver.findElement(By.id("inputState")).sendKeys("North Carolina");	
		driver.findElement(By.id("inputZip")).sendKeys("28201");	
		buttonSubmit.click();

		String expectedResult = "Thanks for contacting us, we will get back to you shortly.";

		String actualResult = driver.findElement(By.xpath("//h2[contains(text(),'Input form validations')]/following::p[@class='success-msg hidden']")).getText();
		if (expectedResult.equalsIgnoreCase(actualResult)) {
			System.out.println("Expected Result Displayed"); 
			executor.executeScript("lambda-status=passed");
		}else {
			System.out.println("Expected Result Not Displayed"); 
			executor.executeScript("lambda-status=failed");
		}
	}

}
