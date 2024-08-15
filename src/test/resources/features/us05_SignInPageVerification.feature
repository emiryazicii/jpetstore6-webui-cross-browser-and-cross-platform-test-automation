@us05
Feature: Sign-In Page Verification

  As a user of the JPetStore application,
  I want to ensure that the Sign-In page is displayed correctly and functions as expected,
  So that I can log in with valid credentials or handle errors if the credentials are invalid.

  Background:
    Given I am on the "Welcome" page
    Given I click on the "Enter The Store Link"
    Given I am on the "Catalog" page
    Given I click on the "Sign-In Link"
    Given I am on the "SignIn" page

  # This scenario verifies that the page title and URL of the Sign-In page match the expected values.
  @us05ac01
  Scenario: Verify Page Title and URL
    Then The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Account.action?signonForm=" should match the expected value

  # This scenario verifies that the Sign-In page contains the expected input fields, messages, and buttons.
  @us05ac02
  Scenario: Verify Presence of Page Elements
    Then I should see the following single elements:
      | Login Helper Message                  |
      | Username Input Box                    |
      | Password Input Box                    |
      | Registration Helper Message           |
      | Register Now Link                     |
      | Login Button                          |
      | Username And Password Input Box Names |

  # This scenario verifies that the text and values of specified elements on the Sign-In page match the expected values.
  @us05ac03
  Scenario: Verify Text and Values of Elements
    Then The text of the element should match the expected value:
      | Login Helper Message | Please enter your username and password. |
      | Register Now Link    | Register Now!                            |
    And The text of the registration helper message should match the expected value
      | Need a user name and password? Register Now! |
    And The text of the username input box name should match the expected value
      | Username: |
    And The text of the password input box name should match the expected value
      | Password: |
    And The "value" value of the element should match the expected value:
      | Login Button | Login |

  # This scenario verifies that the URL linked to the "Register Now" link matches the expected value.
  @us05ac04
  Scenario: Verify Register Now Link URL
    Then The "href" value of the element should match the expected value:
      | Register Now Link | https://petstore.octoperf.com/actions/Account.action?newAccountForm= |

  # This scenario verifies that an appropriate error message is displayed when invalid login credentials are entered.
  @us05ac05
  Scenario:  Verify Error Message for Invalid Login Credentials
    When I enter the "invalidUsername" in the "Username Input Box"
    And I clear the "Password Input Box"
    And I enter the "invalidPassword" in the "Password Input Box"
    And I click on the "Login Button"
    Then I should see the following single elements:
      | Failed Sign-On Message |
    And The text of the element should match the expected value:
      | Failed Sign-On Message | Invalid username or password. Signon failed. |

  # This scenario verifies that a user can successfully register, log in, and log out of the application.
  @us05ac06
  Scenario: Verify User Registration and Login Flow
    When I click on the "Register Now Link"
    Then I am on the "Registration" page
    When I create a new user account using randomly generated data
    Then I am on the "Catalog" page
    When I click on the "Sign-In Link"
    Then I am on the "SignIn" page
    When I log in with valid credentials
    Then I am on the "Catalog" page
    And I should see the following single elements:
      | Welcome Message |
    And The text of the welcome message should match the expected value
    When I click on the "Sign-Out link"
    Then I am on the "Catalog" page
    And I should see the following single elements:
      | Sign-In Link |
    And The text of the element should match the expected value:
      | Sign-In Link | Sign In |