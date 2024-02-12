package Day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import  org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
public class DiffWaysToCreatePostRequestBody {
	int id;
	
/*	POST
	Different  ways we create request body..?

	1)HashMap
	2)using org.json
	3)using POJO (Plain Old Java Object)	
	4)using external json file
	
	*/
//		@Test
		void CreatePostUsingHashMap() {
//			1)HashMap
			
		}
		
//		@Test
		void deleteUser() {
			
			given()
			.when()
				.delete("https://reqres.in/api/users"+id)
				
			.then()
				.statusCode(204)
				.log().all();
		}
		

//	//	@Test
		void CreatePostUsingOrgJson() {
			// 2) Post request body using org.json libray
			JSONObject data = new JSONObject();
	
			data.put("name","shiva");
			data.put("location", "vijayawada");
			data.put("phone", "1234");
			
			id =  given()
				.contentType("application/json")
				.body(data.toString())
			
			.when()
				.post("https://reqres.in/api/users")
				.jsonPath().getInt(" id");
			
		/*	.then()
				.statusCode(201)
				.body("name",equalTo("shiva"))
				.body("location",equalTo("vijayawada"))
				.header("Content-Type","application/json; charset=utf-8")
	   			.log().all();
	   			
	   		*/	
		}			
//	//	    @Test
		    void deleteUser1() {
		    	
		    	given()
		    	.when()
		    		.delete("https://reqres.in/api/users"+id)
		    	.then()
		    		.statusCode(204)
		    		.log().all();
		    }
		
	
		
//		3)using POJO (Plain Old Java Object)	
		
//		@Test
		void CreatePostUsingPOJO() {
			
			Pojo_PostRequest data = new Pojo_PostRequest();
			
			data.setName("raju");
			data.setLocation("banguluru");
			data.setPhone("987453210");
			
			given()
				.contentType("application/json")
				.body(data)
			
			.when()
				.put("https://reqres.in/api/users")
			.then()
				.statusCode(201)
				.body("name",equalTo("raju"))
				.body("location",equalTo("banguluru"))
				.body("phone",equalTo("987453210"))
				.log().all();
			
		}
		
//		4)using external json file
			
		@Test
		void CreatePostUsingExternalJson() throws FileNotFoundException {
			
			File f = new File(".\\body.json");
			FileReader fr = new FileReader(f);
			JSONTokener jt = new JSONTokener(fr);
			JSONObject data = new JSONObject(jt);
			
			given()
				.contentType("application/json")
				.body(data.toString())
			
			.when()
				.post("https://reqres.in/api/users/2")
			
			.then()
			    .statusCode(201)
				.body("name",equalTo("Scott"))
				.body("location",equalTo("France"))
				.body("phone",equalTo("12347"))
				.log().all();
		}
	
}