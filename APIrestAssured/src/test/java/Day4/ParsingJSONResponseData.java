package Day4;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;


public class ParsingJSONResponseData {
	
	@Test
	void testJsonResponse() {
		
		//approach 1
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/users/")
		.then()
			.statusCode(200)
			.header("content-type", "application/json; charset=utf-8")
			.body("data[3].first_name",equalTo("Eve"))
			.log().body();
			
		
		//Approach 2*********
	/*	Response rep = given()
		.when()
			.get("https://reqres.in/api/users/");
		Assert.assertEquals(rep.statusCode(),200);
		Assert.assertEquals(rep.header("content-type"),"application/json; charset=utf-8");
		String FirstName = rep.jsonPath().get("data[3].first_name").toString(); 
		Assert.assertEquals(FirstName, "Eve");
		
		*/
	}
	
//	@Test
	void testJsonResponseBodyData() {
		Response rep = given()
			.contentType(ContentType.JSON)
		.when()
			.get("https://reqres.in/api/users/");
		
		//using JSONObject class
		JSONObject jo = new JSONObject(rep.asString());	//converting response to JSON object
		
		//printing all the Emails from data
		for(int i=0;i<jo.getJSONArray("data").length();i++) {
		String lastName = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
		System.out.println("lastNAme: "+lastName);
		}
		
	}

}
