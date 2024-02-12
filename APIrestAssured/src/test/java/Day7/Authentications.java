package Day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {

	
//	@Test(priority = 1)
	void testBasicAuthentication() {
		
		given()
			.auth().basic("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
			
		
		.then()
			.statusCode(200)
			.body("authentication",equalTo(true))
			.log().all();
		
	}
	
//	@Test(priority = 2)
	void testDigestAuthentication() {
		
		given()
			.auth().digest("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authentication",equalTo(true))
			.log().all();
		
	}
	
	
//	@Test(priority = 3)
	void testPreemptiveAuthentication() {
		
		given()
			.auth().preemptive().basic("postman", "password")
		
		.when()
			.get("https://postman-echo.com/basic-auth")
		
		.then()
			.statusCode(200)
			.body("authentication",equalTo(true))
			.log().all();
		
	}
	
//	@Test(priority = 4)
	void testBearerTokenAuthentication() {
		
		String bearerToken = "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";
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.headers("Accept-Encoding","gzip, deflate, br")
			.headers("X-OAuth-Scopes","repo, workflow")
		
		.when()
			.get("https://api.github.com/user/repos")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
//	@Testpriority = 5)
	void testOAuth_1Authentication() {
		
		String url = "https://api.github.com/user/repos";
		
		given()
			.auth().oauth("consumerKey", "consumerSecrat", "accessToken", "tokenSecrate")
			// In OAuth 1.0 we need to pass muntiple values as shown in above
		.when()
			.get(url)
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
//	@Test(
	void testOAuth_2Authentication() {
		String url = "https://api.github.com/user/repos";
		
		given()
			.auth().oauth2("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")
		.when()	
			.get(url)
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 6)
 	void testAPIKeyAuthentication() {
		//method 1
		given()
			.queryParam("", null)
		
		.when()
		
		.then()
		
 		
 	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
