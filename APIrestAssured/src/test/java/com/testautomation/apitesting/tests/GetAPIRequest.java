package com.testautomation.apitesting.tests;



import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GetAPIRequest {
	
	@Test
	void getrequest() {
		
		Response response =
		(Response) RestAssured
			.given()
				.contentType(ContentType.JSON)
				.baseUri("https://restful-booker.herokuapp.com/booking/87")
				
			.when()
				.get("https://restful-booker.herokuapp.com/booking/87")
//				Assert.assertEquals(response.getStatusCode(),200);	
//				Assert.assertEquals(response.header("Server"),"Cowboy");
//		    
//				// response body contains particular element
//				Assert.assertTrue(response.getBody().asString().contains("bookingid"));
		  
		    
		    .then()
     			.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.header("Connection", "keep-alive")
				
		 .extract()
	   		.response();
		
		String lastname = response.path("lastname");
		
		RestAssured
			.given()
				.contentType(ContentType.JSON)
				.pathParam("lastname",lastname)
				.baseUri("https://restful-booker.herokuapp.com/booking/87")
			.when()
				.get("https://restful-booker.herokuapp.com/booking/87")
			.then()
				.assertThat();
			//	.statusCode(200);
	    	
			//	.log().all();
	}

}