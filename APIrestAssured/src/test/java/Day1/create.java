package Day1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class create {
	
	@Test
	void CreateUser() {
		
		JSONObject object  = new JSONObject();
		
		object.put("name", "kumar");
		object.put("job", "it");
		
		RestAssured
		     .given()
		     .when()
		     	.post("https://reqres.in/api/users")
		     .then()
		     	.statusCode(201);
		
		
		
	}

}
