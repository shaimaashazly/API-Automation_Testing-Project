import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteAll {
    @Test(priority = 1)
    public void archiveList() {
        PutRequest archiveListRequest = new PutRequest(EnviromentVariables.BASE_URL,
                EnviromentVariables.ARCHIVE_LIST);
        archiveListRequest.addPathParam(EnviromentVariables.ID_KEY, EnviromentVariables.LIST_ID);
        Response archiveListResponse = archiveListRequest.send();
        archiveListResponse.prettyPrint();
        System.out.println("Archive List Status Code : " + archiveListResponse.statusCode());
    }

    @Test(priority = 2)
    public void deleteBoard() {
        DeleteRequest deleteBoardRequest = new DeleteRequest(EnviromentVariables.BASE_URL,
                EnviromentVariables.DELETE_BOARD);
        deleteBoardRequest.addPathParam(EnviromentVariables.ID_KEY, EnviromentVariables.BOARD_ID);
        Response deleteBoardResponse = deleteBoardRequest.send();
        deleteBoardResponse.prettyPrint();
        System.out.println("Delete Board Status Code : " + deleteBoardResponse.statusCode());
    }

    @Test(priority = 3)
    public void deleteOrganization() {
        DeleteRequest deleteOrganizationRequest = new DeleteRequest(EnviromentVariables.BASE_URL,
                EnviromentVariables.DELETE_ORGANIZATION);
        deleteOrganizationRequest.addPathParam(EnviromentVariables.ID_KEY, EnviromentVariables.ORGANIZATION_ID);
        Response deleteOrganizationResponse = deleteOrganizationRequest.send();
        deleteOrganizationResponse.prettyPrint();
        System.out.println("Delete Board Status Code : " + deleteOrganizationResponse.statusCode());
    }
}
