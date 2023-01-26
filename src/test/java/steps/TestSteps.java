package steps;

import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static request.REQUEST_TYPE.GET;

public class TestSteps extends TestContext {
    TestContext testContext;

    public TestSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("^user sends GET request on v1/current.json with query parameter - london$")
    public void user_sends_get_request_on_v1_current_json_key_q() {
        Map<String, String> queryParam = new HashMap<>();
        queryParam.put("key", "f4af4c9dc10f41efa6c162548232601");
        queryParam.put("q", "London");

        var request = request("/v1/current.json", GET);
        var response = request.executeWithQueryParams(queryParam);

        setResponse(response);
    }
    @Then("^user receives response body with status code 200$")
    public void user_receives_response_body_with_status_code() {
        var response = getResponse();
        assertThat(response.getStatusCode(), comparesEqualTo(200));
    }
}
