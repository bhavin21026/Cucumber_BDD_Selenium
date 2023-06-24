Feature: Check Customer module functionality

  Background: setup method must be invoked
    Given User must be on EP login page
     When user enters valid "parth.parikh@shaip.com", valid "P@ssw0rd@123" and hit enter buttons
    Then user login is success and user navigated to Landing page and verify copyright text

  
  
  Scenario: Verify as a admin user i should be able to create new customer
    When User clicks on "Administration" menu from landing page
    And select "Customers" as a submenu
    And click on Add customer button from customer listing screen
    And Add new customer by filling or mandatory fileds
    Then Verify customer created successfully with all given values

 
 
 
  Scenario: Verify as a admin user i should be able to search newly created  customer
    When User clicks on "Administration" menu from landing page
    And select "Customers" as a submenu
    And Start searching by "Manoj1" from global search menu and verify searched results

  
  
  Scenario: Verify as a admin user i should be able to Edit newly created  customer from listing page
    When User clicks on "Administration" menu from landing page
    And select "Customers" as a submenu
    Then Verify edit and verify newly created customer details from listing page

 
 
 
  Scenario: Verify as a admin user i should be able to Edit newly created  customer from Details page
    When User clicks on "Administration" menu from landing page
    And select "Customers" as a submenu
    Then Verify edit and verify newly created customer details from customer details page
