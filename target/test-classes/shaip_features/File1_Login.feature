Feature: Check login funcationality of Enterprise Portal

  Background: setup method must be invoked
    Given User must be on EP login page

  Scenario Outline: verify user is able to login successfully in enterprise portal with valid username and password
    When user enters valid <username>, valid <password> and hit enter button
    Then user login is success and user navigated to Landing page and verify copyright text

    Examples: 
      | username                 | password     |
      | parth.parikh@shaip.com   | P@ssw0rd@123 |
      | c.orac@yopmail.com       | CyOFA@0274   |
      | 6hesham2092m@soantiy.com | UFtoB@6176   |

  Scenario Outline: verify user is not able to login  in enterprise portal with invalid username and password
    When user enters invalid <username>, invalid <password> and hit enter button and  user error message should get display

    Examples: 
      | username                | password     |
      | parth.parikh@sdhaip.com | P@ssw0rd@123 |
      | c.orac@yopmadil.com     | CyOFA@0274   |

  Scenario Outline: verify menu permission based on user login
    When user enters valid <username>, valid <password> and hit enter button
    Then user login is success and user navigated to Landing page and verify copyright text
    Then verify menu permission of user based on logged in <username>

    Examples: 
      | username                 | password     |
      | parth.parikh@shaip.com   | P@ssw0rd@123 |
      | c.orac@yopmail.com       | CyOFA@0274   |
      | 6hesham2092m@soantiy.com | UFtoB@6176   |
