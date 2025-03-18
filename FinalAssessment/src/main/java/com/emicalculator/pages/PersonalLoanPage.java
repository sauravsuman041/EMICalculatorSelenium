package com.emicalculator.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.emicalculator.base.BasePage;

public class PersonalLoanPage extends BasePage {

	public PersonalLoanPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver , this);
	}
	
    @FindBy(id = "loanamount") 
    WebElement loanAmount;

    @FindBy(id = "loaninterest") 
    WebElement interestRate;

    @FindBy(id = "loanterm") 
    WebElement loanTenure;

    @FindBy(xpath = "//li[@id='personal-loan']/a")
    WebElement personalLoanButton;

    @FindBy(xpath = "//div[@id='emiamount']//span")
    WebElement emiAmount;

    @FindBy(xpath = "//div[@id='emitotalinterest']//span")
    WebElement totalInterest;

    @FindBy(xpath = "//div[@id='emitotalamount']//span")
    WebElement totalPayment;

    public void setPersonalLoanAmount(String amount) {
    	loanAmount.clear();
        enterText(loanAmount, amount);
    }

    public void setPersonalInterestRate(String rate) {
    	interestRate.clear();
    	enterText(interestRate, rate);
    }

    public void setPersonalLoanTenure(String tenure) {
    	loanTenure.clear();
    	enterText(loanTenure, tenure);
    }

    public void goToPersonalLoanSection() {
        onClick(personalLoanButton);
    }

    public String getPersonalLoanEmiAmount() {
    	Actions action = new Actions(driver);
    	action.scrollToElement(emiAmount).scrollByAmount(0, 500).click(emiAmount).perform();
    	wait.until(ExpectedConditions.visibilityOf(emiAmount));
    	wait.withTimeout(Duration.ofSeconds(2));
        return emiAmount.getText();
    }

    public String getPersonalLoanTotalInterest() {
    	wait.until(ExpectedConditions.visibilityOf(totalInterest));
    	wait.withTimeout(Duration.ofSeconds(2));
        return totalInterest.getText();
    }

    public String getPersonalLoanTotalPayment() {
    	wait.until(ExpectedConditions.visibilityOf(totalPayment));
    	wait.withTimeout(Duration.ofSeconds(2));
        return totalPayment.getText();
    }

}
