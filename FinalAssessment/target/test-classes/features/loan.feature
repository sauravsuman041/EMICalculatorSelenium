Feature: EMI Calculation

  Scenario Outline: Calculate EMI for Home Loan
    Given user is on Home Loan Section on EMI calculator page
    When user sets Home loan amount to "<amount>"
    And user sets Home loan interest rate to "<rate>"
    And user sets Home loan tenure to "<tenure>"
    Then user should see calculated Home loan EMI details "<Loan EMI>" "<Total Interest>" "<Total Payment>"

    Examples: 
      | amount  | rate | tenure | Loan EMI | Total Interest | Total Payment |
      | 5000000 |   10 |     20 |   48,251 |      65,80,260 |   1,15,80,260 |

  Scenario Outline: Calculate EMI for Personal Loan
    Given user is on Personal loan section on EMI calculator page
    When user sets Personal loan amount to "<amount>"
    And user sets Personal loan interest rate to "<rate>"
    And user sets Personal loan tenure to "<tenure>"
    Then user should see calculated Personal loan EMI details "<Loan EMI>" "<Total Interest>" "<Total Payment>"

    Examples: 
      | amount | rate | tenure | Loan EMI | Total Interest | Total Payment |
      | 750000 |   15 |      5 |   17,842 |       3,20,547 |     10,70,547 |

  Scenario Outline: Calculate EMI for Car Loan
    Given user is on Car loan section on EMI calculator page
    When user sets Car loan amount to "<amount>"
    And user sets Car loan interest rate to "<rate>"
    And user sets Car loan tenure to "<tenure>"
    Then user should see calculated Car loan EMI details "<Loan EMI>" "<Total Interest>" "<Total Payment>"

    Examples: 
      | amount  | rate | tenure | Loan EMI | Total Interest | Total Payment |
      | 2000000 |    9 |      6 |   36,051 |       5,95,677 |     25,95,677 |
