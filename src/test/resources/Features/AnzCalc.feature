Feature: User calculating the borrowing estimation

  Background: 
    Given User is on the Anz calculator page

  Scenario Outline: User calculating the borrowing estimation with inputs
    When User enters the personal and expense details "<income>","<otherincome>","<Livingexpenses>","<otherloanrepayments>","<totalcreditcardlimits>"
    And User clicks borrow estimation button
    Then Validate the generated estimation"<borrowingestimate>"

    Examples: 
      | income | otherincome | Livingexpenses | otherloanrepayments | totalcreditcardlimits | borrowingestimate |
      |  80000 |       10000 |            500 |                 100 |                 10000 |            479000 |

  @last
  Scenario: User clicks the start over
    When User enters the personal and expense details and clicks estimate
    And User clicks start over button
    Then Validate the resetted fields

  Scenario Outline: User enters only Living Exp
    When User enters only Living expense and clicks estimate "<Livingexpenses>"
    Then Validate the unable to estimate message

    Examples: 
      | Livingexpenses |
      |              1 |
