@us15
Feature: Order Information Page Verification

  As a registered user of JPetStore,
  I want to verify that the Order Information page displays accurate details of my order,
  So that I can ensure my order was processed correctly and all information is correct after the process.

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

  # This scenario verifies that all expected elements are present on the Order Information page.
  @us15ac01
  Scenario: Verifying Order Information Page Elements
    When I enter the "Persian" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product image for "Persian"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-17"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    And I retrieve the item information for item ID "EST-17"
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
    And The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Order.action?newOrder=&confirmed=true" should match the expected value
    And I should see the following single elements:
      | Order Confirmation Message |
      | Back Link                  |
      | Order Number Date And Time |
      | Payment Details Header     |
      | Billing Address Header     |
      | Shipping Address Header    |
      | Subtotal Cell              |
      | Courier Key Cell           |
      | Courier Value Cell         |
      | Order Status Cell          |
    And I should see the following list of elements:
      | Item Info Table Headers      |
      | Payment Details Key Cells    |
      | Payment Details Value Cells  |
      | Billing Address Key Cells    |
      | Billing Address Value Cells  |
      | Shipping Address Key Cells   |
      | Shipping Address Value Cells |

  # This scenario verifies the correctness of the URLs for links on the Order Information page.
  @us15ac02
  Scenario: Verifying Order Information Page Links
    When I enter the "Poodle" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product image for "Poodle"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-8"
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
    When I click on the "Confirm Button"
    Then I am on the "OrderInformation" page
    And The "href" value of the element should match the expected value:
      | Back Link | https://petstore.octoperf.com/actions/Catalog.action |
    And The href value of the item link for the item "EST-8" should match the expected value:
      | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-8 |

  # This scenario verifies the correctness of specific details on the Order Information page, including text and values.
  @us15ac03
  Scenario: Verifying Order Information Page Details
    When I enter the "Chihuahua" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product image for "Chihuahua"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-26"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    And I retrieve the item information for item ID "EST-26"
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
    And The text of the element should match the expected value:
      | Order Confirmation Message | Thank you, your order has been submitted. |
      | Back Link                  | Return to Main Menu                       |
      | Payment Details Header     | Payment Details                           |
      | Billing Address Header     | Billing Address                           |
      | Shipping Address Header    | Shipping Address                          |
      | Courier Key Cell           | Courier:                                  |
    And The texts of the "Item Info Table Headers" should match the expected values:
      | Item ID     |
      | Description |
      | Quantity    |
      | Price       |
      | Total Cost  |
    And The texts of the "Payment Details Key Cells" should match the expected values:
      | Card Type:             |
      | Card Number:           |
      | Expiry Date (MM/YYYY): |
    And The texts of the "Billing Address Key Cells" should match the expected values:
      | First name: |
      | Last name:  |
      | Address 1:  |
      | Address 2:  |
      | City:       |
      | State:      |
      | Zip:        |
      | Country:    |
    And The texts of the "Shipping Address Key Cells" should match the expected values:
      | First name: |
      | Last name:  |
      | Address 1:  |
      | Address 2:  |
      | City:       |
      | State:      |
      | Zip:        |
      | Country:    |
    And The order date and time should match the expected value
    And The text of the card number warning match the expected value
      | * Fake number! |
    And The courier information should match the expected value
      | UPS |
    And The order status should match the expected value
      | P |
    And The subtotal should match the expected value
    And The payment details should match the expected value
    And The billing address should match the expected value
    And The shipping address should match the expected value
    And The item information for item ID "EST-26" should match the expected value