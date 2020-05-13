package RESTAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;

import APIbody.ADDPlace;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class GetPlace {
	
	@Test
	public void getPlaceClass()
	{
		AddPlaceClass2 addobj = new AddPlaceClass2();
		String place_id = addobj.ADDplaceclass();
		
		String Updated_Address = "Stupid_Fellow @123";
		
		
		given()
		.queryParam("key", "qaclick123")
		.queryParam("place_id", place_id)
		.header("Content-Type","application/json")
		.body("{\r\n" + 
				"\"place_id\":\""+place_id+"\",\r\n" + 
				"\"address\":\""+Updated_Address+"\" ,\r\n" + 
				"\"key\":\"qaclick123\"\r\n" + 
				"}\r\n" + 
				"")
		.when()
		.put("maps/api/place/update/json")   //MAIN THING WE DEFINED HERE 
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200);
		
			
		
		//Mudtidimenionsal Arrays means containg no of arrays : new onjectt[][] { {1,2}, {array 2} , {array 3}  						}
		
		//RestAssured.baseURI = "https://rahulshettyacademy.com";
			
		//AddPlaceClass2 addObj = new AddPlaceClass2();
//		String place_id = addObj.ADDplaceclass();
		
		String responseOfGet = given()
		.queryParam("key", "qaclick123")
		.queryParam("place_id", place_id)
		.when()
		.get("maps/api/place/get/json")                //HERE IS THE MAIN THING
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract()
		.response()
		.asString();
		
		JsonPath jsGET = new JsonPath(responseOfGet);
		String userName = jsGET.getString("name");
		String addressNow = jsGET.getString("address");
		
		System.out.print("manually update"+Updated_Address);
		System.out.println("after updation"+addressNow);
		
		
		Assert.assertEquals(addressNow, Updated_Address);
		
		
		
		
		
	}

}
