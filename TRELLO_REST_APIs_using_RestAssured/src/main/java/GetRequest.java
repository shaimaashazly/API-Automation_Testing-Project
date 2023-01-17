import io.restassured.response.Response;

public class GetRequest extends RequestServer {

    public GetRequest(String uri, String endPoint) {
        super(uri , endPoint);

    }
    public Response send() {
        return request.when().get();
    }

}
