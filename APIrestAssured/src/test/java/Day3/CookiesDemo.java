package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;

public class CookiesDemo {
	
//	@Test
	void testCookies() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		
		.then()
		//	.cookie("AEC","Ad49MVGwt9zFF5FFd6dwjdkPDObGyHl76LaHl1MvfFZ1l3s3Dj4w5Rqdaw")
			.cookie("NID","511%3DtlLCzwxqASCIdJhnr9qASXTXs0lFJDL4tCPbuT7sbv_2h49M9oiZ536-w2H3JEb9_dTaEhqzOcN37fLqmrPuoXxpX2Hj5OYJV4AeC552lcv0kY4PzZczKnSDjJvIre-kjlRBOrPbe-nfDj9voSiI-n7Y1LYBLtLkeO6pn6FkBz0")
			.log().all();
	}
	
	@Test
	void getCookiesInfo() {
		
		
		Response rep = given()
		
		.when()
			.get("https://www.google.com");
		
		    //get single cookies response
//	    String cookies_value1 = rep.cookie("AEC");
//		System.out.println("value of cookie is ====> "+cookies_value1);
//	    String cookies_2 = rep.cookie("NID");
//	    System.out.println("value of cookie os ---->"+cookies_2);
		
		   //get all cookies info
		Map<String,String> cookies_value3 =  rep.getCookies();
//		System.out.println(cookies_value3.keySet());
		
	for(String k : cookies_value3.keySet()) {
			String cookies_value4 = rep.getCookie(k);
			System.out.println(k+":   "+cookies_value4);
			
		}
	}
}	


