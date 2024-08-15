@us13
Feature: Shipping Address Page Verification

  As a registered user of the JPetStore,
  I want to ensure that the Shipping Address page is correctly displayed and functions as expected,
  So that I can provide or verify shipping details before finalizing my order.

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
    Given I retrieve my address information

  # This scenario verifies the presence of specific elements on the Shipping Address page.
  @us13ac01
  Scenario: Verifying Shipping Address Page Elements
    When I enter the "Rattlesnake" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product description for "Rattlesnake"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-11"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    When I click on the "Proceed To Checkout Button"
    Then I am on the "OrderForm" page
    When I enter the payment details
    And I click on the "Ship To Different Address Checkbox"
    And I click on the "Continue Button"
    Then I am on the "ShippingAddress" page
    And I should see the following single elements:
      | Shipping Address Header |
      | Continue Button         |
    And I should see the following list of elements:
      | Shipping Address Input Box Names |
      | Shipping Address Input Boxes     |

  # This scenario verifies the text and default values displayed on the Shipping Address page.
  @us13ac02
  Scenario: Verifying Shipping Address Page Values and Texts
    When I enter the "Bulldog" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product description for "Bulldog"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-7"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    When I click on the "Proceed To Checkout Button"
    Then I am on the "OrderForm" page
    When I enter the payment details
    And I click on the "Ship To Different Address Checkbox"
    And I click on the "Continue Button"
    Then I am on the "ShippingAddress" page
    And The "value" value of the element should match the expected value:
      | Continue Button | Continue |
    And The text of the element should match the expected value:
      | Shipping Address Header | Shipping Address |
    And The texts of the "Shipping Address Input Box Names" should match the expected values:
      | First name: |
      | Last name:  |
      | Address 1:  |
      | Address 2:  |
      | City:       |
      | State:      |
      | Zip:        |
      | Country:    |
    And My address information and default shipping address information should match

  # This scenario verifies the functionality of submitting a shipping address on the Shipping Address page.
  @us13ac03
  Scenario: Verifying Shipping Address Submission
    When I enter the "Iguana" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product description for "Iguana"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-13"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    When I click on the "Proceed To Checkout Button"
    Then I am on the "OrderForm" page
    When I enter the payment details
    And I click on the "Ship To Different Address Checkbox"
    And I click on the "Continue Button"
    Then I am on the "ShippingAddress" page
    When I clear the shipping address input boxes
    And I enter the shipping address information
    And I click on the "Continue Button"
    Then I am on the "OrderConfirmation" page
    And The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Order.action" should match the expected value