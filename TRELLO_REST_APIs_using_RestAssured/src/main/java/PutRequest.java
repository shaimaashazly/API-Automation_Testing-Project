import io.restassured.response.Response;

public class PutRequest extends RequestServer{


    public PutRequest(String uri, String endPoint) {
        super(uri, endPoint);
    }
    @Override
    public Response send() {
        return request.when().put();
    }
}
