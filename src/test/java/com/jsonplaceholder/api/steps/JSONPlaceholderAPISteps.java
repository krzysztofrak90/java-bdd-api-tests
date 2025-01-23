package com.jsonplaceholder.api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONPlaceholderAPISteps {

    private Response response;
    private String method;
    private String url;
    private String body;

    @Given("I make a GET request to {string}")
    public void iMakeAGETRequestTo(String url) {
        this.method = "GET";
        this.url = url;
    }

    @Given("I make a POST request to {string} with body:")
    public void iMakeAPOSTRequestToWithBody(String url, String body) {
        this.method = "POST";
        this.url = url;
        this.body = body;
    }

    @Given("I make a PUT request to {string} with body:")
    public void iMakeAPUTRequestToWithBody(String url, String body) {
        this.method = "PUT";
        this.url = url;
        this.body = body;
    }

    @Given("I make a DELETE request to {string}")
    public void iMakeADELETERequestTo(String url) {
        this.method = "DELETE";
        this.url = url;
    }

    @When("I send the request")
    public void iSendTheRequest() {
        switch (method) {
            case "GET":
                response = RestAssured.get(url);
                break;
            case "POST":
                response = RestAssured
                        .given()
                        .header("Content-Type", "application/json")
                        .body(body)
                        .post(url);
                break;
            case "PUT":
                response = RestAssured
                        .given()
                        .header("Content-Type", "application/json")
                        .body(body)
                        .put(url);
                break;
            case "DELETE":
                response = RestAssured.delete(url);
                break;
        }
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }
}
