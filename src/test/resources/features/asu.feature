@asu
  Feature: Request for Information

    @asu1
    Scenario: RFI form
      Given I open the "asu" page
      When I go to "Request Info" form
      And I select  degree,  area,  program in first step
      And i fill out fields in second step
      And I submit RFI form
      Then I verify that Thank you page is displayed