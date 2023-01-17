import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class RequestServer {

    public String uri;
    public String endPoint;
    public RequestSpecification request;

    public RequestServer(String uri, String endPoint) {
        this.uri = uri;
        this.endPoint = endPoint;
        RestAssured.baseURI = this.uri;
        System.out.println(RestAssured.baseURI);
        RestAssured.basePath = this.endPoint;

        request = RestAssured.given();
        this.addQueryParam(EnviromentVariables.KEY, EnviromentVariables.KEY_VALUE);
        this.addQueryParam(EnviromentVariables.TOKEN, EnviromentVariables.TOKEN_VALUE);
        this.addHeader("Accept", "application/json");
        this.addHeader("Content-Type", "application/json");
    }

    public void addQueryParam(String key, String value) {
        request.queryParam(key, value);

    }

    public void addHeader(String name, String value) {
        request.header(name, value);
    }

    public void addPathParam(String key, String value) {
        request.pathParams(key, value);
    }

    public RequestSpecification getRequestSpecification() {
        return request;
    }

    public abstract Response send();
}
