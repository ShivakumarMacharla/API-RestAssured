package Day8;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class CreateUser {
	
	@Test
	void testCreateUser() {
		
		Faker faker = new Faker();
		
		JSONObject data = new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("Gender", "Male");
		data.put("Email",faker.internet().emailAddress());
		   
		String barertoken  = "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";
		
	  RequestSender rep = given()
			.headers("Authorization","Bearer "+barertoken)
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("https://api.github.com/user/repos")
			.jsonPath().get("id");
	  System.out.println("Generated ID : "+rep);
//		.then()
//			.statusCode(200)
//			.log().all();
//			
		
		
		
	}

}
