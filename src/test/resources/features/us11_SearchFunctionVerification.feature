@us11
Feature: Search Function Verification

  As a user of the online pet store,
  I want to be able to search for products efficiently,
  So that I can find and view specific products based on my search input.

  Background:
    Given I am on the "Welcome" page
    Given I click on the "Enter The Store Link"
    Given I am on the "Catalog" page

  # This scenario tests the system's response when the search input box is left empty.
  # The expected outcome is that the user should see a warning message indicating that a keyword must be entered to perform a search.
  @us11ac01
  Scenario: Search with an empty input
    When I enter the "" in the "Search Input Box"
    And I click on the "Search Button"
    Then I should see the following single elements:
      | Empty Search Warning Message |
    And The text of the element should match the expected value:
      | Empty Search Warning Message | Please enter a keyword to search for, then press the search button. |

  # This scenario verifies the system's behavior when an invalid search term (e.g., non-alphanumeric characters) is entered.
  # It checks that the system displays appropriate table headers and a "Back Link" element, while no search results are expected.
  @us11ac02
  Scenario: Search with an invalid input
    When I enter the "****" in the "Search Input Box"
    And I click on the "Search Button"
    Then I should see the following list of elements:
      | Table Headers |
    And I should see the following single elements:
      | Back Link |
    And The texts of the "Table Headers" should match the expected values:
      | Product ID |
      | Name       |
    And The text of the element should match the expected value:
      | Back Link | Return to Main Menu |

  # This scenario tests the search functionality with various valid search terms.
  # It verifies that the search results include all expected elements such as table headers, product IDs, names, images, and descriptions, along with a "Back Link."
  @us11ac03
  Scenario Outline: Search with valid inputs
    When I enter the "<searchInput>" in the "Search Input Box"
    And I click on the "Search Button"
    Then I should see the following list of elements:
      | Table Headers    |
      | Product Id Texts |
      | Product Id Links |
      | Product Names    |
      | Product Images   |
      | product descriptions    |
    And I should see the following single elements:
      | Back Link |
    Examples:
      | searchInput |
      | Angelfish   |
      | Shark       |
      | Koi         |
      | Goldfish    |
      | Bulldog     |
      | Poodle      |
      | Dalmation   |
      | Golden      |
      | Labrador    |
      | Chihuahua   |
      | Rattlesnake |
      | Iguana      |
      | Manx        |
      | Persian     |
      | Parrot      |
      | Finch       |

  # This scenario checks that the search results for valid inputs display accurate product details.
  # It includes verifying that the product description, link href, ID, ID link href, and name match the expected values.
  @us11ac04
  Scenario Outline: Verify product details for search results
    When I enter the "<searchInput>" in the "Search Input Box"
    And I click on the "Search Button"
    And The text of the element should match the expected value:
      | Back Link | Return to Main Menu |
    And The information of the product "<searchInput>" should match the expected values:
      | productDescription | <productDescription> |
      | productLinkHref    | <productLinkHref>    |
      | productId          | <productId>          |
      | productIdLinkHref  | <productIdLinkHref>  |
      | productName        | <productName>        |
    Examples:
      | searchInput | productDescription                        | productLinkHref                                                                       | productId | productIdLinkHref                                                                     | productName        |
      | Angelfish   | Salt Water fish from Australia            | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01  | FI-SW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01  | Angelfish          |
      | Shark       | Salt Water fish from Australia            | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-02  | FI-SW-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-02  | Tiger Shark        |
      | Koi         | Fresh Water fish from Japan               | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-01  | FI-FW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-01  | Koi                |
      | Goldfish    | Fresh Water fish from China               | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-02  | FI-FW-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-02  | Goldfish           |
      | Bulldog     | Friendly dog from England                 | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-BD-01  | K9-BD-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-BD-01  | Bulldog            |
      | Poodle      | Cute dog from France                      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-PO-02  | K9-PO-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-PO-02  | Poodle             |
      | Dalmation   | Great dog for a Fire Station              | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-DL-01  | K9-DL-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-DL-01  | Dalmation          |
      | Golden      | Great family dog                          | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-01  | K9-RT-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-01  | Golden Retriever   |
      | Labrador    | Great hunting dog                         | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  | K9-RT-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  | Labrador Retriever |
      | Chihuahua   | Great companion dog                       | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-CW-01  | K9-CW-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-CW-01  | Chihuahua          |
      | Rattlesnake | Doubles as a watch dog                    | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-SN-01  | RP-SN-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-SN-01  | Rattlesnake        |
      | Iguana      | Friendly green friend                     | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-LI-02  | RP-LI-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-LI-02  | Iguana             |
      | Manx        | Great for reducing mouse populations      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DSH-01 | FL-DSH-01 | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DSH-01 | Manx               |
      | Persian     | Friendly house cat, doubles as a princess | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DLH-02 | FL-DLH-02 | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DLH-02 | Persian            |
      | Parrot      | Great companion for up to 75 years        | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-CB-01  | AV-CB-01  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-CB-01  | Amazon Parrot      |
      | Finch       | Great stress reliever                     | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-SB-02  | AV-SB-02  | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-SB-02  | Finch              |

  # This scenario validates that clicking on a product image from the search results correctly navigates the user to the product's page, and ensures that the page title and URL are as expected.
  @us11ac05
  Scenario Outline: Navigate to product page from search results by clicking the product image
    When I enter the "<searchInput>" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product image for "<productName>"
    Then I am on the "Product" page
    And The page title "JPetStore Demo" and the URL "<productLinkHref>" should match the expected value
    And I should see the following single elements:
      | Product Name |
    And The text of the element should match the expected value:
      | Product Name | <productName> |
    Examples:
      | searchInput | productLinkHref                                                                       | productName        |
      | Angelfish   | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01  | Angelfish          |
      | Shark       | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-02  | Tiger Shark        |
      | Koi         | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-01  | Koi                |
      | Goldfish    | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-02  | Goldfish           |
      | Bulldog     | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-BD-01  | Bulldog            |
      | Poodle      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-PO-02  | Poodle             |
      | Dalmation   | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-DL-01  | Dalmation          |
      | Golden      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-01  | Golden Retriever   |
      | Labrador    | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  | Labrador Retriever |
      | Chihuahua   | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-CW-01  | Chihuahua          |
      | Rattlesnake | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-SN-01  | Rattlesnake        |
      | Iguana      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-LI-02  | Iguana             |
      | Manx        | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DSH-01 | Manx               |
      | Persian     | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DLH-02 | Persian            |
      | Parrot      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-CB-01  | Amazon Parrot      |
      | Finch       | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-SB-02  | Finch              |

  # This scenario verifies that clicking on a product description link from the search results navigates the user to the product's page.
  # It checks that the page title and URL are correct and that the product name matches the expected value.
  @us11ac06
  Scenario Outline: Navigate to product page from search results by clicking the product description
    When I enter the "<searchInput>" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product description for "<productName>"
    Then I am on the "Product" page
    And The page title "JPetStore Demo" and the URL "<productLinkHref>" should match the expected value
    And I should see the following single elements:
      | Product Name |
    And The text of the element should match the expected value:
      | Product Name | <productName> |
    Examples:
      | searchInput | productLinkHref                                                                       | productName        |
      | Angelfish   | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01  | Angelfish          |
      | Shark       | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-02  | Tiger Shark        |
      | Koi         | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-01  | Koi                |
      | Goldfish    | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-02  | Goldfish           |
      | Bulldog     | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-BD-01  | Bulldog            |
      | Poodle      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-PO-02  | Poodle             |
      | Dalmation   | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-DL-01  | Dalmation          |
      | Golden      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-01  | Golden Retriever   |
      | Labrador    | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  | Labrador Retriever |
      | Chihuahua   | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-CW-01  | Chihuahua          |
      | Rattlesnake | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-SN-01  | Rattlesnake        |
      | Iguana      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-LI-02  | Iguana             |
      | Manx        | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DSH-01 | Manx               |
      | Persian     | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DLH-02 | Persian            |
      | Parrot      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-CB-01  | Amazon Parrot      |
      | Finch       | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-SB-02  | Finch              |

  # This scenario tests the navigation to the product page by clicking on the product ID from the search results.
  # It ensures that the page title, URL, and product name are as expected.
  @us11ac07
  Scenario Outline: Navigate to product page from search results by clicking the product ID
    When I enter the "<searchInput>" in the "Search Input Box"
    And I click on the "Search Button"
    And I click on the product ID for "<productName>"
    Then I am on the "Product" page
    And The page title "JPetStore Demo" and the URL "<productLinkHref>" should match the expected value
    And I should see the following single elements:
      | Product Name |
    And The text of the element should match the expected value:
      | Product Name | <productName> |
    Examples:
      | searchInput | productLinkHref                                                                       | productName        |
      | Angelfish   | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-01  | Angelfish          |
      | Shark       | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-SW-02  | Tiger Shark        |
      | Koi         | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-01  | Koi                |
      | Goldfish    | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FI-FW-02  | Goldfish           |
      | Bulldog     | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-BD-01  | Bulldog            |
      | Poodle      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-PO-02  | Poodle             |
      | Dalmation   | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-DL-01  | Dalmation          |
      | Golden      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-01  | Golden Retriever   |
      | Labrador    | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-RT-02  | Labrador Retriever |
      | Chihuahua   | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=K9-CW-01  | Chihuahua          |
      | Rattlesnake | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-SN-01  | Rattlesnake        |
      | Iguana      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=RP-LI-02  | Iguana             |
      | Manx        | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DSH-01 | Manx               |
      | Persian     | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=FL-DLH-02 | Persian            |
      | Parrot      | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-CB-01  | Amazon Parrot      |
      | Finch       | https://petstore.octoperf.com/actions/Catalog.action?viewProduct=&productId=AV-SB-02  | Finch              |

  # This scenario checks that when the search input box is left empty and the search button is clicked, only one warning message is displayed, indicating that the input is required.
  @us11ac08
  Scenario: Search with an empty input
    When I enter the "" in the "Search Input Box"
    And I click on the "Search Button"
    Then There should be only one warning message

  # This scenario verifies that when searching with valid terms that match a single product, only one product image is displayed in the search results.
  @us11ac09
  Scenario Outline: Search with valid inputs showing only one product image
    When I enter the "<searchInput>" in the "Search Input Box"
    And I click on the "Search Button"
    Then There should be only one product image
    Examples:
      | searchInput        |
      | Tiger Shark        |
      | Golden Retriever   |
      | Labrador Retriever |
      | Amazon Parrot      |

  # This scenario confirms that a valid search term returning only one product will display exactly one product description in the search results.
  @us11ac10
  Scenario Outline: Search with valid inputs showing only one product description
    When I enter the "<searchInput>" in the "Search Input Box"
    And I click on the "Search Button"
    Then There should be only one product description
    Examples:
      | searchInput        |
      | Tiger Shark        |
      | Golden Retriever   |
      | Labrador Retriever |
      | Amazon Parrot      |

  # This scenario ensures that when a valid search term returns only one product, only one product name is shown in the search results.
  @us11ac11
  Scenario Outline: Search with valid inputs showing only one product name
    When I enter the "<searchInput>" in the "Search Input Box"
    And I click on the "Search Button"
    Then There should be only one product name
    Examples:
      | searchInput        |
      | Tiger Shark        |
      | Golden Retriever   |
      | Labrador Retriever |
      | Amazon Parrot      |

  # This scenario checks that a valid search term resulting in a single product will display only one product ID in the search results.
  @us11ac12
  Scenario Outline: Search with valid inputs showing only one product ID
    When I enter the "<searchInput>" in the "Search Input Box"
    And I click on the "Search Button"
    Then There should be only one product ID
    Examples:
      | searchInput        |
      | Tiger Shark        |
      | Golden Retriever   |
      | Labrador Retriever |
      | Amazon Parrot      |

  # This scenario validates that the src attribute of the product image matches the expected value for each search result, ensuring correct image sourcing.
  @us11ac13
  Scenario Outline: Verify product image src value for search results
    When I enter the "<searchInput>" in the "Search Input Box"
    And I click on the "Search Button"
    Then The src value of the image for product name "<productName>" should match the expected value:
      | <productImageSrc> |
    Examples:
      | searchInput | productImageSrc                                  | productName        |
      | Angelfish   | https://petstore.octoperf.com/images/fish1.gif   | Angelfish          |
      | Shark       | https://petstore.octoperf.com/images/fish4.gif   | Tiger Shark        |
      | Koi         | https://petstore.octoperf.com/images/fish3.gif   | Koi                |
      | Goldfish    | https://petstore.octoperf.com/images/fish2.gif   | Goldfish           |
      | Bulldog     | https://petstore.octoperf.com/images/dog7.gif    | Bulldog            |
      | Poodle      | https://petstore.octoperf.com/images/dog6.gif    | Poodle             |
      | Dalmation   | https://petstore.octoperf.com/images/dog8.gif    | Dalmation          |
      | Golden      | https://petstore.octoperf.com/images/dog5.gif    | Golden Retriever   |
      | Labrador    | https://petstore.octoperf.com/images/dog4.gif    | Labrador Retriever |
      | Chihuahua   | https://petstore.octoperf.com/images/dog2.gif    | Chihuahua          |
      | Rattlesnake | https://petstore.octoperf.com/images/snake1.gif  | Rattlesnake        |
      | Iguana      | https://petstore.octoperf.com/images/lizard1.gif | Iguana             |
      | Manx        | https://petstore.octoperf.com/images/cat2.gif    | Manx               |
      | Persian     | https://petstore.octoperf.com/images/cat1.gif    | Persian            |
      | Parrot      | https://petstore.octoperf.com/images/bird2.gif   | Amazon Parrot      |
      | Finch       | https://petstore.octoperf.com/images/bird1.gif   | Finch              |