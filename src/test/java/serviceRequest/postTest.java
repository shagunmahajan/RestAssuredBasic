package serviceRequest;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class postTest {

	String baseUrl = "https://reqres.in";
	String postUrl = baseUrl + "/api/login";

	@Test
	public void getResponseLoginSsuccessFulPostTest() {

		HashMap addData = new HashMap();
		addData.put("email", "eve.holt@reqres.in");
		addData.put("password", "cityslicka");
		given().contentType(ContentType.JSON).body(addData).when().post(postUrl).then().statusCode(200).log().body()
				.extract().response();
	}

	@Test
	public void verifyLoginSuccessFulPostTest() {

		HashMap addData = new HashMap();
		addData.put("email", "eve.holt@reqres.in");
		addData.put("password", "cityslicka");
		given().contentType(ContentType.JSON).body(addData).when().post(postUrl).then().assertThat().statusCode(200).body("token", equalTo("QpwL5tke4Pnpja7X4"));;
	}

	@Test
	public void getResponseLoginUnsuccessFulPostTest() {

		HashMap updateData = new HashMap();
		updateData.put("email", "peter@klaven");

		given().contentType(ContentType.JSON).body(updateData).when().post(postUrl).then().statusCode(400).log().body()
				.extract().response();
	}

	@Test
	public void verifyLoginUnsuccessFulPostTest() {

		HashMap updateData = new HashMap();
		updateData.put("email", "peter@klaven");

		given().contentType(ContentType.JSON).body(updateData).when().post(postUrl).then().assertThat().statusCode(400);
	}
}
