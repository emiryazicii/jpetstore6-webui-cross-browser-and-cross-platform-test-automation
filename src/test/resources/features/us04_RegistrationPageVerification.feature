@us04
Feature: Registration Page Verification

  As a user of the JPetStore application,
  I want to verify that the Registration page is correctly displayed and that all input fields, dropdowns, and buttons function as expected,
  So that I can successfully create a new user account with accurate and complete information.

  Background:
    Given I am on the "Welcome" page
    Given I click on the "Enter The Store Link"
    Given I am on the "Catalog" page
    Given I click on the "Sign-In Link"
    Given I am on the "SignIn" page
    Given I click on the "Register Now Link"
    Given I am on the "Registration" page

  # This scenario verifies that the page title and URL of the Registration page match the expected values.
  @us04ac01
  Scenario: Verify Page Title and URL
    Then The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Account.action?newAccountForm=" should match the expected value

  # This scenario verifies that the Registration page contains the expected input fields, dropdowns, checkboxes, and buttons.
  @us04ac02
  Scenario: Verify Presence of Page Elements
    Then I should see the following single elements:
      | User Id Input Box               |
      | New Password Input Box          |
      | Repeat Password Input Box       |
      | Firstname Input Box             |
      | Lastname Input Box              |
      | Email Input Box                 |
      | Phone Input Box                 |
      | Address1 Input Box              |
      | Address2 Input Box              |
      | City Input Box                  |
      | State Input Box                 |
      | Zip Input Box                   |
      | Country Input Box               |
      | Language Preference Dropdown    |
      | Favourite Category Dropdown     |
      | Enable My List Checkbox         |
      | Enable My Banner Checkbox       |
      | Save Account Information Button |
      | User Information Header         |
      | Account Information Header      |
      | Profile Information Header      |

  # This scenario verifies that the text and values of specified elements on the Registration page match the expected values.
  @us04ac03
  Scenario: Verify Text and Values of Elements
    Then The text of the element should match the expected value:
      | User Information Header    | User Information    |
      | Account Information Header | Account Information |
      | Profile Information Header | Profile Information |
    And The "value" value of the element should match the expected value:
      | Save Account Information Button | Save Account Information |
    And The first selected option text of the following dropdown should match the expected value
      | Language Preference Dropdown | english |
      | Favourite Category Dropdown  | FISH    |
    And The all options texts of the "Language Preference Dropdown" should match the expected values:
      | english  |
      | japanese |
    And The all options texts of the "Favourite Category Dropdown" should match the expected values:
      | FISH     |
      | DOGS     |
      | REPTILES |
      | CATS     |
      | BIRDS    |
    And The texts of the "User Information Input Box Names" should match the expected values:
      | User ID:         |
      | New password:    |
      | Repeat password: |
    And The texts of the "Account Information Input Box Names" should match the expected values:
      | First name: |
      | Last name:  |
      | Email:      |
      | Phone:      |
      | Address 1:  |
      | Address 2:  |
      | City:       |
      | State:      |
      | Zip:        |
      | Country:    |
    And The texts of the "Profile Information Dropdown And Checkbox Names" should match the expected values:
      | Language Preference: |
      | Favourite Category:  |
      | Enable MyList        |
      | Enable MyBanner      |
    And The status of the "enable my list checkbox" should match the expected value "unchecked"
    And The status of the "enable my banner checkbox" should match the expected value "unchecked"

  # This scenario verifies that a new user account can be created using randomly generated data and that the user is correctly navigated to the Catalog page after account creation.
  @us04ac04
  Scenario: Create New Account and Verify Navigation
    When I create a new user account using randomly generated data
    Then I am on the "Catalog" page
    And The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Catalog.action" should match the expected value