Feature: Update Preferences

    @App_ApiDemos
    Scenario: Add WIFI settings
        When a user taps on preference link
        And the user taps on preference dependencies link
        And the user checks the WIFI checkbox
        And the user taps on WIFI settings
        And the user enters their WIFI settings name as "Norrsken"
        And the user taps on OK button
        Then WIFI settings should be saved