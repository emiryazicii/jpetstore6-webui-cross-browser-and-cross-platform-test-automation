@us10
Feature: Cart Page Verification

  As a user of the JPetStore application,
  I want to be able to add items to my cart and verify the cart page,
  So that I can ensure that the cart displays the correct items and information.

  Background:
    Given I am on the "Welcome" page
    Given I click on the "Enter The Store Link"
    Given I am on the "Catalog" page

  # This scenario verifies that after adding an item to the cart, the user is redirected to the Cart page with the correct URL and page title.
  @us10ac01
  Scenario Outline: Verify Cart Page URL and Title
    When I click on the "<categoryName>" in the sidebar section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    And The page title "JPetStore Demo" and the URL "<addToCartButtonURL>" should match the expected value
    Examples:
      | categoryName | productId | itemId | addToCartButtonURL                                                                    |
      | Fish         | FI-SW-01  | EST-1  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-1  |
      | Fish         | FI-SW-01  | EST-2  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-2  |
      | Fish         | FI-SW-02  | EST-3  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-3  |
      | Fish         | FI-FW-01  | EST-4  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-4  |
      | Fish         | FI-FW-01  | EST-5  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-5  |
      | Fish         | FI-FW-02  | EST-20 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-20 |
      | Fish         | FI-FW-02  | EST-21 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-21 |
      | Dogs         | K9-BD-01  | EST-6  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-6  |
      | Dogs         | K9-BD-01  | EST-7  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-7  |
      | Dogs         | K9-PO-02  | EST-8  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-8  |
      | Dogs         | K9-DL-01  | EST-9  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-9  |
      | Dogs         | K9-DL-01  | EST-10 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-10 |
      | Dogs         | K9-RT-01  | EST-28 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-28 |
      | Dogs         | K9-RT-02  | EST-22 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-22 |
      | Dogs         | K9-RT-02  | EST-23 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-23 |
      | Dogs         | K9-RT-02  | EST-24 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-24 |
      | Dogs         | K9-RT-02  | EST-25 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-25 |
      | Dogs         | K9-CW-01  | EST-26 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-26 |
      | Dogs         | K9-CW-01  | EST-27 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-27 |
      | Cats         | FL-DSH-01 | EST-14 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-14 |
      | Cats         | FL-DSH-01 | EST-15 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-15 |
      | Cats         | FL-DLH-02 | EST-16 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-16 |
      | Cats         | FL-DLH-02 | EST-17 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-17 |
      | Reptiles     | RP-SN-01  | EST-11 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-11 |
      | Reptiles     | RP-SN-01  | EST-12 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-12 |
      | Reptiles     | RP-LI-02  | EST-13 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-13 |
      | Birds        | AV-SB-02  | EST-19 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-19 |
      | Birds        | AV-CB-01  | EST-18 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-18 |

  # This scenario checks that specific elements are present on the Cart page, including headers, buttons, and item-related elements.
  @us10ac02
  Scenario Outline: Verify Cart Page Elements
    When I click on the "<categoryName>" in the sidebar section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    And I should see the following single elements:
      | Shopping Cart Header       |
      | Back Link                  |
      | Update Cart Button         |
      | Proceed To Checkout Button |
      | Subtotal Cell              |
    And I should see the following list of elements:
      | Table Headers  |
      | Remove Buttons |
    Examples:
      | categoryName | productId | itemId |
      | Fish         | FI-SW-01  | EST-1  |
      | Fish         | FI-SW-01  | EST-2  |
      | Fish         | FI-SW-02  | EST-3  |
      | Fish         | FI-FW-01  | EST-4  |
      | Fish         | FI-FW-01  | EST-5  |
      | Fish         | FI-FW-02  | EST-20 |
      | Fish         | FI-FW-02  | EST-21 |
      | Dogs         | K9-BD-01  | EST-6  |
      | Dogs         | K9-BD-01  | EST-7  |
      | Dogs         | K9-PO-02  | EST-8  |
      | Dogs         | K9-DL-01  | EST-9  |
      | Dogs         | K9-DL-01  | EST-10 |
      | Dogs         | K9-RT-01  | EST-28 |
      | Dogs         | K9-RT-02  | EST-22 |
      | Dogs         | K9-RT-02  | EST-23 |
      | Dogs         | K9-RT-02  | EST-24 |
      | Dogs         | K9-RT-02  | EST-25 |
      | Dogs         | K9-CW-01  | EST-26 |
      | Dogs         | K9-CW-01  | EST-27 |
      | Cats         | FL-DSH-01 | EST-14 |
      | Cats         | FL-DSH-01 | EST-15 |
      | Cats         | FL-DLH-02 | EST-16 |
      | Cats         | FL-DLH-02 | EST-17 |
      | Reptiles     | RP-SN-01  | EST-11 |
      | Reptiles     | RP-SN-01  | EST-12 |
      | Reptiles     | RP-LI-02  | EST-13 |
      | Birds        | AV-SB-02  | EST-19 |
      | Birds        | AV-CB-01  | EST-18 |

  # This scenario ensures that the texts and values displayed on the Cart page match the expected values for headers, buttons, and item details.
  @us10ac03
  Scenario Outline: Verify Texts and Values on Cart Page
    When I click on the "<categoryName>" in the quick links section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    And I retrieve the most recent stock information
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    And The text of the element should match the expected value:
      | Shopping Cart Header       | Shopping Cart       |
      | Back Link                  | Return to Main Menu |
      | Proceed To Checkout Button | Proceed to Checkout |
    And The "value" value of the element should match the expected value:
      | Update Cart Button | Update Cart |
    And The texts of the "Table Headers" should match the expected values:
      | Item ID     |
      | Product ID  |
      | Description |
      | In Stock?   |
      | Quantity    |
      | List Price  |
      | Total Cost  |
    And The text of the remove button for item ID "<itemId>" should match the expected value "Remove"
    And The item data for item ID "<itemId>" should match the expected value
      | Item ID     | <itemId>      |
      | Product ID  | <productId>   |
      | Description | <description> |
      | Quantity    | 1             |
      | List Price  | <listPrice>   |
      | Total Cost  | <totalCost>   |
    And The subtotal should match the expected value:
      | <subTotal> |
    Examples:
      | categoryName | productId | itemId | description                     | listPrice | totalCost | subTotal |
      | Fish         | FI-SW-01  | EST-1  | Large Angelfish                 | $16.50    | $16.50    | $16.50   |
      | Fish         | FI-SW-01  | EST-2  | Small Angelfish                 | $16.50    | $16.50    | $16.50   |
      | Fish         | FI-SW-02  | EST-3  | Toothless Tiger Shark           | $18.50    | $18.50    | $18.50   |
      | Fish         | FI-FW-01  | EST-4  | Spotted Koi                     | $18.50    | $18.50    | $18.50   |
      | Fish         | FI-FW-01  | EST-5  | Spotless Koi                    | $18.50    | $18.50    | $18.50   |
      | Fish         | FI-FW-02  | EST-20 | Adult Male Goldfish             | $5.50     | $5.50     | $5.50    |
      | Fish         | FI-FW-02  | EST-21 | Adult Female Goldfish           | $5.29     | $5.29     | $5.29    |
      | Dogs         | K9-BD-01  | EST-6  | Male Adult Bulldog              | $18.50    | $18.50    | $18.50   |
      | Dogs         | K9-BD-01  | EST-7  | Female Puppy Bulldog            | $18.50    | $18.50    | $18.50   |
      | Dogs         | K9-PO-02  | EST-8  | Male Puppy Poodle               | $18.50    | $18.50    | $18.50   |
      | Dogs         | K9-DL-01  | EST-9  | Spotless Male Puppy Dalmation   | $18.50    | $18.50    | $18.50   |
      | Dogs         | K9-DL-01  | EST-10 | Spotted Adult Female Dalmation  | $18.50    | $18.50    | $18.50   |
      | Dogs         | K9-RT-01  | EST-28 | Adult Female Golden Retriever   | $155.29   | $155.29   | $155.29  |
      | Dogs         | K9-RT-02  | EST-22 | Adult Male Labrador Retriever   | $135.50   | $135.50   | $135.50  |
      | Dogs         | K9-RT-02  | EST-23 | Adult Female Labrador Retriever | $145.49   | $145.49   | $145.49  |
      | Dogs         | K9-RT-02  | EST-24 | Adult Male Labrador Retriever   | $255.50   | $255.50   | $255.50  |
      | Dogs         | K9-RT-02  | EST-25 | Adult Female Labrador Retriever | $325.29   | $325.29   | $325.29  |
      | Dogs         | K9-CW-01  | EST-26 | Adult Male Chihuahua            | $125.50   | $125.50   | $125.50  |
      | Dogs         | K9-CW-01  | EST-27 | Adult Female Chihuahua          | $155.29   | $155.29   | $155.29  |
      | Reptiles     | RP-SN-01  | EST-11 | Venomless Rattlesnake           | $18.50    | $18.50    | $18.50   |
      | Reptiles     | RP-SN-01  | EST-12 | Rattleless Rattlesnake          | $18.50    | $18.50    | $18.50   |
      | Reptiles     | RP-LI-02  | EST-13 | Green Adult Iguana              | $18.50    | $18.50    | $18.50   |
      | Cats         | FL-DSH-01 | EST-14 | Tailless Manx                   | $58.50    | $58.50    | $58.50   |
      | Cats         | FL-DSH-01 | EST-15 | With tail Manx                  | $23.50    | $23.50    | $23.50   |
      | Cats         | FL-DLH-02 | EST-16 | Adult Female Persian            | $93.50    | $93.50    | $93.50   |
      | Cats         | FL-DLH-02 | EST-17 | Adult Male Persian              | $93.50    | $93.50    | $93.50   |
      | Birds        | AV-SB-02  | EST-19 | Adult Male Finch                | $15.50    | $15.50    | $15.50   |
      | Birds        | AV-CB-01  | EST-18 | Adult Male Amazon Parrot        | $193.50   | $193.50   | $193.50  |

  # This scenario confirms that the "Remove" button and other navigation links on the Cart page have the correct href values.
  @us10ac04
  Scenario Outline: Verify Remove Button and Other Links
    When I click on the "<categoryName>" in the main image section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    And The href value of the remove button for item ID "<itemId>" should match the expected value "<removeButtonHrefValue>"
    And The "href" value of the element should match the expected value:
      | Proceed To Checkout Button | https://petstore.octoperf.com/actions/Order.action?newOrderForm= |
      | Back Link                  | https://petstore.octoperf.com/actions/Catalog.action             |
    Examples:
      | categoryName | productId | itemId | removeButtonHrefValue                                                                      |
      | Fish         | FI-SW-01  | EST-1  | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-1  |
      | Fish         | FI-SW-01  | EST-2  | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-2  |
      | Fish         | FI-SW-02  | EST-3  | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-3  |
      | Fish         | FI-FW-01  | EST-4  | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-4  |
      | Fish         | FI-FW-01  | EST-5  | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-5  |
      | Fish         | FI-FW-02  | EST-20 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-20 |
      | Fish         | FI-FW-02  | EST-21 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-21 |
      | Dogs         | K9-BD-01  | EST-6  | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-6  |
      | Dogs         | K9-BD-01  | EST-7  | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-7  |
      | Dogs         | K9-PO-02  | EST-8  | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-8  |
      | Dogs         | K9-DL-01  | EST-9  | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-9  |
      | Dogs         | K9-DL-01  | EST-10 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-10 |
      | Dogs         | K9-RT-01  | EST-28 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-28 |
      | Dogs         | K9-RT-02  | EST-22 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-22 |
      | Dogs         | K9-RT-02  | EST-23 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-23 |
      | Dogs         | K9-RT-02  | EST-24 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-24 |
      | Dogs         | K9-RT-02  | EST-25 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-25 |
      | Dogs         | K9-CW-01  | EST-26 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-26 |
      | Dogs         | K9-CW-01  | EST-27 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-27 |
      | Reptiles     | RP-SN-01  | EST-11 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-11 |
      | Reptiles     | RP-SN-01  | EST-12 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-12 |
      | Reptiles     | RP-LI-02  | EST-13 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-13 |
      | Cats         | FL-DSH-01 | EST-14 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-14 |
      | Cats         | FL-DSH-01 | EST-15 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-15 |
      | Cats         | FL-DLH-02 | EST-16 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-16 |
      | Cats         | FL-DLH-02 | EST-17 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-17 |
      | Birds        | AV-SB-02  | EST-19 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-19 |
      | Birds        | AV-CB-01  | EST-18 | https://petstore.octoperf.com/actions/Cart.action?removeItemFromCart=&workingItemId=EST-18 |

  # This scenario tests that after updating the quantity of an item in the cart, the Cart page reflects the correct quantity, total cost, and subtotal.
  @us10ac05
  Scenario Outline: Verify Cart Updates and Quantities
    When I click on the "<categoryName>" in the sidebar section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    And I retrieve the most recent stock information
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    When I enter the quantity "<quantity>" for item id "<itemId>"
    And I click on the "Update Cart Button"
    Then The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Cart.action" should match the expected value
    And The item data for item ID "<itemId>" should match the expected value
      | Item ID     | <itemId>      |
      | Product ID  | <productId>   |
      | Description | <description> |
      | Quantity    | <quantity>    |
      | List Price  | <listPrice>   |
      | Total Cost  | <totalCost>   |
    And The subtotal should match the expected value:
      | <subTotal> |
    Examples:
      | categoryName | productId | itemId | description                     | listPrice | quantity | totalCost | subTotal  |
      | Fish         | FI-SW-01  | EST-1  | Large Angelfish                 | $16.50    | 2        | $33.00    | $33.00    |
      | Fish         | FI-SW-01  | EST-2  | Small Angelfish                 | $16.50    | 3        | $49.50    | $49.50    |
      | Fish         | FI-SW-02  | EST-3  | Toothless Tiger Shark           | $18.50    | 4        | $74.00    | $74.00    |
      | Fish         | FI-FW-01  | EST-4  | Spotted Koi                     | $18.50    | 5        | $92.50    | $92.50    |
      | Fish         | FI-FW-01  | EST-5  | Spotless Koi                    | $18.50    | 2        | $37.00    | $37.00    |
      | Fish         | FI-FW-02  | EST-20 | Adult Male Goldfish             | $5.50     | 3        | $16.50    | $16.50    |
      | Fish         | FI-FW-02  | EST-21 | Adult Female Goldfish           | $5.29     | 4        | $21.16    | $21.16    |
      | Dogs         | K9-BD-01  | EST-6  | Male Adult Bulldog              | $18.50    | 5        | $92.50    | $92.50    |
      | Dogs         | K9-BD-01  | EST-7  | Female Puppy Bulldog            | $18.50    | 2        | $37.00    | $37.00    |
      | Dogs         | K9-PO-02  | EST-8  | Male Puppy Poodle               | $18.50    | 3        | $55.50    | $55.50    |
      | Dogs         | K9-DL-01  | EST-9  | Spotless Male Puppy Dalmation   | $18.50    | 4        | $74.00    | $74.00    |
      | Dogs         | K9-DL-01  | EST-10 | Spotted Adult Female Dalmation  | $18.50    | 5        | $92.50    | $92.50    |
      | Dogs         | K9-RT-01  | EST-28 | Adult Female Golden Retriever   | $155.29   | 2        | $310.58   | $310.58   |
      | Dogs         | K9-RT-02  | EST-22 | Adult Male Labrador Retriever   | $135.50   | 3        | $406.50   | $406.50   |
      | Dogs         | K9-RT-02  | EST-23 | Adult Female Labrador Retriever | $145.49   | 4        | $581.96   | $581.96   |
      | Dogs         | K9-RT-02  | EST-24 | Adult Male Labrador Retriever   | $255.50   | 5        | $1,277.50 | $1,277.50 |
      | Dogs         | K9-RT-02  | EST-25 | Adult Female Labrador Retriever | $325.29   | 2        | $650.58   | $650.58   |
      | Dogs         | K9-CW-01  | EST-26 | Adult Male Chihuahua            | $125.50   | 3        | $376.50   | $376.50   |
      | Dogs         | K9-CW-01  | EST-27 | Adult Female Chihuahua          | $155.29   | 4        | $621.16   | $621.16   |
      | Cats         | FL-DSH-01 | EST-14 | Tailless Manx                   | $58.50    | 4        | $234.00   | $234.00   |
      | Cats         | FL-DSH-01 | EST-15 | With tail Manx                  | $23.50    | 4        | $94.00    | $94.00    |
      | Cats         | FL-DLH-02 | EST-16 | Adult Female Persian            | $93.50    | 5        | $467.50   | $467.50   |
      | Cats         | FL-DLH-02 | EST-17 | Adult Male Persian              | $93.50    | 2        | $187.00   | $187.00   |
      | Reptiles     | RP-SN-01  | EST-11 | Venomless Rattlesnake           | $18.50    | 5        | $92.50    | $92.50    |
      | Reptiles     | RP-SN-01  | EST-12 | Rattleless Rattlesnake          | $18.50    | 2        | $37.00    | $37.00    |
      | Reptiles     | RP-LI-02  | EST-13 | Green Adult Iguana              | $18.50    | 3        | $55.50    | $55.50    |
      | Birds        | AV-CB-01  | EST-18 | Adult Male Amazon Parrot        | $193.50   | 3        | $580.50   | $580.50   |
      | Birds        | AV-SB-02  | EST-19 | Adult Male Finch                | $15.50    | 4        | $62.00    | $62.00    |

  # This scenario outlines the process of adding an item to the cart and then removing it to ensure that the cart correctly reflects the empty state.
  # It verifies that the empty cart message is displayed, and the subtotal is updated to $0.00.
  @us10ac06
  Scenario Outline: Remove item from cart and verify empty state
    When I click on the "<categoryName>" in the quick links section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    When I click on the "Add To Cart Button"
    Then I am on the "Cart" page
    And I click on the remove button for item id "<itemId>"
    And I should see the following single elements:
      | Empty Cart Message |
    And The text of the element should match the expected value:
      | Empty Cart Message | Your cart is empty. |
    And The subtotal should match the expected value:
      | $0.00 |
    Examples:
      | categoryName | productId | itemId |
      | Fish         | FI-SW-01  | EST-1  |
      | Fish         | FI-SW-01  | EST-2  |
      | Fish         | FI-SW-02  | EST-3  |
      | Fish         | FI-FW-01  | EST-4  |
      | Fish         | FI-FW-01  | EST-5  |
      | Fish         | FI-FW-02  | EST-20 |
      | Fish         | FI-FW-02  | EST-21 |
      | Dogs         | K9-BD-01  | EST-6  |
      | Dogs         | K9-BD-01  | EST-7  |
      | Dogs         | K9-PO-02  | EST-8  |
      | Dogs         | K9-DL-01  | EST-9  |
      | Dogs         | K9-DL-01  | EST-10 |
      | Dogs         | K9-RT-01  | EST-28 |
      | Dogs         | K9-RT-02  | EST-22 |
      | Dogs         | K9-RT-02  | EST-23 |
      | Dogs         | K9-RT-02  | EST-24 |
      | Dogs         | K9-RT-02  | EST-25 |
      | Dogs         | K9-CW-01  | EST-26 |
      | Dogs         | K9-CW-01  | EST-27 |
      | Reptiles     | RP-SN-01  | EST-11 |
      | Reptiles     | RP-SN-01  | EST-12 |
      | Reptiles     | RP-LI-02  | EST-13 |
      | Cats         | FL-DSH-01 | EST-14 |
      | Cats         | FL-DSH-01 | EST-15 |
      | Cats         | FL-DLH-02 | EST-16 |
      | Cats         | FL-DLH-02 | EST-17 |
      | Birds        | AV-CB-01  | EST-18 |
      | Birds        | AV-SB-02  | EST-19 |