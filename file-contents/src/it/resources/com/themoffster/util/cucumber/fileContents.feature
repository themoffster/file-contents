Feature: Reading contents of a file
    Text files contain strings
    The contents of these files should be readable
    Files are able to be empty
    Non-text files aren't readable to humans

  Scenario: Reading contents of a non-empty text file
    Given I have a text file containing text
    When I read the contents of the file
    Then I should be returned a string which matches the file contents
    
  Scenario: Reading an empty text file
    Given I have an empty text file
    When I read the contents of the file
    Then I should be returned an empty string
    
  Scenario: Reading contents of a file that isn't text
    Given I have a non text file
    When I read the contents of the file
    Then I should get be returned a string which is not human readable