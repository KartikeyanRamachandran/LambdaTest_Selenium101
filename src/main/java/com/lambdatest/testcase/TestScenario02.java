package com.lambdatest.testcase;

import org.testng.annotations.Test;

import com.lambdatest.seleniumbase.SeleniumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class TestScenario02 extends SeleniumBase{

	@BeforeTest
	public void testCaseSetup() {
		browserName = "Safari";
		browserVersion = "16.0";
		platformName = "MacOS Ventura";
		testCaseName = "TestScenario02";
	}

	@Test
	public void toDoTestScenario02() {
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();

		Actions actions = new Actions(driver);
		WebElement moveSlider = driver.findElement(By.xpath("(//h4[contains(text(),'Default value 15')]/following::div)[1]"));
		Action action = actions.dragAndDropBy(moveSlider, 98, 0).release().build();
		action.perform();

		String rangeOutput = driver.findElement(By.xpath("//h4[text()=' Default value 15']/following::output[@id='rangeSuccess']")).getText();
		if(rangeOutput.equalsIgnoreCase("95")) {
			System.out.println("Range values shows as 95");
		}
		else{
			System.out.println("Range values not requal to 95");
		}
	}

}
