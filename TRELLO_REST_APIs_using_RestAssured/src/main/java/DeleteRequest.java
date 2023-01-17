import io.restassured.response.Response;

public class DeleteRequest extends RequestServer {
    public DeleteRequest(String uri, String endPoint) {
        super(uri, endPoint);
    }

    @Override
    public Response send() {
        return request.when().delete();
    }
}
