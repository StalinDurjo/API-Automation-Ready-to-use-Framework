Feature: Send GET request on weather API
  Scenario: Retrive current weather data for location "london"
    Given user sends GET request on v1/current.json with query parameter - london
    Then user receives response body with status code 200