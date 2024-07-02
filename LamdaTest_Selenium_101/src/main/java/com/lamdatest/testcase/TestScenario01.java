package com.lamdatest.testcase;

import org.testng.annotations.Test;

import com.lamdatest.basecode.SeleniumBase;

import org.openqa.selenium.By;


public class TestScenario01 extends SeleniumBase {

	@Test
	public void toDoTestScenario01() {

		driver.findElement(By.linkText("Simple Form Demo")).click();
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains("simple-form-demo")) {
			System.out.println("URL contains *simple-form-demo*");
		}
		else {
			System.out.println("URL not contains *simple-form-demo*");
		}

		String inputString = "Welcome to LambdaTest";
		driver.findElement(By.xpath("//p[text()='Enter Message']/following::input[@id='user-message']")).sendKeys(inputString);

		driver.findElement(By.id("showInput")).click();	
		String resultString = driver.findElement(By.xpath("//label[contains(text(),'Your Message')]/following::p[@id='message']")).getText();
		if (inputString.equalsIgnoreCase(resultString)) {
			System.out.println("Inputed String displayed in Your Message");
			executor.executeScript("lambda-status=passed");
		} else {
			System.out.println("Inputed String and Your Message are wrong");
			executor.executeScript("lambda-status=failed");
		}

	}

}
