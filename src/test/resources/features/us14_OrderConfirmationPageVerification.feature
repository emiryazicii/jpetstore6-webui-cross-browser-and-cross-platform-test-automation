@us14
Feature: Order Confirmation Page Verification

  As a registered user of JPetStore,
  I want to ensure that the Order Confirmation page is correctly displayed and contains all necessary information,
  So that I can review and confirm my order details before finalizing my purchase.

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

  # This scenario verifies the presence of key elements on the Order Confirmation page.
  @us14ac01
  Scenario: Verifying Order Confirmation Page Elements
    When I enter the "Manx" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product ID for "Manx"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-14"
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
    And I should see the following single elements:
      | Order Header            |
      | Order Date And Time     |
      | Billing Address Header  |
      | Shipping Address Header |
      | Back Link               |
      | Confirm Button          |
    And I should see the following list of elements:
      | Billing Address Key Cells    |
      | Billing Address Value Cells  |
      | Shipping Address Key Cells   |
      | Shipping Address Value Cells |

  # This scenario verifies the correctness of the URLs for links on the Order Confirmation page.
  @us14ac02
  Scenario: Verifying Order Confirmation Page Links
    When I enter the "Dalmation" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product image for "Dalmation"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-9"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    When I click on the "Proceed To Checkout Button"
    Then I am on the "OrderForm" page
    And I retrieve my billing address information
    When I enter the payment details
    And I click on the "Ship To Different Address Checkbox"
    And I click on the "Continue Button"
    Then I am on the "ShippingAddress" page
    When I clear the shipping address input boxes
    And I enter the shipping address information
    And I click on the "Continue Button"
    Then I am on the "OrderConfirmation" page
    And The "href" value of the element should match the expected value:
      | Back Link      | https://petstore.octoperf.com/actions/Catalog.action                        |
      | Confirm Button | https://petstore.octoperf.com/actions/Order.action?newOrder=&confirmed=true |

  # This scenario verifies the details and functionality of the Order Confirmation page, including the confirmation message.
  @us14ac03
  Scenario: Verifying Order Confirmation Page Details and Submission
    When I enter the "Finch" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product image for "Finch"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-19"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    When I click on the "Proceed To Checkout Button"
    Then I am on the "OrderForm" page
    And I retrieve my billing address information
    When I enter the payment details
    And I click on the "Ship To Different Address Checkbox"
    And I click on the "Continue Button"
    Then I am on the "ShippingAddress" page
    When I clear the shipping address input boxes
    And I enter the shipping address information
    And I click on the "Continue Button"
    Then I am on the "OrderConfirmation" page
    And I retrieve the order date and time
    And The confirmation instruction message text should match expected value
      | Please confirm the information below and then press continue... |
    And The text of the element should match the expected value:
      | Order Header            | Order               |
      | Billing Address Header  | Billing Address     |
      | Shipping Address Header | Shipping Address    |
      | Confirm Button          | Confirm             |
      | Back Link               | Return to Main Menu |
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
    And My billing address information should match the expected value
    And My shipping address information should match the expected value
    When I click on the "Confirm Button"
    Then I am on the "OrderInformation" page
    And The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Order.action?newOrder=&confirmed=true" should match the expected value
    And I should see the following single elements:
      | Order Confirmation Message |
    And The text of the element should match the expected value:
      | Order Confirmation Message | Thank you, your order has been submitted. |