package test;

 import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Firstmethod
{

	@Test
	public void getmethod() 
	{
		
		Response response =get("https://reqres.in/api/users?page=2");
		response.getStatusCode();
		response.getTime();
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("Content-type"));
		int statusCode = response.getStatusCode();
		
		AssertJUnit.assertEquals(statusCode, 200);
		
			
	}
	
	@Test
	public void getmethod2() 
	{
		baseURI ="https://reqres.in/api"; 
		given()
		.get("/users?page=2")
		.then()
		.statusCode(200).body("data.id[5]", equalTo(12)).log().all();
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
