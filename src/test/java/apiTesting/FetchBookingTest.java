package apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class FetchBookingTest {
  @Test
  public void getAllBookings() {
	  RestAssured.baseURI ="https://restful-booker.herokuapp.com";
	  Response response = RestAssured.get("/booking");
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, 200);
	  Assert.assertEquals(response.getContentType(),
			  "application/json; charset=utf-8");
	  //retrieve the body of the Response
	  ResponseBody body = response.getBody();
	  String bodyAsString = body.asString();
	  System.out.println(bodyAsString);
  }
  @Test
  
  public void getBookingDetails() {
	  RestAssured.baseURI ="https://restful-booker.herokuapp.com";
	  Response response = RestAssured.get("/booking/2");
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, 200);
	  Assert.assertEquals(response.getContentType(),
			  "application/json; charset=utf-8");
	  System.out.println(response.getBody().asString());
	  JsonPath jsonPathEvaluator = response.jsonPath();
	  String fname = jsonPathEvaluator.getString("firstname");
	  Assert.assertEquals(fname, "Sally");
	  Assert.assertEquals(jsonPathEvaluator.get("additionalneeds"),"Breakfast");
  }


@Test

public void getDetails() {

	 RestAssured.baseURI ="https://conduit-realworld-example-app.fly.dev/#/";
	  Response response = RestAssured.get("/api/tags");
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode, 200);
	 // System.out.println(response.getStatusLine());
	  Assert.assertEquals(response.getContentType(),
			  "application/json; charset=utf-8");
	//retrieve the body of the Response
	  ResponseBody body = response.getBody();
	  String bodyAsString = body.asString();
	  System.out.println(bodyAsString);
}

//@Test
//
//public void queryParameter() {
//	
//	RestAssured.baseURI ="https://petstore.swagger.io/";
////	  Response response = RestAssured.get("/pet/findPetsByStatus");
//	RequestSpecification request =RestAssured.given();
//	.accept("application/json")
//	z.queryParam("status", available)
//	.get("/pet/findBystatus")
////	Response response = request.queryParam(null, null);
//	String jsonString = response.asString();
//	System.out.println(response.getStatusCode());
//	System.out.println(jsonString);
//	Assert.assertEquals(jsonString.contains("London"),true);


}
