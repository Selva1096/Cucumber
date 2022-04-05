#Author: Selva.email@your.domain.com

Feature: Television Validation

  Scenario: Television Validation Steps
    Given user launches flipkart application
    And user closes the login tab
    When user search television
    And user clicks the television
    Then user validates the television names
    
  Scenario: Data Table Value List
    Given user launches flipkart application
    And user closes the login tab
    When user search television using one dime list
    |LG tv|oneplus tv|Samsung tv|
    And user clicks the television
    Then user validates the television names
    
  Scenario: Data Table Value Map
    Given user launches flipkart application
    And user closes the login tab
    When user search television using one dime Map
    |1|LG tv|
    |2|oneplus tv|
    |3|Samsung tv|
    And user clicks the television
    Then user validates the television names
    
    Scenario Outline: Data Table Value List
    Given user launches flipkart application
    And user closes the login tab
    When user search television "<Televisions>"
    And user clicks the television
    Then user validates the television names
    
    Examples:
    |Televisions|
    |LG tv|
    |oneplus tv|
    |Samsung tv|
    
    
    
   

  