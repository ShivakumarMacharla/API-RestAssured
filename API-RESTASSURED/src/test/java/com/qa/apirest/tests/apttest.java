package com.qa.apirest.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class apttest {
	
	@Test
	public void get() {
		RestAssured
			.given()
			.when()
				.get("https://reqres.in/api/unknown/2")
			.then()
				.statusCode(200);
		
	}

}
