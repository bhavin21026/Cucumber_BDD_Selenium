Feature: Check Custome user  functionality

  
  Background: setup method must be invoked
    Given User must be on EP login page
    When user enters valid "parth.parikh@shaip.com", valid "P@ssw0rd@123" and hit enter buttons
    Then user login is success and user navigated to Landing page and verify copyright text
    When User clicks on "Administration" menu from landing page
    And select "Customers" as a submenu
    And Start searching by "Manoj Patel1" from global search menu and verify searched results

  
 @one 
  Scenario: Verify as a admin user i should be able to create new customer user from users tab of customer
    When user clicks on Users tab
    And click on Add Customer User button
    And clicks on Add New User button
    Then verify add new customer user functionality by filling all mendatory details
    Then verify user created successfully
