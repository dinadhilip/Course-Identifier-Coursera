Feature: IdentifyCourse

Scenario: Course Details
    Given the user is navigated to coursera home page
    When user searches for webdevelopment courses,it should display all the web development courses
    Then the user clicks on English and Beginner checkbox,it should display the courses according to the filters.
    And the user should extract the details of first two courses.
    Then the user is navigated to Language learning page.
    Then user clicks on show all button in language section,it should display all the languages.
    Then the user should print all the levels with its count.
    And the user should print all the languages with its count in the console.
    Then the user is navigated to Home page.
    Then the user is click to enterprises.
    Then the user is navigated to enterprises page.
    Then the user should fill the form with valid details except for mail.
    And an error msg will be displayed for the mail and user have to capture that msg and display it.