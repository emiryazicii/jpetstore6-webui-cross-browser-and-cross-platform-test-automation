@us12
Feature: Order Form Page Verification

  As a registered user of the JPetStore,
  I want to ensure that the Order Form page is correctly displayed and functions as expected,
  So that I can review and confirm my payment and shipping details before finalizing my purchase.

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

  # This scenario verifies the presence of specific elements on the Order Form page.
  @us12ac01
  Scenario: Verifying Order Form Page Elements
    When I enter the "Angelfish" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product image for "Angelfish"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-1"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    When I click on the "Proceed To Checkout Button"
    Then I am on the "OrderForm" page
    And I should see the following single elements:
      | Ship To Different Address Checkbox |
      | Continue Button                    |
      | Payment Details Header             |
      | Billing Address Header             |
      | Checkbox Description               |
      | Card Number Warning                |
    And I should see the following list of elements:
      | Payment Details Input Box Names |
      | Billing Address Input Box Names |
      | Payment Details Input Boxes     |
      | Billing Address Input Boxes     |

  # This scenario verifies the text and default values displayed on the Order Form page.
  @us12ac02
  Scenario: Verifying Order Form Page Values and Texts
    When I enter the "Koi" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product image for "Koi"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-5"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    When I click on the "Proceed To Checkout Button"
    Then I am on the "OrderForm" page
    And The "value" value of the element should match the expected value:
      | Continue Button | Continue |
    And The text of the element should match the expected value:
      | Payment Details Header | Payment Details              |
      | Billing Address Header | Billing Address              |
      | Checkbox Description   | Ship to different address... |
      | Card Number Warning    | * Use a fake number!         |
    And The texts of the "Payment Details Input Box Names" should match the expected values:
      | Card Type:             |
      | Card Number:           |
      | Expiry Date (MM/YYYY): |
    And The texts of the "Billing Address Input Box Names" should match the expected values:
      | First name: |
      | Last name:  |
      | Address 1:  |
      | Address 2:  |
      | City:       |
      | State:      |
      | Zip:        |
      | Country:    |
    And The default values of the payment details should match the expected values:
      | cardType   | Visa               |
      | cardNumber | 999 9999 9999 9999 |
      | expiryDate | 12/03              |
    And My address information and default billing address information should match

  # This scenario verifies the navigation to the Shipping Address page and checks page title and URL.
  @us12ac03
  Scenario: Verifying Shipping Address Page Navigation
    When I enter the "Goldfish" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product image for "Goldfish"
    Then I am on the "Product" page
    When I click on the item link for item ID "EST-21"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    When I click on the "Proceed To Checkout Button"
    Then I am on the "OrderForm" page
    When I enter the payment details
    And I click on the "Ship To Different Address Checkbox"
    And I click on the "Continue Button"
    Then I am on the "ShippingAddress" page
    And The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Order.action" should match the expected value