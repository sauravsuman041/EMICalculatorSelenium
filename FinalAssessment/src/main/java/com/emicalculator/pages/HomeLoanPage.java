package com.emicalculator.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.emicalculator.base.BasePage;

public class HomeLoanPage extends BasePage {

	public HomeLoanPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver , this);
	}
	
	@FindBy(id = "loanamount")
    WebElement loanAmount;

    @FindBy(id = "loaninterest")
    WebElement interestRate;

    @FindBy(id = "loanterm")
    WebElement loanTenure;

    @FindBy(xpath = "//li[@id='home-loan']/a")
    WebElement homeLoanButton;
    
    @FindBy(xpath = "//div[@id='emiamount']/p/span")
    WebElement emiAmount;

    @FindBy(xpath = "//div[@id='emitotalinterest']/p/span")
    WebElement totalInterest;

    @FindBy(xpath = "//div[@id='emitotalamount']/p/span")
    WebElement totalPayment;
    
    public void setHomeLoanAmount(String amount) {
    	loanAmount.clear();
        enterText(loanAmount, amount);
    }

    public void setHomeInterestRate(String rate) {
    	interestRate.clear();
        enterText(interestRate, rate);
    }

    public void setHomeLoanTenure(String tenure) {
    	loanTenure.clear();
    	enterText(loanTenure, tenure);
    }

    public void goToHomeLoanSection() {
        onClick(homeLoanButton);
    }
    
    public String getHomeLoanEmiAmount() {
    	Actions action = new Actions(driver);
    	action.scrollToElement(emiAmount).scrollByAmount(0, 500).click(emiAmount).perform();
    	wait.until(ExpectedConditions.visibilityOf(emiAmount));
    	wait.withTimeout(Duration.ofSeconds(2));
    	System.out.println(emiAmount.getText());
        return emiAmount.getText();
    }

    public String getHomeLoanTotalInterest() {
    	wait.until(ExpectedConditions.visibilityOf(totalInterest));
    	wait.withTimeout(Duration.ofSeconds(2));
        return totalInterest.getText();
    }

    public String getHomeLoanTotalPayment() {
    	wait.until(ExpectedConditions.visibilityOf(totalPayment));
    	wait.withTimeout(Duration.ofSeconds(2));
        return totalPayment.getText();
    }

    

}
