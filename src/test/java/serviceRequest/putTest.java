package serviceRequest;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import java.util.HashMap;

public class putTest {

	String baseUrl = "https://reqres.in";
	String putUrl = baseUrl + "/api/users/2";

	@Test
	public void getResponseUpdateUserPutTest() {

		HashMap updateData = new HashMap();
		updateData.put("job","zion resident");
		
		given().contentType(ContentType.JSON)
        .body(updateData).when().put(putUrl).then().statusCode(200).log().body().extract().response();
	}
	
	@Test
	public void verifyUpdateUserPutTest() {
		given().contentType(ContentType.JSON)
        .body("{ \"job\": \"zion resident\" }").when().put(putUrl).then().assertThat().statusCode(200);
	}
}
