@us16
Feature: My Orders Page Verification

  As a registered user of JPetStore,
  I want to verify that the My Orders page displays accurate and complete details of my previous orders,
  So that I can view the details of my past orders.

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

  # This scenario verifies that the My Orders page displays all necessary elements and details correctly.
  @us16ac01
  Scenario: Verifying My Orders Page Elements and Information
    When I enter the "Iguana" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product image for "Iguana"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-13"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    And I retrieve the subtotal
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
    And I retrieve the order date and time
    When I click on the "Confirm Button"
    Then I am on the "OrderInformation" page
    And I retrieve the order ID
    When I click on the "My Account Link"
    Then I am on the "MyAccount" page
    When I click on the "My Orders Link"
    Then I am on the "MyOrders" page
    And I should see the following single elements:
      | My Orders Header |
    And I should see the following list of elements:
      | Table Headers |
    And The text of the element should match the expected value:
      | My Orders Header | My Orders |
    And The texts of the "Table Headers" should match the expected values:
      | Order ID    |
      | Date        |
      | Total Price |
    And The order information should match the expected value