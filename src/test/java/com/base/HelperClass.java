package com.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {

	public WebDriver driver;
	public WebDriverWait wait;

	public WebDriver LaunchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		driver.manage().window().maximize();
		return driver;

	}

	public String sendTextString(WebElement e, String s) {
		e.sendKeys(s);
		System.out.println(s);
		return s;
	}

	// public long sendTextNum(WebElement e, long a) {
	// e.sendKeys(a);
	// System.out.println(a);
	// return a;
	// }
	public long JsSendtext(WebElement e, long a) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='';", e);
		return a;
	}

	public void ClickAction(WebElement e) {
		e.click();
	}

	public void selectAction(WebElement e, String s) {
		Select a = new Select(e);
		a.selectByValue(s);
	}

	public void explisitWaitVisibility() {

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='start-over']"))));
	}

	public void waitTill(int a) throws InterruptedException {

		Thread.sleep(a);
	}

	public void selectActionvalue(WebElement e, int i) {
		Select a = new Select(e);
		a.selectByIndex(i);
	}

	public String getAttr(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}

	public void elementReset(WebElement e) {
		e.clear();
	}

}
