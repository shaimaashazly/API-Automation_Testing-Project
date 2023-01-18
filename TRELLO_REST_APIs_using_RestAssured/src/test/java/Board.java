import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

@Test
public class Board {
    @Test(priority = 1)
    public void createBoardInOrganization() {
        System.out.println("ORGANIZATION ID = " + EnviromentVariables.ORGANIZATION_ID);
        PostRequest createBoardRequest = new PostRequest(EnviromentVariables.BASE_URL, EnviromentVariables.CREATE_BOARD_IN_ORGANIZATION);
        createBoardRequest.addQueryParam("name", "restassured_board");
        createBoardRequest.addQueryParam(EnviromentVariables.ORGANIZATION_ID_KEY, EnviromentVariables.ORGANIZATION_ID);

        Response createResponse = createBoardRequest.send();
        System.out.println("Create Board status code = " + createResponse.getStatusCode());
        createResponse.prettyPrint();

        JsonPath path = createResponse.jsonPath();
        String boardId = path.getString("id");
        System.out.println("boardId = " + boardId);
        EnviromentVariables.BOARD_ID = boardId;

    }

    @Test(priority = 2)
    public void getBoardsInOrganization() {
        GetRequest getBoardsRequest = new GetRequest(EnviromentVariables.BASE_URL, EnviromentVariables.GET_BOARDS_IN_ORGANIZATION);
        getBoardsRequest.addPathParam(EnviromentVariables.ID_KEY, EnviromentVariables.ORGANIZATION_ID);
        Response getBoardsResponse = getBoardsRequest.send();
        System.out.println("GET BOARDS IN ORGANIZATION STATUS CODE : " + getBoardsResponse.statusCode());
        getBoardsResponse.prettyPrint();

    }
}
