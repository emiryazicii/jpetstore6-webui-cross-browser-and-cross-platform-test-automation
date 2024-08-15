@us03
Feature: Help Page Verification

  As a user of the JPetStore application,
  I want to ensure that the "Help" page is displayed correctly and that all elements, links, and text are functioning as expected,
  So that I can easily find help and information about using the application.

  Background:
    Given I am on the "Welcome" page
    Given I click on the "Enter The Store Link"
    Given I am on the "Catalog" page
    Given I click on the "Help Link"
    Given I am on the "Help" page

  # This scenario verifies that the page title and URL of the Help page match the expected values.
  @us03ac01
  Scenario: Verify Page Title and URL
    Then The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/help.html" should match the expected value

  # This scenario verifies that the Help page contains the expected elements.
  @us03ac02
  Scenario: Verify Presence of Page Elements
    Then I should see the following single elements:
      | Copyright Subtitle |
    And I should see the following list of elements:
      | Header Links   |
      | All Headers    |
      | All Paragraphs |

  # This scenario verifies that the text of specified elements on the Help page match the expected values.
  @us03ac03
  Scenario: Verify Text of Elements
    Then The texts of the "Header Links" should match the expected values:
      | Signing Up                       |
      | Signing In                       |
      | Working with the Product Catalog |
      | Browsing the Catalog             |
      | Searching the Catalog            |
      | Working with the Shopping Cart   |
      | Adding and Removing Items        |
      | Updating the Quantity of an Item |
      | Ordering Items                   |
      | Reviewing an Order               |
      | Known Issues                     |
    And The texts of the "All Headers" should match the expected values:
      | JPetStore Demo                   |
      | Signing Up                       |
      | Signing In                       |
      | Working with the Product Catalog |
      | Browsing the Catalog             |
      | Searching the Catalog            |
      | Working with the Shopping Cart   |
      | Adding and Removing Items        |
      | Updating the Quantity of an Item |
      | Ordering Items                   |
      | Reviewing An Order               |
    And The text of the element should match the expected value:
      | Copyright Subtitle                         | Copyright www.mybatis.org                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
      | JPetStore Demo Paragraph                   | The JPetStore Demo is an online pet store. Like most e-stores, you can browse and search the product catalog, choose items to add to a shopping cart, amend the shopping cart, and order the items in the shopping cart. You can perform many of these actions without registering with or logging into the application. However, before you can order items you must log in (sign in) to the application. In order to sign in, you must have an account with the application, which is created when you register (sign up) with the application. |
      | Signing Up Paragraph                       | To sign up, click the Sign-in link at the right end of the banner. Next, click the New User link in the resulting page. Among other information, the signup page requires you to provide a user identifier and password. This information is used to identify your account and must be provided when signing in.                                                                                                                                                                                                                                  |
      | Working With The Product Catalog Paragraph | This section describes how to browse and search the product catalog.                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
      | Searching The Catalog Paragraph            | You search for products by typing the product name in search field in the middle of the banner.                                                                                                                                                                                                                                                                                                                                                                                                                                                   |
    And The texts of the "Signing In paragraphs" should match the expected values:
      | You sign in to the application by clicking the Sign-in link at the right end of the banner, filling in the user identifier and password, and clicking the Submit button.                                                                      |
      | You will also be redirected to the signin page when you try to place an order and you have not signed in. Once you have signed in, you can return to your shopping session by clicking the shopping cart icon at the right end of the banner. |
    And The texts of the "Browsing The Catalog Paragraphs" should match the expected values:
      | The pet store catalog is organized hierarchically as follows: categories, products, items.                                                                                                                                                                                    |
      | You list the pets in a category by clicking on the category name in the left column of the main page, or by clicking on the picture representing the category.                                                                                                                |
      | Once you select a category, the pet store will display a list of products within a category. Selecting a product displays a list of items and their prices. Selecting a product item displays a text and visual description of the item and the number of that item in stock. |
    And The texts of the "Adding And Removing Items Paragraphs" should match the expected values:
      | You add an item to your shopping cart by clicking the Add to Cart button to the right of an item. This action also displays your shopping cart. |
      | You can remove the item by clicking the Remove button to the left of the item.                                                                  |
      | To continue shopping, you select a product category from the list under the banner.                                                             |
    And The texts of the "Updating The Quantity Of An Item Paragraphs" should match the expected values:
      | You adjust the quantity of an item by typing the quantity in the item's Quantity field in the shopping cart and clicking the Update button.       |
      | If the quantity of items requested is greater than that in stock, the In Stock field in the shopping cart will show that the item is backordered. |
    And The texts of the "Ordering Item Paragraphs" should match the expected values:
      | You order the items in the shopping cart by selecting the Proceed to Checkout button. The pet store will display a read-only list of the shopping cart contents. To proceed with the checkout, click the Continue button.                                                                                                                                                                                                                                                                                                                                                           |
      | If you have not signed in, the application will display the signin page, where you will need to provide your account name and password. Otherwise, the application will display a page requesting payment and shipping information. When you have filled in the required information, you click the Submit button, and the application will display a read-only page containing your billing and shipping address. If you need to change any information, click your browser's Back button and enter the correct information. To complete the order, you click the Continue button. |
    And The texts of the "Reviewing An Order Paragraphs" should match the expected values:
      | The final screen contains your order information.                                                                                                                                            |
      | The application can be set up to send email confirmation of orders. This option can only be set when the application is deployed. See the installation instructions for further information. |

  # This scenario verifies that the href attributes of the header links on the Help page match the expected values.
  @us03ac04
  Scenario: Verify Header Link href Values
    Then The "href" values of the "Header Links" should match the expected values:
      | https://petstore.octoperf.com/help.html#SigningUp          |
      | https://petstore.octoperf.com/help.html#SigningIn          |
      | https://petstore.octoperf.com/help.html#Catalog            |
      | https://petstore.octoperf.com/help.html#CatalogBrowsing    |
      | https://petstore.octoperf.com/help.html#CatalogSearching   |
      | https://petstore.octoperf.com/help.html#ShoppingCart       |
      | https://petstore.octoperf.com/help.html#ShoppingCartAdd    |
      | https://petstore.octoperf.com/help.html#ShoppingCartUpdate |
      | https://petstore.octoperf.com/help.html#Ordering           |
      | https://petstore.octoperf.com/help.html#OrderReview        |
      | https://petstore.octoperf.com/help.html#Issues             |

  # This scenario verifies that clicking on the header links navigates to the expected sections within the Help page with the correct URL.
  @us03ac05
  Scenario Outline: Verify Navigation from Header Links
    When I click on the "<link>"
    Then The page title "JPetStore Demo" and the URL "<pageURL>" should match the expected value
    Examples:
      | link                                  | pageURL                                                    |
      | Signing Up Link                       | https://petstore.octoperf.com/help.html#SigningUp          |
      | Signing In Link                       | https://petstore.octoperf.com/help.html#SigningIn          |
      | Working With The Product Catalog Link | https://petstore.octoperf.com/help.html#Catalog            |
      | Browsing The Catalog Link             | https://petstore.octoperf.com/help.html#CatalogBrowsing    |
      | Searching The Catalog Link            | https://petstore.octoperf.com/help.html#CatalogSearching   |
      | Working With The Shopping Cart Link   | https://petstore.octoperf.com/help.html#ShoppingCart       |
      | Adding And Removing Items Link        | https://petstore.octoperf.com/help.html#ShoppingCartAdd    |
      | Updating The Quantity Of An Item Link | https://petstore.octoperf.com/help.html#ShoppingCartUpdate |
      | Ordering Items Link                   | https://petstore.octoperf.com/help.html#Ordering           |
      | Reviewing An Order Link               | https://petstore.octoperf.com/help.html#OrderReview        |
      | Known Issues Link                     | https://petstore.octoperf.com/help.html#Issues             |