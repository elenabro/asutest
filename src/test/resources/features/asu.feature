@asu
Feature: Request for Information

  @asu1
  Scenario: RFI form Happy Path
    Given I open the "asu" page
    When I go to "Request Info" form
    And I select  degree,  area,  program in first step
    And i fill out fields in second step
    And I submit RFI form
    Then I verify that Thank you page is displayed

  @asu2
  Scenario: RFI form required field
    Given I open the "asu" page
    When I go to "Request Info" form
    And I select   program in first step
    And i fill out fields in second step
    And I submit RFI form
    Then I verify that Thank you page is displayed

  @asu3
  Scenario: RFI form required field error
    Given I open the "asu" page
    When I go to "Request Info" form
    And I select  degree,  area  in first step
    Then I verify that required field error is displayed
