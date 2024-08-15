@us08
Feature: Product Page Verification

  As a user,
  I want to verify the product page functionality,
  So that I can ensure that the product pages display the correct information and links.

  Background:
    Given I am on the "Welcome" page
    Given I click on the "Enter The Store Link"
    Given I am on the "Catalog" page


  # This scenario verifies that the title and URL of the Product page match the expected values for different products.
  # It tests navigation through various product categories and ensures that the Product page title and URL are correct based on the `categoryName` and `productId`.
  @us08ac01
  Scenario Outline: Page Title and URL Validation
    When I click on the "<categoryName>" in the sidebar section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    And The page title "<pageTitle>" and the URL "<pageURL>" should match the expected value
    Examples:
      | categoryName | productId | pageTitle      | pageURL                                                                               |
      | Fish         | FI-SW-01  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01  |
      | Fish         | FI-SW-02  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-02  |
      | Fish         | FI-FW-01  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-01  |
      | Fish         | FI-FW-02  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-02  |
      | Dogs         | K9-BD-01  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-BD-01  |
      | Dogs         | K9-PO-02  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-PO-02  |
      | Dogs         | K9-DL-01  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-DL-01  |
      | Dogs         | K9-RT-01  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-01  |
      | Dogs         | K9-RT-02  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  |
      | Dogs         | K9-CW-01  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-CW-01  |
      | Cats         | FL-DSH-01 | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DSH-01 |
      | Cats         | FL-DLH-02 | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DLH-02 |
      | Reptiles     | RP-SN-01  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-SN-01  |
      | Reptiles     | RP-LI-02  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-LI-02  |
      | Birds        | AV-CB-01  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-CB-01  |
      | Birds        | AV-SB-02  | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-SB-02  |


  # This scenario ensures that specific elements are present on the Product page.
  # It verifies the presence of single and list elements to confirm that the Product page displays all necessary information.
  @us08ac02
  Scenario Outline: Verify Product Page Elements
    When I click on the "<categoryName>" in the sidebar section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    And I should see the following single elements:
      | Product Name |
      | Back Link    |
    And I should see the following list of elements:
      | Add To Cart Buttons |
      | Item Ids            |
      | Product Ids         |
      | Descriptions        |
      | List Prices         |
      | Table Headers       |
    Examples:
      | categoryName | productId |
      | Fish         | FI-SW-01  |
      | Fish         | FI-SW-02  |
      | Fish         | FI-FW-01  |
      | Fish         | FI-FW-02  |
      | Dogs         | K9-BD-01  |
      | Dogs         | K9-PO-02  |
      | Dogs         | K9-DL-01  |
      | Dogs         | K9-RT-01  |
      | Dogs         | K9-RT-02  |
      | Dogs         | K9-CW-01  |
      | Cats         | FL-DSH-01 |
      | Cats         | FL-DLH-02 |
      | Reptiles     | RP-SN-01  |
      | Reptiles     | RP-LI-02  |
      | Birds        | AV-CB-01  |
      | Birds        | AV-SB-02  |


  # This scenario checks that the text and table headers on the Product page match the expected values.
  # It also verifies the accuracy of the item's details, including Item ID, Product ID, Description, and List Price.
  @us08ac03
  Scenario Outline: Text and Table Headers Validation
    When I click on the "<categoryLink>" in the quick links section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    And The text of the element should match the expected value:
      | Product Name | <productName>  |
      | Back Link    | <backLinkText> |
    And The texts of the "Table Headers" should match the expected values:
      | Item ID     |
      | Product ID  |
      | Description |
      | List Price  |
    And The information of the item "<itemId>" should match the expected value:
      | itemId      | <itemId>      |
      | productId   | <productId>   |
      | description | <description> |
      | listPrice   | <listPrice>   |
    Examples:
      | categoryLink | productId | productName        | backLinkText       | itemId | description                     | listPrice |
      | Fish         | FI-SW-01  | Angelfish          | Return to FISH     | EST-1  | Large Angelfish                 | $16.50    |
      | Fish         | FI-SW-01  | Angelfish          | Return to FISH     | EST-2  | Small Angelfish                 | $16.50    |
      | Fish         | FI-SW-02  | Tiger Shark        | Return to FISH     | EST-3  | Toothless Tiger Shark           | $18.50    |
      | Fish         | FI-FW-01  | Koi                | Return to FISH     | EST-4  | Spotted Koi                     | $18.50    |
      | Fish         | FI-FW-01  | Koi                | Return to FISH     | EST-5  | Spotless Koi                    | $18.50    |
      | Fish         | FI-FW-02  | Goldfish           | Return to FISH     | EST-20 | Adult Male Goldfish             | $5.50     |
      | Fish         | FI-FW-02  | Goldfish           | Return to FISH     | EST-21 | Adult Female Goldfish           | $5.29     |
      | Dogs         | K9-BD-01  | Bulldog            | Return to DOGS     | EST-6  | Male Adult Bulldog              | $18.50    |
      | Dogs         | K9-BD-01  | Bulldog            | Return to DOGS     | EST-7  | Female Puppy Bulldog            | $18.50    |
      | Dogs         | K9-PO-02  | Poodle             | Return to DOGS     | EST-8  | Male Puppy Poodle               | $18.50    |
      | Dogs         | K9-DL-01  | Dalmation          | Return to DOGS     | EST-9  | Spotless Male Puppy Dalmation   | $18.50    |
      | Dogs         | K9-DL-01  | Dalmation          | Return to DOGS     | EST-10 | Spotted Adult Female Dalmation  | $18.50    |
      | Dogs         | K9-RT-01  | Golden Retriever   | Return to DOGS     | EST-28 | Adult Female Golden Retriever   | $155.29   |
      | Dogs         | K9-RT-02  | Labrador Retriever | Return to DOGS     | EST-22 | Adult Male Labrador Retriever   | $135.50   |
      | Dogs         | K9-RT-02  | Labrador Retriever | Return to DOGS     | EST-23 | Adult Female Labrador Retriever | $145.49   |
      | Dogs         | K9-RT-02  | Labrador Retriever | Return to DOGS     | EST-24 | Adult Male Labrador Retriever   | $255.50   |
      | Dogs         | K9-RT-02  | Labrador Retriever | Return to DOGS     | EST-25 | Adult Female Labrador Retriever | $325.29   |
      | Dogs         | K9-CW-01  | Chihuahua          | Return to DOGS     | EST-26 | Adult Male Chihuahua            | $125.50   |
      | Dogs         | K9-CW-01  | Chihuahua          | Return to DOGS     | EST-27 | Adult Female Chihuahua          | $155.29   |
      | Cats         | FL-DSH-01 | Manx               | Return to CATS     | EST-14 | Tailless Manx                   | $58.50    |
      | Cats         | FL-DSH-01 | Manx               | Return to CATS     | EST-15 | With tail Manx                  | $23.50    |
      | Cats         | FL-DLH-02 | Persian            | Return to CATS     | EST-16 | Adult Female Persian            | $93.50    |
      | Cats         | FL-DLH-02 | Persian            | Return to CATS     | EST-17 | Adult Male Persian              | $93.50    |
      | Reptiles     | RP-SN-01  | Rattlesnake        | Return to REPTILES | EST-11 | Venomless Rattlesnake           | $18.50    |
      | Reptiles     | RP-SN-01  | Rattlesnake        | Return to REPTILES | EST-12 | Rattleless Rattlesnake          | $18.50    |
      | Reptiles     | RP-LI-02  | Iguana             | Return to REPTILES | EST-13 | Green Adult Iguana              | $18.50    |
      | Birds        | AV-CB-01  | Amazon Parrot      | Return to BIRDS    | EST-18 | Adult Male Amazon Parrot        | $193.50   |
      | Birds        | AV-SB-02  | Finch              | Return to BIRDS    | EST-19 | Adult Male Finch                | $15.50    |


  # This scenario ensures that the href values for various links on the Product page are correct.
  # It checks the Back Link, item links, and Add To Cart button links to confirm that they direct to the appropriate URLs.
  @us08ac04
  Scenario Outline: Link Verification
    When I click on the "<categoryLink>" in the main image section
    Then I am on the "Category" page
    When I click on the product "<productId>"
    Then I am on the "Product" page
    And The "href" value of the element should match the expected value:
      | Back Link | <backLinkURL> |
    And The href value of the item link "<itemId>" should match the expected value:
      | <itemIdHrefValue> |
    And The href value of the add to cart button for item ID "<itemId>" should match the expected value:
      | <addToCartButtonHrefValue> |
    Examples:
      | categoryLink | productId | backLinkURL                                                                            | itemId | itemIdHrefValue                                                              | addToCartButtonHrefValue                                                              |
      | Fish         | FI-SW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     | EST-1  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-1  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-1  |
      | Fish         | FI-SW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     | EST-2  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-2  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-2  |
      | Fish         | FI-SW-02  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     | EST-3  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-3  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-3  |
      | Fish         | FI-FW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     | EST-4  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-4  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-4  |
      | Fish         | FI-FW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     | EST-5  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-5  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-5  |
      | Fish         | FI-FW-02  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     | EST-20 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-20 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-20 |
      | Fish         | FI-FW-02  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     | EST-21 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-21 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-21 |
      | Dogs         | K9-BD-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-6  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-6  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-6  |
      | Dogs         | K9-BD-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-7  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-7  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-7  |
      | Dogs         | K9-PO-02  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-8  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-8  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-8  |
      | Dogs         | K9-DL-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-9  | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-9  | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-9  |
      | Dogs         | K9-DL-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-10 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-10 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-10 |
      | Dogs         | K9-RT-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-28 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-28 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-28 |
      | Dogs         | K9-RT-02  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-22 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-22 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-22 |
      | Dogs         | K9-RT-02  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-23 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-23 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-23 |
      | Dogs         | K9-RT-02  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-24 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-24 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-24 |
      | Dogs         | K9-RT-02  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-25 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-25 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-25 |
      | Dogs         | K9-CW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-26 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-26 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-26 |
      | Dogs         | K9-CW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     | EST-27 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-27 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-27 |
      | Cats         | FL-DSH-01 | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     | EST-14 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-14 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-14 |
      | Cats         | FL-DSH-01 | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     | EST-15 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-15 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-15 |
      | Cats         | FL-DLH-02 | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     | EST-16 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-16 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-16 |
      | Cats         | FL-DLH-02 | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     | EST-17 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-17 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-17 |
      | Reptiles     | RP-SN-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES | EST-11 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-11 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-11 |
      | Reptiles     | RP-SN-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES | EST-12 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-12 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-12 |
      | Reptiles     | RP-LI-02  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES | EST-13 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-13 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-13 |
      | Birds        | AV-CB-01  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS    | EST-18 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-18 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-18 |
      | Birds        | AV-SB-02  | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS    | EST-19 | https://petstore.octoperf.com/actions/Catalog.action?viewItem=&itemId=EST-19 | https://petstore.octoperf.com/actions/Cart.action?addItemToCart=&workingItemId=EST-19 |