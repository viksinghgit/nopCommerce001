package com.extentreports.basics;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoExtentReport {

	public ExtentHtmlReporter extentHtmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	public WebDriver driver;
	public ITestResult result;
	public Logger logger;

	@BeforeTest
	public void initializationExtentReports() {
		extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");

		extentHtmlReporter.config().setDocumentTitle("Automation Report");
		extentHtmlReporter.config().setReportName("Functional Testcases");
		extentHtmlReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);

		extentReports.setSystemInfo("Application Name", "Amazon.com");
		extentReports.setSystemInfo("OS", "WINDOWS10");
		extentReports.setSystemInfo("Tester Name", "Vikrant Singh");
		extentReports.setSystemInfo("Browser", "Google Chrome");

		logger = LogManager.getLogger(DemoExtentReport.class);

	}

	@BeforeMethod
	public void preSetup() {
		System.setProperty("webdriver.chrome.driver", "C:/Setups/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.nopcommerce.com/");

		driver.manage().window().maximize();
	}

	@Test
	public void noCommerceTitleTest() {
		extentTest = extentReports.createTest("noCommerceTitletTest");

		logger.info("noCommerceTitleTest has been started");

		String actualTitle = "nopCommerce demo store";
		String expectedTitle = driver.getTitle();
		Boolean value = actualTitle.equals(expectedTitle);
		Assert.assertTrue(value);

		logger.info(" Assertion for noCommerceTitleTest is true");

	}

	@Test
	public void verifyImage() {
		extentTest = extentReports.createTest("verifyImage");

		logger.info("verifyImage has been started");

		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Camera");
		driver.findElement(By.xpath("//input[@value='Search']")).submit();

		// throw new SkipException("I am skipping this Testcase");
		logger.info(" Assertion for verifyImage is true");
	}

	@Test
	public void navigateToCameraSection() {
		extentTest = extentReports.createTest("navigateToCameraSection");

		logger.info("navigateToCameraSection has been started");

		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Electronics')]"))).build().perform();
		actions.moveToElement(
				driver.findElement(By.xpath("//a[contains(text(),'camera') or contains(text(),'Camera')]"))).click()
				.build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Nikon')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Nikon')]")).click();
		Assert.assertTrue(driver
				.findElement(By
						.xpath("//img[@src='//demo.nopcommerce.com/images/thumbs/0000035_nikon-d5500-dslr_550.jpeg']"))
				.isDisplayed());
		logger.info(" Assertion for navigateToCameraSection is true");

	}

	@Test
	public void changeCurrency() throws Exception {

		logger.info("changeCurrency has been started");

		extentTest = extentReports.createTest("changeCurrency");
		Select select = new Select(driver.findElement(By.id("customerCurrency")));
		select.selectByVisibleText("Euro");

		Thread.sleep(3000);
		logger.info(" Assertion for changeCurrency is true");

	}

	@Test
	public void selectDesktop() throws Exception {

		logger.info("selectDesktop has been started");

		extentTest = extentReports.createTest("selectDesktop");
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[contains(text(),'Computers')]")))
				.build().perform();
		actions.moveToElement(driver.findElement(By
				.xpath("//ul[@class='top-menu notmobile']/li/ul[@class='sublist first-level']/li/a[contains(text(),'Desktops')]")))
				.click().build().perform();

		driver.findElement(By
				.xpath("(//div[@class='product-grid']/div/div[2]/div/div/following::div/child::div[3]/child::div[2]/input[1])[position()=1]"))
				.click();
		Thread.sleep(3000);
		logger.info(" Assertion for selectDesktop is true");

	}

	@AfterMethod
	public void afterExecution(ITestResult result) throws Throwable {
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "TestCase passed is ==>" + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, "TestCase skipped is ==>" + result.getName());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "TestCase failed is ==>" + result.getName());
			extentTest.log(Status.FAIL, "TestCase failed is ==>" + result.getThrowable());
			String screenshotPath = DemoExtentReport.takesFailedScreenShot(driver, result.getName());
			extentTest.addScreenCaptureFromPath(screenshotPath);

		}
		driver.close();

	}

	@AfterTest
	public void postCondition() {
		extentReports.flush();
	}

	public static String takesFailedScreenShot(WebDriver driver, String screenshotName) throws Throwable {
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		String date = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String finalDestination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "-" + date
				+ ".png";
		File destination = new File(finalDestination);
		FileUtils.copyFile(source, destination);
		return finalDestination;

	}

}
