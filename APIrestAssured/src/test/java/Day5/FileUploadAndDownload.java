package Day5;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class FileUploadAndDownload {
	
//	@Test
	void singleFileUpload() {
		
		//Single File uploading
		
		File myfile = new File("location of file");
		
		given()
			.multiPart("file",myfile)	//what kind of data file is it..?
			.contentType("multipart/form-data")
		.when()
			.post("url")
		.then()
			.statusCode(200)
			.body("fileName",equalTo("filename"))
			.log().all();
	}
	
//	@Test
	void multipleFileUpload() {
		
		//multiple Files uploading
		
		File myfile1 = new File("location of file");
		File myfile2 = new File("location of file");
		
		given()
			.multiPart("files",myfile1)   //what kind of data file is it..?
			.multiPart("files",myfile2)	
			.contentType("multipart/form-data")
		.when()
			.post("url")
		.then()
			.statusCode(200)
			.body("[0].fileName",equalTo("filename"))
			.body("[1].fileName",equalTo("filename"))
			.log().all();
	}
	
	@Test
	void fileDownload() {
		
		// file downloading
		
		given()
		.when()
			.get("url")
		.then()
			.statusCode(200)
			.log().body();
	}

}
