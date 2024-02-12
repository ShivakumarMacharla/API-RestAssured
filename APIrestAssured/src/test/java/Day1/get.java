package Day1;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class get {

	@Test
	void getrequest() {
		given()
		.when()
			.get("https://restful-booker.herokuapp.com/booking")
		.then()
			.statusCode(200)
			.log().all();
	}
	
}
