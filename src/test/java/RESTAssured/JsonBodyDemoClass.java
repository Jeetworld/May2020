package RESTAssured;

import org.testng.annotations.Test;

import APIbody.JsonBodyDemo;
import io.restassured.path.json.JsonPath;

public class JsonBodyDemoClass {
	
	@Test
	public void OperationsOnJsonOutput()
	{
		
		JsonPath js = new JsonPath(JsonBodyDemo.JsonBodyDemoAPI());
		
		System.out.println(js.getInt("courses[1].price"));  //whenever we need to convert to String from int : we use .toString
		
		System.out.println(js.get("courses.size()"));		//for count the number of courses in output
		
		
		int countOfCourses = js.get("courses.size()");
		int Sum = 0 ;
		
		for(int i= 0; i<countOfCourses; i++)
		{
			int price = js.get("courses["+i+"].price");
			int copies = js.get("courses["+i+"].copies");
			
			System.out.println("price"+price+"copies"+copies);

			int multiplicationOfpriceAndCopies = (price)*(copies);
			
			System.out.println(multiplicationOfpriceAndCopies);
			
			
			Sum = Sum + multiplicationOfpriceAndCopies;
			
			
			
		}
		
		
		System.out.println("Sum is "+Sum);
		
	}

}
