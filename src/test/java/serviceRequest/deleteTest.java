package serviceRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class deleteTest {

	String baseUrl = "https://reqres.in";
	
	@Test
	public void deleteUserTest() {
		String deleteUrl = baseUrl + "/api/users/2";
		given().when().delete(deleteUrl).then().assertThat().statusCode(204);
	}
}
