import io.restassured.response.Response;

public class PostRequest extends RequestServer {
    public PostRequest(String url, String endPoint) {
        super(url, endPoint);
    }

    @Override
    public Response send() {
        return request.when().post();
    }

}
