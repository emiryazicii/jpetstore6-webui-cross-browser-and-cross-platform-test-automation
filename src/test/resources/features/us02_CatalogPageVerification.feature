@us02
Feature: Catalog Page Verification

  As a user of the JPetStore application,
  I want to ensure that the "Catalog" page is displayed correctly and that all elements, links, and text are functioning as expected,
  So that I can confidently navigate through the catalog and access the correct pages.

  Background:
    Given I am on the "Welcome" page
    Given I click on the "Enter The Store Link"
    Given I am on the "Catalog" page

  # This scenario verifies that the page title and URL of the Catalog page match the expected values.
  @us02ac01
  Scenario: Verify Page Title and URL
    Then The page title "JPetStore Demo" and the URL "https://petstore.octoperf.com/actions/Catalog.action" should match the expected value

  # This scenario verifies that the Catalog page contains the expected elements.
  @us02ac02
  Scenario: Verify Presence of Page Elements
    Then I should see the following single elements:
      | Logo Image                             |
      | Cart Image                             |
      | Sign-In Link                           |
      | Help Link                              |
      | Search Input Box                       |
      | Search Button                          |
      | OctoPerf Link In The CTA Section       |
      | OctoPerf Link In The PoweredBy Section |
      | MyBatis Link In The PoweredBy Section  |
      | Main Image                             |
    And I should see the following list of elements:
      | Separator Images In The Menu Content Section |
      | Category Images In The Quick Links Section   |
      | Separator Images In The Quick Links Section  |
      | Sidebar Images                               |

  # This scenario verifies that the text of the specified elements on the Catalog page match the expected values.
  @us02ac03
  Scenario: Verify Text of Elements
    Then The text of the element should match the expected value:
      | Sign-In link                           | Sign In                                 |
      | Help Link                              | ?                                       |
      | CTA Section                            | Elevate you load-testing with OctoPerf! |
      | OctoPerf Link In The CTA Section       | OctoPerf                                |
      | OctoPerf Link In The PoweredBy Section | https://octoperf.com                    |
      | MyBatis Link In The PoweredBy Section  | www.mybatis.org                         |
    And The text of the powered by section should match the expected value
      | Powered by www.mybatis.org |
    And The text of the hosted by section should match the expected value
      | Hosted by https://octoperf.com |
    And The the text of the following links in the sidebar section should match the expected value
      | Fish     | Saltwater, Freshwater            |
      | Dogs     | Various Breeds                   |
      | Cats     | Various Breeds, Exotic Varieties |
      | Reptiles | Lizards, Turtles, Snakes         |
      | Birds    | Exotic Varieties                 |
    And The "value" value of the element should match the expected value:
      | Search Button | Search |

  # This scenario verifies that the attributes of specified elements on the Catalog page match the expected values.
  @us02ac04
  Scenario: Verify Element Attributes
    Then The "href" value of the element should match the expected value:
      | Logo Link                              | https://petstore.octoperf.com/actions/Catalog.action             |
      | Cart Link                              | https://petstore.octoperf.com/actions/Cart.action?viewCart=      |
      | Sign-In Link                           | https://petstore.octoperf.com/actions/Account.action?signonForm= |
      | Help Link                              | https://petstore.octoperf.com/help.html                          |
      | OctoPerf Link In The CTA Section       | https://octoperf.com/                                            |
      | OctoPerf Link In The PoweredBy Section | https://octoperf.com/                                            |
      | MyBatis Link In The PoweredBy Section  | https://mybatis.org/                                             |
    And The "src" value of the element should match the expected value:
      | Logo Image | https://petstore.octoperf.com/images/logo-topbar.svg |
      | Cart Image | https://petstore.octoperf.com/images/cart.gif        |
      | Main Image | https://petstore.octoperf.com/images/splash.gif      |
    And The "href" values of the "Category Links In The Quick Links Section" should match the expected values:
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS    |
    And The "src" values of the "Category Images In The Quick Links Section" should match the expected values:
      | https://petstore.octoperf.com/images/sm_fish.gif     |
      | https://petstore.octoperf.com/images/sm_dogs.gif     |
      | https://petstore.octoperf.com/images/sm_reptiles.gif |
      | https://petstore.octoperf.com/images/sm_cats.gif     |
      | https://petstore.octoperf.com/images/sm_birds.gif    |
    And The "src" values of the "Separator Images In The Menu Content Section" should match the expected values:
      | https://petstore.octoperf.com/images/separator.gif |
      | https://petstore.octoperf.com/images/separator.gif |
    And The "src" values of the "Separator Images In The Quick Links Section" should match the expected values:
      | https://petstore.octoperf.com/images/separator.gif |
      | https://petstore.octoperf.com/images/separator.gif |
      | https://petstore.octoperf.com/images/separator.gif |
      | https://petstore.octoperf.com/images/separator.gif |
    And The "href" values of the "Sidebar Links" should match the expected values:
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS    |
    And The "src" values of the "Sidebar Images" should match the expected values:
      | https://petstore.octoperf.com/images/fish_icon.gif     |
      | https://petstore.octoperf.com/images/dogs_icon.gif     |
      | https://petstore.octoperf.com/images/cats_icon.gif     |
      | https://petstore.octoperf.com/images/reptiles_icon.gif |
      | https://petstore.octoperf.com/images/birds_icon.gif    |
    And The "alt" values of the "Main Image Links" should match the expected values:
      | Birds    |
      | Fish     |
      | Dogs     |
      | Reptiles |
      | Cats     |
      | Birds    |
    And The "coords" values of the "Main Image Links" should match the expected values:
      | 72,2,280,250    |
      | 2,180,72,250    |
      | 60,250,130,320  |
      | 140,270,210,340 |
      | 225,240,295,310 |
      | 280,180,350,250 |
    And The "href" values of the "Main Image Links" should match the expected values:
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS    |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     |
      | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS    |

  # This scenario verifies that clicking on various links on the Catalog page navigates to the expected pages with the correct titles and URLs.
  @us02ac05
  Scenario Outline: Verify Navigation from Various Links
    When I click on the "<link>"
    Then The page title "<pageTitle>" and the URL "<pageURL>" should match the expected value
    Examples:
      | link                                   | pageTitle                                   | pageURL                                                          |
      | Cart Link                              | JPetStore Demo                              | https://petstore.octoperf.com/actions/Cart.action?viewCart=      |
      | Sign-In Link                           | JPetStore Demo                              | https://petstore.octoperf.com/actions/Account.action?signonForm= |
      | Help Link                              | JPetStore Demo                              | https://petstore.octoperf.com/help.html                          |
      | OctoPerf Link In The CTA Section       | SaaS and On-Premise Load Testing - OctoPerf | https://octoperf.com/                                            |
      | OctoPerf Link In The PoweredBy Section | SaaS and On-Premise Load Testing - OctoPerf | https://octoperf.com/                                            |
      | MyBatis Link In The PoweredBy Section  | The MyBatis Blog                            | https://blog.mybatis.org/                                        |

  # This scenario verifies that clicking on the sidebar links navigates to the expected pages with the correct titles and URLs.
  @us02ac06
  Scenario Outline: Verify Navigation from Sidebar Links
    When I click on the "<link>" in the sidebar section
    Then The page title "<pageTitle>" and the URL "<pageURL>" should match the expected value
    Examples:
      | link     | pageTitle      | pageURL                                                                                |
      | Fish     | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     |
      | Dogs     | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     |
      | Cats     | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     |
      | Reptiles | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES |
      | Birds    | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS    |

  # This scenario verifies that clicking on the quick links navigates to the expected pages with the correct titles and URLs.
  @us02ac07
  Scenario Outline: Verify Navigation from Quick Links Section
    When I click on the "<link>" in the quick links section
    Then The page title "<pageTitle>" and the URL "<pageURL>" should match the expected value
    Examples:
      | link     | pageTitle      | pageURL                                                                                |
      | Fish     | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     |
      | Dogs     | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     |
      | Reptiles | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES |
      | Cats     | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     |
      | Birds    | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS    |

  # This scenario verifies that clicking on the main image links navigates to the expected pages with the correct titles and URLs.
  @us02ac08
  Scenario Outline: Verify Navigation from Main Image Section
    When I click on the "<link>" in the main image section
    Then The page title "<pageTitle>" and the URL "<pageURL>" should match the expected value
    Examples:
      | link     | pageTitle      | pageURL                                                                                |
      | Fish     | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=FISH     |
      | Dogs     | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=DOGS     |
      | Reptiles | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=REPTILES |
      | Cats     | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=CATS     |
      | Birds    | JPetStore Demo | https://petstore.octoperf.com/actions/Catalog.action?viewCategory=&categoryId=BIRDS    |