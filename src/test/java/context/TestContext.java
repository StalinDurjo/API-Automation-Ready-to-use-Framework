package context;

import com.fasterxml.jackson.databind.JsonNode;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import request.REQUEST_TYPE;
import request.Request;
import support.Print;
import test_data.UserData;

import java.util.HashMap;
import java.util.Map;

public class TestContext {
    private static ResponseOptions<Response> response;
    private static String accessToken;
    private static final Map<String, Object> globalVariable = new HashMap<>();

    public static ResponseOptions<Response> getResponse() {
        return response;
    }

    public static void setResponse(ResponseOptions<Response> response) {
        TestContext.response = response;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        TestContext.accessToken = accessToken;
    }

    public static Request request(String uri, REQUEST_TYPE method){
        return request(uri, method, null);
    }

    public static Request request(String uri, REQUEST_TYPE method, String accessToken){
        return new Request(uri, method, accessToken);
    }

    public void setGlobalVariable(String key, Object value){
        if(value instanceof JsonNode)
            throw new RuntimeException("Instance of JsonNode should not be saved. Parse value into Java primitive types. Exception called from " + TestContext.class + " -> setGlobalVariable() method");

        globalVariable.put(key.toLowerCase(), value);
    }

    public Object getGlobalVariable(String key){

        if(globalVariable.get(key) == null)
            Print.errorMessage("Global variable '" + key + "' is null");

        return globalVariable.get(key);
    }

    public void clearGlobalVariable(){
        globalVariable.clear();
    }

    public UserData userDetails(){
        return new UserData();
    }
}
