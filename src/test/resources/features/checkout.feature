Feature: Checkout functionality

  Scenario: Successful checkout
    Given user is logged in
    When user adds product to cart
    And user proceeds to checkout
    And user enters checkout details
    Then order should be placed successfully

  Scenario: Checkout with missing details
    Given user is logged in
    When user adds product to cart
    And user proceeds to checkout
    And user enters incomplete details
    Then error message should be shown