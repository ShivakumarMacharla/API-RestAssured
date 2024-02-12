package Day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

	public class HeaderDemo {
		
//	@Test
		void testHeaders() {
		
		given()
		.when()
			.get("https://www.google.com")
		
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.and()
			.header("Server", "gws")
			.log().all();
//			.log().headers();	// get only headers data
		}
		@Test
		void getHeader() {
			
			Response rep = given()
			.when()
				.get("https://www.google.com/");
			
			
			//Get single header Info
//			String headerValue = rep.getHeader("Content-Type");
//			System.out.println("the value of content type: "+headerValue);
			
			//Get all headers
			
			Headers myheaders = rep.getHeaders();
			for(Header hd :myheaders) {
				System.out.println(hd.getName()+"   "+hd.getValue());
				
			}
			
		}
		

	}



