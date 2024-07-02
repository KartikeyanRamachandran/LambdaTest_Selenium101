package com.lamdatest.basecode;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class SeleniumBase {

	//Lambda_test__access_details
	public String lamdaTestUName = "karthikyuva75";
	public String lamdaTestAccessKey = "NfUl1JCQsjmoz8gJOck5j0CcBsRn7aW4T0dpC7YHkwYwVv6Tpd";
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;

	//Variables
	public static RemoteWebDriver driver = null;
	public static Actions actionEvent;
	public static DesiredCapabilities capabilities;
	public static JavascriptExecutor executor;
	public static SoftAssert assertObject;
	public static WebDriverWait waitObject;

	@Parameters({"browser","version","platform","testcasename"})
	@BeforeTest
	public void setUp(String  browserName,String browserVersion,String platformName,String testCaseName) throws Exception {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("browserVersion", browserVersion);
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", lamdaTestUName);
		ltOptions.put("accessKey", lamdaTestAccessKey);
		ltOptions.put("visual", true);
		ltOptions.put("platformName", platformName);
		ltOptions.put("build", "LambdaTestSampleApp");
		ltOptions.put("project", "LambdaTest Selenium 101");
		ltOptions.put("name", testCaseName);
		capabilities.setCapability("LT:Options", ltOptions);
		try {
			driver = new RemoteWebDriver(new URL("https://" + lamdaTestUName + ":" + lamdaTestAccessKey + gridURL), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		actionEvent = new Actions(driver);
		assertObject = new SoftAssert();
		executor = (JavascriptExecutor) driver;
		waitObject = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://www.lambdatest.com/selenium-playground");	
		try {
			// Adjust the selector to match the Cookiebot accept button
			WebElement acceptCookie = driver.findElement(By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll' and contains(text(),'Allow all')]"));
			waitObject.until(ExpectedConditions.elementToBeClickable(acceptCookie));
			acceptCookie.click();
			System.out.println("Cookiebot popup accepted");
		} catch (Exception e) {
			System.out.println("Cookiebot popup not found or already accepted");
		}
		Thread.sleep(3000);

	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
