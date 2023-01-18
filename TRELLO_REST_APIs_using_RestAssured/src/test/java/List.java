import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class List {
    @Test(priority = 1)
    public void createNewList() {
        PostRequest createListRequest = new PostRequest(EnviromentVariables.BASE_URL,
                EnviromentVariables.CREATE_NEW_LIST_IN_BOARD);
        createListRequest.addQueryParam(EnviromentVariables.NAME_KEY, "restassurd_list");
        createListRequest.addQueryParam(EnviromentVariables.BOARD_ID_KEY, EnviromentVariables.BOARD_ID);

        Response createListResponse = createListRequest.send();
        System.out.println("CREATE NEW LIST STATUS CODE : " + createListResponse.statusCode());
        createListResponse.prettyPrint();

        JsonPath path = createListResponse.jsonPath();
        String listId = path.getString("id");
        System.out.println("listId = " + listId);
        EnviromentVariables.LIST_ID = listId;

    }

    @Test(priority = 2)
    public void getAllListsinBoard() {
        GetRequest getListRequest = new GetRequest(EnviromentVariables.BASE_URL, EnviromentVariables.GET_LISTS_IN_BOARD);
        getListRequest.addPathParam(EnviromentVariables.ID_KEY, EnviromentVariables.BOARD_ID);
        Response getListsResponse = getListRequest.send();
        System.out.println("GET Lists IN Board STATUS CODE : " + getListsResponse.statusCode());
        getListsResponse.prettyPrint();
    }

}
