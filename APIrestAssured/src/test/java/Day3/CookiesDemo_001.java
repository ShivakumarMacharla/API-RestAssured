package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class CookiesDemo_001 {
//	@Test
	void testCookies() {
		
		 given()
		.when()
			.get("https://www.google.com")
		
		.then()
			.cookie("NID","511%3DtlLCzwxqASCIdJhnr9qASXTXs0lFJDL4tCPbuT7sbv_2h49M9oiZ536-w2H3JEb9_dTaEhqzOcN37fLqmrPuoXxpX2Hj5OYJV4AeC552lcv0kY4PzZczKnSDjJvIre-kjlRBOrPbe-nfDj9voSiI-n7Y1LYBLtLkeO6pn6FkBz0");
		
	}
	
	
	@Test
	void testCookies_Info() {
		Response rep = given()
		.when()
			.get("https://www.google.com");
		
		//Get sinlge Cookie
//		String cookieValue1 = rep.cookie("NID");
//		System.out.println("cookies values: "+cookieValue1);
		
		//Get all cookies
		Map<String,String> cookiesValues2 = rep.getCookies();
		System.out.println(cookiesValues2.keySet());
		
      	for(String k :cookiesValues2.keySet()) {
			String cookiesValues3 = rep.getCookie(k);
			System.out.println(k+": "+cookiesValues3);
		}
		
	}

}
