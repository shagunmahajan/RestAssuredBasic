package serviceRequest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class getTest {

	String baseUrl = "https://reqres.in";

	@Test
	public void getResponseDataTest1() {
		Response response = RestAssured.get(baseUrl + "/api/users?page=2");

		System.out.println("The Status code is : " + response.getStatusCode());
		System.out.println("The response body is : " + response.asString());
		System.out.println("The response body is : " + response.getBody().asString());
		System.out.println("The response time is :" + response.getTime());
		System.out.println("The status line is :" + response.getStatusLine());
		System.out.println("The header-content type is :" + response.getHeader("content-type"));
	}
	
	@Test
	public void getResponseDataTest2() {

		String getUrl = baseUrl + "/api/users?page=2";
		System.out.println("The Status code is : " + get(getUrl).then().extract().statusCode());
		System.out.println("The response body is : " + get(getUrl).then().extract().asString());
		System.out.println("The response body is : " + get(getUrl).then().extract().body().asString());
		System.out.println("The response time is :" + get(getUrl).then().extract().time());
		System.out.println("The status line is :" + get(getUrl).then().extract().statusLine());
		System.out.println("The header-content type is :"+ get(getUrl).then().extract().header("content-type"));
	}

	@Test
	public void verifyResponseStatus() {
		given().when().get(baseUrl + "/api/users?page=2").then().assertThat().statusCode(200);
	}
	
	@Test
	public void getResponseDataSingleUser() {

		String getUrl = baseUrl + "/api/users/2";
		System.out.println("The Status code is : " + get(getUrl).then().extract().statusCode());
		System.out.println("The response body is : " + get(getUrl).then().extract().asString());
		System.out.println("The response body is : " + get(getUrl).then().extract().body().asString());
		System.out.println("The response time is :" + get(getUrl).then().extract().time());
		System.out.println("The status line is :" + get(getUrl).then().extract().statusLine());
		System.out.println("The header-content type is :"+ get(getUrl).then().extract().header("content-type"));
	}
	

	@Test
	public void verifyResponseStatusSingleUser() {
		given().when().get(baseUrl + "/api/users/2").then().assertThat().statusCode(200);
	}
}
