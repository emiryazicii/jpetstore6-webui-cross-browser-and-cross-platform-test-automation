@us06
Feature: My Account Page Verification

  As a user of the JPetStore application,
  I want to ensure that the My Account page displays correctly and all functionalities work as expected,
  So that I can view and manage my account information accurately.

  Background:
    Given I am on the "Welcome" page
    Given I click on the "Enter The Store Link"
    Given I am on the "Catalog" page
    Given I click on the "Sign-In Link"
    Given I am on the "SignIn" page
    Given I click on the "Register Now Link"
    Given I am on the "Registration" page
    Given I create a new user account using randomly generated data
    Given I am on the "Catalog" page
    Given I click on the "Sign-In Link"
    Given I am on the "SignIn" page
    Given I log in with valid credentials
    Given I am on the "Catalog" page
    Given I click on the "My Account Link"
    Given I am on the "MyAccount" page

  # This scenario verifies that the page title and URL of the My Account page match the expected values
  @us06ac01
  Scenario: Verify Page Title and URL
    Then The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Account.action?editAccountForm=" should match the expected value

  # This scenario verifies that the My Account page contains the expected input fields, headers, checkboxes, buttons, and links.
  @us06ac02
  Scenario: Verify Presence of Page Elements
    Then I should see the following single elements:
      | Username Cell                   |
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
      | My Orders Link                  |
    And I should see the following list of elements:
      | Input Box Names |

  # This scenario verifies that the text and values of specified elements on the My Account page match the expected values.
  @us06ac03
  Scenario: Verify Text and Values of Elements
    Then The text of the element should match the expected value:
      | User Information Header    | User Information    |
      | Account Information Header | Account Information |
      | Profile Information Header | Profile Information |
      | My Orders Link             | My Orders           |
    And The "value" value of the element should match the expected value:
      | Save Account Information Button | Save Account Information |
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

  # This scenario verifies that the URL linked to the "My Orders" link matches the expected value.
  @us06ac04
  Scenario: Verify My Orders Link URL
    Then The "href" value of the element should match the expected value:
      | My Orders Link | https://petstore.octoperf.com/actions/Order.action?listOrders= |

  # This scenario verifies that the account information displayed on the My Account page matches the information provided during registration.
  @us06ac05
  Scenario: Verify Account Information Matches Registration Information
    When I retrieve my account information
    Then My account information should match my registration information

  # This scenario verifies that a user can update their account information, save it, and log in with the updated credentials.
  @us06ac06
  Scenario: Verify Account Update and Re-login
    When I update my account information
    And I click on the "Save Account Information Button"
    And I click on the "Sign-Out Link"
    Then I am on the "Catalog" page
    When I click on the "Sign-In Link"
    Then I am on the "SignIn" page
    When I login with updated password
    Then I am on the "Catalog" page
    And The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Catalog.action" should match the expected value
    And I should see the following single elements:
      | Welcome Message |
    And The text of the welcome message should match the expected value

  # This scenario verifies that the account information persists correctly after an update, save, sign-out, and re-login.
  @us06ac07
  Scenario: Verify Account Information Persistence After Update
    When I update my account information
    And I click on the "Save Account Information Button"
    And I click on the "Sign-Out Link"
    Then I am on the "Catalog" page
    When I click on the "Sign-In Link"
    Then I am on the "SignIn" page
    When I log in with valid credentials
    And I click on the "My Account Link"
    Then My account information should match my updated account information