package Day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class XMLSchemaValidation {
	
	@Test
	void xmlSchemavalidation() {
		
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		.then()
			.assertThat().body(RestAssuredMatches.matchesXsdInClasspath("traveler.xsd"));
		
	}

}
