package Day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.hamcrest.xml.HasXPath;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import io.restassured.path.xml.*;

public class ParsingXMLResponse {
	
	//https://youtu.be/IB3G7IbdD1k?si=aVdw-P0kK-2SI-FM
	
//	@Test (priority =0)
	void testXMLResponse() {
		
		//Approach 1
		
	/*	given()
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			.body("TravelerinformationResponse.travelers.Travelerinformation[1].name",equalTo("AS"))
			.body("TravelerinformationResponse.travelers.Travelerinformation[5].email",equalTo("ghag@mail.ru"));
		
	
		*/

		
		//Approach 2
		
	/*	Response rep = given()
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		Assert.assertEquals(rep.getStatusCode(),200);
		Assert.assertEquals(rep.header("Content-Type"),"application/xml; charset=utf-8");
		
       String name1 =  rep.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].name");
       Assert.assertEquals(name1, "AS");
      
		String name2 = rep.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[2].name");
		Assert.assertEquals(name2, "vano");
		
		*/
	}
	
//	@Test
	void testXMLResponseBody() {
		
		Response rep = given()
		
		.when()
		.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath xmlobj =  new XmlPath(rep.asString());
		
		//verify total number of travellers
		List<String> travels = (xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation"));
		Assert.assertEquals(travels, 10);
	
		//verify the name in list
		boolean status = false;
		List<String> traveller_Name = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		for(String travellerName:traveller_Name) {
			if(travellerName.equals("Developer")) {
			status = true;
			break;
		  }
			
		}
		Assert.assertEquals(status, true);
	}
	
	
	
}	
	
	
	
	
	
	
	
	
	
	
}
