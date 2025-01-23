Feature: JSONPlaceholder API testing

  Scenario: GET request for a single todo item
    Given I make a GET request to "https://jsonplaceholder.typicode.com/todos/1"
    When I send the request
    Then the response status code should be 200

  Scenario: POST request to create a new post
    Given I make a POST request to "https://jsonplaceholder.typicode.com/posts" with body:
      """
      {
        "title": "foo",
        "body": "bar",
        "userId": 1
      }
      """
    When I send the request
    Then the response status code should be 201

  Scenario: PUT request to update a post
    Given I make a PUT request to "https://jsonplaceholder.typicode.com/posts/1" with body:
      """
      {
        "id": 1,
        "title": "foo",
        "body": "bar",
        "userId": 1
      }
      """
    When I send the request
    Then the response status code should be 200

  Scenario: DELETE request to delete a post
    Given I make a DELETE request to "https://jsonplaceholder.typicode.com/posts/1"
    When I send the request
    Then the response status code should be 200
