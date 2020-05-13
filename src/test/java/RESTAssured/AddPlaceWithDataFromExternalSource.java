package RESTAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;


import APIbody.ADDPlace;
import io.restassured.RestAssured;

//import files.ReusableMethods;

//import files.payLoad;

public class AddPlaceWithDataFromExternalSource {
	
	@Test
	public void orange() throws IOException
	{

		RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		//givenSection
		String ResponseOfADDPlace = given()   
		.log().all()
		.queryParam("key","qaclick123")
		.header("Content-Type","application/json")
		.body(GenerateStringFromResource("C:\\Users\\Kamaljeet-PC\\eclipse-workspace\\world\\src\\main\\java\\Files\\APIadddPlaceBody.json"))
		
		//whenSection
		.when().post("maps/api/place/add/json")
		
		//thenSection
		.then()
		// .log().all()
		.assertThat()			//first it extract the fields from response and then compare with the expected values
		.statusCode(200)
		.body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)")
		.extract().response().asString();
		
		
		
	}
	
	
	//Code to get all the data from ".json" external file
	public static String GenerateStringFromResource(String path) throws IOException {



	    return new String(Files.readAllBytes(Paths.get(path))); 



	}
	

}
