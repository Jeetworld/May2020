package RESTAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import APIbody.ADDPlace;
import io.restassured.RestAssured;

public class AddPlaceWithDataParemterization {
	
	
	@Test(dataProvider= "parameterization")
	public void yellow()
	{
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
	
	}
	
	@DataProvider(name = "parameterization")  	//we use data parameterizaition with "DataProvider" for 
												//using/executing the same script for multiple times with change in attributes
	public Object[][] black()
	{
		
		return new Object[][]
				{
			
			{"aaa","df","gf"}, //array1			 //run first time for this array with aaa, df, gf elements
			{"aaa","ff","gg"}, // array 2		//like run second time ----
			{"sss","hh","fff"}, //arrray3
			{"ddd","ff","gg"},
			{"gg","fff","hh"}
			
				};
		
		
		
		
		
	}

}
