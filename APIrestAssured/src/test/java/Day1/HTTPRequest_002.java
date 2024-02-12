package Day1;

import  org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class HTTPRequest_002 {
	int id;
	
	@Test
	void getUser() {
		//get method
		given()
		
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void creatUser() {
		//post method
		HashMap data  = new HashMap();
		data.put("secondname","kumar");
		data.put("firstname", "shiva");
		data.put("age", "23");
		
		id = given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("  id");
		
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
	@Test
	void updateUser() {
		//put method
		given()
		
		.when()
			.put("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void deleteUser() {
		//delete method
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}

}
