package serviceRequest;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class patchTest {

	String baseUrl = "https://reqres.in";
	String PatchUrl = baseUrl + "/api/users/2";

	@Test
	public void getResponseUpdateUserPatchTest() {

		HashMap updateData = new HashMap();
		updateData.put("job","zion resident");
		
		given().contentType(ContentType.JSON)
        .body(updateData).when().patch(PatchUrl).then().statusCode(200).log().body().extract().response();
	}
	
	@Test
	public void verifyUpdateUserPatchTest() {
		given().contentType(ContentType.JSON)
        .body("{ \"job\": \"zion resident\" }").when().patch(PatchUrl).then().assertThat().statusCode(200);
	}
}
