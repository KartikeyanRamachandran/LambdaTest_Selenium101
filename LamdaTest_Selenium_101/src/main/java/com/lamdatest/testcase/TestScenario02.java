package com.lamdatest.testcase;

import org.testng.annotations.Test;

import com.lamdatest.basecode.SeleniumBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestScenario02 extends SeleniumBase{

	@Test
	public void toDoTestScenario02() {
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();

		Actions actions = new Actions(driver);
		WebElement moveSlider = driver.findElement(By.xpath("//h4[text()=' Default value 15']/following::input[@value='15']"));
		Action action = actions.dragAndDropBy(moveSlider, 215, 0).release().build();
		action.perform();

		String rangeOutput = driver.findElement(By.xpath("//h4[text()=' Default value 15']/following::output[@id='rangeSuccess']")).getText();
		if(rangeOutput.equalsIgnoreCase("95")) {
			System.out.println("Range values shows as 95");
			executor.executeScript("lambda-status=passed");
		}
		else{
			System.out.println("Range values not requal to 95");
			executor.executeScript("lambda-status=failed");
		}
	}

}
