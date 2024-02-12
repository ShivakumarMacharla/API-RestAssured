package Day4;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;


public class ParsingJSONResponseData_001 {
	
//	@Test(priority=2)
	void testJsonResponse1(){
		//Approach 1
		given()
			
		.when()
			.get("https://reqres.in/api/users/4")
		.then()
			.statusCode(200)
			.header("Cache-Control","max-age=14400")
			.body("data.first_name",equalTo("Eve"))
//			.body(".data.id",equalTo("4"))
			.body("support.url",equalTo("https://reqres.in/#support-heading"));
		
		
	}
	
//	@Test(priority=1)
	void testJsonResponse2() {
		//Approach 2
		
		Response rep = given()
			.contentType("Content-Type.JSON")
		.when()
		.get("https://reqres.in/api/users/4");
		
		Assert.assertEquals(rep.getStatusCode(),200);
		Assert.assertEquals(rep.header("Server"),"cloudflare");
		Assert.assertEquals(rep.header("Content-Encoding"),"gzip");
		Assert.assertEquals(rep.body().jsonPath().get("data.last_name"),"Holt");
		Assert.assertEquals(rep.body().jsonPath().get("data.avatar"),"https://reqres.in/img/faces/4-image.jpg");
		String lastName = rep.jsonPath().get("data.last_name").toString();
		
		Assert.assertEquals(lastName, "Holt");
	}

	
//	@Test(priority=0)
	void testJsonResponse3() {
		
		//Approach 3
		Response rep = given()
			.contentType("Content-Type.JSON")
		.when()
		.get("https://reqres.in/api/users/");
		
		String url = rep.jsonPath().get("support.url").toString();
		Assert.assertEquals(url,"https://reqres.in/#support-heading");
		//create the JSON Object
		JSONObject jo = new JSONObject(rep.asString()); ///convert the response to JSON Object type
	boolean status = false;
		for(int i=0;i<jo.getJSONArray("data").length();i++) {
			String FirstName = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
		//	String LastName = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
			System.out.println("FirstName: "+FirstName);
		//	System.out.println("LastName: "+LastName);
		//	String avatar = jo.getJSONArray("data").getJSONObject(i).get("avatar").toString();
		//	Assert.assertEquals(avatar,  "https://reqres.in/img/faces/6-image.jpg");
		//  Assert.assertEquals(avatar, "https://reqres.in/img/faces/1-image.jpg");
		 
		 
		 
		
			
		   if(FirstName.equals("George")) {
			   status = true;
			   break;
		   }
		}
		Assert.assertEquals(status, true);
	}
	
	
	@Test
	void testJsonResponse4() {
		
		Response rep = given()
			.contentType("Content-Type.JSoN")
		.when()
			.get("https://reqres.in/api/users/");
		
		double totalId = 0;
		JSONObject jo = new JSONObject(rep.asString());
		for(int i=0;i<jo.getJSONArray("data").length();i++){
			
	   String Id = jo.getJSONArray("data").getJSONObject(i).get("id").toString();
	   
		totalId = totalId + Double.parseDouble(Id);  //Double.parseDouble --> this will convert into double
	
		
		}
		System.out.println("total price: "+totalId);
	}
	
}












