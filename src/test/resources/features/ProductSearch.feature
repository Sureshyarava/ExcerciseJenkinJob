@AmazonFeatureTest
Feature: As an amazon user
         I want to search for products
         So that I can compare the products

  Scenario: Search for mobile related products.
    Given the user is at Amazon Home Page
    When the user searches for "mobile" in the search bar
    Then the user gets the search results

  Scenario Outline: Search for mobile related products by applying different filters
    Given search results for "mobile" are shown
    When user selects the "<deliveryDay>" under Delivery Day section
    Then the user gets the filtered search results
    And the user verifies the results obtained using this "<deliveryDay>"
    Examples:
      | deliveryDay             |
      | Get It by Tomorrow |

