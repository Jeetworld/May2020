package RESTAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import APIbody.ADDPlace;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class  AddPlaceClass2 {
	
	@Test
	public static String ADDplaceclass()
	{
		//given() : includes all queryParameters, Headers, Body
		//when() : includes post("all sub resources")
		//then() : includes results (validation by asserThat())
		 
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		//givenSection
		String ResponseOfADDPlace = given()   
		.log().all()
		.queryParam("key","qaclick123")
		.header("Content-Type","application/json")
		.body(ADDPlace.addPlace())
		
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
		
		
		//printing the reponse
		System.out.println(ResponseOfADDPlace+"STUPID FELLOW");
		
		//now parsing the reponse in simple string with JsonPath class as we got reposne in Json format
		
		JsonPath js= new JsonPath(ResponseOfADDPlace);
		
		String place_id = js.getString("place_id");
		return place_id;
		
	}

}
