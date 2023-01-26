package request;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static constants.URL.BASE_URL;
import static request.REQUEST_TYPE.*;

public class Request {
    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private REQUEST_TYPE method;
    private String url;

    public Request(String uri, REQUEST_TYPE method, String accessToken){
        this.url = BASE_URL() + uri;
        this.method = method;

        if(accessToken != null){
            builder.addHeader("Authorization", "Bearer " + accessToken);
        }
    }

    private ResponseOptions<Response> executeAPI(){
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpecification);

        if(this.method.equals(GET)){
            return request.get(this.url);
        }else if(this.method.equals(POST)){
            return request.post(this.url);
        }else if(this.method.equals(DELETE)){
            return request.delete(this.url);
        }else if(this.method.equals(PUT)){
            return request.put(this.url);
        }

        return null;
    }

    public ResponseOptions<Response> executeWithBody(Map<?,?> body){
        builder.setBody(body);
        return executeAPI();
    }

    public ResponseOptions<Response> executeWithQueryParams(Map<String,?> queryParams){
        builder.addQueryParams(queryParams);
        return executeAPI();
    }

    public ResponseOptions<Response> execute(){
        return executeAPI();
    }
}
