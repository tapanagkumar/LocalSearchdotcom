@SearchStep
Feature: Test to Search for an
  Item using local search.


  @SearchStep-One
  Scenario Outline: I should be able to search using LocalSearch
    Given I am on the Home Page of Website "https://www.localsearch.com.au/"
    When I enter "<searchword>" in the search field
    And I click search key
    Then the search "<businessProfileName>" should match

    Examples:

      |searchword|businessProfileName|
      |Electrical |JVK Electrical|
      |Restaurants |Cocotte Dining in Robina|


  @SearchStep-Two
  Scenario Outline: I should be able to search using popular searches
    Given I am on the Home Page of Website "https://www.localsearch.com.au/"
    When I click on any "<category>" item from popular searches
    And choose an item from the list
    Then the search "<businessProfileName>" should match

    Examples:
      |category|businessProfileName|
      |Excavating & Earthmovers|Axle’s Earthmoving & Civil Works P/L|