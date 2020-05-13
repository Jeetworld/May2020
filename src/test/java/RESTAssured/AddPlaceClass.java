package RESTAssured;

//import io.restassured:rest-assured:4.0.0;
//import io.rest-assured:json-path:4.0.0;
//import io.rest-assured:xml-path:4.0.0;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import APIbody.ADDPlace;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;



public class AddPlaceClass {
	
	@Test
	public void ADDplace()
	{
		//given() : includes all queryParameters, Headers, Body
		//when() : includes post("all sub resources")
		//then() : includes results (validation by asserThat())
		
		
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		given()   
		.log().all()
		.queryParam("key","qaclick123")
		.header("Content-Type","application/json")
		
		.body(ADDPlace.addPlace())
		
		.when().post("maps/api/place/add/json")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");
		
		
		
	}
	

}
