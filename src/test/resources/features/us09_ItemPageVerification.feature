@us09
Feature: Item Page Verification

  As a user of the pet store website,
  I want to be able to verify that the item page displays accurate details and the expected elements,
  So that I can ensure the product information is correct and the page functions as intended.

  Background:
    Given I am on the "Welcome" page
    Given I click on the "Enter The Store Link"
    Given I am on the "Catalog" page

  # This scenario verifies that the item page displays the correct page title and URL based on the item ID and category selected.
  # It ensures that the navigation through categories and products leads to the correct item page with accurate metadata.
  @us09ac01
  Scenario Outline: Page Title and URL Verification
    When I click on the "<categoryName>" in the sidebar section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    And The page title "<pageTitle>" and the URL "<pageURL>" should match the expected value
    Examples:
      | categoryName | productId | pageTitle      | itemId | pageURL                                                                      |
      | Fish         | FI-SW-01  | JPetStore Demo | EST-1  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-1  |
      | Fish         | FI-SW-01  | JPetStore Demo | EST-2  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-2  |
      | Fish         | FI-SW-02  | JPetStore Demo | EST-3  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-3  |
      | Fish         | FI-FW-01  | JPetStore Demo | EST-4  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-4  |
      | Fish         | FI-FW-01  | JPetStore Demo | EST-5  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-5  |
      | Fish         | FI-FW-02  | JPetStore Demo | EST-20 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-20 |
      | Fish         | FI-FW-02  | JPetStore Demo | EST-21 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-21 |
      | Dogs         | K9-BD-01  | JPetStore Demo | EST-6  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-6  |
      | Dogs         | K9-BD-01  | JPetStore Demo | EST-7  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-7  |
      | Dogs         | K9-PO-02  | JPetStore Demo | EST-8  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-8  |
      | Dogs         | K9-DL-01  | JPetStore Demo | EST-9  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-9  |
      | Dogs         | K9-DL-01  | JPetStore Demo | EST-10 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-10 |
      | Dogs         | K9-RT-01  | JPetStore Demo | EST-28 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-28 |
      | Dogs         | K9-RT-02  | JPetStore Demo | EST-22 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-22 |
      | Dogs         | K9-RT-02  | JPetStore Demo | EST-23 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-23 |
      | Dogs         | K9-RT-02  | JPetStore Demo | EST-24 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-24 |
      | Dogs         | K9-RT-02  | JPetStore Demo | EST-25 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-25 |
      | Dogs         | K9-CW-01  | JPetStore Demo | EST-26 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-26 |
      | Dogs         | K9-CW-01  | JPetStore Demo | EST-27 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-27 |
      | Cats         | FL-DSH-01 | JPetStore Demo | EST-14 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-14 |
      | Cats         | FL-DSH-01 | JPetStore Demo | EST-15 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-15 |
      | Cats         | FL-DLH-02 | JPetStore Demo | EST-16 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-16 |
      | Cats         | FL-DLH-02 | JPetStore Demo | EST-17 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-17 |
      | Reptiles     | RP-SN-01  | JPetStore Demo | EST-11 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-11 |
      | Reptiles     | RP-SN-01  | JPetStore Demo | EST-12 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-12 |
      | Reptiles     | RP-LI-02  | JPetStore Demo | EST-13 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-13 |
      | Birds        | AV-CB-01  | JPetStore Demo | EST-18 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-18 |
      | Birds        | AV-SB-02  | JPetStore Demo | EST-19 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-19 |

  # This scenario checks the presence of key elements on the item page to ensure that essential information is displayed correctly.
  # It verifies the visibility of various UI components related to the item.
  @us09ac02
  Scenario Outline: Element Presence Verification
    When I click on the "<categoryName>" in the sidebar section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    And I should see the following single elements:
      | Item Information   |
      | Item Image         |
      | Item Id            |
      | Item Description   |
      | Item Price         |
      | Product Name       |
      | Stock Info         |
      | Add To Cart Button |
      | Back Link          |
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
      | Birds        | AV-CB-01  | EST-18 |
      | Birds        | AV-SB-02  | EST-19 |

  # This scenario ensures that both the textual content and detailed item information on the item page are correct.
  # It verifies that the page displays the expected values for various UI elements and product details.
  @us09ac03
  Scenario Outline: Text and Detailed Information Verification
    When I click on the "<categoryName>" in the quick links section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    And The text of the element should match the expected value:
      | Back Link          | <backLinkText> |
      | Add To Cart Button | Add to Cart    |
    And The detailed information of the item should match the expected value:
      | itemInformation | <itemInformation> |
      | itemId          | <itemId>          |
      | description     | <description>     |
      | productName     | <productName>     |
      | listPrice       | <listPrice>       |
    Examples:
      | categoryName | productId | productName        | backLinkText        | itemInformation                           | itemId | description                     | listPrice |
      | Fish         | FI-SW-01  | Angelfish          | Return to FI-SW-01  | Salt Water fish from Australia            | EST-1  | Large Angelfish                 | $16.50    |
      | Fish         | FI-SW-01  | Angelfish          | Return to FI-SW-01  | Salt Water fish from Australia            | EST-2  | Small Angelfish                 | $16.50    |
      | Fish         | FI-SW-02  | Tiger Shark        | Return to FI-SW-02  | Salt Water fish from Australia            | EST-3  | Toothless Tiger Shark           | $18.50    |
      | Fish         | FI-FW-01  | Koi                | Return to FI-FW-01  | Fresh Water fish from Japan               | EST-4  | Spotted Koi                     | $18.50    |
      | Fish         | FI-FW-01  | Koi                | Return to FI-FW-01  | Fresh Water fish from Japan               | EST-5  | Spotless Koi                    | $18.50    |
      | Fish         | FI-FW-02  | Goldfish           | Return to FI-FW-02  | Fresh Water fish from China               | EST-20 | Adult Male Goldfish             | $5.50     |
      | Fish         | FI-FW-02  | Goldfish           | Return to FI-FW-02  | Fresh Water fish from China               | EST-21 | Adult Female Goldfish           | $5.29     |
      | Dogs         | K9-BD-01  | Bulldog            | Return to K9-BD-01  | Friendly dog from England                 | EST-6  | Male Adult Bulldog              | $18.50    |
      | Dogs         | K9-BD-01  | Bulldog            | Return to K9-BD-01  | Friendly dog from England                 | EST-7  | Female Puppy Bulldog            | $18.50    |
      | Dogs         | K9-PO-02  | Poodle             | Return to K9-PO-02  | Cute dog from France                      | EST-8  | Male Puppy Poodle               | $18.50    |
      | Dogs         | K9-DL-01  | Dalmation          | Return to K9-DL-01  | Great dog for a Fire Station              | EST-9  | Spotless Male Puppy Dalmation   | $18.50    |
      | Dogs         | K9-DL-01  | Dalmation          | Return to K9-DL-01  | Great dog for a Fire Station              | EST-10 | Spotted Adult Female Dalmation  | $18.50    |
      | Dogs         | K9-RT-01  | Golden Retriever   | Return to K9-RT-01  | Great family dog                          | EST-28 | Adult Female Golden Retriever   | $155.29   |
      | Dogs         | K9-RT-02  | Labrador Retriever | Return to K9-RT-02  | Great hunting dog                         | EST-22 | Adult Male Labrador Retriever   | $135.50   |
      | Dogs         | K9-RT-02  | Labrador Retriever | Return to K9-RT-02  | Great hunting dog                         | EST-23 | Adult Female Labrador Retriever | $145.49   |
      | Dogs         | K9-RT-02  | Labrador Retriever | Return to K9-RT-02  | Great hunting dog                         | EST-24 | Adult Male Labrador Retriever   | $255.50   |
      | Dogs         | K9-RT-02  | Labrador Retriever | Return to K9-RT-02  | Great hunting dog                         | EST-25 | Adult Female Labrador Retriever | $325.29   |
      | Dogs         | K9-CW-01  | Chihuahua          | Return to K9-CW-01  | Great companion dog                       | EST-26 | Adult Male Chihuahua            | $125.50   |
      | Dogs         | K9-CW-01  | Chihuahua          | Return to K9-CW-01  | Great companion dog                       | EST-27 | Adult Female Chihuahua          | $155.29   |
      | Cats         | FL-DSH-01 | Manx               | Return to FL-DSH-01 | Great for reducing mouse populations      | EST-14 | Tailless Manx                   | $58.50    |
      | Cats         | FL-DSH-01 | Manx               | Return to FL-DSH-01 | Great for reducing mouse populations      | EST-15 | With tail Manx                  | $23.50    |
      | Cats         | FL-DLH-02 | Persian            | Return to FL-DLH-02 | Friendly house cat, doubles as a princess | EST-16 | Adult Female Persian            | $93.50    |
      | Cats         | FL-DLH-02 | Persian            | Return to FL-DLH-02 | Friendly house cat, doubles as a princess | EST-17 | Adult Male Persian              | $93.50    |
      | Reptiles     | RP-SN-01  | Rattlesnake        | Return to RP-SN-01  | Doubles as a watch dog                    | EST-11 | Venomless Rattlesnake           | $18.50    |
      | Reptiles     | RP-SN-01  | Rattlesnake        | Return to RP-SN-01  | Doubles as a watch dog                    | EST-12 | Rattleless Rattlesnake          | $18.50    |
      | Reptiles     | RP-LI-02  | Iguana             | Return to RP-LI-02  | Friendly green friend                     | EST-13 | Green Adult Iguana              | $18.50    |
      | Birds        | AV-CB-01  | Amazon Parrot      | Return to AV-CB-01  | Great companion for up to 75 years        | EST-18 | Adult Male Amazon Parrot        | $193.50   |
      | Birds        | AV-SB-02  | Finch              | Return to AV-SB-02  | Great stress reliever                     | EST-19 | Adult Male Finch                | $15.50    |

  # This scenario ensures that the URLs for specific elements on the item page are correct.
  # It verifies that the Add To Cart button and Back Link point to the expected destinations.
  @us09ac04
  Scenario Outline: URL Verification
    When I click on the "<categoryName>" in the main image section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    Then The "href" value of the element should match the expected value:
      | Add To Cart Button | <addToCartButtonHrefValue> |
      | Back Link          | <backLinkURL>              |
    Examples:
      | categoryName | productId | backLinkURL                                                                           | itemId | addToCartButtonHrefValue                                                              |
      | Fish         | FI-SW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01  | EST-1  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-1  |
      | Fish         | FI-SW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01  | EST-2  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-2  |
      | Fish         | FI-SW-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-02  | EST-3  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-3  |
      | Fish         | FI-FW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-01  | EST-4  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-4  |
      | Fish         | FI-FW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-01  | EST-5  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-5  |
      | Fish         | FI-FW-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-02  | EST-20 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-20 |
      | Fish         | FI-FW-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-02  | EST-21 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-21 |
      | Dogs         | K9-BD-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-BD-01  | EST-6  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-6  |
      | Dogs         | K9-BD-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-BD-01  | EST-7  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-7  |
      | Dogs         | K9-PO-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-PO-02  | EST-8  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-8  |
      | Dogs         | K9-DL-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-DL-01  | EST-9  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-9  |
      | Dogs         | K9-DL-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-DL-01  | EST-10 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-10 |
      | Dogs         | K9-RT-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-01  | EST-28 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-28 |
      | Dogs         | K9-RT-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  | EST-22 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-22 |
      | Dogs         | K9-RT-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  | EST-23 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-23 |
      | Dogs         | K9-RT-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  | EST-24 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-24 |
      | Dogs         | K9-RT-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  | EST-25 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-25 |
      | Dogs         | K9-CW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-CW-01  | EST-26 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-26 |
      | Dogs         | K9-CW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-CW-01  | EST-27 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-27 |
      | Cats         | FL-DSH-01 | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DSH-01 | EST-14 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-14 |
      | Cats         | FL-DSH-01 | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DSH-01 | EST-15 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-15 |
      | Cats         | FL-DLH-02 | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DLH-02 | EST-16 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-16 |
      | Cats         | FL-DLH-02 | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DLH-02 | EST-17 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-17 |
      | Reptiles     | RP-SN-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-SN-01  | EST-11 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-11 |
      | Reptiles     | RP-SN-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-SN-01  | EST-12 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-12 |
      | Reptiles     | RP-LI-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-LI-02  | EST-13 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-13 |
      | Birds        | AV-CB-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-CB-01  | EST-18 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-18 |
      | Birds        | AV-SB-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-SB-02  | EST-19 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-19 |

  # This scenario verifies that the image source for the item on the item page is correct.
  # It ensures that the item image loads from the expected URL.
  @us09ac05
  Scenario Outline: Image Source Verification
    When I click on the "<categoryName>" in the main image section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    When I click on the item link for item ID "<itemId>"
    Then I am on the "Item" page
    And The "src" value of the element should match the expected value:
      | Item Image | <itemImageSrcValue> |
    Examples:
      | categoryName | productId | itemId | itemImageSrcValue                                |
      | Fish         | FI-SW-01  | EST-1  | https://petstore.octoperf.com/images/fish1.gif   |
      | Fish         | FI-SW-01  | EST-2  | https://petstore.octoperf.com/images/fish1.gif   |
      | Fish         | FI-SW-02  | EST-3  | https://petstore.octoperf.com/images/fish4.gif   |
      | Fish         | FI-FW-01  | EST-4  | https://petstore.octoperf.com/images/fish3.gif   |
      | Fish         | FI-FW-01  | EST-5  | https://petstore.octoperf.com/images/fish3.gif   |
      | Fish         | FI-FW-02  | EST-20 | https://petstore.octoperf.com/images/fish2.gif   |
      | Fish         | FI-FW-02  | EST-21 | https://petstore.octoperf.com/images/fish2.gif   |
      | Dogs         | K9-BD-01  | EST-6  | https://petstore.octoperf.com/images/dog7.gif    |
      | Dogs         | K9-BD-01  | EST-7  | https://petstore.octoperf.com/images/dog7.gif    |
      | Dogs         | K9-PO-02  | EST-8  | https://petstore.octoperf.com/images/dog6.gif    |
      | Dogs         | K9-DL-01  | EST-9  | https://petstore.octoperf.com/images/dog8.gif    |
      | Dogs         | K9-DL-01  | EST-10 | https://petstore.octoperf.com/images/dog8.gif    |
      | Dogs         | K9-RT-01  | EST-28 | https://petstore.octoperf.com/images/dog5.gif    |
      | Dogs         | K9-RT-02  | EST-22 | https://petstore.octoperf.com/images/dog4.gif    |
      | Dogs         | K9-RT-02  | EST-23 | https://petstore.octoperf.com/images/dog4.gif    |
      | Dogs         | K9-RT-02  | EST-24 | https://petstore.octoperf.com/images/dog4.gif    |
      | Dogs         | K9-RT-02  | EST-25 | https://petstore.octoperf.com/images/dog4.gif    |
      | Dogs         | K9-CW-01  | EST-26 | https://petstore.octoperf.com/images/dog2.gif    |
      | Dogs         | K9-CW-01  | EST-27 | https://petstore.octoperf.com/images/dog2.gif    |
      | Cats         | FL-DSH-01 | EST-14 | https://petstore.octoperf.com/images/cat2.gif    |
      | Cats         | FL-DSH-01 | EST-15 | https://petstore.octoperf.com/images/cat2.gif    |
      | Cats         | FL-DLH-02 | EST-16 | https://petstore.octoperf.com/images/cat1.gif    |
      | Cats         | FL-DLH-02 | EST-17 | https://petstore.octoperf.com/images/cat1.gif    |
      | Reptiles     | RP-SN-01  | EST-11 | https://petstore.octoperf.com/images/snake1.gif  |
      | Reptiles     | RP-SN-01  | EST-12 | https://petstore.octoperf.com/images/snake1.gif  |
      | Reptiles     | RP-LI-02  | EST-13 | https://petstore.octoperf.com/images/lizard1.gif |
      | Birds        | AV-CB-01  | EST-18 | https://petstore.octoperf.com/images/bird2.gif   |
      | Birds        | AV-SB-02  | EST-19 | https://petstore.octoperf.com/images/bird1.gif   |