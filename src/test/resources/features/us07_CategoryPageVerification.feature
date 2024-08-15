@us07
Feature: Category Page Verification

  As a user of the JPetStore application,
  I want to ensure that the Category page displays correctly for different categories and that all functionalities work as expected,
  So that I can view and navigate through the products in each category without issues.

  Background:
    Given I am on the "Welcome" page
    Given I click on the "Enter The Store Link"
    Given I am on the "Catalog" page

  # This scenario verifies that the page title and URL of the Category page are correct for each specified category.
  @us07ac01
  Scenario Outline: Verify Page Title and URL for Each Category
    When I click on the "<categoryName>" in the sidebar section
    Then I am on the "Category" page
    And The page title "<pageTitle>" and the URL "<pageURL>" should match the expected value
    Examples:
      | categoryName | pageTitle      | pageURL                                                                                |
      | Fish         | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     |
      | Dogs         | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     |
      | Cats         | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     |
      | Reptiles     | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES |
      | Birds        | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS    |

  # This scenario verifies that specific elements are present on the Category page for each specified category.
  @us07ac02
  Scenario Outline: Verify Presence of Page Elements
    When I click on the "<categoryName>" in the sidebar section
    Then I am on the "Category" page
    And I should see the following single elements:
      | Category Name |
      | Back Link     |
    And I should see the following list of elements:
      | Table Headers |
      | Product Ids   |
      | Product Names |
    Examples:
      | categoryName |
      | Fish         |
      | Dogs         |
      | Cats         |
      | Reptiles     |
      | Birds        |

  # This scenario verifies that the "Back Link" URL and product link URLs are correct for each specified product in the Category page.
  @us07ac03
  Scenario Outline: Verify Back Link and Product Links
    When I click on the "<categoryName>" in the quick links section
    Then I am on the "Category" page
    And The "href" value of the element should match the expected value:
      | Back Link | https://petstore.octoperf.com/actions/Catalog.action |
    And The href value of the product link "<productId>" should match the expected value:
      | <productIdHrefValue> |
    Examples:
      | categoryName | productId | productIdHrefValue                                                                    |
      | Fish         | FI-SW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01  |
      | Fish         | FI-SW-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-02  |
      | Fish         | FI-FW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-01  |
      | Fish         | FI-FW-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-02  |
      | Dogs         | K9-BD-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-BD-01  |
      | Dogs         | K9-PO-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-PO-02  |
      | Dogs         | K9-DL-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-DL-01  |
      | Dogs         | K9-RT-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-01  |
      | Dogs         | K9-RT-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  |
      | Dogs         | K9-CW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-CW-01  |
      | Cats         | FL-DSH-01 | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DSH-01 |
      | Cats         | FL-DLH-02 | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DLH-02 |
      | Reptiles     | RP-SN-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-SN-01  |
      | Reptiles     | RP-LI-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-LI-02  |
      | Birds        | AV-CB-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-CB-01  |
      | Birds        | AV-SB-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-SB-02  |


  # This scenario verifies that clicking on the main image for a category correctly leads to the Category page, and that the details such as category name, back link, table headers, and product information are correct.
  @us07ac04
  Scenario Outline: Verify Category Page Details from Main Image Section
    When I click on the "<categoryName>" in the main image section
    Then I am on the "Category" page
    And The text of the element should match the expected value:
      | Category Name | <categoryName>      |
      | Back Link     | Return to Main Menu |
    And The texts of the "Table Headers" should match the expected values:
      | Product ID |
      | Name       |
    And The information of the product "<productId>" should match the expected value:
      | productId   | <productId>   |
      | productName | <productName> |
    Examples:
      | categoryName | productId | productName        |
      | Fish         | FI-SW-01  | Angelfish          |
      | Fish         | FI-SW-02  | Tiger Shark        |
      | Fish         | FI-FW-01  | Koi                |
      | Fish         | FI-FW-02  | Goldfish           |
      | Dogs         | K9-BD-01  | Bulldog            |
      | Dogs         | K9-PO-02  | Poodle             |
      | Dogs         | K9-DL-01  | Dalmation          |
      | Dogs         | K9-RT-01  | Golden Retriever   |
      | Dogs         | K9-RT-02  | Labrador Retriever |
      | Dogs         | K9-CW-01  | Chihuahua          |
      | Cats         | FL-DSH-01 | Manx               |
      | Cats         | FL-DLH-02 | Persian            |
      | Reptiles     | RP-SN-01  | Rattlesnake        |
      | Reptiles     | RP-LI-02  | Iguana             |
      | Birds        | AV-CB-01  | Amazon Parrot      |
      | Birds        | AV-SB-02  | Finch              |