package Day1;

import  org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequest_001 {
	int id;
	String name;
	
	//Get method
	@Test(priority=0)
	void getUsers() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
		
	}
	
	
	//Get Method
	// @Test(priority=1)
	 void getUser() {
		 
		 given()
		 
		 .when()
		 	.get("https://reqres.in/api/users/2")
		 
		 .then()
		 	.statusCode(200)
		 	.body("data.id", equalTo(2))
		 	.log().all();
		 
		
	}
	 //post method
	 @Test(priority=2)
	 void createUser() {
		 
		 HashMap data = new HashMap();
		 data.put("name","shiva");
		 data.put("job","IT");
		 data.put("surname","macharla");
		 
		 given()
		 	.contentType("application/json")
		 	.body(data)
		 
		 .when()
		 	.post("https://reqres.in/api/users")
		 //	.jsonPath().getInt("id");
		//	.jsonPath().getString("name");
		 
		 .then()
		 	.statusCode(201)
		 	.log().all();
		 	
	 }
	 
	 //put method
//	 @Test(priority=3,dependsOnMethods= {"createUser"} )
	 void updateUser() {
		 HashMap data = new HashMap();
		 data.put("name","siri");
		 data.put("job","ITC");
		 
		 given()
		 	.contentType("application/json")
		 	.body(data)
		 
		 .when()
		// 	.put("https://reqres.in/api/users/"+id)
		 	.put("https://reqres.in/api/users/"+name)
		 
		 .then()
		 	.statusCode(200)
		 	.log().all();
		 
	 }
	 
	// @Test(priority = 4)
	 void deleteUser() {
		//Delete 
		 given()
		 
		 .when()
		 	.delete("https://reqres.in/api/users/"+name)
		 
		 .then()
		 	.statusCode(204)
		 	.log().all();
		 
		 
	 }
	 
	
}

/*	we use three methods 
   given()
   	> content type cookies,add auth, add param,set header info ect...
   when()
   	> get,post,put,delete...
   then()
  	> validate status code,extract response,extract headers cookies and response body...
 */


