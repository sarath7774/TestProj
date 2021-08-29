package com.AnzCalcSetp;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.base.HelperClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.lu.an;

public class AnzCalcStep extends HelperClass {

	AnzCalcPage objAnzCalcPage;
	WebDriver driver;

	@Given("User is on the Anz calculator page")
	public void user_is_on_the_Anz_calculator_page() {
		driver = LaunchBrowser();
		objAnzCalcPage = new AnzCalcPage(driver);
	}

	@When("User enters the personal and expense details {string},{string},{string},{string},{string}")
	public void user_enters_the_personal_and_expense_details(String income, String otherincome, String Livingexpenses,
			String otherloanrepayments, String totalcreditcardlimits) {
		
		objAnzCalcPage.calculateBorrowEstimation(income, otherincome, Livingexpenses, otherloanrepayments, totalcreditcardlimits);
		//objAnzCalcPage.calculateBorrowEstimation("80000", "10000", "500", "100", "10000");
	}

	@When("User clicks borrow estimation button")
	public void user_clicks_borrow_estimation_button() {

		objAnzCalcPage.ClickAction(objAnzCalcPage.getbtnBorrowCalculater());
	}

	@Then("Validate the generated estimation{string}")
	public void validate_the_generated_estimation(String Expected) throws InterruptedException {
		Thread.sleep(3000);
		String actual = objAnzCalcPage.getborrowEstimatedAmt().getText();

		if (Expected.equals(actual)) {
			System.out.println("Generated amount is matching with the expected" + actual);

		} else {
			System.out.println("Generated amount is not matching with the expected" + actual);

		}
		driver.quit();

	}
	
	@When("User enters the personal and expense details and clicks estimate")
	public void user_enters_the_personal_and_expense_details_and_clicks_estimate() {
		user_enters_the_personal_and_expense_details("80000", "10000", "500", "100", "10000");
		user_clicks_borrow_estimation_button();
	}

	@When("User clicks start over button")
	public void user_clicks_start_over_button() throws InterruptedException {
		objAnzCalcPage.fieldsReset();
	}

	@Then("Validate the resetted fields")
	public void validate_the_resetted_fields() {
		objAnzCalcPage.ResetValidation();
	}
	
	@When("User enters only Living expense and clicks estimate {string}")
	public void user_enters_only_Living_expense_and_clicks_estimate(String Livingexpenses) {
		objAnzCalcPage.enterOnlyLivingExp(Livingexpenses);
		objAnzCalcPage.ClickAction(objAnzCalcPage.getbtnBorrowCalculater());

	}

	@Then("Validate the unable to estimate message")
	public void validate_the_unable_to_estimate_message() throws InterruptedException {
		
		objAnzCalcPage.unabletoExtimateValidation("//span[contains(text(),'Based')]");
	}
	
	
}
