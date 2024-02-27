Feature: Actions

    @App_ApiDemos
    Scenario: Long Click Gesture
        When a user tap on views link
        And the user tap on Drag and Drop link
        And the user long clicks on the textless circle
        Then the message "Dropped!" should be displayed