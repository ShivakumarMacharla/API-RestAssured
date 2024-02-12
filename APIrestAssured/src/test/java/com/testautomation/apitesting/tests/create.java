package com.testautomation.apitesting.tests;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class create {

	@Test
	void postuser() {
		
		JSONObject object = new JSONObject();
		object.put("name","shiva");
		object.put("job", "IT");
		
		Response rep =
		(Response)RestAssured
		.given()
//		.log().all()
		.when()
			.post("https://reqres.in/api/users");
			
		Assert.assertEquals(rep.header("Connection"),("keep-alive"));
		Assert.assertEquals(rep.getStatusCode(),201);
			
//		.then()
//		.statusCode(201);
//		
		
	}
}
