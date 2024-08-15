@us01
Feature: Welcome Page Verification

  As a user of the JPetStore application,
  I want to verify that the "Welcome" page displays correctly and that all elements are functioning as expected,
  So that I can be confident that the page is correctly set up and can navigate to the store.

  Background:
    Given I am on the "Welcome" page

  # This scenario verifies that the page title and URL of the Welcome page match the expected values.
  @us01ac01
  Scenario: Verify Page Title and URL
    Then The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/" should match the expected value

  # This scenario verifies that the Welcome page contains the expected elements.
  @us01ac02
  Scenario: Verify Presence of Page Elements
    Then I should see the following single elements:
      | Welcome Header       |
      | Enter The Store Link |
      | Copyright Subtitle   |

  # This scenario verifies that the text of the specified elements on the Welcome page match the expected values.
  @us01ac03
  Scenario: Verify Text of Elements
    Then The text of the element should match the expected value:
      | Welcome Header       | Welcome to JPetStore 6    |
      | Enter The Store Link | Enter the Store           |
      | Copyright Subtitle   | Copyright www.mybatis.org |

  # This scenario verifies that the URL of the "Enter The Store" link matches the expected value.
  @us01ac04
  Scenario: Verify Link URL
    Then The "href" value of the element should match the expected value:
      | Enter The Store Link | https://petstore.octoperf.com/actions/Catalog.action |

  # This scenario verifies that clicking on the "Enter The Store" link navigates to the Catalog page and the title and URL match the expected values.
  @us01ac05
  Scenario: Verify Navigation to Catalog Page
    When I click on the "Enter The Store Link"
    Then I am on the "Catalog" page
    And The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Catalog.action" should match the expected value