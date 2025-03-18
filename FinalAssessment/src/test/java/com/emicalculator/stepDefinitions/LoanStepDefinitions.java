package com.emicalculator.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.emicalculator.hooks.Hooks;
import com.emicalculator.pages.CarLoanPage;
import com.emicalculator.pages.HomeLoanPage;
import com.emicalculator.pages.PersonalLoanPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoanStepDefinitions {
	
	WebDriver driver = Hooks.getWebDriver();
	HomeLoanPage homePage = new HomeLoanPage(driver);
	PersonalLoanPage personalPage = new PersonalLoanPage(driver);
	CarLoanPage carPage = new CarLoanPage(driver);
	
	@Given("user is on Home Loan Section on EMI calculator page")
	public void user_is_on_home_loan_section_on_emi_calculator_page() {
	    homePage.goToHomeLoanSection();
	}

	@When("user sets Home loan amount to {string}")
	public void user_sets_home_loan_amount_to(String string) {
	    homePage.setHomeLoanAmount(string);
	}

	@When("user sets Home loan interest rate to {string}")
	public void user_sets_home_loan_interest_rate_to(String string) {
	    homePage.setHomeInterestRate(string);
	}

	@When("user sets Home loan tenure to {string}")
	public void user_sets_home_loan_tenure_to(String string) {
		homePage.setHomeLoanTenure(string);
	}

	@Then("user should see calculated Home loan EMI details {string} {string} {string}")
	public void user_should_see_calculated_home_loan_emi_details(String string, String string2, String string3) {
	    Assert.assertEquals(homePage.getHomeLoanEmiAmount(), string);
	    Assert.assertEquals(homePage.getHomeLoanTotalInterest(), string2);
	    Assert.assertEquals(homePage.getHomeLoanTotalPayment(), string3);
	}

	@Given("user is on Personal loan section on EMI calculator page")
	public void user_is_on_personal_loan_section_on_emi_calculator_page() {
	    personalPage.goToPersonalLoanSection();
	}

	@When("user sets Personal loan amount to {string}")
	public void user_sets_personal_loan_amount_to(String string) {
		personalPage.setPersonalLoanAmount(string);
	}

	@When("user sets Personal loan interest rate to {string}")
	public void user_sets_personal_loan_interest_rate_to(String string) {
		personalPage.setPersonalInterestRate(string);
	}

	@When("user sets Personal loan tenure to {string}")
	public void user_sets_personal_loan_tenure_to(String string) {
		personalPage.setPersonalLoanTenure(string);
	}

	@Then("user should see calculated Personal loan EMI details {string} {string} {string}")
	public void user_should_see_calculated_personal_loan_emi_details(String string, String string2, String string3) {
	    Assert.assertEquals(personalPage.getPersonalLoanEmiAmount(), string);
	    Assert.assertEquals(personalPage.getPersonalLoanTotalInterest(), string2);
	    Assert.assertEquals(personalPage.getPersonalLoanTotalPayment(), string3);
	}

	@Given("user is on Car loan section on EMI calculator page")
	public void user_is_on_car_loan_section_on_emi_calculator_page() {
	    carPage.goToCarLoanSection();
	}

	@When("user sets Car loan amount to {string}")
	public void user_sets_car_loan_amount_to(String string) {
		carPage.setCarLoanAmount(string);
	}

	@When("user sets Car loan interest rate to {string}")
	public void user_sets_car_loan_interest_rate_to(String string) {
		carPage.setCarInterestRate(string);
	}

	@When("user sets Car loan tenure to {string}")
	public void user_sets_car_loan_tenure_to(String string) {
		carPage.setCarLoanTenure(string);
	}

	@Then("user should see calculated Car loan EMI details {string} {string} {string}")
	public void user_should_see_calculated_car_loan_emi_details(String string, String string2, String string3) {
		Assert.assertEquals(carPage.getEmiAmount(), string);
		Assert.assertEquals(carPage.getTotalInterest(), string2);
		Assert.assertEquals(carPage.getTotalPayment(), string3);
	}


}
