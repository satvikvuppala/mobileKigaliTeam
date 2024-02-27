Feature: Swipe

    @App_ApiDemos
    Scenario: Swipe left
    When a user tap on views link
    And the user taps on Gallery link
    And the user taps on Photos link
    And the user swipes left on the first image
    Then the second image should be in focus