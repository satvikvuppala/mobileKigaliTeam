Feature: Forms

    @App_wdiodemo
    Scenario: Interact with form elements
    When the user taps on Forms link
    And the user fills the form
    And the user taps on Active button
    And the user taps on OK button from the popup
    Then popup should close