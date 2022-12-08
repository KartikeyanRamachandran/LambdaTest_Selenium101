package com.lambdatest.seleniumbase;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SeleniumBase {

	public String username = "karthikyuva75";
	public String accesskey = "NfUl1JCQsjmoz8gJOck5j0CcBsRn7aW4T0dpC7YHkwYwVv6Tpd";
	public static RemoteWebDriver driver = null;
	public static Actions actionEvent;
	public String gridURL = "@hub.lambdatest.com/wd/hub";
	boolean status = false;

	//capabilities
	public String  browserName;
	public String browserVersion;
	public String platformName;
	public String testCaseName;

	@BeforeMethod
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browserName);
		capabilities.setCapability("browserVersion", browserVersion);
		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("username", "karthikyuva75");
		ltOptions.put("accessKey", "NfUl1JCQsjmoz8gJOck5j0CcBsRn7aW4T0dpC7YHkwYwVv6Tpd");
		ltOptions.put("visual", true);
		ltOptions.put("platformName", platformName);
		ltOptions.put("build", "LambdaTestSampleApp");
		ltOptions.put("project", "LambdaTest Selenium 101");
		ltOptions.put("name", testCaseName);
		capabilities.setCapability("LT:Options", ltOptions);
		try {
			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		actionEvent = new Actions(driver);

		driver.get("https://www.lambdatest.com/selenium-playground");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
