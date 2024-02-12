package Day3;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo_001 {

//	@Test
	void testHeader() {
		given()
		.when()
			.get("https://www.google.com/")
		.then()
			.header("X-XSS-Protection", "0")
			.and()
			.header("Server","gws");
	}
	
//	@Test
	void GettestHeader1() {
		Response rep = given()
		.when()
			.get("https://www.google.com");
		//Get specific header
	String header =	rep.getHeader("Set-Cookie");
	System.out.println(header);
		
	}
	
	@Test
	void GettestHeader2() {
		Response rep = given()
		.when()
			.get("https://www.google.com/");
		
		Headers myheader = rep.getHeaders();
		for(Header hd : myheader) {
			System.out.println(hd.getName()+": "+hd.getValue());
		}
		
		
	}
}
