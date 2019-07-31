package com.maven.demo.firsttest;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectRandomOptionInDropdown {

	@Test
	public void selectRandomOption() {
		System.setProperty("webdriver.chrome.driver", "C:\\Setups\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		Select select = new Select(driver.findElement(By.id("month")));

		List<WebElement> webElements = select.getOptions();

		Random random = new Random();
		int randomOption = random.nextInt(webElements.size());
		webElements.get(randomOption).click();
		driver.close();

	}

}
