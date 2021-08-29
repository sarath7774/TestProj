package com.AnzCalcSetp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.HelperClass;

import junit.framework.Assert;

public class AnzCalcPage extends HelperClass {
	WebDriver driver;

	public AnzCalcPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@for='application_type_single']")
	private WebElement AppTypeSingle;

	@FindBy(xpath = "//label[@for='application_type_joint']")
	private WebElement AppTypeJoint;

	@FindBy(xpath = " //label[@for='borrow_type_home']")
	private WebElement BorrowTypeHome;

	@FindBy(xpath = " //label[@for='borrow_type_investment']")
	private WebElement BorrowTypeInvestment;

	@FindBy(xpath = "//select[@title='Number of dependants']")
	private WebElement Numberofdependants;

	@FindBy(xpath = "//input[@aria-labelledby='q2q1']")
	private WebElement Yourincome;

	@FindBy(xpath = "//input[@aria-labelledby='q2q2']")
	private WebElement Yourotherincome;

	@FindBy(xpath = "//input[@aria-labelledby='q3q1']")
	private WebElement Livingexpenses;

	@FindBy(xpath = "//input[@aria-labelledby='q3q2']")
	private WebElement Currhomeloanrepayments;

	@FindBy(xpath = "//input[@aria-labelledby='q3q3']")
	private WebElement Otherloanrepayments;

	@FindBy(xpath = "//input[@aria-labelledby='q3q4']")
	private WebElement Othercommitments;

	@FindBy(xpath = "//input[@aria-labelledby='q3q5']")
	private WebElement Totalcreditcardlimits;

	@FindBy(xpath = "//span[contains(text(),'We estimate you could borrow')]//child::span[@id='borrowResultTextAmount']")
	private WebElement borrowEstimatedAmt;

	@FindBy(xpath = "//button[@class='start-over']")
	private WebElement btnStartOver;

	@FindBy(id = "btnBorrowCalculater")
	private WebElement btnBorrowCalculater;

	@FindBy(xpath = "//span[contains(text(),'Based')]")
	private WebElement unableToEstimateText;

	public WebElement getunableToEstimateText() {
		return unableToEstimateText;
	}

	public WebElement getbtnStartOver() {
		return btnStartOver;
	}

	public WebElement getborrowEstimatedAmt() {
		return borrowEstimatedAmt;
	}

	public WebElement getAppTypeSingle() {
		return AppTypeSingle;
	}

	public WebElement getAppTypeJoint() {
		return AppTypeJoint;
	}

	public WebElement getBorrowTypeHome() {
		return BorrowTypeHome;
	}

	public WebElement getBorrowTypeInvestment() {
		return BorrowTypeInvestment;
	}

	public WebElement getNumberofdependants() {
		return Numberofdependants;
	}

	public WebElement getYourincome() {
		return Yourincome;
	}

	public WebElement getYourotherincome() {
		return Yourotherincome;
	}

	public WebElement getLivingexpenses() {
		return Livingexpenses;
	}

	public WebElement getCurrhomeloanrepayments() {
		return Currhomeloanrepayments;
	}

	public WebElement getOtherloanrepayments() {
		return Otherloanrepayments;
	}

	public WebElement getOthercommitments() {
		return Othercommitments;
	}

	public WebElement getTotalcreditcardlimits() {
		return Totalcreditcardlimits;
	}

	public WebElement getbtnBorrowCalculater() {
		return btnBorrowCalculater;
	}

	public void calculateBorrowEstimation(String income, String Yourotherincome, String Livingexpenses,
			String Otherloanrepayments, String Totalcreditcardlimits) {

		sendTextString(getYourincome(), income);
		sendTextString(getYourotherincome(), Yourotherincome);
		sendTextString(getLivingexpenses(), Livingexpenses);
		sendTextString(getOtherloanrepayments(), Otherloanrepayments);
		sendTextString(getTotalcreditcardlimits(), Totalcreditcardlimits);

	}

	public void fieldsReset() throws InterruptedException {
		//wait = new WebDriverWait(driver, 60);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class='start-over']"))));
		waitTill(3000);
		ClickAction(getbtnStartOver());

	}

	public void ResetValidation() {
		String zero = "0";
		if (getAttr(getYourincome()).equals(zero) && getAttr(getYourotherincome()).equals(zero)
				&& getAttr(getLivingexpenses()).equals(zero) && getAttr(getOtherloanrepayments()).equals(zero)
				&& getAttr(getTotalcreditcardlimits()).equals(zero)) {
			System.out.println("Feilds are cleared");
		} else {
			System.out.println("Feilds are not cleared");
		}
	}

	public void enterOnlyLivingExp(String Livingexpenses) {
		sendTextString(getLivingexpenses(), Livingexpenses);

	}

	public void unabletoExtimateValidation(String s) throws InterruptedException {
		waitTill(3000);
		String expected = "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.";
		String actual = getunableToEstimateText().getText();
		// explisitWaitText(s,expected);
		Assert.assertEquals(expected, actual);

	}

}
