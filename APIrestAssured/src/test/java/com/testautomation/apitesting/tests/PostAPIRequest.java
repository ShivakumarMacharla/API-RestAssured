//package com.testautomation.apitesting.tests;
//
//import org.json.simple.JSONObject;
//import org.testng.annotations.Test;
//
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//
//public class PostAPIRequest {
//
//	@SuppressWarnings("unchecked")
//	@Test
//	void createBooking() {
//		//prepare request body
//		JSONObject booking  = new JSONObject();
//		JSONObject bookingDate = new JSONObject();
//		
//		booking.put("firstname","kumar");
//		booking.put("lastname", "macharla");
//		booking.put("totalprice", 3535);
//		booking.put("depositpaid",true);
//		booking.put("bookingdates", bookingDate);
//		
//		bookingDate.put("Checkin", "2023-03-34");
//		bookingDate.put("Checkout", "2023-03-47");
//		
//		
//		RestAssured
//			.given()
//				.contentType(ContentType.JSON)
//				.body(booking.toString())
//				.baseUri("https://restful-booker.herokuapp.com/booking")
//			.when()
//				.post()
//			.then()
//				.assertThat()
//			//	.statusCode(200)
//				.log().all();
//		
//		
//		
//		
//		
//		
//	}
//}
