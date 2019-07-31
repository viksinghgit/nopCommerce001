package com.selenium.hashmap;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Implementing HashMap in Selenium

public class ImplementingHashMap {

	public static void main(String[] args) {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("usernamePassword", "emailmegmail.com@Tyajsa");

		String[] arr = hashMap.get("usernamePassword").split("@");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		driver.findElement(By.xpath("//span[contains(text(),'Hello')]")).click();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("");
	}

}
