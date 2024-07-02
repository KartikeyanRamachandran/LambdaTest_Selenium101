# Run Selenium Tests With TestNG On LambdaTest


## Table Of Contents

* Pre-requisites
* Run Your First Test
* Parallel Testing With TestNG


## Pre-requisites

Before you can start performing Java automation testing with Selenium, you would need to:

- Install the latest **Java development environment** i.e. **JDK 1.8** or higher. We recommend using the latest version.

- Download the latest **Selenium Client** and its **WebDriver bindings** from the official website. Latest versions of Selenium Client and WebDriver are ideal for running your automation script on LambdaTest Selenium cloud grid.

- Install **Maven** which supports **TestNG** framework out of the box. **Maven** can be downloaded and installed following the steps from [the official website](https://maven.apache.org/). Maven can also be installed easily.

	
### Setting Up Your Authentication

**Step 1:** Make sure you have your LambdaTest credentials with you to run test automation scripts. You can get these credentials from your LambdaTest Profile.

**Step 2:** Set LambdaTest **Username** and **Access Key** in LambdaTest_Selenium101\src\main\java\com\lambdatest\seleniumbase\SeleniumBase.java

## Run Your First Test

**Step 3:** >**Test Scenario**: The sample [LambdaTest_Selenium101\src\main\java\com\lambdatest\testcase\TestScenario01.java] tests a sample to-do list app by marking couple items as done, adding a new item to the list and finally displaying the count of pending items as output.


### Configuring Your Test Capabilities

In the test case, you need to update your test capabilities. In this code, we are passing browser, browser version, and operating system information, along with LambdaTest Selenium grid capabilities via capabilities object. The capabilities object in the above code are defined as:

	public void testCaseSetup() {
		browserName = "Safari";
		browserVersion = "16.0";
		platformName = "MacOS Ventura";
		testCaseName = "TestScenario02";
	}

You can generate capabilities for your test requirements with the help of our inbuilt [Desired Capability Generator](https://www.lambdatest.com/capabilities-generator/?utm_source=github&utm_medium=repo&utm_campaign=Java-TestNG-Selenium).

### Executing The Test

**Step 4:** The tests can be executed Right click -> Run-> TestNG test.

 	* To perform sequential execution - Open "101_Sequential_Runner.xml" and then do right click and **Run As -> TestNG Suite  **
  	* To perform parallel execution - Open "101_Parallel_Runner.xml" and then do right click and **Run As -> TestNG Suite  **


Your test results would be displayed on the test console and on LambdaTest automation dashboard. 

## Run Parallel Tests Using TestNG


Here is an example `xml` file which would help you to run the test on various browsers at the same time.


<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite thread-count="2" parallel="tests" name="Suite">

	<test thread-count="2" parallel="tests" name="Test01">
		<parameter name="browser" value="Chrome" />
		<parameter name="version" value="108.0" />
		<parameter name="platform" value="Windows 11" />
		<parameter name="testcasename" value="TestScenario_01" />
		<classes>
			<class name="com.lamdatest.testcase.TestScenario01" />
		</classes>
	</test> <!-- Test -->

	<test thread-count="2" parallel="tests" name="Test02">
		<parameter name="browser" value="Safari" />
		<parameter name="version" value="16.0" />
		<parameter name="platform" value="macOS Ventura" />
		<parameter name="testcasename" value="TestScenario_02" />
		<classes>
			<class name="com.lamdatest.testcase.TestScenario02" />
		</classes>
	</test> <!-- Test -->

	<test thread-count="2" parallel="tests" name="Test03">
		<parameter name="browser" value="Edge" />
		<parameter name="version" value="107.0" />
		<parameter name="platform" value="Windows 10" />
		<parameter name="testcasename" value="TestScenario_03" />
		<classes>
			<class name="com.lamdatest.testcase.TestScenario03" />
		</classes>
	</test> <!-- Test -->

</suite> <!-- Suite -->
