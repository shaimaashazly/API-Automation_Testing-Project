import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

@Test
public class Organization {
    @Test(priority = 1)
    public void createNewOrganization() {
        PostRequest createOrganizationRequest = new PostRequest(EnviromentVariables.BASE_URL, EnviromentVariables.CREATE_ORGANIZATION_URL);
        createOrganizationRequest.addQueryParam("displayName", "Rest_Api_With_RestAssured");

        Response createResponse = createOrganizationRequest.send();
        System.out.println("Create Organization status code = " + createResponse.getStatusCode());
        createResponse.prettyPrint();

        JsonPath path = createResponse.jsonPath();
        String organizationId = path.getString("id");
        System.out.println("organizationId = " + organizationId);
        EnviromentVariables.ORGANIZATION_ID = organizationId;

    }

    @Test(priority = 2)
    public void getOrganizationForMember() {
        GetRequest getMemberOrganizationRequest = new GetRequest(EnviromentVariables.BASE_URL, EnviromentVariables.GET_MEMBER_ORGANIZATION);
        getMemberOrganizationRequest.addPathParam("id", EnviromentVariables.MEMBER_ID);
        Response organizationResponse = getMemberOrganizationRequest.send();
        System.out.println(" Get Organizations status code = " + organizationResponse.getStatusCode());
        organizationResponse.prettyPrint();

    }
}
